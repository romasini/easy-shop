package ru.romasini.easy.shop.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.romasini.easy.shop.models.Product;
import ru.romasini.easy.shop.sevices.ProductService;
import ru.romasini.easy.shop.utils.ProductFilter;

import java.util.Map;
import java.util.Optional;

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
        Optional<Product> product = productService.findById(id);
        if(!product.isEmpty()){
            model.addAttribute("product",product.get());
            return "edit_product";
        }else{
            return "redirect:/products";
        }
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@RequestParam Long id,
                              @RequestParam String title,
                              @RequestParam (defaultValue = "0") Integer price){

        Product product = new Product();
        if(id != null) {
            product.setId(id);
        }
        product.setTitle(title);
        product.setPrice(price);
        productService.save(product);
        return "redirect:/products";
    }

}
