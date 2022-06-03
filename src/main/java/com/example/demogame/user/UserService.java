package com.example.demogame.user;

import com.example.demogame.cart.Cart;
import com.example.demogame.cart.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    private CartRepository cartRepository;

    @Autowired
    public UserService(UserRepository userRepository, CartRepository cartRepository) {
        this.userRepository = userRepository;
        this.cartRepository = cartRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public User addUser(User userToInsert) {
        try {
            User addedUser = userRepository.save(userToInsert);
            addedUser.getUser_id();
            Cart userCart = new Cart(addedUser);
            cartRepository.save(userCart);
            return addedUser;
        } catch (Exception e) {
            System.out.println(e.toString());
            throw e;
        }
    }
}
