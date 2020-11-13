// pages/address_info/address_info.js
import request from '../../service/network.js'
var QQMapWX = require('../../utils/common/qqmap-wx-jssdk.js');
var demo = new QQMapWX({
  key: 'WH4BZ-NBAR3-WQL32-YMGSO-WHQJ3-4IFFO' // 必填 
});
Page({

  /**
   * 页面的初始数据
   */
  data: {
    chooseAddress: "",
    homeNumber: "",
    phoneNumber: ""
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var userId=wx.getStorageSync("userId");
    request({
      url: "/user/userInfo",
      method: "get",
      data: {
        userId: userId
      }
    }).then(res=>{
      console.log(res.data.result);
      const result = res.data.result;
      console.log(result.address != null && result.homenumber != null)
      if(result.address!=null&&result.homenumber!=null){
        this.setData({
          chooseAddress: result.address,
          homeNumber: result.homenumber
        })
      }
      if (result.phone!=null) {
        this.setData({
          phoneNumber: result.phone
        })
      }
    }).catch(err=>{
      console.log("获取结果失败");
    })
  },
  //移动选点
  onChangeAddress: function () {
    var _page = this;
    wx.chooseLocation({
      success: function (res) {
        _page.setData({
          chooseAddress: res.name
        });
      },
      fail: function (err) {
        console.log(err)
      }
    });
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },
  submit: function(e){
    console.log(e.detail.value);
    const value = e.detail.value;
    var address=value.address;
    var homeNumber=value.homeNumber;
    var phone=value.phone;
    var userId = wx.getStorageSync("userId");
    request({
      url: "/user/update",
      method: "post",
      data: {
        userId: userId,
        address: address,
        homeNumber: homeNumber,
        phone : phone
      }
    }).then(res => {
      console.log(res)
      wx.showToast({
        title: '保存成功',
        icon: 'success',
        duration: 2000
      })
      wx.navigateBack({
        delta: 1
      })
    })
  }
})