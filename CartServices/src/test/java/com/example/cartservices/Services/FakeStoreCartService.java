package com.example.cartservices.Services;

import com.example.cartservices.DTOs.FakeStoreCartDTO;
import com.example.cartservices.models.Cart;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreCartService implements CartServices {
    RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Cart> getAllCarts() {
        String url ="https://fakestoreapi.com/carts";
        RestTemplate restTemplate = new RestTemplate();

        ParameterizedTypeReference<List<FakeStoreCartDTO>> responseType = new ParameterizedTypeReference<>() {
        };
        ResponseEntity<List<FakeStoreCartDTO>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                responseType
        );

        List<FakeStoreCartDTO> fakeStoreCartDTOS = responseEntity.getBody();

        List<Cart> carts = new ArrayList<>();

        if(fakeStoreCartDTOS == null) {
            return new ArrayList<>();
        }


        for(FakeStoreCartDTO fakeStoreCartDTO : fakeStoreCartDTOS) {
            Cart cart = new Cart();
            cart.setId(fakeStoreCartDTO.getId());
            cart.setUserId(fakeStoreCartDTO.getUserId());
            cart.setDate(fakeStoreCartDTO.getDate());

            carts.add(cart);
        }

        return carts;

    }

    @Override
    public Cart getCartById(Long id) {
        String url = "https://fakestoreapi.com/carts/" + id;
        RestTemplate restTemplate = new RestTemplate();

        FakeStoreCartDTO fakeStoreCartDTO = restTemplate.getForObject(
                url,
                FakeStoreCartDTO.class
        );

        if(fakeStoreCartDTO == null) {
            return new Cart();
        }
//
        Cart cart = new Cart();
        cart.setId(fakeStoreCartDTO.getId());
        cart.setUserId(fakeStoreCartDTO.getUserId());
        cart.setDate(fakeStoreCartDTO.getDate());
        return cart;

    }

    @Override
    public Cart createCart(Cart product) {
        String url = "https://fakestoreapi.com/carts";

        FakeStoreCartDTO fakeStoreCartDTO = new FakeStoreCartDTO();
        Cart cart = new Cart();
        cart.setId(fakeStoreCartDTO.getId());
        cart.setUserId(fakeStoreCartDTO.getUserId());
        cart.setDate(fakeStoreCartDTO.getDate());

        restTemplate.postForObject(
                url,
                fakeStoreCartDTO,
                FakeStoreCartDTO.class
        );
        return product;
    }

    @Override
    public String updateCart(Long id, Cart cart) {
        FakeStoreCartDTO fakeStoreCartDTO = new FakeStoreCartDTO();
        cart.setId(fakeStoreCartDTO.getId());
        cart.setUserId(fakeStoreCartDTO.getUserId());
        cart.setDate(fakeStoreCartDTO.getDate());

        String url = "https://fakestoreapi.com/carts/" + id;

        restTemplate.put(
                url,
                fakeStoreCartDTO
        );

        return "Cart with id " + id + " updated successfully.";

    }

    @Override
    public String deleteCart(Long id) {
        String url = "https://fakestoreapi.com/carts/" + id;
        restTemplate.delete(url);
        return "Cart with id " + id + " deleted successfully.";
    }
}
