import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        Map<String, Product> productMap = new HashMap<>();

        // Add sample products
        products.add(new Product("P002", "Mouse", 19.99, 50));
        products.add(new Product("P003", "Keyboard", 49.99, 30));
        products.add(new Product("P001", "Monitor", 129.99, 10));

        // Add to map
        for (Product p : products) {
            productMap.put(p.getId(), p);
        }

        System.out.println("Original Product List:");
        for (Product p : products) {
            System.out.println(p);
        }

        System.out.println("\nSorted by Product ID:");
        Collections.sort(products);
        for (Product p : products) {
            System.out.println(p);
        }

        System.out.println("\nSorted by Price:");
        products.sort(new PriceComparator());
        for (Product p : products) {
            System.out.println(p);
        }

        System.out.println("\nSearch by ID 'P003':");
        System.out.println(productMap.get("P003"));
    }
}
