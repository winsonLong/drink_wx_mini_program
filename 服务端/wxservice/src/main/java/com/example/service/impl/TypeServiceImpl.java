package com.example.service.impl;

import com.example.mapper.TypeMapper;
import com.example.pojo.Type;
import com.example.pojo.TypeExample;
import com.example.service.TypeService;
import com.example.vo.TypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public List<TypeVO> getTypes() {
        TypeExample typeExample=new TypeExample();
        TypeExample.Criteria criteria=typeExample.createCriteria();
        criteria.andTypeidIsNotNull();
        List<Type> types=typeMapper.selectByExample(typeExample);
        List<TypeVO> typeVOS=new ArrayList<>();
        types.stream().forEach(type -> {
            String[] ids=type.getDrinkids().split(",");
            TypeVO typeVO=new TypeVO();
            typeVO.setDrinkids(ids);
            typeVO.setName(type.getName());
            typeVO.setTypeid(type.getTypeid());
            typeVOS.add(typeVO);
        });
        return typeVOS;
    }
}
