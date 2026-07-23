package com.hol4.paymentservice.service;

import com.hol4.paymentservice.model.Payment;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PaymentService {

    private final List<Payment> payments = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);
    private static final String PAYMENT_SERVICE = "paymentService";

    public List<Payment> getAllPayments() { return new ArrayList<>(payments); }

    @CircuitBreaker(name = PAYMENT_SERVICE, fallbackMethod = "processPaymentFallback")
    @Retry(name = PAYMENT_SERVICE)
    @RateLimiter(name = PAYMENT_SERVICE)
    public Payment processPayment(Payment payment) {
        payment.setId(idCounter.getAndIncrement());
        payment.setStatus("COMPLETED");
        payments.add(payment);
        return payment;
    }

    public Payment processPaymentFallback(Payment payment, Throwable t) {
        payment.setId(idCounter.getAndIncrement());
        payment.setStatus("FAILED - Circuit Breaker Active: " + t.getMessage());
        payments.add(payment);
        return payment;
    }

    @CircuitBreaker(name = PAYMENT_SERVICE, fallbackMethod = "getPaymentByIdFallback")
    public Payment getPaymentById(Long id) {
        return payments.stream().filter(p -> p.getId().equals(id)).findFirst()
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + id));
    }

    public Payment getPaymentByIdFallback(Long id, Throwable t) {
        Payment fallback = new Payment();
        fallback.setId(id);
        fallback.setStatus("UNAVAILABLE - Service degraded");
        return fallback;
    }

    public List<Payment> getPaymentsByOrderId(Long orderId) {
        return payments.stream().filter(p -> p.getOrderId().equals(orderId)).toList();
    }
}
