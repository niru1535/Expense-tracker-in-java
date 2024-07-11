

JSP page for viewing Expenses:


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Expenses</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <h1>All Expenses</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Category</th>
            <th>Amount</th>
            <th>Date</th>
        </tr>
        <c:forEach var="expense" items="${expenses}">
            <tr>
                <td>${expense.id}</td>
                <td>${expense.category}</td>
                <td>${expense.amount}</td>
                <td>${expense.date}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="addExpense.jsp">Add New Expense</a>
</body>
</html>
