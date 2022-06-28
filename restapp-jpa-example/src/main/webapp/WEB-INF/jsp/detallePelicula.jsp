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
		<title>Películas</title>
	
		<link
			href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
			rel="stylesheet"
			integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
			crossorigin="anonymous">
	
	</head>

	<body>
	
		<div class="page-header">
			<h1 class="text-center">Base de datos de películas</h1>
		</div>
	
		<br />
	
		<div class="row">
			<div class="col-sm-1"></div>
			<form:form id="formularioPelicula" method="post"
				modelAttribute="pelicula" action="guardar-pelicula"
				cssClass="col-sm-10 form-horizontal">
				<form:hidden path="id"/>
				<div class="form-group">
					<label class="control-label col-sm-2" for="titulo">Título</label>
					<div class="col-sm-8">
						<form:input path="titulo" type="text" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="director">Director</label>
					<div class="col-sm-8">
						<form:input path="director" type="text" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="genero">Genero</label>
					<div class="col-sm-8">
						<form:input path="genero" type="text" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="estreno">Estreno</label>
					<div class="col-sm-8">
						<form:input path="fechaEstreno" type="text" class="form-control" />
					</div>
				</div>
				<div class="col-sm-1"></div>
			</form:form>
		</div>
	
		<br />
	
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="text-center col-sm-10">
				<input type="button" id="btnGuardar" class="btn btn-primary" value="Guardar" />
			</div>
			<div class="col-sm-1"></div>
		</div>
	
		<spring:url value="/nueva-pelicula" var="nuevaPelicula" />
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
				
			    $("#btnGuardar").click( function() {
					$("form").submit();
				});
	
			});
		
		</script>
	
	</body>
</hmtl>