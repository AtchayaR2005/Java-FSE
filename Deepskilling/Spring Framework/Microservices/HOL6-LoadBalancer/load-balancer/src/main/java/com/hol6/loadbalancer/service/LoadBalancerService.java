package com.hol6.loadbalancer.service;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoadBalancerService {

    private final LoadBalancerClient loadBalancerClient;
    private final RestTemplate restTemplate;

    public LoadBalancerService(LoadBalancerClient loadBalancerClient) {
        this.loadBalancerClient = loadBalancerClient;
        this.restTemplate = new RestTemplate();
    }

    public Map<String, Object> callService(String serviceId) {
        ServiceInstance instance = loadBalancerClient.choose(serviceId);
        Map<String, Object> result = new HashMap<>();
        if (instance != null) {
            result.put("serviceId", serviceId);
            result.put("host", instance.getHost());
            result.put("port", instance.getPort());
            result.put("uri", instance.getUri().toString());
            result.put("status", "UP");
        } else {
            result.put("serviceId", serviceId);
            result.put("status", "NO_INSTANCE_AVAILABLE");
        }
        return result;
    }

    public Map<String, String> getServiceInfo() {
        Map<String, String> info = new HashMap<>();
        info.put("load-balancer", "Spring Cloud LoadBalancer");
        info.put("strategy", "Round Robin");
        info.put("available-services", "user-service, order-service, product-service");
        return info;
    }
}
