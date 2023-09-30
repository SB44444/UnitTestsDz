package seminars.first.hw;


public class Product {
    private double cost; // Стоимость продукта
    
    private String title; // Название продукта

    public Product(String title, double cost) {
        this.title = title;
        this.cost = cost;
    }

    public double getCost() {return cost; }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Product{name= %s, price= %s".formatted(title, cost);}

    }