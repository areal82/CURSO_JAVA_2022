<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Peliculas</title>
	
		<link
			href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
			rel="stylesheet"
			integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
			crossorigin="anonymous">
		<link rel="stylesheet" href="css/bootstrap-theme.min.css">
	
	</head>

	<body>
		<spring:url value="/nueva-pelicula" var="nuevaPelicula" />
		<spring:url value="/modificar-pelicula" var="modificarPelicula" />
		<spring:url value="/eliminar-pelicula" var="eliminarPelicula" />
		
		<div class="page-header">
			<h1 class="text-center">Base de datos de películas</h1>
		</div>
	
		<div class="row">
	        <div class="col-xs-1"></div>  
	        <div class="text-center col-xs-10">  
	            <input type="button" id="btnNueva"  class="btn btn-primary" value="Nueva"/>
	        </div>
	        <div class="col-xs-1"></div>  
    	</div>
	
		<br />
	
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-10">
				<table class="table table-hover table-striped">
					<thead>
						<tr>
							<th>Título</th>
							<th>Director</th>
							<th>Genero</th>
							<th>Estreno</th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody id="tablaPeliculas"></tbody>
					<c:forEach items="${peliculas}" var="pelicula" varStatus="loop">
						<tr id="pelicula_${pelicula.id}" role="row" data-id="${pelicula.id}">
							<td><spring:eval expression="pelicula.titulo" /></td>
							<td><spring:eval expression="pelicula.director" /></td>
							<td><spring:eval expression="pelicula.genero" /></td>
							<td><spring:eval expression="pelicula.fechaEstreno" /></td>
							<td><input type="button" class="btn btn-primary" 
									value="Modificar" onclick="window.location.href = '${modificarPelicula}'+'?idPelicula='+'${pelicula.id}';"/>
							</td>
							<td><input type="button" class="btn btn-primary btn-eliminar" value="Eliminar"/>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="col-sm-1"></div>
		</div>
	
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
			integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ=="
			crossorigin="anonymous" referrerpolicy="no-referrer"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
			crossorigin="anonymous"></script>
			
		<script type="text/javascript">
			$(document).ready(function() {
				
			    $("#btnNueva").click(function(e){window.location.href = "${nuevaPelicula}";});
			    
			    $(".btn-eliminar").click(function(e){
			    	var eliminarPelicula = "${eliminarPelicula}";
			    	var idPelicula = $(this).parents("tr").data("id");
			    	
			    	$.ajax({
			             type: "DELETE",
			             url: eliminarPelicula+"?idPelicula="+idPelicula,
			             success: function (data) {
			            	 $('#pelicula_'+idPelicula).remove();
			             },
			             error: function (e) {
			            	 alert("Error al eliminar la pelicula: " + e);
			             }
					});
			    	
			    });
	
			});
		
		</script>
	
	</body>
</hmtl>