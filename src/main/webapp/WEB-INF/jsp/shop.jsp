<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <span>My Item list?</span>
                <div><table>
                        <th>type</th>
                        <th>price</th>
                        <th>cost</th>
                        
                        <c:forEach var="item" items="${items}">
                            <tr><td>${item.type}</td><td>${item.price}</td><td>${item.cost}</td></tr>
                        </c:forEach>
                    </table>
                </div>
    </body>
</html>
