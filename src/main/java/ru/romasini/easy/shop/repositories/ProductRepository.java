package ru.romasini.easy.shop.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.romasini.easy.shop.models.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    Page<Product> findAllByPriceGreaterThanEqual(int minPrice, Pageable page);
    Page<Product> findAllByPriceLessThanEqual(int maxPrice, Pageable page);
    Page<Product> findAllByPriceGreaterThanEqualAndPriceLessThanEqual(int minPrice, int maxPrice, Pageable page);

}
