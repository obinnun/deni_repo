package com.example.demogame.cart;

import com.example.demogame.user.User;

import javax.persistence.*;

@Entity
@Table(name="carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cart_id;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user_id")
    private User user;

    public Cart(Long cartId, User user) {
        this.cart_id = cartId;
        this.user = user;
    }

    public Cart(User user) {
        this.user = user;
    }

    public Cart() {
    }

    public Long getCart_id() {
        return cart_id;
    }

    public User getUser() {
        return user;
    }
}
