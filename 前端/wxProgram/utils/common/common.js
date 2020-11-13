//时间格式
function formatDate(date){
  var typeDate = date.toJSON().substr(0, 19).replace('T', ' ');;
  return typeDate;
  }
