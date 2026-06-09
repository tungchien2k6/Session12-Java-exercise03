import java.util.*;

public class Main {
    private static List<Drink> menu = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    private static int nextId = 1;
    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = getIntInput("Nhập lựa chọn: ");

            switch (choice) {
                case 1: addDrink(); break;
                case 2: displayMenu(); break;
                case 3: applyPromotion(); break;
                case 4: deleteDrink(); break;
                case 5: showStatistics(); break;
                case 6:
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                    sc.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("          QUẢN LÝ MENU QUÁN CÀ PHÊ");
        System.out.println("=".repeat(50));
        System.out.println("1. Thêm món mới");
        System.out.println("2. Hiển thị Menu");
        System.out.println("3. Áp dụng mã giảm giá");
        System.out.println("4. Xóa món");
        System.out.println("5. Thống kê");
        System.out.println("6. Thoát");
        System.out.println("=".repeat(50));
    }

    private static void addDrink() {
        System.out.println("\n--- THÊM MÓN MỚI ---");
        System.out.println("1. Cà phê");
        System.out.println("2. Trà trái cây");
        int type = getIntInput("Chọn loại: ");

        System.out.print("Nhập tên món: ");
        String name = sc.nextLine();
        double price = getDoubleInput("Nhập giá: ");

        if (type == 1) {
            menu.add(new Coffee(nextId++, name, price));
        } else {
            menu.add(new FruitTea(nextId++, name, price));
        }
        System.out.println("✅ Thêm món thành công!");
    }

    private static void displayMenu() {
        System.out.println("\n--- MENU ĐỒ UỐNG ---");
        if (menu.isEmpty()) {
            System.out.println("Chưa có món nào trong menu!");
            return;
        }
        for (Drink d : menu) {
            d.showInfo();
            System.out.println("-".repeat(45));
        }
    }

    private static void applyPromotion() {
        if (menu.isEmpty()) {
            System.out.println("Menu trống!");
            return;
        }
        double percent = getDoubleInput("\nNhập % giảm giá: ");
        for (Drink d : menu) {
            d.applyDiscount(percent);
        }
        System.out.println("Đã áp dụng giảm giá cho toàn menu!");
    }

    private static void deleteDrink() {
        int id = getIntInput("\nNhập ID món cần xóa: ");
        for (int i = 0; i < menu.size(); i++) {
            if (menu.get(i).getId() == id) {
                System.out.println("Đã xóa: " + menu.get(i).getName());
                menu.remove(i);
                return;
            }
        }
        System.out.println("Không tìm thấy món có ID này!");
    }

    private static void showStatistics() {
        if (menu.isEmpty()) {
            System.out.println("Menu trống!");
            return;
        }
        double total = 0;
        for (Drink d : menu) {
            total += d.getPrice();
        }
        System.out.printf("Tổng số món: %d%n", menu.size());
        System.out.printf("Giá trung bình: %.0f VND%n", total / menu.size());
    }

    private static int getIntInput(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số nguyên!");
            }
        }
    }

    private static double getDoubleInput(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Double.parseDouble(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số!");
            }
        }
    }
}