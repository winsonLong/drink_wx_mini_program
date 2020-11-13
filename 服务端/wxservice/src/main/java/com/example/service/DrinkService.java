package com.example.service;

import com.example.pojo.Drink;

import java.util.List;

public interface DrinkService {

    List<Drink> getDrinks(String drinkId,String name);
}
