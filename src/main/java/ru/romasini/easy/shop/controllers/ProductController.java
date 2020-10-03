package ru.romasini.easy.shop.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.romasini.easy.shop.exceptions.ResourceNotFoundException;
import ru.romasini.easy.shop.models.Product;
import ru.romasini.easy.shop.sevices.ProductService;
import ru.romasini.easy.shop.utils.ProductFilter;

import java.util.Map;

@Controller
@AllArgsConstructor
public class ProductController {

    private static final int PAGE_SIZE = 5;
    private ProductService productService;

    @GetMapping("/products")
    public String index(Model model,
                        @RequestParam(name = "p", required = false, defaultValue = "1") Integer numPage,
                        @RequestParam Map<String, String> params){

        if(numPage <= 0){
            numPage = 1;
        }

        ProductFilter productFilter = new ProductFilter(params);
        model.addAttribute("products", productService.findAll(productFilter.getSpec(), numPage-1, PAGE_SIZE));
        model.addAttribute("filterDefinition", productFilter.getFilterDefinition());

        return "products";
    }

    @GetMapping("/edit_product/{id}")
    public String editProduct(Model model,
                              @PathVariable Long id){
        Product product = productService.findById(id).orElseThrow(()->new ResourceNotFoundException("Продукт не найден (для редактирования)"));
        model.addAttribute("product",product);
        return "edit_product";
    }

    @PostMapping("/save_product")
    public String saveProduct(@ModelAttribute Product product){
        productService.save(product);
        return "redirect:/products";
    }

}
