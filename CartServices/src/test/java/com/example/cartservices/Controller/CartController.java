package com.example.cartservices.Controller;//package com.example.cartservices.Controller;
//
//import com.example.cartservices.Services.CartServices;
//import com.example.cartservices.models.Cart;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//public class CartController {
////    CartServices cartServices;
//
////    public CartController(CartServices cartServices){this.cartServices = cartSertvices;}
////    @GetMapping("/carts/{id}")
////    public Cart getsingleCart(@PathVariable("id") Long id){
////        return new Cart();
////    }
////
////    @GetMapping("/carts")
////    public ArrayList<Cart> getallCarts(){
////        return new ArrayList<>();
////    }
////    @PostMapping("/carts")
////    public Cart createCart(){
////        return new Cart();
////    }
////    @PutMapping("/products/update/{id}")
////    public String updateProduct(@PathVariable("id") Long id) {
////        return new String();
////
////
////        @DeleteMapping("/carts/{id}")
////        public Cart deleteCart(@PathVariable("id") Long id){
////            return new Cart();
////        }
//
//        //
//
//
//        CartServices cartServices;
//
//
//    public CartController(CartServices cartServices) {
//            this.cartServices = cartServices;
//        }
//
//        @GetMapping("/hello")
//        public String sayHello(){
//        return "Hello world";
//        }
//
//
//
//
//
//
//
//
//        @GetMapping("/carts")
//        public List<Cart> getAllProducts() {
//            return cartServices.getAllCarts();
//        }
//
//        @GetMapping("/carts/{id}")
//        public Cart getProductById(@PathVariable Long id) {
//            return cartServices.getCartById(id);
//        }
//        @PostMapping("/carts")
//        public Cart createProduct(@RequestBody Cart product) {
//            return cartServices.createCart(product);
//        }
//
//        @PutMapping("/carts/update/{id}")
//        public String updateProduct(@PathVariable("id") Long id, @RequestBody Cart cart) {
//            return cartServices.updateCart(id, cart);
//        }
//
//        @DeleteMapping("/carts/delete/{id}")
//        public String deleteProduct(@PathVariable("id") Long id) {
//            return cartServices.deleteCart(id);
//        }
//
//    }
//
//
//
import com.example.cartservices.Services.CartServices;
import com.example.cartservices.models.Cart;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {
    CartServices cartServices;


    public CartController(CartServices cartServices) {
        this.cartServices = cartServices;
    }
    @GetMapping("/hello")
    public String sayhello(){
        return "Hello ,World";
    }

    @GetMapping("/carts")
    public List<Cart> getAllProducts() {
        return cartServices.getAllCarts();
    }

    @GetMapping("/carts/{id}")
    public Cart getProductById(@PathVariable Long id) {
        return cartServices.getCartById(id);
    }



    @PostMapping("/carts")
    public Cart createProduct(@RequestBody Cart cart) {
        return cartServices.createCart(cart);
    }

    @PutMapping("/carts/update/{id}")
    public String updateProduct(@PathVariable("id") Long id, @RequestBody Cart product) {
        return cartServices.updateCart(id, product);
    }

    @DeleteMapping("/carts/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        return cartServices.deleteCart(id);
    }
}
