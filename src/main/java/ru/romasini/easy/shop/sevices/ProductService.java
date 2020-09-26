package ru.romasini.easy.shop.sevices;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.romasini.easy.shop.models.Product;
import ru.romasini.easy.shop.repositories.ProductRepository;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;

    public Page<Product> findAll(Specification<Product> spec, Integer numPage, int sizePage){
        return productRepository.findAll(spec, PageRequest.of(numPage, sizePage));
    }

}
