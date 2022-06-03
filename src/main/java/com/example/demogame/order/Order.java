package com.example.demogame.order;

import com.example.demogame.product.Product;
import com.example.demogame.user.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long order_id;

    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    private User user;

    public Order() {
    }

    public Order(User user) {
        this.user = user;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public User getUser() {
        return user;
    }
}
