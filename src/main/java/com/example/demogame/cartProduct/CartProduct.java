package com.example.demogame.cartProduct;


import com.example.demogame.cart.Cart;
import com.example.demogame.product.Product;
import com.example.demogame.user.User;
import org.springframework.data.annotation.Reference;

import javax.persistence.*;

@Entity
@Table(name="cart_products")
public class CartProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_product_id")
    private Long cart_product_id;

    @ManyToOne
    @JoinColumn(name = "fk_cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "fk_product_id")
    private Product product;

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private int quantity;

    public  CartProduct(){

    }

    public CartProduct(Cart cart, Product product) {
        this.cart = cart;
        this.product = product;
        this.quantity =1;
    }

    public CartProduct(Cart cart, Product product, int quantity) {
        this.cart = cart;
        this.product = product;
        this.quantity = quantity;
    }
}
