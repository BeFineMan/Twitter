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



