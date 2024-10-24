package final_module_2;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class ContactManager {
    private static final String PATH= "src/final_module_2/data/contacts.csv";
    private ArrayList<Contact> contactList;
    private Scanner scanner;

    public ContactManager() {
        contactList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addContact() {
        System.out.println("Nhập số điện thoại: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Nhập nhóm: ");
        String group = scanner.nextLine();
        System.out.println("Nhập họ tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập giới tính: ");
        String gender = scanner.nextLine();
        System.out.println("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        System.out.println("Nhập ngày sinh (dd/MM/yyyy): ");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Nhập email: ");
        String email = scanner.nextLine();

        Contact contact = new Contact(phoneNumber, group, name, gender, address, dateOfBirth, email);
        contactList.add(contact);
        System.out.println("Đã thêm danh bạ mới.");
    }

    public void editContact(String phoneNumber) {
        for (Contact contact : contactList) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                System.out.println("Nhập thông tin mới cho danh bạ (nhấn enter để giữ thông tin cũ):");

                System.out.println("Nhập nhóm: ");
                String newGroup = scanner.nextLine();
                if (!newGroup.isEmpty()) contact.setGroup(newGroup);

                System.out.println("Nhập họ tên: ");
                String newName = scanner.nextLine();
                if (!newName.isEmpty()) {
                    contact.setName(newName);
                }

                System.out.println("Nhập giới tính: ");
                String newGender = scanner.nextLine();
                if (!newGender.isEmpty()){
                    contact.setGender(newGender);
                }

                System.out.println("Nhập địa chỉ: ");
                String newAddress = scanner.nextLine();
                if (!newAddress.isEmpty()){
                    contact.setAddress(newAddress);
                }

                System.out.println("Nhập ngày sinh: ");
                String newDateOfBirth = scanner.nextLine();
                if (!newDateOfBirth.isEmpty()){
                    contact.setDateOfBirth(newDateOfBirth);
                }

                System.out.println("Nhập email: ");
                String newEmail = scanner.nextLine();
                if (!newEmail.isEmpty()){
                    contact.setEmail(newEmail);
                }

                System.out.println("Đã sửa danh bạ.");
                return;
            }
        }
        System.out.println("Không tìm thấy danh bạ với số điện thoại: " + phoneNumber);
    }

    public void deleteContact(String phoneNumber) {
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getPhoneNumber().equals(phoneNumber)) {
                contactList.remove(i);
                System.out.println("Đã xóa danh bạ.");
                return;
            }
        }
        System.out.println("Không tìm thấy danh bạ với số điện thoại: " + phoneNumber);
    }

    public void displayContacts() {
        int count = 0;
        for (Contact contact : contactList) {
            System.out.println(contact);
            count++;
            if (count % 5 == 0) {
                System.out.println("Nhấn Enter để tiếp tục...");
                scanner.nextLine();
            }
        }
        if (contactList.size() == 0) {
            System.out.println("Danh bạ trống.");
        }
    }

    public void searchContact(String phoneNumber) {
        for (Contact contact : contactList) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                System.out.println("Thông tin danh bạ tìm thấy:");
                System.out.println(contact);
                return;
            }
        }
        System.out.println("Không tìm thấy danh bạ với số điện thoại: " + phoneNumber);
    }

    public void saveContactsToFile(String PATH) {
        try (FileWriter writer = new FileWriter(PATH)) {
            for (Contact contact : contactList) {
                writer.write(contact.getPhoneNumber() + "," +
                        contact.getGroup() + "," +
                        contact.getName() + "," +
                        contact.getGender() + "," +
                        contact.getAddress() + "," +
                        contact.getDateOfBirth() + "," +
                        contact.getEmail() + "\n");
            }
            System.out.println("Đã ghi danh bạ vào file " + PATH);
        } catch (IOException e) {
            System.out.println("Có lỗi khi ghi dữ liệu vào file: " + e.getMessage());
        }
    }

    public void loadContactsFromFile(String PATH) {
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            String line;
            contactList.clear();
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 7) {
                    Contact contact = new Contact(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], fields[6]);
                    contactList.add(contact);
                }
            }
            System.out.println("Đã đọc dữ liệu từ file " + PATH);
        } catch (IOException e) {
            System.out.println("Có lỗi khi đọc dữ liệu từ file: " + e.getMessage());
        }
    }
}

