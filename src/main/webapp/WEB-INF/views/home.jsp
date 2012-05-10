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
        <script src="http://ajax.googleapis.com/ajax/libs/dojo/1.7.2/dojo/dojo.js"></script>
        <script>
            require(["dojo/ready","dojo/_base/connect"],function(ready,connect) {
                ready(function () {
                    var addDummyLink = dojo.byId("addDummyMail");
                    connect.connect(addDummyLink,"onclick",function() {
                        var xhrArgs = {
                            url: "${pageContext.request.contextPath}/addDummyMail",
                            handleAs: "json"
                        }
                        var deferred = dojo.xhrPost(xhrArgs);
                    });                    
                });            
            });
        </script>
    </head>
    <body>
        <header>
            <h1>Mail Tester</h1>
        </header>
        <section>
            <header>
                <h2>Received Mails</h2>
            </header>
            <p><a href="#addDummyMail" id="addDummyMail">Add dummy mail</a></p>
            <c:forEach items="${wiserMessages}" var="em">
                <article>
                    <h3>${em.mimeMessage.subject}</h3>
                    <p>${em.envelopeSender}</p>
                    <p>${em.envelopeReceiver}</p>
                </article>
            </c:forEach>
        </section>
        <footer>
            <p>
                <small>Copyright to Bajoneando</small>
            </p>
        </footer>
    </body>
</html>