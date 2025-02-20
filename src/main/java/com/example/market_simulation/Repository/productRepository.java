package com.example.market_simulation.Repository;

import com.example.market_simulation.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productRepository extends JpaRepository<Product,Long> {

}
