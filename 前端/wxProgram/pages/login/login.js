// pages/login/login.js
import request from '../../service/network.js'
Page({

  /**
   * 页面的初始数据
   */
  data: {
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    isHide: false
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
   
  },

  bindGetUserInfo: function (e) {
    const userInfo = e.detail.userInfo
    if (e.detail.userInfo) {
      //用户按了允许授权按钮
      var that = this;
      // 获取到用户的信息了，打印到控制台上看下
      console.log("用户的信息如下：");
      console.log(e.detail.userInfo);
      wx.login({
        success: function(res) {
          request({
            url: '/user/login',
            data: {
              code: res.code,
              nickname: userInfo.nickName,
              city: userInfo.city,
              province: userInfo.province,
              avartar: userInfo.avatarUrl
            },
            method: 'post'
          }).then(res => {
            wx.setStorageSync('userId', res.data.result);
            console.log(wx.getStorageSync('userId'));
            wx.reLaunch({
              url: '/pages/home/home',
          });
            console.log(res.data.result);
          }).catch(err => {
            console.log('请求失败');
          })
        },
        fail: function(res) {},
        complete: function(res) {},
      })
      //授权成功后,通过改变 isHide 的值，让实现页面显示出来，把授权页面隐藏起来
      that.setData({
        isHide: false
      });
    } else {
      //用户按了拒绝按钮
      wx.showModal({
        title: '警告',
        content: '您点击了拒绝授权，将无法进入小程序，请授权之后再进入!!!',
        showCancel: false,
        confirmText: '返回授权',
        success: function (res) {
          // 用户没有授权成功，不需要改变 isHide 的值
          if (res.confirm) {
            console.log('用户点击了“返回授权”');
          }
        }
      });
    }
  }

})