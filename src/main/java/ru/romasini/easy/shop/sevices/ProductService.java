package ru.romasini.easy.shop.sevices;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.romasini.easy.shop.models.Product;
import ru.romasini.easy.shop.repositories.ProductRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public List<Product> findAllByPriceGreaterThanEqual(int minPrice){
        return productRepository.findAllByPriceGreaterThanEqual(minPrice);
    }

    public List<Product> findAllByPriceLessThanEqual(int maxPrice){
        return productRepository.findAllByPriceLessThanEqual(maxPrice);
    }

    public List<Product> findAllByPriceGreaterThanEqualAndPriceLessThanEqual(int minPrice, int maxPrice){
        return productRepository.findAllByPriceGreaterThanEqualAndPriceLessThanEqual(minPrice, maxPrice);
    }

}
