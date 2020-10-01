package ru.romasini.easy.shop.utils;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import ru.romasini.easy.shop.models.OrderItem;
import ru.romasini.easy.shop.models.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@NoArgsConstructor
@Data
public class Cart {
    private List<OrderItem> items;

    @PostConstruct
    public void init(){
        items = new ArrayList<>();
    }

    public void add(Product product){
        //items.add(product);
    }

}
