package com.example.demogame.cart;

import com.example.demogame.cartProduct.CartProduct;
import com.example.demogame.cartProduct.CartProductRepository;
import com.example.demogame.order.Order;
import com.example.demogame.order.OrderRepository;
import com.example.demogame.product.Product;
import com.example.demogame.productOrderCon.ProductOrderCon;
import com.example.demogame.productOrderCon.ProductOrderConRepository;
import com.example.demogame.user.User;
import com.example.demogame.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
public class CartService {
    private CartRepository cartRepository;
    private CartProductRepository cartProductRepository;

    private UserRepository userRepository;

    private OrderRepository orderRepository;

    private ProductOrderConRepository productOrderConRepository;

    @Autowired
    public CartService(CartRepository cartRepository,
                       CartProductRepository cartProductRepository,
                       OrderRepository orderRepository,
                       ProductOrderConRepository productOrderConRepository
    ) {
        this.cartRepository = cartRepository;
        this.cartProductRepository = cartProductRepository;
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.productOrderConRepository = productOrderConRepository;
    }

    public Cart getCartById(Long id) {
        return cartRepository.getCartById(id);
    }

    public boolean addProductToCart(Long userId, Long productId, int quantity) {
        //assuming every user already have existing cart- inserted in generation
        try {
            Cart cart = getCartByUserId(userId);
            Product product = new Product(productId);
            CartProduct existingCp = cartProductRepository.getCartProduct(cart, product);
            if (existingCp != null) {
                existingCp.setQuantity(existingCp.getQuantity() + quantity);
                cartProductRepository.save(existingCp);
            } else {
                CartProduct cp = new CartProduct(cart, product, quantity);
                cartProductRepository.save(cp);
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public Cart getCartByUserId(Long id) {
        return cartRepository.getCartByUserId(new User(id));
    }

    @Transactional
    public void purchaseCart(Long userId) {
        Cart cartToPurchase = getCartByUserId(userId);
        List<CartProduct> cartProductList = cartProductRepository.getCartProductsByCart(cartToPurchase);
        Order newOrder = orderRepository.save(new Order(new User(userId)));
        List productOrderConsToSave = new LinkedList();
        for (int i = 0; i < cartProductList.size(); i++) {
            CartProduct cp = cartProductList.get(i);
            ProductOrderCon productOrderCon = new ProductOrderCon(cp.getProduct(), newOrder, cp.getQuantity());
            productOrderConsToSave.add(productOrderCon);
        }
        //save all products to new order
        productOrderConRepository.saveAll(productOrderConsToSave);
        //delete cartProducts
        cartProductRepository.deleteAll(cartProductList);
    }
}
