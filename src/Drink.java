public abstract class Drink implements IPromotion {
    private int id;
    private String name;
    private double price;
    public Drink(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public abstract void prepare();

    @Override
    public void applyDiscount(double percentage) {
        if (percentage > 0 && percentage <= 100) {
            this.price = this.price * (1 - percentage / 100);
            System.out.printf("Đã áp dụng giảm %.0f%% cho %s%n", percentage, name);
        }
    }

    public void showInfo() {
        System.out.printf("ID: %d | Tên: %s | Giá: %.0f VND%n", id, name, price);
        prepare();
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}