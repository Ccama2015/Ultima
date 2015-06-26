$(document).ready(function() {
	$('#registro').click(function() {
		var cui = $('#cui').val();
		var nombre = $('#nombre').val();
		var apellidoPaterno = $('#apellidoPaterno').val();
		var apellidoMaterno = $('#apellidoMaterno').val();
		var toString = "Cui = " + cui + "\n" + "Nombre = " + nombre + "\n" +
						"apellidoPaterno = " + apellidoPaterno + "\n" +
						"apellidoMaterno = " + apellidoMaterno + "\n" ;
		var result = window.confirm('¿Seguro que quiere Guardar?\n' + toString);
        if (result == false) {
            return;
        };
    	$.post('registroAlumnos',{"cui": cui, "nombre": nombre, "apellidoPaterno": apellidoPaterno, "apellidoMaterno": apellidoMaterno},
                function() { // on success
                    alert("Se Guardo .. Bien!");
                    window.location.href = "/index.jsp";
                })
                .fail(function() { //on failure
                	alert("Ups Error");
                });
	}); 
});