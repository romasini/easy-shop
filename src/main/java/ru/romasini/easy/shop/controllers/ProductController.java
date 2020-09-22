package ru.romasini.easy.shop.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.romasini.easy.shop.sevices.ProductService;

@Controller
@AllArgsConstructor
public class ProductController {

    private static final int PAGE_SIZE = 5;
    private ProductService productService;

    @GetMapping("/products")
    public String index(Model model, @RequestParam(name = "p", required = false, defaultValue = "1") Integer numPage, @RequestParam(required = false, defaultValue = "0") int minPrice,  @RequestParam(required = false, defaultValue = "0") int maxPrice){
        if(numPage <= 0){
            numPage = 1;
        }

        if (minPrice==0 && maxPrice==0){
            model.addAttribute("productlist", productService.findAll(numPage - 1, PAGE_SIZE));
        }else if(minPrice>0 && maxPrice>0){
            model.addAttribute("productlist", productService.findAllByPriceGreaterThanEqualAndPriceLessThanEqual(numPage - 1, PAGE_SIZE, minPrice, maxPrice));
        }else if(minPrice>0){
            model.addAttribute("productlist", productService.findAllByPriceGreaterThanEqual(numPage - 1, PAGE_SIZE, minPrice));
        }else if(maxPrice>0){
            model.addAttribute("productlist", productService.findAllByPriceLessThanEqual(numPage - 1, PAGE_SIZE, maxPrice));
        }

        return "products";
    }

}
