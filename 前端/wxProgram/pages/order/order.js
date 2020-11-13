// pages/order/order.js
import request from '../../service/network.js'
import common from '../../utils/common/common.js'
Page({

  /**
   * 页面的初始数据
   */
  data: {
    orders:{}
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var userId=wx.getStorageSync("userId");
    request({
        url: "/order/getOrders",
        data: {
          userId: userId
        },
        method: "get" 
    }).then(res=>{
      const result = res.data.result;
      console.log(result[0])
      for(var i in result){
        var date=result[i].date
        console.log(date)
        date=date.substr(0, 19).replace('T', ' ');
        result[i].date=date;
      }
      console.log(result)
      this.setData({
        orders: result
      })
      console.log(this.data.orders);
    }).catch(err=>{
      console.log("请求异常")
    })

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
  gotoOrder() {
    wx.navigateTo({
      url: '/pages/order_detail/order_detail',
    })
  }
})