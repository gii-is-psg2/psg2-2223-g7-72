<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<petclinic:layout pageName="petHotels">

	<jsp:attribute name="customScript">
		<script>
			$(function () {
				
				$("#start").datepicker({dateFormat: 'yy/mm/dd'});
				$("#finish").datepicker({dateFormat: 'yy/mm/dd'});
			});
		</script>
	</jsp:attribute>
	<jsp:body>
		<h2>
			<c:if test="${petHotel['new'] }"><fmt:message key="newPetHotel"/> </c:if> 
		</h2>
		
		<form:form modelAttribute="petHotel" class="form-horizontal" id="add-petHotel-form">
			<input type="hidden" name="id" value="${petHotel.id }"/>
			<div class="form-group has-feedback"> 
				<div class="form-group">
                    <label class="col-sm-2 control-label"><fmt:message key="owner"/></label>
                    <div class="col-sm-10">
                        <c:out value="${petHotel.owner.firstName} ${petHotel.owner.lastName}"/>
                    </div>
                    
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Pet</label>
                    <div class="col-sm-10">
                        <c:out value="${petHotel.pet.name}"/>
                    </div>
                    
                </div>
				 <petclinic:inputField label="Start" name="start"/>
				 <petclinic:inputField label="Finish" name="finish"/> 
			</div>
			<div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <c:choose>
                        <c:when test="${petHotel['new']}">
                        	<button class="btn btn-default" type="submit"><fmt:message key="addPetHotel"/></button>
                        </c:when>
                        <c:otherwise>
                            <button class="btn btn-default" type="submit"><fmt:message key="updatePetHotel"/></button>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </form:form>
	</jsp:body>

</petclinic:layout>