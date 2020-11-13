package com.example.controller;

import com.example.constant.CommonConstant;
import com.example.pojo.Drink;
import com.example.pojo.ResultMap;
import com.example.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = {"/drink"})
public class DrinkController {

    @Autowired
    private DrinkService drinkService;

    @GetMapping("getDrinks")
    public ResultMap getDrinks(@RequestParam("drinkId") String drinkId,@RequestParam("name") String name) {
        List<Drink> drinks=drinkService.getDrinks(drinkId,name);
        return new ResultMap(CommonConstant.SUCCESS,CommonConstant.SELECT_TYPEINFO_SUCCESS,drinks);
    }

    @GetMapping("searchDrinks")
    public ResultMap searchDrinks(@RequestParam("name") String name) {
        List<Drink> drinks=new ArrayList<>();
        if(!StringUtils.isEmpty(name)) {
            drinks = drinkService.getDrinks("", name);
        }
        int size=drinks.size();
        if(size>3){
            for (int i=3;i<size;i++){
                drinks.remove(3);
            }
        }
        return new ResultMap(CommonConstant.SUCCESS,CommonConstant.SELECT_TYPEINFO_SUCCESS,drinks);
    }

}
