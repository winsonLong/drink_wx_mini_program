export default function request(options){
  const ip ="http://10.3.96.69:8080";
 return new Promise((resolve,reject)=>{
   wx.request({
     url: ip+options.url,
     method: options.method || 'get',
     data: options.data || {},
     success: function (res) {
       resolve(res);
       //console.log(res.data.result);
     },
     fail: function (err) {
       reject(err);
      // console.log(err);
     }
   })
 })
}
