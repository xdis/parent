/* =================================================
//
// author : peng
// 封装公共请求
//
// =================================================*/
Request = {};
//ajax加载内容区
Request.loadMain = function(options){
    var loadLayerIdx = layer.load(2);
	if(!options.url){
		return ;
	}
	$.ajax({
		url:cxt+options.url,
		type:"post",
		data:options.params,
		success:typeof(eval(options.success)) == "function"?options.success:function(data){
			if(options.container){
                $(options.container).html(data);
			}else{
				$("#main").html(data);
                if(options.max){
                    $(".z-main>.zhong-left").html($("#main .zhong-left").html());
                    $("#main .zhong-left").remove();
                }
            }
            layer.close(loadLayerIdx);
		},
        error:function(){
            layer.close(loadLayerIdx);
            layer.msg("操作失败, 请重试!",{time:1000});
        }
	});
};