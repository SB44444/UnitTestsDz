package seminars.first.hw;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Store {
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }


    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * @return отсортированный по возрастанию и цене список продуктов
     */
    public List<Product> getSortedListProducts() {
        products.sort(Comparator.comparingDouble(Product::getCost));
        return products;
    }

    /**
     * @return самый дорогой продукт
     */
    public Product getMostExpensiveProduct() {
        Product MostExpensiveProduct;
        MostExpensiveProduct = Collections.max(products, Comparator.comparingDouble(Product::getCost));
        return MostExpensiveProduct;
    }
}