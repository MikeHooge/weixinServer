layui.use(['layer', 'form'], function(){
  var layer = layui.layer,
  $ =layer.jquery,
  form = layui.form();
  
  form.on('submit(login)',function(data){
	  layer.msg(JSON.stringify(data.field));
	  Location.href="#";
	  return false;
  });
});