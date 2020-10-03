package ru.romasini.easy.shop.sevices;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.romasini.easy.shop.models.Order;
import ru.romasini.easy.shop.models.OrderItem;
import ru.romasini.easy.shop.repositories.OrderRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderService {

    private OrderRepository orderRepository;

    public Page<Order> findAll(Integer numPage, int sizePage){
        return orderRepository.findAll(PageRequest.of(numPage, sizePage));
    }

    public Optional<Order> findById(Long id){
        return orderRepository.findById(id);
    }

    public Order save(Order order){
        for (OrderItem o:order.getItems()) {
            o.setOrder(order);
        }
       return orderRepository.save(order);
    }

}
