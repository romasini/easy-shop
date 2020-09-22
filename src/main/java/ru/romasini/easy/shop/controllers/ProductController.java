package ru.romasini.easy.shop.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.romasini.easy.shop.sevices.ProductService;

@Controller
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping("/products")
    public String index(Model model, @RequestParam(required = false, defaultValue = "0") int minPrice,  @RequestParam(required = false, defaultValue = "0") int maxPrice){
        if (minPrice==0 && maxPrice==0){
            model.addAttribute("productlist", productService.findAll());
        }else if(minPrice>0 && maxPrice>0){
            model.addAttribute("productlist", productService.findAllByPriceGreaterThanEqualAndPriceLessThanEqual(minPrice, maxPrice));
        }else if(minPrice>0){
            model.addAttribute("productlist", productService.findAllByPriceGreaterThanEqual(minPrice));
        }else if(maxPrice>0){
            model.addAttribute("productlist", productService.findAllByPriceLessThanEqual(maxPrice));
        }
        return "products";
    }

}
