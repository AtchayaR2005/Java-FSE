package com.library.microservices;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public Product getProduct() {
        return new Product(101, "Laptop");
    }
}
