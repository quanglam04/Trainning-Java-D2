package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import Entity.User;
import Helper.DatabaseConnection;

public class UserDAO {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
    private static final String PASSWORD_REGEX = "^(?=.*[A-Z]).{6,12}$";
    private static final String FULLNAME_REGEX = "^[A-Za-z\\s]+$"; 
    String defaultPassword = "123456A";	

    
    public void createUser(Scanner scanner) throws SQLException
    {
    	System.out.println("Nhập họ tên User: ");
    	String fullName = scanner.nextLine().trim();
    	if(!Pattern.matches(FULLNAME_REGEX, fullName)) {
    		System.out.println("Tên không hợp lệ! Chỉ chứa chữ và không chứa bất kỳ ký tự đặc biệt nào");
    		return;
    	}
    	System.out.println("Nhập email của User:");
        String email = scanner.nextLine().trim();
    	if(!Pattern.matches(EMAIL_REGEX, email)) {
    		System.out.println("Email không hợp lệ");
    		return;
    	}
    	if(isEmailExists(email)) {
    		System.out.println("Email đã tồn tại. Vui lòng thứ lại với email khác");
    		return;
    	}
    	User newUser = new User(0, fullName, email, defaultPassword, "Employee");
    	System.out.println("Nhập kỹ năng chuyên môn của User:");
    	String proSkill = scanner.nextLine().trim();
    	insertUser(newUser, null, proSkill);
    }
    
    private boolean isEmailExists(String email) throws SQLException {
        String query = "SELECT COUNT(*) FROM Users WHERE email = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0; 
                }
            }
        }
        return false;
    }

    
    public void insertUser(User user, Integer expInYear, String proSkill) throws SQLException {
        String query = "INSERT INTO Users (fullName, email, password, role, expInYear, proSkill) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, user.getFullName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getRole());
            stmt.setObject(5, expInYear);
            stmt.setObject(6, proSkill);
            stmt.executeUpdate();
        }
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String query = "SELECT id, fullName, email, role FROM Users";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                users.add(new User(
                    rs.getInt("id"),
                    rs.getString("fullName"),
                    rs.getString("email"),
                    "", 
                    rs.getString("role")
                ));
            }
        }
        return users;
    }

    public User getUserById(int id) throws SQLException {
        String query = "SELECT * FROM Users WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("id"), rs.getString("fullName"), rs.getString("email"),
                        rs.getString("password"), rs.getString("role"));
            }
        }
        return null;
    }

    public void deleteUser(int id) throws SQLException {
    	User user = getUserById(id);
    	if(user == null) {
    		System.out.println("User với id = "+id+" không tồn tại");
    		return;
    	}
        String query = "DELETE FROM Users WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
        System.out.println("Đã xóa User!");
    }

    public User login(String email, String password) throws SQLException {
    	if (!Pattern.matches(EMAIL_REGEX, email)) {
            System.out.println("Email không hợp lệ!");
            return null;
        }

        if (!Pattern.matches(PASSWORD_REGEX, password)) {
            System.out.println("Mật khẩu phải có 6-12 ký tự và ít nhất 1 chữ hoa!");
            return null;
        }
        String query = "SELECT * FROM Users WHERE email = ? AND password = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("id"), rs.getString("fullName"), rs.getString("email"),
                        rs.getString("password"), rs.getString("role"));
            }
        }
        return null;
    }
}
