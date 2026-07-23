package com.hol2.productservice.service;

import com.hol2.productservice.model.Product;
import com.hol2.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) { this.productRepository = productRepository; }
    public List<Product> getAllProducts() { return productRepository.findAll(); }
    public Optional<Product> getProductById(Long id) { return productRepository.findById(id); }
    public List<Product> getProductsByCategory(String category) { return productRepository.findByCategory(category); }
    public Product createProduct(Product product) { return productRepository.save(product); }
    public Product updateProduct(Long id, Product details) {
        Product p = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        p.setName(details.getName()); p.setDescription(details.getDescription());
        p.setPrice(details.getPrice()); p.setCategory(details.getCategory());
        return productRepository.save(p);
    }
    public void deleteProduct(Long id) { productRepository.deleteById(id); }
}
