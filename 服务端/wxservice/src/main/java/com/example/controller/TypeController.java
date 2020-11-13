package com.example.controller;

import com.example.constant.CommonConstant;
import com.example.pojo.Drink;
import com.example.pojo.ResultMap;
import com.example.service.TypeService;
import com.example.vo.TypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = {"/type"})
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("getTypes")
    public ResultMap getTypes() {
        List<TypeVO> types=typeService.getTypes();
        return new ResultMap(CommonConstant.SUCCESS,CommonConstant.RESULT_SUCCESS,types);
    }
}
