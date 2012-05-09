<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Mail Tester</title>
    </head>
    <body>
        <c:forEach items="${wiserMessages}" var="em">
            <p>${em.envelopeSender}</p>
            <p>${em.envelopeReceiver}</p>
            <p>${em.mimeMessage.content}</p>
        </c:forEach>
    </body>
</html>