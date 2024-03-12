package com.example.cartservices.Services;

import com.example.cartservices.models.Cart;

import java.util.List;

public interface CartServices {


    List<Cart> getAllCarts();
    Cart getCartById(Long id);
    Cart createCart(Cart product);
    String updateCart(Long id, Cart cart);
    String deleteCart(Long id);
//    String sayHello();
//

}
