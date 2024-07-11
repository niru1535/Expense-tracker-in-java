

Create servlets to handle adding and viewing expenses.




package servlet;

import dao.ExpenseDAO;
import model.Expense;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/addExpense")
public class AddExpenseServlet extends HttpServlet {
    private ExpenseDAO expenseDAO;

    public void init() {
        expenseDAO = new ExpenseDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String category = request.getParameter("category");
        double amount = Double.parseDouble(request.getParameter("amount"));
        String date = request.getParameter("date");

        Expense newExpense = new Expense(0, category, amount, date);
        try {
            expenseDAO.insertExpense(newExpense);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("viewExpenses");
    }
}
