package BT_10;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        VietnamesePhone vietnamesePhone = new VietnamesePhone();

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Thêm mới liên hệ");
            System.out.println("2. Xóa liên hệ");
            System.out.println("3. Cập nhật liên hệ");
            System.out.println("4. Tìm kiếm liên hệ");
            System.out.println("5. Hiển thị tất cả liên hệ");
            System.out.println("6. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Nhập tên liên hệ: ");
                    String nameToAdd = scanner.nextLine();
                    System.out.print("Nhập số điện thoại: ");
                    String phoneToAdd = scanner.nextLine();
                    vietnamesePhone.insertContact(nameToAdd, phoneToAdd);
                    break;

                case 2:
                    System.out.print("Nhập tên liên hệ cần xóa: ");
                    String nameToRemove = scanner.nextLine();
                    vietnamesePhone.removeContact(nameToRemove);
                    break;

                case 3:
                    System.out.print("Nhập tên liên hệ cần cập nhật: ");
                    String nameToUpdate = scanner.nextLine();
                    System.out.print("Nhập số điện thoại mới: ");
                    String newPhone = scanner.nextLine();
                    vietnamesePhone.updateContact(nameToUpdate, newPhone);
                    break;

                case 4:
                    System.out.print("Nhập tên liên hệ cần tìm: ");
                    String nameToSearch = scanner.nextLine();
                    vietnamesePhone.searchContact(nameToSearch);
                    break;

                case 5:
                	System.out.println("Danh sách tất cả liên hệ: ");
                    vietnamesePhone.showAllContact();
                    break;
                case 6:
                	System.out.println("Thoát chương trình");
                	return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
		
	}
}
