import java.util.Comparator;

public class PriceComparator implements Comparator<Product> {

    @Override
    public int compare(Product p1, Product p2) {
        // TODO: Compare products by price
        // return a negative, zero, or positive value

        return Double.compare(p1.getPrice(), p2.getPrice());
        return 0;
    }
}