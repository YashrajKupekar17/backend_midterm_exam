package com.example.cartservices.DTOs;

import com.example.cartservices.models.Products;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class FakeStoreCartDTO {
    Long id;
    Long userId;
    String date;
    List<Products> products;
//    id:5,
//    userId:1,
//    date:...,
//    products:[...]
}
