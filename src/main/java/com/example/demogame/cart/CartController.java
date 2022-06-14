package com.example.demogame.cart;

import com.example.demogame.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("cart")
public class CartController {

    private CartService cartService;
    private UserService userService;

    @Autowired
    public CartController(CartService cartService, UserService userService) {
        this.cartService = cartService;
        this.userService = userService;
    }

    @PostMapping("/addtocart")
    public void addProductToCart(HttpServletRequest request, HttpServletResponse response, @RequestBody Map reqBody, @RequestHeader Object authorization) {
        String email = (String) request.getAttribute("username");
        if (email == null) {
            response.setStatus(400);
            return;
        }
        Long userId = userService.getUserByEmail(email).getUser_id();
        Long productId = Long.parseLong(reqBody.get("productid") + "");
        int quantity = (int) reqBody.get("quantity");
        cartService.addProductToCart(userId, productId, quantity);
    }

    @PostMapping("/purchaseCart")
    public void purchaseCart(HttpServletRequest request, HttpServletResponse response, @RequestBody Map reqBody) throws IOException {
        String email = (String) request.getAttribute("username");
        if (email == null) {
            response.sendError(400, "Incorrect access token");
            return;
        }
        Long userId = userService.getUserByEmail(email).getUser_id();
        cartService.purchaseCart(userId);
    }
}
