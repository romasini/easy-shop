package ru.romasini.easy.shop.sevices;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.romasini.easy.shop.models.Product;
import ru.romasini.easy.shop.repositories.ProductRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;

    public Page<Product> findAll(Integer numPage, int sizePage){
        return productRepository.findAll(PageRequest.of(numPage, sizePage));
    }

    public Page<Product> findAllByPriceGreaterThanEqual(Integer numPage, int sizePage, int minPrice){
        Pageable page = PageRequest.of(numPage, sizePage);
        return productRepository.findAllByPriceGreaterThanEqual(minPrice, page);
    }

    public Page<Product> findAllByPriceLessThanEqual(Integer numPage, int sizePage, int maxPrice){
        Pageable page = PageRequest.of(numPage, sizePage);
        return productRepository.findAllByPriceLessThanEqual(maxPrice, page);
    }

    public Page<Product> findAllByPriceGreaterThanEqualAndPriceLessThanEqual(Integer numPage, int sizePage, int minPrice, int maxPrice){
        Pageable page = PageRequest.of(numPage, sizePage);
        return productRepository.findAllByPriceGreaterThanEqualAndPriceLessThanEqual(minPrice, maxPrice, page);
    }

}
