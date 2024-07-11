
View Expenses: 

package servlet;

import dao.ExpenseDAO;
import model.Expense;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/viewExpenses")
public class ViewExpensesServlet extends HttpServlet {
    private ExpenseDAO expenseDAO;

    public void init() {
        expenseDAO = new ExpenseDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Expense> expenses = expenseDAO.selectAllExpenses();
        request.setAttribute("expenses", expenses);
        request.getRequestDispatcher("viewExpenses.jsp").forward(request, response);
    }
}
