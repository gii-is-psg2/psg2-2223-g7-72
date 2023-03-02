<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<petclinic:layout pageName="owners">

    <h2><fmt:message key="ownerInformation"/></h2>


    <table class="table table-striped">
        <tr>
            <th><fmt:message key="name"/></th>
            <td><b><c:out value="${owner.firstName} ${owner.lastName}"/></b></td>
        </tr>
        <tr>
            <th><fmt:message key="address"/></th>
            <td><c:out value="${owner.address}"/></td>
        </tr>
        <tr>
            <th><fmt:message key="city"/></th>
            <td><c:out value="${owner.city}"/></td>
        </tr>
        <tr>
            <th><fmt:message key="telephone"/></th>
            <td><c:out value="${owner.telephone}"/></td>
        </tr>
    </table>

    <spring:url value="{ownerId}/edit" var="editUrl">
        <spring:param name="ownerId" value="${owner.id}"/>
    </spring:url>
    <a href="${fn:escapeXml(editUrl)}" class="btn btn-default"><fmt:message key="editOwner"/></a>

    <spring:url value="{ownerId}/pets/new" var="addUrl">
        <spring:param name="ownerId" value="${owner.id}"/>
    </spring:url>
    <a href="${fn:escapeXml(addUrl)}" class="btn btn-default"><fmt:message key="addNewPet"/></a>

    <sec:authorize access="hasAuthority('admin')">
        <spring:url value="{ownerId}/delete" var="deleteUrl">
            <spring:param name="ownerId" value="${owner.id}"/>
        </spring:url>
        <a href="${fn:escapeXml(deleteUrl)}" class="btn btn-default">Delete Owner</a>
    </sec:authorize>

    <br/>
    <br/>
    <br/>
    <h2><fmt:message key="petsandVisits"/></h2>

    <table class="table table-striped">
        <c:forEach var="pet" items="${owner.pets}">

            <tr>
                <td valign="top">
                    <dl class="dl-horizontal">
                        <dt><fmt:message key="name"/></dt>
                        <dd><c:out value="${pet.name}"/></dd>
                        <dt><fmt:message key="birthDate"/></dt>
                        <dd><petclinic:localDate date="${pet.birthDate}" pattern="yyyy-MM-dd"/></dd>
                        <dt><fmt:message key="type"/></dt>
                        <dd><c:out value="${pet.type.name}"/></dd>
                    </dl>
                </td>
                <td valign="top">
                    <table class="table-condensed">
                        <thead>
                        <tr>
                            <th><fmt:message key="visitDate"/></th>
                            <th><fmt:message key="description"/></th>
                        </tr>
                        </thead>
                        <c:forEach var="visit" items="${pet.visits}">
                            <tr>
                                <td><petclinic:localDate date="${visit.date}" pattern="yyyy-MM-dd"/></td>
                                <td><c:out value="${visit.description}"/></td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td>
                                <spring:url value="/owners/{ownerId}/pets/{petId}/edit" var="petUrl">
                                    <spring:param name="ownerId" value="${owner.id}"/>
                                    <spring:param name="petId" value="${pet.id}"/>
                                </spring:url>
                                <a href="${fn:escapeXml(petUrl)}"><fmt:message key="editPet"/></a>
                            </td>
                            <td>
                                <spring:url value="/owners/{ownerId}/pets/{petId}/visits/new" var="visitUrl">
                                    <spring:param name="ownerId" value="${owner.id}"/>
                                    <spring:param name="petId" value="${pet.id}"/>
                                </spring:url>
                                <a href="${fn:escapeXml(visitUrl)}"><fmt:message key="addVisit"/></a>
                            </td>
                            <td>
                                <sec:authorize access="hasAuthority('admin')">
                                <spring:url value="/owners/{ownerId}/pets/{petId}/delete" var="deleteUrl">
                                    <spring:param name="ownerId" value="${owner.id}"/>
                                    <spring:param name="petId" value="${pet.id}"/>
                                </spring:url>
                                <a href="${fn:escapeXml(deleteUrl)}">Delete Pet</a>
                                </sec:authorize>
                            </td>
                             <td>
                          
                                <spring:url value="/owners/{ownerId}/{petId}/petHotels/new" var="petHotelUrl">
                                    <spring:param name="ownerId" value="${owner.id}"/>
                                    <spring:param name="petId" value="${pet.id}"/>
                                </spring:url>
                                <a href="${fn:escapeXml(petHotelUrl)}">Book a PetHotel</a>
                          
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>

        </c:forEach>
    </table>
    
    <br/>
    <br/>
    <br/>
    <c:if test="${owner.petHotels.size() != 0}">
    <h2>Pet Hotels</h2>
    
   
    <table class="table table-striped">
    	<c:forEach var="petHotel" items="${owner.petHotels }">
    	
    	<tr>
                <td valign="top">
                    <dl class="dl-horizontal">
                        <dt>Name</dt>
                        <dd><c:out value="${petHotel.pet.name}"/></dd>
                        <dt>Start</dt>
                        <dd><petclinic:localDate date="${petHotel.start}" pattern="yyyy-MM-dd"/></dd>
                        <dt>Finish</dt>
                        <dd><petclinic:localDate date="${petHotel.finish}" pattern="yyyy-MM-dd"/></dd>
                    </dl>
                </td>
                <td valign="top">
                    <table class="table-condensed">
                    	<tr>
                            <td>
                                <spring:url value="/owners/{ownerId}/{petId}/petHotels/{id}/edit" var="editPetHotelUrl">
                                    <spring:param name="ownerId" value="${owner.id}"/>
                                    <spring:param name="petId" value="${petHotel.pet.id}"/>
                                    <spring:param name="id" value="${petHotel.id}"/>
                                </spring:url>
                                <a href="${fn:escapeXml(editPetHotelUrl)}">Edit PetHotel</a>
                            </td>
                            <td>
                            <td>
                                <spring:url value="/owners/{ownerId}/{petId}/petHotels/{id}/delete" var="deletePetHotelUrl">
                                    <spring:param name="ownerId" value="${owner.id}"/>
                                    <spring:param name="petId" value="${petHotel.pet.id}"/>
                                    <spring:param name="id" value="${petHotel.id}"/>
                                </spring:url>
                                <a href="${fn:escapeXml(deletePetHotelUrl)}">Delete PetHotel</a>
                            </td>
                        </td>
                    </table>
                </td>
       </tr>
       </c:forEach>
   </table>
   </c:if> 	

    

</petclinic:layout>
