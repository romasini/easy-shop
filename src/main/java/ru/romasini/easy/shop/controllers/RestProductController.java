package ru.romasini.easy.shop.controllers;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;
import ru.romasini.easy.shop.exceptions.ResourceNotFoundException;
import ru.romasini.easy.shop.models.Product;
import ru.romasini.easy.shop.sevices.ProductService;
import ru.romasini.easy.shop.utils.ProductFilter;

import java.util.Map;

@RequestMapping("/api/v1/products")
@RestController
@AllArgsConstructor
public class RestProductController {

    private static final int PAGE_SIZE = 5;
    private ProductService productService;

    @GetMapping
    public Page<Product> productsList(@RequestParam(name = "p", required = false, defaultValue = "1") Integer numPage,
                                      @RequestParam Map<String, String> params){
        if(numPage <= 0){
            numPage = 1;
        }

        ProductFilter productFilter = new ProductFilter(params);
        return productService.findAll(productFilter.getSpec(), numPage-1, PAGE_SIZE);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.findById(id).orElseThrow(()-> new ResourceNotFoundException("No data"));
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.save(product);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product){
        return productService.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteById(id);
    }

}
