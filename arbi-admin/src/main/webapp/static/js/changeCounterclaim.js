//变更仲裁请求仲裁费公共计算规则      
//涉案金额的ID=amounts 
//计算按钮onclick="arbitrationFee()" 
//仲裁费ID=arbitrationFee 仲裁费=处理费+受理费
//a 代表指定案件所有变更仲裁请求应缴费的集合
//b 代表请求立案受理费
//c 代表请求立案的处理费
	function arbitrationFee(a,b,c) {
		
	var amounts = $("#amounts").val(); // 获取当前涉案金额
	var handling = "500"; // 处理费固定 暂定500;
	var theFeeFor; // 受理费 受理费=涉案金额*仲裁案件受理费比例
	var number // 仲裁案件受理费比例
	var paymentShouldBeList=a;
	var paymentShouldBeTotal=0;//所有已经通过的仲裁请求应缴费总和
	var payment  //本次变更仲裁请求应补缴费用
	var requestPayment=parseFloat(b)+parseFloat(c);
	if(paymentShouldBeList!=null){
		
		for (var int = 0; int < paymentShouldBeList.length; int++) {
			var paymentShouldBe = paymentShouldBeList[int];
		
			paymentShouldBeTotal=parseFloat(paymentShouldBeTotal)+parseFloat(paymentShouldBe);
		}
	}
	
	if (parseFloat(amounts) <= 1000) {
		theFeeFor = 100;
	}

	if (1001 < parseFloat(amounts) && parseFloat(amounts) <= 50000) {
		number = 0.05;
		theFeeFor = parseFloat(amounts) * parseFloat(number);
	}

	if (50001 < parseFloat(amounts) && parseFloat(amounts) <= 100000) {
		number = 0.04;
		theFeeFor = parseFloat(amounts) * parseFloat(number);
	}

	if (100001 < parseFloat(amounts) && parseFloat(amounts) <= 200000) {
		number = 0.03;
		theFeeFor = parseFloat(amounts) * parseFloat(number);
	}

	if (200001 < parseFloat(amounts) && parseFloat(amounts) <= 500000) {
		number = 0.02;
		theFeeFor = parseFloat(amounts) * parseFloat(number);
	}

	if (500001 < parseFloat(amounts) && parseFloat(amounts) <= 1000000) {
		number = 0.01;
		theFeeFor = parseFloat(amounts) * parseFloat(number);

	}

	if (1000001 < parseFloat(amounts)) {
		number = 0.005;
		theFeeFor = parseFloat(amounts) * parseFloat(number);
	}

	var arbitrationFee = (parseFloat(handling) + parseFloat(theFeeFor))
			.toFixed(2); // 合计=受理费+处理费
	$("#arbitrationFee").text(arbitrationFee);//合计
	
	theFeeFor=parseFloat(theFeeFor).toFixed(2);
	handling=parseFloat(handling).toFixed(2);
	$("#theFeeFor").text(theFeeFor);//受理费
	$("#handling").text(handling);//处理费
	payment=(parseFloat(arbitrationFee)-parseFloat(paymentShouldBeTotal)-parseFloat(requestPayment)).toFixed(2);//本次应补缴费用=本次仲裁请求费-案件请求仲裁费-所有已通过变更仲裁请求应缴费
	if(parseFloat(payment)>0){
		$("#payment").text(payment);//应补缴	
		$("#prompting").text("");
	}else{
		
		$("#prompting").text("输入金额小于上一次仲裁费，有误，请重新输入");
		$("#payment").text("");//应补缴	
	}
	
	

}
