package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.constant.CommonConstant;
import com.example.pojo.ResultMap;
import com.example.pojo.User;
import com.example.service.UserService;
import com.example.utils.MDUtil;
import com.example.utils.UrlUtil;
import com.example.vo.LoginUser;
import com.example.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = {"/user"})
public class UserController {

    @Autowired
    private UserService userService;

    private String appId="wx42dc6d07e991bb2a";

    private String appKey="cb9600332d327f5645e77b8a00e1c8b5";


    private JSONObject getUserWXLoginInfo(String wxCode) {
        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";
        Map<String,String> requestUrlParam = new HashMap<String,String>();
        requestUrlParam.put("appid", appId);	//开发者设置中的appId
        requestUrlParam.put("secret", appKey);	//开发者设置中的appSecret
        requestUrlParam.put("js_code", wxCode);	//小程序调用wx.login返回的code
        requestUrlParam.put("grant_type", "authorization_code");	//默认参数
        JSONObject jsonObject = JSON.parseObject(UrlUtil.doGet(requestUrl, requestUrlParam));
        return jsonObject;
    }

    @PostMapping("login")
    public ResultMap login(@RequestBody LoginUser loginUser) throws ParseException {
        //请求微信api获取用户的openid和sessionKey
        JSONObject jsonObject = getUserWXLoginInfo(loginUser.getCode());
        if(jsonObject!=null&&!jsonObject.containsKey("openid")) {
            return new ResultMap(CommonConstant.ERROR,CommonConstant.RESULT_ERROR);
        }
        String openid = (String)jsonObject.get("openid");
        String userId= MDUtil.getEncrpytedPassword(openid);
        User user=userService.getById(userId);
        if(user==null){
            userService.insert(userId,loginUser);
        }
        //String sessionKey = (String)jsonObject.get("session_key");
        return new ResultMap(CommonConstant.SUCCESS,CommonConstant.RESULT_SUCCESS,userId);
    }

    @GetMapping("userInfo")
    public ResultMap userInfo(@RequestParam("userId") String userId) {
        User user=userService.getById(userId);
        return new ResultMap(CommonConstant.SUCCESS,CommonConstant.RESULT_SUCCESS,user);
    }

    @PostMapping("update")
    public ResultMap update(@RequestBody UserVO userVO) {
        User user=userService.getById(userVO.getUserId());
        if(!StringUtils.isEmpty(userVO.getAddress())){
            user.setAddress(userVO.getAddress());
        }
        if(!StringUtils.isEmpty(userVO.getPhone())){
            user.setPhone(userVO.getPhone());
        }
        if(!StringUtils.isEmpty(userVO.getHomeNumber())){
            user.setHomenumber(userVO.getHomeNumber());
        }
        userService.update(user);
        return new ResultMap(CommonConstant.SUCCESS,CommonConstant.RESULT_SUCCESS,CommonConstant.UPDATE_USERINFO_SUCCESS);
    }

}
