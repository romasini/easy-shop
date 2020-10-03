package ru.romasini.easy.shop.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.romasini.easy.shop.exceptions.ResourceNotFoundException;
import ru.romasini.easy.shop.models.Order;
import ru.romasini.easy.shop.sevices.OrderService;
import ru.romasini.easy.shop.utils.Cart;


@Controller
@AllArgsConstructor
public class OrderController {

    private static final int PAGE_SIZE = 5;

    private OrderService orderService;
    private Cart cart;

    @GetMapping("/order_complete")
    public String orderComplete1(Model model){
        Order order = new Order();
        order.setPrice(cart.getAmount());
        order.setItems(cart.getItems());
        model.addAttribute("order", order);
        return "order_complete";
    }

    @PostMapping("/save_order")
    public String saveOrder(Model model, @ModelAttribute Order order){
        order.setItems(cart.getItems());
        orderService.save(order);
        cart.setAmount(0);
        cart.init();
        return "redirect:/orders";
    }

    @GetMapping("/orders")
    public String ordersList(Model model, @RequestParam(name = "p", required = false, defaultValue = "1") Integer numPage){

        if(numPage <= 0){
            numPage = 1;
        }

        model.addAttribute("orders", orderService.findAll(numPage-1, PAGE_SIZE));
        return "orders";
    }


    @GetMapping("/orders/{order_id}")
    public String orderView(Model model, @PathVariable(name = "order_id") Long orderId){
        Order order = orderService.findById(orderId).orElseThrow(()-> new ResourceNotFoundException("Заказ не найден"));
        model.addAttribute("order", order);
        return "order";
    }
}
