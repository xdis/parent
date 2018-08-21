
function setTime(om,index,timerArr,status){

	//补零
	function toDub(n){
	    return n<10?"0"+n:""+n;
	}
	if(status!='0'){
		$('.timeSet'+index).parent('tr').css("background-color","none");
    	$('.timeSet'+index).parent('tr').find('td').css("color","none");
		return;
	}
	
   var n = 0;
   var timer=setInterval(function () {
//    	console.log(om);
    	
    	om = om.replace(/\-/g, "/");
    	var endTime = new Date(om);//结束时间
//    	console.log(om);
    	//这里有个Safir的神坑 不识别2016-05-31 08:00这种日期格式
    	
    	var curTime = new Date();//当前时间
    	

    	var leftTime = parseInt((endTime.getTime() - curTime.getTime())/1000);//获得时间差

//    	console.log('leftTime='+leftTime);
/*    	var leftsecond = parseInt(leftTime/1000); */
    	//var day1=parseInt(leftsecond/(24*60*60*6)); 
    	
    	
		//小时、分、秒需要取模运算
		var d = parseInt(leftTime/(60*60*24));
		var h = parseInt(leftTime/(60*60)%24);

		var m = parseInt(leftTime/60%(24*60)%60);

		var s = parseInt(leftTime%60);
		var ms = parseInt(((endTime.getTime() - curTime.getTime())/100)%10);
    	
    	/*var day1=Math.floor(leftsecond/(60*60*24)); 
    	var m=Math.floor((leftsecond-day1*24*60*60)/3600); 
    	var s=Math.floor((leftsecond-day1*24*60*60-m*3600)/60); 
    	var ms=Math.floor(leftsecond-day1*24*60*60-m*3600-s*60); */
        n++;
      /*  var m = om - parseInt(parseInt(n/60)/60);
        var s = 59 - parseInt(parseInt(n/60)%60);
        var ms=parseInt(n%60);*/
       /* $('.m').text(toDub(m));
        $('.s').text(toDub(s));
        $('.ms').text(toDub(ms));*/
        var countDownTime='';
        if(d>0){
        	countDownTime+=d+'天';
        }
        
        if(h>0){
        	countDownTime+=h+'时';
        }
        
        if(m>0){
        	countDownTime+=toDub(m)+'分';
        }
        
        if(s>0){
        	countDownTime+=toDub(s)+'秒';
        }
        
        if(d<=0&&h<=0&&m<=0&&s<=0){
        	countDownTime+='0';
        }
        
        $('.timeSet'+index).text(countDownTime);

        if(d == 0 && h<=24){
        	$('.timeSet'+index).parent('tr').css("background-color","yellow");
        }
        
//        console.log(m);
        if(d<=0 && h<=0 && m<=0 && s<=0  ){
        	$('.timeSet'+index).parent('tr').css("background-color","none");
        	$('.timeSet'+index).parent('tr').find('td').css("color","red");
            clearInterval(timer);
        }
    },1000/60);
   timerArr.push(timer);
   //return d+"天"+h+"小时"+m+"分"+s+"秒";
}




Date.prototype.Format = function (fmt) { //author: meizz 
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}