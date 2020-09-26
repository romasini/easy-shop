package ru.romasini.easy.shop.sevices;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.romasini.easy.shop.models.Product;
import ru.romasini.easy.shop.repositories.ProductRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;

    public Page<Product> findAll(Specification<Product> spec, Integer numPage, int sizePage){
        return productRepository.findAll(spec, PageRequest.of(numPage, sizePage));
    }

    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
    }

    public void save(Product product){
        productRepository.save(product);
    }

}
