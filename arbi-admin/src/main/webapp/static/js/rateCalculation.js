//仲裁费公共计算规则      
//涉案金额的ID=amounts 
//计算按钮onclick="arbitrationFee()" 
//仲裁费ID=arbitrationFee 仲裁费=处理费+受理费

	function arbitrationFee() {
	var amounts = $("#amounts").val(); // 获取当前涉案金额
	var handling = "500"; // 处理费固定 暂定500;
	var theFeeFor; // 受理费 受理费=涉案金额*仲裁案件受理费比例
	var number // 仲裁案件受理费比例

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
			.toFixed(2); // 仲裁费=处理费+受理费
	$("#arbitrationFee").text(arbitrationFee);

}

	
	//算出受理费
	function caseAdmissibleAmount(markAmount){
		var theFeeFor; // 受理费 受理费=涉案金额*仲裁案件受理费比例
		var number // 仲裁案件受理费比例
		
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
		
		return theFeeFor;
	}
	
	//返回处理费
	function handling(){
		return "500";
	}