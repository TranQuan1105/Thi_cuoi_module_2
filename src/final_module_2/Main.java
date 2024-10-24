package final_module_2;

import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContactManager manager = new ContactManager();
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("----- CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ -----");
            System.out.println("Chọn chức năng theo số (để tiếp tục):");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi vào file");
            System.out.println("8. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    manager.displayContacts();
                    break;
                case "2":
                    manager.addContact();
                    break;
                case "3":
                    System.out.println("Nhập số điện thoại của danh bạ cần cập nhật: ");
                    String phoneToEdit = scanner.nextLine();
                    manager.editContact(phoneToEdit);
                    break;
                case "4":
                    System.out.println("Nhập số điện thoại của danh bạ cần xóa: ");
                    String phoneToDelete = scanner.nextLine();
                    manager.deleteContact(phoneToDelete);
                    break;
                case "5":
                    System.out.println("Nhập số điện thoại để tìm kiếm: ");
                    String phoneToSearch = scanner.nextLine();
                    manager.searchContact(phoneToSearch);
                    break;
                case "6":
                    /*oadContactsFromFile();*/
                    break;
                case "7":
                    /*saveContactsToFile();*/
                    break;
                case "8":
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (!choice.equals("8"));

        scanner.close();
    }
}

