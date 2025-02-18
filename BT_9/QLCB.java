package BT_9;

import java.util.ArrayList;
import java.util.Scanner;

public class QLCB {
    private ArrayList<CanBo> listCanBo;

    public QLCB() {
        listCanBo = new ArrayList<CanBo>();
    }

    public void addCanBo(CanBo canBo) {
        listCanBo.add(canBo);
    }

    public void searchByName(String name) {
        for (CanBo canBo : listCanBo) {
            if (canBo.getName().equals(name)) {
                System.out.println(canBo.toString());
                return;
            }
        }
        System.out.println("Không tìm thấy");
        return;
    }

    public void showAll() {
        for (CanBo canBo : listCanBo)
            System.out.println(canBo.toString());
    }

    public void deleteByName(String name) {
        for (CanBo canBo : listCanBo)
            if (canBo.getName().equals(name)) {
                listCanBo.remove(canBo);
                return;
            }
        System.out.println("Không có cán bộ có tên " + name + " trong danh sách!");
    }

    // Phương thức menu để thao tác
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Thêm mới cán bộ");
            System.out.println("2. Tìm kiếm theo họ tên");
            System.out.println("3. Hiển thị danh sách cán bộ");
            System.out.println("4. Xóa cán bộ theo tên");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:

                    System.out.println("Nhập tên: ");
                    String name = scanner.nextLine();
                    System.out.println("Nhập tuổi: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Nhập giới tính: ");
                    String gender = scanner.nextLine();
                    System.out.println("Nhập địa chỉ: ");
                    String address = scanner.nextLine();

                    System.out.println("Chọn loại cán bộ: ");
                    System.out.println("1. Công nhân");
                    System.out.println("2. Kỹ sư");
                    System.out.println("3. Nhân viên");
                    int type = scanner.nextInt();
                    scanner.nextLine();

                    if (type == 1) {
                        System.out.println("Nhập bậc công nhân (1-10): ");
                        int level = scanner.nextInt();
                        addCanBo(new CongNhan(name, age, gender, address, level));
                    } else if (type == 2) {
                        System.out.println("Nhập ngành đào tạo: ");
                        String major = scanner.nextLine();
                        addCanBo(new KySu(name, age, gender, address, major));
                    } else if (type == 3) {
                        System.out.println("Nhập công việc: ");
                        String job = scanner.nextLine();
                        addCanBo(new NhanVien(name, age, gender, address, job));
                    } else {
                        System.out.println("Lựa chọn không hợp lệ.");
                    }
                    break;

                case 2:

                    System.out.print("Nhập tên cán bộ cần tìm: ");
                    String searchName = scanner.nextLine();
                    searchByName(searchName);
                    break;

                case 3:
                    showAll();
                    break;

                case 4:

                    System.out.print("Nhập tên cán bộ cần xóa: ");
                    String deleteName = scanner.nextLine();
                    deleteByName(deleteName);
                    break;

                case 5:
                    System.out.println("Thoát chương trình.");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    public static void main(String[] args) {
        QLCB qlcb = new QLCB();
        qlcb.menu();
    }

}
