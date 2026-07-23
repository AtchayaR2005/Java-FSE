package com.hol6.loadbalancer.config;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import java.net.URI;
import java.util.List;

@Configuration
public class ServiceConfig {

    @Bean
    public ServiceInstanceListSupplier serviceInstanceListSupplier() {
        return new StaticServiceInstanceListSupplier();
    }

    static class StaticServiceInstanceListSupplier implements ServiceInstanceListSupplier {

        @Override
        public String getServiceId() { return "backend-service"; }

        @Override
        public Flux<List<ServiceInstance>> get() {
            return Flux.just(List.of(
                new SimpleServiceInstance(URI.create("http://localhost:8081"), "user-service"),
                new SimpleServiceInstance(URI.create("http://localhost:8082"), "order-service"),
                new SimpleServiceInstance(URI.create("http://localhost:8083"), "product-service")
            ));
        }
    }

    static class SimpleServiceInstance implements ServiceInstance {
        private final URI uri;
        private final String serviceId;

        SimpleServiceInstance(URI uri, String serviceId) { this.uri = uri; this.serviceId = serviceId; }

        @Override public String getServiceId() { return serviceId; }
        @Override public String getHost() { return uri.getHost(); }
        @Override public int getPort() { return uri.getPort(); }
        @Override public boolean isSecure() { return "https".equals(uri.getScheme()); }
        @Override public URI getUri() { return uri; }
        @Override public java.util.Map<String, String> getMetadata() { return java.util.Map.of(); }
        @Override public String getScheme() { return uri.getScheme(); }
        @Override public String getInstanceId() { return serviceId + "-" + uri.getPort(); }
    }
}
