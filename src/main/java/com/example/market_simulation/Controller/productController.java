package com.example.market_simulation.Controller;

import java.util.List;
import com.example.market_simulation.Repository.productRepository;
import com.example.market_simulation.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/users")
public class productController {
    @Autowired
    private productRepository repository;

    @GetMapping
    public List<Product> getAllProducts(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductId(@PathVariable Long id){
        return repository.findById(id).orElseThrow(() ->
                new RuntimeException("Product not found with id "+ id));
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return repository.save(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product){
        Product existingProduct = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Product not found with id "+ id));
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        return repository.save(existingProduct);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        try {
            repository.deleteById(id);
            return "(+) Product deleted successfully!";
        } catch (Exception e) {
            return "(-) Product not found!";
        }
    }


}
