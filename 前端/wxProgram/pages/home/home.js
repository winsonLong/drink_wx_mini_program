// pages/home/home.js
import request from '../../service/network.js'
Page({
  data: {
    name: 'Coderwhy',
    age: 23,
    movies: [],
    count: 0
  },
  click(){
    this.setData({
      count: this.data.count+1
    })
  },
  gotoOrder(){
    wx.navigateTo({
      url: '/pages/order_detail/order_detail',
    })
  },
  onLoad: function(){
    request({
      
    }).then(res=>{
      console.log(res);
    }).catch(err=>{
      console.log('请求失败')
    })
    
  }
  
})