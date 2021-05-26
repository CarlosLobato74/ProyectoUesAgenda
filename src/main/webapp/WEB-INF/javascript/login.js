
      
function enviar() {
    var usuario = document.getElementById("userId").value;
    var contra = document.getElementById("contraseniaId").value;
     
    if( usuario === "" && contra === ""){
        alert("Los campos no an sido llenados");
    }else if( usuario == "" ||  contra = ""){
          alert("El usuario o contrasenia no se especifico");
    }else {
         document.formu.submit();
    }
    
}





