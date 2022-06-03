package com.example.demogame.productOrderCon;

import com.example.demogame.order.Order;
import com.example.demogame.product.Product;

import javax.persistence.*;

@Entity
@Table(name = "product_order_con")
public class ProductOrderCon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long product_order_con_id;

    @ManyToOne
    @JoinColumn(name = "fk_product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "fk_order_id")
    private Order order;

    private int quantity;

    public ProductOrderCon(Product product, Order order, int quantity) {
        this.product = product;
        this.order = order;
        this.quantity = quantity;
    }

    public ProductOrderCon() {
    }
}
