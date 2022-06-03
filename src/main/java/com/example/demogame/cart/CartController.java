package com.example.demogame.cart;

import com.example.demogame.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("cart")
public class CartController {

    private CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/addtocart")
    public void addProductToCart(@RequestBody Map reqBody, @RequestHeader Object authorization) {
        Long userId = Long.parseLong(reqBody.get("userid") + "");
        Long productId = Long.parseLong(reqBody.get("productid") + "");
        int quantity = (int)reqBody.get("quantity");
        cartService.addProductToCart(userId, productId, quantity);
    }

    @PostMapping("/purchaseCart")
    public void purchaseCart(@RequestBody Map reqBody){
        Long userId = Long.parseLong(reqBody.get("userid") + "");
        cartService.purchaseCart(userId);
    }

}
