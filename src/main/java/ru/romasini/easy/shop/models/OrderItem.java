package ru.romasini.easy.shop.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "order_items")
@Data
@NoArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private int price;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public OrderItem(Product product){
        this.product = product;
        this.quantity = 1;
        this.price = product.getPrice();
    }

    public void incrementQuantity(){
        quantity++;
    }

    public void decrementQuantity(){
        quantity--;
        if(quantity<=0){
            quantity = 0;
        }
    }
}
