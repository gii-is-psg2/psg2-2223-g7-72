<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<!-- %@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %-->  

<petclinic:layout pageName="home">
    <h1><fmt:message key="welcome"/></h1>
<%--     <div class="row">
        <div class="col-md-12">
            <spring:url value="/resources/images/lola2.png" htmlEscape="true" var="petsImage"/>
            <img class="img-responsive" src="${petsImage}"/>
        </div>
    </div> --%>
    <div class="row">
  		<div class="col-sm-6 col-md-4">
    		<div class="thumbnail">
      			<img src="/resources/images/cuadro1.jpg" alt="cuadro1">
      			<div class="caption">
        			<h3>Quienes somos</h3>
        			<p>Somos una empresa de veterinaria, amante de los animales y con gran cualificación. Atendemos cualquier tipo de dolencia o mal estar de su mascota pero también somos muy buenos en los momentos más complicados</p>
      			</div>
    		</div>
  		</div>
  		<div class="col-sm-6 col-md-4">
    		<div class="thumbnail">
      			<img src="/resources/images/cuadro2.jpg" alt="cuadro2">
      			<div class="caption">
        			<h3>Años de experiencia</h3>
        			<p>Más de 20 años de experiencia en nuestro trabajo. Además de la profesionalidad que nos abala también utilizamos las mejores tecnologías en veterinaria.</p>
      			</div>
    		</div>
  		</div>
  		<div class="col-sm-6 col-md-4">
    		<div class="thumbnail">
      			<img src="/resources/images/cuadro3.jpg" alt="cuadro3">
      			<div class="caption">
        			<h3>El mejor trato</h3>
        			<p>Tenemos el mejor trato tanto para el cliente como para su mascota. Nuestros clientes siempre nos vuelven a elegir como su veterinario de confianza.</p>
      			</div>
    		</div>
  		</div>
	</div>
</petclinic:layout>
