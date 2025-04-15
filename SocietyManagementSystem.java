// SocietyManagementSystem.java
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class SocietyManagementSystem {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Setup.init();
        MainMenu.show();
    }
}

class Setup {
    public static void init() {
        new File("users/person").mkdirs();
        new File("users/staff").mkdirs();
        new File("users/staff/attendance.txt").delete();
        try {
            new File("users/funds").mkdirs();
            new File("users/funds/donations.txt").createNewFile();
            new File("users/funds/maintenance.txt").createNewFile();
            new File("users/staff/attendance.txt").createNewFile();
        } catch (IOException e) {
            System.out.println("Error setting up files");
        }
    }
}

class MainMenu {
    public static void show() {
        while (true) {
            System.out.println("\n--- Society Management System ---");
            System.out.println("1. Secretary Login");
            System.out.println("2. Owner Menu");
            System.out.println("3. Exit");
            int ch=-1;
            while(true){
                System.out.print("Choice: ");
                try{
                ch = Integer.parseInt(SocietyManagementSystem.sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
            switch (ch) {
                case 1: Auth.secretaryLogin(); break;
                case 2: Owner.menu(); break;
                case 3: System.exit(0);
                default: System.out.println("Invalid choice");
            }
        }
    }
}

class Auth {
    static String secPass = "admin123";
     public static void secretaryLogin() {
         System.out.print("Enter Secretary password: ");
         String pass = SocietyManagementSystem.sc.nextLine();
        if (pass.equals(secPass)) {
             Secretary.menu();
         } else {
             System.out.println("Wrong password.");
         }
     }
    

}

class Secretary {
    @SuppressWarnings("UnnecessaryContinue")
    public static void menu() {
        while (true) {
            System.out.println("\n--- Secretary Menu ---");
            System.out.println("1. Add Person");
            System.out.println("2. Modify Person");
            System.out.println("3. Delete Person");
            System.out.println("4. View All Persons");
            System.out.println("5. Add Donation");
            System.out.println("6. View Fund Summary");
            System.out.println("7. Add Maintenance Payment");
            System.out.println("8. Add Staff");
            System.out.println("9. View Staff");
            System.out.println("10. Delete Staff");
            System.out.println("11. Mark Attendance");
            System.out.println("12. View Attendance");
            System.out.println("13. Search Person");
            System.out.println("0. Back");
            int ch=-1;
            while(true){
                System.out.print("Choice: ");
                try{
                ch = Integer.parseInt(SocietyManagementSystem.sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
        }
            switch (ch) {
                case 1 -> Person.add();
                case 2 -> Person.modify();
                case 3 -> Person.delete();
                case 4 -> Person.viewAll();
                case 5 -> Funds.addDonation();
                case 6 -> Funds.viewSummary();
                case 7 -> Funds.addMaintenance();
                case 8 -> Staff.add();
                case 9 -> Staff.viewAll();
                case 10 -> Staff.delete();
                case 11 -> Staff.markAttendance();
                case 12 -> Staff.viewAttendance();
                case 13 -> PersonSearch.search();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}

class Owner {
    public static void menu() {
        while (true) {
            System.out.println("\n--- Owner Menu ---");
            System.out.println("1. View My Info");
            System.out.println("2. Pay Maintenance");
            System.out.println("3. View Fund Summary");
            System.out.println("4. Search Person");
            System.out.println("0. Back");
            System.out.print("Choice: ");
            int ch=-1;
            while(true){
                System.out.print("Choice: ");
                try{
                ch = Integer.parseInt(SocietyManagementSystem.sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
        }
            switch (ch) {
                case 1: PersonSearch.search(); break;
                case 2: Funds.addMaintenance(); break;
                case 3: Funds.viewSummary(); break;
                case 4: PersonSearch.search(); break;
                case 0: return;
                default: System.out.println("Invalid choice");
            }
        }
    }
}

class Person {
    static final String folder = "users/person/";
    static Scanner sc = new Scanner(System.in);

    public static void add() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter block: ");
        String block = sc.nextLine();
        System.out.print("Enter room no: ");
        String room = sc.nextLine();
        System.out.print("Enter phone: ");
        String phone = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();

        if (!Validator.isValidPhone(phone) || !Validator.isValidEmail(email)) {
            System.out.println("Invalid phone or email");
            return;
        }
        String filePath = folder + block + "_" + room + ".txt";
        File file = new File(filePath);
        if (file.exists()) {
            System.out.println("A person is already living in Block " + block + ", Room " + room + ".");
            return;
        }
    
        try (FileWriter fw = new FileWriter(filePath)) {
            fw.write(name + "\n" + block + "\n" + room + "\n" + phone + "\n" + email);
            System.out.println("Person added.");
        } catch (IOException e) {
            System.out.println("Error writing file.");
        }
    }

    public static void modify() {
        System.out.print("Enter block: ");
        String block = sc.nextLine();
        System.out.print("Enter room to modify: ");
        String room = sc.nextLine();
    
        File file = new File(folder +block+"_"+ room + ".txt");
        if (!file.exists()) {
            System.out.println("Person does not exist.");
            return;
        }
    
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String name = br.readLine();
            String oldBlock = br.readLine();
            String oldRoom = br.readLine();
            String phone = br.readLine();
            String email = br.readLine();
    
            System.out.println("\n--- Current Info ---");
            System.out.println("Name: " + name);
            System.out.println("Block: " + oldBlock);
            System.out.println("Room: " + oldRoom);
            System.out.println("Phone: " + phone);
            System.out.println("Email: " + email);
    
            System.out.println("\n--- Enter New Info (press Enter to keep current) ---");
            System.out.print("New name: ");
            String newName = sc.nextLine();
            if (newName.trim().isEmpty()) newName = name;
    
            System.out.print("New phone: ");
            String newPhone = sc.nextLine();
            if (newPhone.trim().isEmpty()) newPhone = phone;
            else if (!Validator.isValidPhone(newPhone)) {
                System.out.println("Invalid phone number.");
                return;
            }
    
            System.out.print("New email: ");
            String newEmail = sc.nextLine();
            if (newEmail.trim().isEmpty()) newEmail = email;
            else if (!Validator.isValidEmail(newEmail)) {
                System.out.println("Invalid email address.");
                return;
            }
    
            try (FileWriter fw = new FileWriter(file)) {
                fw.write(newName + "\n" + block + "\n" + room + "\n" + newPhone + "\n" + newEmail);
                System.out.println("Person details updated.");
            }
    
        } catch (IOException e) {
            System.out.println("Error modifying details.");
        }
    }    

    public static void delete() {
        System.out.print("Enter room to delete: ");
        String room = sc.nextLine();
        System.out.print("Enter block: ");
        String block = sc.nextLine();
        File file = new File(folder + block+"_"+room + ".txt");
        if (file.exists() && file.delete()) {
            System.out.println("Deleted successfully.");
        } else {
            System.out.println("Person not found.");
        }
    }

    public static void viewAll() {
        File[] files = new File(folder).listFiles();
        if (files == null) return;
        for (File file : files) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                System.out.println("\n--------------------");
                System.out.println("Name: " + br.readLine());
                System.out.println("Block: " + br.readLine());
                System.out.println("Room: " + br.readLine());
                System.out.println("Phone: " + br.readLine());
                System.out.println("Email: " + br.readLine());
            } catch (IOException ignored) {}
        }
    }
}

class Staff {
    static final String folder = "users/staff/";
    static Scanner sc = new Scanner(System.in);

    public static void add() {
        System.out.print("Enter ID: ");
        String id = sc.nextLine();
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter role: ");
        String role = sc.nextLine();
        System.out.print("Enter phone: ");
        String phone = sc.nextLine();

        if (!Validator.isValidPhone(phone)) {
            System.out.println("Invalid phone number");
            return;
        }
        String filePath = folder + id + ".txt";
        File file = new File(filePath);
        if (file.exists()) {
            System.out.println("A staff member with this ID already exists.");
            return;
        }
        try (FileWriter fw = new FileWriter(filePath)) {
            fw.write(id + "\n" + name + "\n" + role + "\n" + phone);
            System.out.println("Staff added.");
        } catch (IOException e) {
            System.out.println("Error writing staff file.");
        }
    }

    public static void viewAll() {
        File[] files = new File(folder).listFiles();
        if (files == null) return;
        for (File file : files) {
            if (file.getName().equals("attendance.txt")) continue;
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                System.out.println("\n-------------------");
                System.out.println("ID: " + br.readLine());
                System.out.println("Name: " + br.readLine());
                System.out.println("Role: " + br.readLine());
                System.out.println("Phone: " + br.readLine());
            } catch (IOException ignored) {}
        }
    }

    public static void delete() {
        System.out.print("Enter ID to delete: ");
        String id = sc.nextLine();
        File file = new File(folder + id + ".txt");
        if (file.exists() && file.delete()) System.out.println("Deleted.");
        else System.out.println("Not found.");
    }
    public static void markAttendance() {
    System.out.print("Enter staff ID: ");
    String id = sc.nextLine();
    File staffFile = new File(folder + id + ".txt");
    if (!staffFile.exists()) {
        System.out.println("Staff ID does not exist.");
        return;
    }
    String attendanceFilePath = folder + "attendance.txt";
    String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    try (BufferedReader br = new BufferedReader(new FileReader(attendanceFilePath))) {
        String line;
        while ((line = br.readLine()) != null) {
            if (line.startsWith(id + " Present on: " + today)) {
                System.out.println("Attendance already marked for today.");
                return;
            }
        }
    } catch (FileNotFoundException e) {
        System.out.println("Attendance file not found. Creating a new one.");
    } catch (IOException e) {
        System.out.println("Error reading attendance file: " + e.getMessage());
        return;
    }
    try (FileWriter fw = new FileWriter(attendanceFilePath, true)) {
        fw.write(id + " Present on: " + today + "\n");
        System.out.println("Attendance marked.");
    } catch (IOException e) {
        System.out.println("Error writing attendance: " + e.getMessage());
    }
}
    public static void viewAttendance() {
        try (BufferedReader br = new BufferedReader(new FileReader(folder + "attendance.txt"))) {
            String line;
            while ((line = br.readLine()) != null) System.out.println(line);
        } catch (IOException e) {
            System.out.println("No attendance data.");
        }
    }
}
class Funds {
    static Scanner sc = new Scanner(System.in);
    public static void addDonation() {
        System.out.print("Enter donor name: ");
        String name = sc.nextLine();
        System.out.print("Enter block: ");
        String block = sc.nextLine();
        System.out.print("Enter room number: ");
        String room = sc.nextLine();
        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        File file = new File("users/person/" + block+"_"+room + ".txt");
        if (!file.exists()) {
        System.out.println("You are not a verified member of the society. Donation not accepted.");
        return;
        }
        System.out.print("Enter amount: ");
        String amount = sc.nextLine();
        System.out.print("Do you want to be a secret donor? (yes/no): ");
        String hide = sc.nextLine().trim().toLowerCase();
        try (FileWriter fw = new FileWriter("users/funds/donations.txt", true)) {
        fw.write("---\n");
        if (hide.equals("yes")) {
            fw.write("Donor: Secret Donor\n");
        } else {
            fw.write("Donor Name: " + name + "\n");
            fw.write("Phone: " + phone + "\n");
            fw.write("Email: " + email + "\n");
            fw.write("Block: " + block + "\n");
            fw.write("Room: " + room + "\n");
        }
        fw.write("Amount: Rs." + amount + "\n");
        fw.write("---\n");
        System.out.println("Donation recorded successfully.");
        } catch (IOException e) {
        System.out.println("Failed to record donation: " + e.getMessage());
    }
    }
    public static void addMaintenance() {
        System.out.print("Enter owner name: ");
        String name = sc.nextLine();
        System.out.print("Enter block: ");
        String block = sc.nextLine();
        System.out.print("Enter room number: ");
        String room = sc.nextLine();
        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        // Verify if the person exists in the society database
        File file = new File("users/person/" +block+"_"+ room + ".txt");
        if (!file.exists()) {
            System.out.println("You are not a verified member of the society. Maintenance payment not accepted.");
            return;
        }
        System.out.print("Enter amount: ");
        String amount = sc.nextLine();
        try (FileWriter fw = new FileWriter("users/funds/maintenance.txt", true)) {
            fw.write("---\n");
            fw.write("Owner Name: " + name + "\n");
            fw.write("Phone: " + phone + "\n");
            fw.write("Email: " + email + "\n");
            fw.write("Block: " + block + "\n");
            fw.write("Room: " + room + "\n");
            fw.write("Amount: Rs." + amount + "\n");
            fw.write("---\n");
            System.out.println("Maintenance payment recorded successfully.");
        } catch (IOException e) {
            System.out.println("Failed to record maintenance: " + e.getMessage());
        }
    }
    public static void viewSummary() {
       System.out.println("\n--- Donations ---");
        display("users/funds/donations.txt");
        System.out.println("\n--- Maintenance ---");
        display("users/funds/maintenance.txt");
    }
    private static void display(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) System.out.println(line);
        } catch (IOException ignored) {}
    }
}
class PersonSearch {
    static Scanner sc = new Scanner(System.in);
    public static void search() {
        System.out.print("Search by (name/block&room): ");
        String key = sc.nextLine().toLowerCase();
        String searchName = "", searchBlock = "", searchRoom = "";
        if (key.equals("name")) {
            System.out.print("Enter name: ");
            searchName = sc.nextLine().toLowerCase();
        } else if (key.equals("block&room") || key.equals("block and room")) {
            System.out.print("Enter block: ");
            searchBlock = sc.nextLine().toLowerCase();
            System.out.print("Enter room: ");
            searchRoom = sc.nextLine().toLowerCase();
        } else {
            System.out.println("Invalid search key.");
            return;
        }
        File[] files = new File("users/person/").listFiles();
        if (files == null || files.length == 0) {
            System.out.println("No resident records found.");
            return;
        }
        boolean found = false;
        for (File file : files) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String name = br.readLine();
                String block = br.readLine();
                String room = br.readLine();
                String phone = br.readLine();
                String email = br.readLine();
                if ((key.equals("name") && name.toLowerCase().contains(searchName)) ||
                    (key.startsWith("block") && block.toLowerCase().equals(searchBlock) && room.equalsIgnoreCase(searchRoom))) {
                    System.out.println("\nName: " + name);
                    System.out.println("Block: " + block);
                    System.out.println("Room: " + room);
                    System.out.println("Phone: " + phone);
                    System.out.println("Email: " + email);
                    found = true;
                }
    } catch (IOException ignored) {}
}
if (!found) {
    System.out.println("No matching record found.");
}
}
}
class Validator {
    public static boolean isValidPhone(String phone) {
        return phone.matches("\\d{10}");
    }
    public static boolean isValidEmail(String email) {
        return email.matches("[a-zA-Z0-9._%+-]+@gmail\\.com");
    }
}
