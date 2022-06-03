package com.example.demogame.cartProduct;

import com.example.demogame.cart.Cart;
import com.example.demogame.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartProductRepository extends JpaRepository<CartProduct, Long> {
//    @Query("INSERT into CartProduct c VALUES(cart_id, product_id)")
    @Query("from CartProduct c where c.product=:product and c.cart=:cart")
    CartProduct getCartProduct(Cart cart, Product product);

    @Query("from CartProduct c where c.cart=:cart")
    List<CartProduct> getCartProductsByCart(Cart cart);
//    @SQLInsert("insert into Cart")
}
