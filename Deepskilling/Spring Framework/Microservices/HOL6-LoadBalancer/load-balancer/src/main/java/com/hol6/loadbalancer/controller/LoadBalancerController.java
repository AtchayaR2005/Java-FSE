package com.hol6.loadbalancer.controller;

import com.hol6.loadbalancer.service.LoadBalancerService;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/loadbalancer")
public class LoadBalancerController {

    private final LoadBalancerService loadBalancerService;

    public LoadBalancerController(LoadBalancerService loadBalancerService) {
        this.loadBalancerService = loadBalancerService;
    }

    @GetMapping("/info")
    public Map<String, String> getInfo() { return loadBalancerService.getServiceInfo(); }

    @GetMapping("/call/{serviceId}")
    public Map<String, Object> callService(@PathVariable String serviceId) {
        return loadBalancerService.callService(serviceId);
    }
}
