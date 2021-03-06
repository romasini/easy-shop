package ru.romasini.easy.shop.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.romasini.easy.shop.exceptions.ResourceNotFoundException;
import ru.romasini.easy.shop.models.Product;
import ru.romasini.easy.shop.sevices.ProductService;
import ru.romasini.easy.shop.utils.Cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/cart")
@AllArgsConstructor
public class CartController {

    private ProductService productService;
    private Cart cart;

    @GetMapping
    public String showCartPage(HttpSession session){
        return "cart";
    }

    @GetMapping("/add/{product_id}")
    public void add(@PathVariable(name = "product_id") Long productId,
                      HttpServletRequest request,
                      HttpServletResponse response) throws IOException {
        Product product = productService.findById(productId).orElseThrow(()->new ResourceNotFoundException("Продукт не найден"));
        cart.addOrIncrement(product);
        response.sendRedirect(request.getHeader("referer"));
    }

    @GetMapping("/inc/{product_id}")
    public String addOrIncrement(@PathVariable(name = "product_id") Long productId)  {
        cart.increment(productId);
        return "redirect:/cart";
    }

    @GetMapping("/dec/{product_id}")
    public String decrementOrRemove(@PathVariable(name = "product_id") Long productId)  {
        cart.decrementOrRemove(productId);
        return "redirect:/cart";
    }

    @GetMapping("/remove/{product_id}")
    public String remove(@PathVariable(name = "product_id") Long productId)  {
        cart.remove(productId);
        return "redirect:/cart";
    }


}
