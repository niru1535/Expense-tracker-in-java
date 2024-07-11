

ExpenseDAO class for database operations: 



package dao;

import model.Expense;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/expense_tracker";
    private String jdbcUsername = "root";
    private String jdbcPassword = "password";

    private static final String INSERT_EXPENSE_SQL = "INSERT INTO expenses (category, amount, date) VALUES (?, ?, ?)";
    private static final String SELECT_ALL_EXPENSES = "SELECT * FROM expenses";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertExpense(Expense expense) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EXPENSE_SQL)) {
            preparedStatement.setString(1, expense.getCategory());
            preparedStatement.setDouble(2, expense.getAmount());
            preparedStatement.setString(3, expense.getDate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Expense> selectAllExpenses() {
        List<Expense> expenses = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EXPENSES)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String category = rs.getString("category");
                double amount = rs.getDouble("amount");
                String date = rs.getString("date");
                expenses.add(new Expense(id, category, amount, date));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expenses;
    }
}
