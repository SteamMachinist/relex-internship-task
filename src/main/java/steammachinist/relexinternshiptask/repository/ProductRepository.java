package steammachinist.relexinternshiptask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import steammachinist.relexinternshiptask.entity.Product;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findProductByName(String name);
}