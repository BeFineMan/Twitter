function publish(){
	var publish_dynamic_form = document.getElementById("publish_dynamic_form");
	if(publish_dynamic_form != null){
		for(var i = 0; i < publish_dynamic_form.length; i++){
			console.log("name:"+publish_dynamic_form.elements[i].name+",value:"+publish_dynamic_form.elements[i].value
				+"type:"+publish_dynamic_form.elements[i].type
			);
		}
	}
};