<%--
  Created by IntelliJ IDEA.
  User: 13326
  Date: 2020/2/11
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>增加</title>
</head>
<body>
<c:if test="${not empty li}">
    <table>
        <tr>
            <th>序号</th>
            <th>姓名</th>
            <th>生日</th>
            <th>兴趣</th>
            <th>手机号</th>
            <th>QQ</th>
            <th>相识时间</th>
        </tr>
        <c:forEach items="${li}" var="u">
            <tr>
                <td>${u.id}</td>
                <td>${u.userName}</td>
                <td>${u.birthDay}</td>
                <td>${u.interest}</td>
                <td>${u.phoneNumber}</td>
                <td>${u.qq}</td>
                <td>${u.createTime}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<c:if test="${empty li}">
    没有更多的人物
</c:if>
</body>
</html>
