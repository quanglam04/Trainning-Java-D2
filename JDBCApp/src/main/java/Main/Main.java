package Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import DAO.UserDAO;
import Entity.User;
import Helper.DatabaseConnection;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserDAO userDAO = new UserDAO();
        // init DB
        if (isDatabaseEmpty()) {
            User admin = new User(1, "Trinh Quang Lam", "trinhquanglam2k4@gmail.com", "123456A", "Admin");
            userDAO.insertUser(admin, 5, null);
        }
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Xem danh sách User");
            System.out.println("2. Tìm User theo ID");
            System.out.println("3. Xóa User theo ID");
            System.out.println("4. Đăng nhập");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        List<User> users = userDAO.getAllUsers();
                        System.out.println("ID | Full Name | Email | Role");
                        for (User u : users) {
                            System.out.printf("%d | %s | %s | %s\n", u.getId(), u.getFullName(), u.getEmail(), u.getRole());
                        }
                        break;
                    case 2:
                        System.out.print("Nhập ID: ");
                        int id = scanner.nextInt();
                        User user = userDAO.getUserById(id);
                        if (user != null) {
                            System.out.println("User: " + user.getFullName() + " - " + user.getEmail());
                        } else {
                            System.out.println("Không tìm thấy User!");
                        }
                        break;
                    case 3:
                        System.out.print("Nhập ID cần xóa: ");
                        userDAO.deleteUser(scanner.nextInt());
                         
                        break;
                    case 4:
                        System.out.print("Nhập Email: ");
                        String email = scanner.next();
                        System.out.print("Nhập Password: ");
                        String password = scanner.next();
                        User loginUser = userDAO.login(email, password);
                        System.out.println(loginUser != null ? "Đăng nhập thành công!" : "Sai thông tin đăng nhập!");
                        if(loginUser!=null && loginUser.getRole().equals("Admin"))
                        {
                        	scanner.nextLine();
                        	userDAO.createUser(scanner);
                        }
                        break;
                    case 5:
                        return;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static boolean isDatabaseEmpty() throws SQLException {
        String query = "SELECT COUNT(*) FROM Users";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1) == 0; 
            }
        }
        return false;
    }

}