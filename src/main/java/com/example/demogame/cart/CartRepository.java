package com.example.demogame.cart;

import com.example.demogame.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    @Query("from Cart c where c.cart_id=:id")
    Cart getCartById(Long id);

    @Query("from Cart c where c.user=:user")
    Cart getCartByUserId(User user);

}
