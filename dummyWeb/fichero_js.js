// JavaScript Document

function valida_envia(){
	
	//alert("Empezamos a validar");
	
	//valido el nombre
    if (document.getElementById('usuario').value.length==0){
       alert("Error: Tiene que escribir su nombre de usuario")
       document.getElementById('usuario').focus()
       return false;
    }
	
	//valido contraseñas: mas de 6 caracteres, al menos un digito,una minuscula, una mayuscula  y ser igual a confirmar contraseña
	if(document.getElementById('pwd').value != "" && document.getElementById('pwd').value == document.getElementById('pwd2').value) {
      if(document.getElementById('pwd').value.length < 6) {
        alert("Error: la contraseña debe contener al menos 6 caracteres");
        document.getElementById('pwd').focus();
        return false;
      }
      re = /[0-9]/;
      if(!re.test(document.getElementById('pwd').value)) {
        alert("Error: la contraseña debe contener al menos un digito(0-9)");
        document.getElementById('pwd').focus();
        return false;
      }
      re = /[a-z]/;
      if(!re.test(document.getElementById('pwd').value)) {
        alert("Error: la contraseña debe contener al menos una letra minuscula (a-z)");
        document.getElementById('pwd').focus();
        return false;
      }
      re = /[A-Z]/;
      if(!re.test(document.getElementById('pwd').value)) {
        alert("Error: la contraseña debe contener al menos una letra mayuscula (A-Z)");
        document.getElementById('pwd').focus();
        return false;
      }
    } else {
      alert("Error de verificacion de contraseña: Por favor chequea los campos contraseña y confirmar Contraseña");
      document.getElementById('pwd').focus();
      return false;
    } 
	
	//validar mail
	expr = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		if ( !expr.test(document.getElementById('email').value) ){
			alert("Error: La dirección de correo " + document.getElementById('email').value + " es incorrecta.");
			document.getElementById('email').focus();
			return false;
			}
	//validar confirmar mail es igual a mail
	    if(document.getElementById('email').value !=   document.getElementById('email2').value) {
			alert("Error: Los campos email y confirmar email deben coincidir");
			document.getElementById('email2').focus();
			return false;
		  }
		  
	//validar sexo seleccionado
	if (document.getElementById('boy').checked==false && document.getElementById('girl').checked==false){
       alert("Error: Tiene que seleccionar su sexo")
       return false;
    }
	
	
	//valido localidad
    if (document.getElementById('localidad').value.length==0){
       alert("Error: Tiene que escribir su localidad")
       document.getElementById('localidad').focus()
       return false;
    }

     //valido provincia
    if (document.getElementById('provincia').value.length==0){
       alert("Error: Tiene que escribir su provincia")
       document.getElementById('provincia').focus()
       return false;
    }
	
	//valido pais
    if (document.getElementById('pais').value.length==0){
       alert("Error: Tiene que seleccionar su pais")
       return false;
    }
	
	//el formulario se envia
   //alert("Usuario registrado correctamente.");
    
	
	//OPCIONAL. submit del formulario mediante Javascript
	document.getElementById('formulario').submit();
	
}


function valida_campos_login(){
	
	//alert("Empezamos a validar campos login");
	
	//valido el nombre
    if (document.getElementById('usuario').value.length==0){
       alert("Error: Tiene que escribir su nombre de usuario")
       document.getElementById('usuario').focus()
       return false;
    }
	
	//valido contraseñas: mas de 6 caracteres, al menos un digito,una minuscula, una mayuscula  y ser igual a confirmar contraseña
	if(document.getElementById('pwd').value != "" && document.getElementById('pwd').value == document.getElementById('pwd2').value) {
      if(document.getElementById('pwd').value.length < 6) {
        alert("Error: la contraseña debe contener al menos 6 caracteres");
        document.getElementById('pwd').focus();
        return false;
      }
      re = /[0-9]/;
      if(!re.test(document.getElementById('pwd').value)) {
        alert("Error: la contraseña debe contener al menos un digito(0-9)");
        document.getElementById('pwd').focus();
        return false;
      }
      re = /[a-z]/;
      if(!re.test(document.getElementById('pwd').value)) {
        alert("Error: la contraseña debe contener al menos una letra minuscula (a-z)");
        document.getElementById('pwd').focus();
        return false;
      }
      re = /[A-Z]/;
      if(!re.test(document.getElementById('pwd').value)) {
        alert("Error: la contraseña debe contener al menos una letra mayuscula (A-Z)");
        document.getElementById('pwd').focus();
        return false;
      }
    } else {
      alert("Error de verificacion de contraseña: Por favor chequea los campos contraseña y confirmar Contraseña");
      document.getElementById('pwd').focus();
      return false;
    } 
	

	
	//el formulario se envia
    //alert("Muchas gracias. Login Correcto");
	return true;
	//OPCIONAL. submit del formulario mediante Javascript
	//document.getElementById('formulario').submit();
	
}


function valida_login(){
	
	//alert("Empezamos a validar  login");
	
	//valido el nombre
    if (valida_campos_login()){
		//alert("Dentro del IF");
		if (document.getElementById('usuario').value=="UnirTFGII"){
			//alert("Dentro del 2º IF");
			if (document.getElementById('pwd').value=="Unir.2018"){
					//alert("Dentro del 3º IF");
					document.getElementById('formulario1').submit();
				
			}else {
				alert("Error: Password Incorrecta")
				document.getElementById('pwd').focus()
				return false;
			}

        
		}else {
			alert("Error: Usuario Incorrecto")
			document.getElementById('usuario').focus()
			return false;
		}
      
    }else{
		//alert("Fuera del IF");
		return false;
	}
}

