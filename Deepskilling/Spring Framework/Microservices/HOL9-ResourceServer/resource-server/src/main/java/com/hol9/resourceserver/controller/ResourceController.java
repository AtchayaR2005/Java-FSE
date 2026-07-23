package com.hol9.resourceserver.controller;

import com.hol9.resourceserver.model.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {

    private final List<Resource> resources = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public ResourceController() {
        resources.add(new Resource(1L, "Public Doc", "A public document", "system"));
        resources.add(new Resource(2L, "Private Doc", "A private document", "admin"));
    }

    @GetMapping("/public")
    public Map<String, String> publicResource() {
        return Map.of("message", "This is a public resource - no authentication required");
    }

    @GetMapping
    public List<Resource> getAllResources(@AuthenticationPrincipal Jwt jwt) {
        return resources;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource> getResourceById(@PathVariable Long id, @AuthenticationPrincipal Jwt jwt) {
        return resources.stream().filter(r -> r.getId().equals(id)).findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Resource createResource(@RequestBody Resource resource, @AuthenticationPrincipal Jwt jwt) {
        resource.setId(idCounter.getAndIncrement());
        resource.setOwner(jwt.getSubject());
        resources.add(resource);
        return resource;
    }

    @GetMapping("/user-info")
    public Map<String, Object> getUserInfo(@AuthenticationPrincipal Jwt jwt) {
        return Map.of(
            "subject", jwt.getSubject(),
            "claims", jwt.getClaims(),
            "tokenValue", jwt.getTokenValue()
        );
    }
}
