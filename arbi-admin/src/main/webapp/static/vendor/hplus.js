// Custom scripts
$(document).ready(function () {

	//判断是否收缩侧边栏
	//(function(){
	//	var $urlHash = window.location.hash;
	//	if($urlHash != ''){
	//		$("body").addClass("mini-navbar");
	//		SmoothlyMenu();
	//	}
	//})();
	
    // MetsiMenu
    $('#side-menu').metisMenu();

    // Collapse ibox function
    $('.collapse-link').click( function() {
        var ibox = $(this).closest('div.ibox');
        var button = $(this).find('i');
        var content = ibox.find('div.ibox-content');
        content.slideToggle(200);
        button.toggleClass('fa-chevron-up').toggleClass('fa-chevron-down');
        ibox.toggleClass('').toggleClass('border-bottom');
        setTimeout(function () {
            ibox.resize();
            ibox.find('[id^=map-]').resize();
        }, 50);
    });

    // Close ibox function
    $('.close-link').click( function() {
        var content = $(this).closest('div.ibox');
        content.remove();
    });

    // Small todo handler
    $('.check-link').click( function(){
        var button = $(this).find('i');
        var label = $(this).next('span');
        button.toggleClass('fa-check-square').toggleClass('fa-square-o');
        label.toggleClass('todo-completed');
        return false;
    });

    // Append config box / Only for demo purpose
    //$.get("skin-config.html", function (data) {
    //    $('body').append(data);
    //});

    // minimalize menu
    $('.navbar-minimalize').click(function () {
        $("body").toggleClass("mini-navbar");
        SmoothlyMenu();
    })

    // tooltips
    $('.tooltip-demo').tooltip({
        selector: "[data-toggle=tooltip]",
        container: "body"
    })

    // Move modal to body
    // Fix Bootstrap backdrop issu with animation.css
    $('.modal').appendTo("body")

    // Full height of sidebar
    function fix_height() {
        var heightWithoutNavbar = $("body > #wrapper").height() - 61;
        $(".sidebard-panel").css("min-height", heightWithoutNavbar + "px");
    }
    fix_height();

    // Fixed Sidebar
    // unComment this only whe you have a fixed-sidebar
                $(window).bind("load", function() {
                    if($("body").hasClass('fixed-sidebar')) {
                        $('.sidebar-collapse').slimScroll({
                            height: '100%',
                            railOpacity: 0.9,
                        });
                    }
                })

    $(window).bind("load resize click scroll", function() {
        if(!$("body").hasClass('body-small')) {
            fix_height();
        }
    })

    $("[data-toggle=popover]")
        .popover();
    
    
	// a链接跳转
	$('a').on('click',function(){
		var urlHash = window.location.hash;
		if(urlHash != ''){
			$(this).context.href = $(this).context.href + urlHash;
		}
	})
	
	//iconfont加载切换
	$('#side-menu > li').each(function(){
		if($(this).hasClass('active')){
			var usedClass = $(this).find('.hfqfont').attr('class').split(' ')[1];
			var dataClass = $(this).find('.hfqfont').attr('data-active');
			$(this).find('.hfqfont').removeClass(usedClass);
			$(this).find('.hfqfont').addClass(dataClass);
			$(this).find('.hfqfont').attr('data-active',usedClass);
		}
	})
	
	//iconfont点击切换
	$('#side-menu > li > a').mousedown(function(e){
		if(e.which == 1){
			$(this).parent('li').siblings('li').each(function(){
				if($(this).hasClass('active')){
					var $usedClass = $(this).find('a > .hfqfont').attr('class').split(' ')[1];
					var $dataClass = $(this).find('a > .hfqfont').attr('data-active');
					$(this).find('a > .hfqfont').removeClass($usedClass);
					$(this).find('a > .hfqfont').addClass($dataClass);
					$(this).find('a > .hfqfont').attr('data-active',$usedClass);
				}
			})
			var usedClass = $(this).find('.hfqfont').attr('class').split(' ')[1];
			var dataClass = $(this).find('.hfqfont').attr('data-active');
			$(this).find('.hfqfont').removeClass(usedClass);
			$(this).find('.hfqfont').addClass(dataClass);
			$(this).find('.hfqfont').attr('data-active',usedClass);
		}
	})
	//返回顶部js
	$(window).scroll(function () {
		var $top = $(window).scrollTop();
		if($top>0){
			$("#backTop").addClass("animate");
		}else{
			$("#backTop").removeClass("animate");
		}
	});
	$("#backTop").click(function(){
		backTop();
	});
});


// For demo purpose - animation css script
function animationHover(element, animation){
    element = $(element);
    element.hover(
        function() {
            element.addClass('animated ' + animation);
        },
        function(){
            //wait for animation to finish before removing classes
            window.setTimeout( function(){
                element.removeClass('animated ' + animation);
            }, 2000);
        });
}

// Minimalize menu when screen is less than 768px
$(function() {
    $(window).bind("load resize", function() {
        if ($(this).width() < 769) {
            $('body').addClass('body-small')
        } else {
            $('body').removeClass('body-small')
        }
    })
})

function SmoothlyMenu() {
    if (!$('body').hasClass('mini-navbar') || $('body').hasClass('body-small')) {
    	window.location.hash = '';
        // Hide menu in order to smoothly turn on when maximize menu
        $('#side-menu').hide();
        $('#index-word').hide();
        // For smoothly turn on menu
        setTimeout(
            function () {
                $('#side-menu').fadeIn(500);
                $('#index-word').fadeIn(500);
            }, 100);
    } else if ($('body').hasClass('fixed-sidebar')){
    	window.location.hash = '';
        $('#side-menu').hide();
        $('#index-word').hide();
        setTimeout(
            function () {
                $('#side-menu').fadeIn(500);
                $('#index-word').fadeIn(500);
            }, 300);
    } else {
    	window.location.hash = 'mini-navbar';
        // Remove all inline style from jquery fadeIn function to reset menu state
        $('#side-menu').removeAttr('style');
        $('#index-word').removeAttr('style');
    }
}

// Dragable panels
function WinMove() {
    var element = "[class*=col]";
    var handle = ".ibox-title";
    var connect = "[class*=col]";
    $(element).sortable(
        {
            handle: handle,
            connectWith: connect,
            tolerance: 'pointer',
            forcePlaceholderSize: true,
            opacity: 0.8,
        })
        .disableSelection();
};

function backTop () {
	$("body,html").stop().animate({"scrollTop": 0});
}

