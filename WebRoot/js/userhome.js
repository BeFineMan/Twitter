var xmlHttp;

function createXHR(){
	if (typeof XMLHttpRequest != "undefined"){
		return new XMLHttpRequest();
	} else if (typeof ActiveXObject != "undefined"){
		if (typeof arguments.callee.activeXString != "string"){
			var versions = [ "MSXML2.XMLHttp.6.0", "MSXML2.XMLHttp.3.0", "MSXML2.XMLHttp"],i,len;
			for(i = 0; i < versions.length ;i++){
				try{
					new ActiveXObject(versions[i]);
					arguments.callee.activeXString = version[i];
					break;
				}catch(ex){
					
				}
			}
		}
		return new ActiveXObject(arguments.callee.activeXString);
	}else{
		throw new Error("NO XHR object available.");
	}
}
function publish(){
	createXHR();
	xmlHttp.open("post","/Twitter/user/publishDynamic.log");
	xmlHttp.onreadystatechange = publishCallback;
	var publish_dynamic_form = document.getElementById("publish_dynamic_form");
	if(publish_dynamic_form != null){
		for(var i = 0; i < publish_dynamic_form.length; i++){
			console.log("name:"+publish_dynamic_form.elements[i].name+",value:"+publish_dynamic_form.elements[i].value
				+"type:"+publish_dynamic_form.elements[i].type);
		}
	}
};

function publishCallback(){
}
$(function(){
	var $test = function(){
		alert("打算大苏打111");
	};
	$test();
	//上传图片
	var $tgaUpload = $('#goodsUpload').diyUpload({
		url:'/Twitter/user/uploadIcon.log',
		success:function( data ) { 
			alert("啊啊啊啊");
		},
		error:function( err ) {
			alert("哦哦哦哦哦哦")
		},
		buttonText : '',
		accept: {
			title: "Images",
			extensions: 'gif,jpg,jpeg,bmp,png'
		},
		thumb:{
			width:120,
			height:90,
			quality:100,
			allowMagnify:true,
			crop:true,
			type:"image/jpeg"
		}
	});
	$tgaUpload();
});



