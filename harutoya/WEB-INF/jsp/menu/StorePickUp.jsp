<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>メニュー</title>
</head>
    <body>
        <div>
            <table>
                
                <form method="POST" action="snext">
                    <c:forEach var="prof" items="${product}">
                        <tr>                        
                            <td>
                                ${prof.st_name}
                            </td>
                            <td>
                                ${prof.st_address}
                            </td>
                            <td>
                                ${prof.st_phone}
                            </td>
                            <td>
                                ${prof.st_hours}
                            </td>
                            <!-- <td>
                                <input type="date" name="date" value="">
                                <input type="time" name="time" value="">
                            </td> -->
                            <td>
                                <input type="hidden" name="st_name" value="${prof.st_name}">
                                <input type="hidden" name="store" value="${prof.st_id}">
                                <input type="submit" value="次へ">
                            </td>
                        </tr>                                        
                    </c:forEach>
                </form>
            </table>
        </div>
    </body>
</html>