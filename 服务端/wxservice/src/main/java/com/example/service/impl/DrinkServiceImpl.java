package com.example.service.impl;

import com.example.mapper.DrinkMapper;
import com.example.pojo.Drink;
import com.example.pojo.DrinkExample;
import com.example.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class DrinkServiceImpl implements DrinkService {

    @Autowired(required = false)
    private DrinkMapper drinkMapper;

    @Override
    public List<Drink> getDrinks(String drinkId,String name) {
        DrinkExample drinkExample=new DrinkExample();
        DrinkExample.Criteria criteria=drinkExample.createCriteria();
        criteria.andDrinkidLike(generateLike(drinkId));
        if(!StringUtils.isEmpty(name)){
            criteria.andNameLike(generateLike(name));
        }
        List<Drink> drinks=drinkMapper.selectByExample(drinkExample);
        return drinks;
    }

    private String generateLike(String str){
        return "%"+str+"%";
    }

}
