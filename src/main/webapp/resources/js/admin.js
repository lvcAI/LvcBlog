
	// 防止页面后退
	history.pushState(null, null, document.URL);
    window.addEventListener('popstate', function () {
    history.pushState(null, null, document.URL);});
    
    var tagss = null;
	var tagsArray = new Array();
	// addpost
	function setTag2(tagName){
		var tags = document.getElementById("tags");
		var str =tags.value;
		if(str!=null && str!=""){
			if(str==tagName){
				document.getElementById("tags").value=tagName;
			}else{
				if(tagName!=tagss){
					
					for (var i=0;i<tagsArray.length;i++)
					{
						if(tagName==tagsArray[i]){
							return ;
						}
					}
					document.getElementById("tags").value=str+","+tagName;
				}
			}
		}else{
			document.getElementById("tags").value=tagName;
		}
		tagss=tagName;
		tagsArray.push(tagss);
		
	}
	
	
	
	function setCate2(cateName){
		var categories1 = document.getElementById("categories1");
		var str =categories1.value;
		if(str!=null && str!=""){
			
			if(str==cateName){
				document.getElementById("categories1").value=cateName;
			}else{
				document.getElementById("categories1").value=cateName;
			}
		}else{
			document.getElementById("categories1").value=cateName;
		}
		
	}
	
	function toggle(name){
		if(name=="tags"){
			document.getElementById('tag2box2').style.display='none';
			document.getElementById('tag2box1').style.display='block';
		}else if(name=="categories"){
			document.getElementById('tag2box1').style.display='none';
			document.getElementById('tag2box2').style.display='block';
		}else  if(name=="none"){
			document.getElementById('tag2box1').style.display='none';
			document.getElementById('tag2box2').style.display='none';
		}
		
	}
	
	function clearTags(){
		tagsArray=new Array();
	}


