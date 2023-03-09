<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<petclinic:layout pageName="notification">
	<jsp:body>
		<h2>
            <c:if test="${notification['new']}"><fmt:message key="newNotification"/> </c:if> 
        </h2>
        <form:form modelAttribute="notification" class="form-horizontal">
        	<input type="hidden" name="id" value="${notification.id}"/>
        		<div class="form-group">
                    <label class="col-sm-2 control-label"><fmt:message key="owner"/></label>
                    <div class="col-sm-10">
                        <c:out value="${owner.firstName} ${owner.lastName}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Pet</label>
                    <div class="col-sm-10">
                        <c:out value="${pet.name}"/>
                    </div>
                    
                </div>
        	<div class="form-group has-feedback">
        		<petclinic:inputField label="Solicitud" name="solicitud"/>
        	</div>
        	<div class="form-group">
        		<div class="col-sm-offset-2 col-sm-10">
                    <c:choose>
                        <c:when test="${notification['new']}">
                            <button class="btn btn-default" type="submit"><fmt:message key="addNotification"/></button>
                        </c:when>
                        <c:otherwise>
                            <button class="btn btn-default" type="submit"><fmt:message key="updateNotification"/></button>
                        </c:otherwise>
                    </c:choose>
                </div>
        	</div>
        </form:form>
        <c:if test="${!notification['new']}">
        </c:if>
	</jsp:body>
</petclinic:layout>