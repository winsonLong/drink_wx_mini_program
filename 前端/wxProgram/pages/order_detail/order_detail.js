// pages/order_detail/order_detail.js
import request from '../../service/network.js'

Page({

  /**
   * 页面的初始数据
   */
  data: {
    goods: {
      1: {
        id: 1,
        name: '奶茶三兄弟',
        pic: 'http://www.coco-tea.com.cn/images/product/%E9%86%87%E9%A6%99%E5%A5%B6%E8%8C%B6/%E7%8F%8D%E7%8F%A0%E5%A5%B6%E8%8C%B6460x460.png',
        price: 18
      }
    },
    searchGoods: {

    }
    ,
    goodsList: [],
    cart: {
      count: 0,
      total: 0,
      list: {}
    },
    cartList: {},
    showCartDetail: false,
    inputShowed: false,
    inputVal: ""
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    request({
      url: '/drink/getDrinks',
      data: {
        name: "",
        drinkId: ""
      },
      method: 'get'
    }).then(res => {
      this.setData({
        goods: res.data.result
      })
      console.log(this.data.goods);
    }).catch(err => {
      console.log("请求商品信息失败")
    })

    request({
      url: '/type/getTypes',
      method: 'get'
    }).then(res => {
      this.setData({
        goodsList: res.data.result,
      })
      this.setData({
        classifySeleted: this.data.goodsList[0].typeid
      });
      console.log(this.data.goodsList);
    }).catch(err => {
      console.log("请求商品类型失败")
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
    console.log(this.data.goods);
    
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
  // 开发者可以添加任意的函数或数据到
  //  object 参数中，在页面的函数中用 this 可以访问
  checkOrderSame: function (name) {
    var list = this.data.goods;
    for (var index in list) {
      if (list[index].name === name) {
        console.log(index);
        return index;
      }
    }
    return false;
  },
  tapAddCart: function (e) {
    this.addCart(e.target.dataset.id);
  
  },
  tapReduceCart: function (e) {
    this.reduceCart(e.target.dataset.id);
  },
  addCart: function (id) {
    console.log(id+"++++++"+this.data);
    var num = this.data.cart.list[id] || 0;
    this.data.cart.list[id] = num + 1;
    this.countCart();
    var price = this.data.goods[id].price;
    var name = this.data.goods[id].name;
    var img = this.data.goods[id].picurl;
    var list = this.data.cartList;
    var sortedList = [];
    var index;
    if (index = this.checkOrderSame(name)) {
      sortedList = list[index];
      var num = this.data.cart.list[id] || 0;
      num = num + 1;
    }
    else {
      var order = {
        "price": price,
        "num": 1,
        "name": name,
        'img': img,
        "shopId": this.data.shopId,
        "shopName": this.data.shop.restaurant_name,
        "pay": 0,
      }
      list.push(order);
      sortedList = order;
    }
    this.setData({
      cartList: list,
    });
    console.log(list)
  },
  reduceCart: function (id) {
    var num = this.data.cart.list[id] || 0;
    if (num <= 1) {
      delete this.data.cart.list[id];
    } else {
      this.data.cart.list[id] = num - 1;
    }
    this.countCart();
  },
  countCart: function (index, lists) {
    var count = 0,
      total = 0;
    var goods;
    for (var id in this.data.cart.list) {
      goods = this.data.goods[id];
      count += this.data.cart.list[id];
      total += goods.price * this.data.cart.list[id];
    }
    this.data.cart.count = count;
    this.data.cart.total = total;
    this.setData({
      cart: this.data.cart
    });
    // 存储订单页所需要的数据
    wx.setStorage({
      key: 'orderList',
      data: {
        count: this.data.cart.count,
        total: this.data.cart.total,
        list: this.data.cart.list,
      }
    })

  },
  follow: function () {
    this.setData({
      followed: !this.data.followed
    });
  },
  onGoodsScroll: function (e) {
    console.log(e.detail);
    /* var scale = e.detail.scrollWidth / 570,
      scrollTop = e.detail.scrollTop / scale,
      h = 0,
      classifySeleted,
      len = this.data.goodsList.length;
    this.data.goodsList.forEach(function (classify, i) {
      var _h = 70 + classify.drinkids.length * (46 * 3 + 20 * 2);
      if (scrollTop >= h - 100 / scale) {
        classifySeleted = classify.typeid;
      }
      h += _h;
    });
     */
    var scrollTop=e.detail.scrollTop;
    var h=0;
    var classifySeleted;
    this.data.goodsList.forEach(function (classify, i) {
      var _h = 34.4 + classify.drinkids.length * (65.8);
      if (scrollTop >= h) {
        classifySeleted = classify.typeid;
        console.log("h+:" + h);
      }
      h += _h;
      
    });
    this.setData({
      classifySeleted: classifySeleted
    });
  },
  tapClassify: function (e) {
    console.log(e.target);
    var id = e.target.dataset.id;
    this.setData({
      classifyViewed: id
    });
    var self = this;
    setTimeout(function () {
      self.setData({
        classifySeleted: id
      });
    }, 100);
  },
  showCartDetail: function () {
    this.setData({
      showCartDetail: !this.data.showCartDetail,
    });
  },
  hideCartDetail: function () {
    this.setData({
      showCartDetail: false,
      hidden: "false"
    });
  },
  submit: function (e) {
    const cart = this.data.cart;
    const goods = this.data.goods;
    wx.showModal({
      title: '提示',
      content: '确认下单吗？',
      success: function (res) {
        if (res.confirm) {
          
          var total = cart.total;
          const list = cart.list;
          console.log(list);
          var content = "";
          for (var id in list) {
            content += goods[id].name + "x" + list[id] + " ";
          }
          var userId_data = wx.getStorageSync("userId");
          request({
            url: '/order/create',
            data: {
              userId: userId_data,
              content: content,
              total: total
            },
            method: 'post',
          }).then(res => {
            wx.showToast({ title: '加载中', icon: 'loading', duration: 3000 });
           // wx.hideToast();
          var interval= setInterval(function (){
              wx.showToast({
              title: '下单成功',
              icon: 'success',
              duration: 2000
            })
              clearInterval(interval);
            },3000)
          })
        } else if (res.cancel) {
          console.log('用户点击取消')
        }
      }
    })
  },
  //搜索
  showInput: function () {
    this.setData({
      inputShowed: true
    });
  },
  hideInput: function () {
    this.setData({
      inputVal: "",
      inputShowed: false
    });
  },
  clearInput: function () {
    this.setData({
      inputVal: ""
    });
  },
  inputTyping: function (e) {
    this.setData({
      inputVal: e.detail.value
    });
    var value = e.detail.value;
    if(value!=null&&value!=""){
      request({
        url: '/drink/searchDrinks',
        data: {
          name: value
        },
        method: 'get'
      }).then(res => {
        if(res.data.result.length!=0){
        this.setData({
          searchGoods: res.data.result
        })
        console.log(this.data.searchGoods);
        }else{
          this.setData({
            searchGoods: [{name:"暂无相关商品信息"}]
          })
        }
       
      }).catch(err => {
        console.log("请求商品信息失败")
      })
    }
   
  },
  goToPosition: function(e){
   
    console.log(e.currentTarget.dataset.id);
    var name = e.currentTarget.dataset.id;
    var index=this.checkOrderSame(name)
    this.addCart(index);
  }
})
