<%@page pageEncoding="Windows-31J" contentType="text/html; charset=Windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>メニュー</title>
</head>
    <body>
        <div>
            <table>
                <tr>
                    <c:forEach var="prof" items="${product}">
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
                                
                    </c:forEach>
                </tr>
            </table>
        </div>
    </body>
</html>