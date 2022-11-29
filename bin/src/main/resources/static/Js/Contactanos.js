var form=document.getElementById("contact-form");

var btn=document.getElementById("btn");
btn.onclick=function(){
	let nombre,correo,asunto,mensaje,expreg,entrar,error;
	nombre=document.getElementById("txtnombre").value;
	correo=document.getElementById("txtcorreo").value;
	asunto=document.getElementById("txtasunto").value;
	mensaje=document.getElementById("mensaje").value;
	entrar=false;
	error=""
	expreg=/^[a-zA-Z\s]+$/
	if (expreg.test(nombre)==false) {
		error+="Ingrese el nombre correctamente\n";
		entrar=true;
	}
	expreg=/^[a-zA-Z_0-9-]+\@\w+\.[a-z]/;
	if (expreg.test(correo)==false) {
		error+="Ingrese correo correctamente\n";
		entrar=true;
	}
	expreg=/^[a-zA-Z\s0-9]+$/;
	if (expreg.test(asunto)==false) {
		error+="Ingrese asunto correctamente\n"
		entrar=true;
	}
	if(entrar==true){
		alert(error)
	}else{
		alert("Datos enviados correctamente");
		form.submit();
	}
	}
	
