//全局通用js

// 页面返回顶部图标按钮
	$('#back-to-top').click(function(){$('html,body').animate({scrollTop: '0px'}, 800);return false;});
	window.onscroll = function () {
	    if (document.documentElement.scrollTop + document.body.scrollTop > 100) {
	        document.getElementById("back-to-top").style.display = "block";
	    }
	    else {
	        document.getElementById("back-to-top").style.display = "none";
	    }
	};
	
//留言或评论框现先隐藏
	$("#writeGuest").click(function(){
		  $("#toggleGuest").toggle();
		});
	
	//留言的实现
	function send2(){
		
		var reg = /^\s*$/g;
		if(reg.test($('#userName').val()))
		{
			//alert("\u8bf7\u586b\u5199\u60a8\u7684\u59d3\u540d");
			$('#userName').focus()
			return false;
		}
		else if(!/^[u4e00-\u9fa5\w]{2,8}$/g.test($('#userName').val()))
		{
			//alert("\u59d3\u540d\u75312-8\u4f4d\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u3001\u6c49\u5b57\u7ec4\u6210\uff01");
			$('#userName').focus()
			return false;
		}
		
		var commnet={
				name:$('#userName').val(),
				email:$('#email').val(),
				context:$('#conBox').val(),
				state:0};
		//alert("请填写完整！");
		
			if($('#userName').val()!=null && $('#userName').val()!=""){
				//alert(commnet);
			$.post("<%= request.getContextPath()%>/comments/save",commnet,function(result,state){
				//alert(result+state);
			});			
			}else{
				//alert("请填写完整！");
				return false;
			}
	}
	
	//发送评论
	function send2(){
		
		var reg = /^\s*$/g;
		if(reg.test($('#userName').val()))
		{
			//alert("\u8bf7\u586b\u5199\u60a8\u7684\u59d3\u540d");
			$('#userName').focus()
			return false;
		}
		else if(!/^[u4e00-\u9fa5\w]{2,8}$/g.test($('#userName').val()))
		{
			//alert("\u59d3\u540d\u75312-8\u4f4d\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u3001\u6c49\u5b57\u7ec4\u6210\uff01");
			$('#userName').focus()
			return false;
		}
		
		var commnet={
				name:$('#userName').val(),
				email:$('#email').val(),
				context:$('#conBox').val(),
				state:1};
		//alert("请填写完整！");
		
			if($('#userName').val()!=null && $('#userName').val()!=""){
				//alert(commnet);
			$.post("<%= request.getContextPath()%>/comments/save",commnet,function(result,state){
				//alert(result+state);
			});			
			}else{
				//alert("请填写完整！");
				return false;
			}
	}

	