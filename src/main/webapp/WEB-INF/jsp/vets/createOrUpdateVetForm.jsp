<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="vets">
    <h2>
        <c:if test="${vetForm['new']}"><fmt:message key="newVet"/> </c:if> 
    </h2>
    <form:form modelAttribute="vetForm" class="form-horizontal" id="add-vet-form">
        <div class="form-group has-feedback">
            <petclinic:inputField label="Nombre" name="vet.firstName"/>
            <petclinic:inputField label="Apellidos" name="vet.lastName"/>
            <petclinic:selectField label="Especialidad" names="${specialties}" size="5" name="specialties" />
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${vetForm['new']}">
                        <button class="btn btn-default" type="submit"><fmt:message key="addVet"/></button>
                    </c:when>
                    <c:otherwise>
                        <button class="btn btn-default" type="submit"><fmt:message key="updateVet"/></button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
</petclinic:layout>
