
Create JSP pages for adding and viewing expenses:



<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Expense</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <h1>Add Expense</h1>
    <form action="addExpense" method="post">
        <label for="category">Category:</label>
        <input type="text" id="category" name="category" required><br>
        <label for="amount">Amount:</label>
        <input type="number" step="0.01" id="amount" name="amount" required><br>
        <label for="date">Date:</label>
        <input type="date" id="date" name="date" required><br>
        <input type="submit" value="Add Expense">
    </form>
    <a href="viewExpenses">View All Expenses</a>
</body>
</html>
