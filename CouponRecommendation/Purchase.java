package CouponRecommendation;


import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Purchase {
    private String id;
    private User user;
    private List<Product> products;
    private LocalDateTime purchaseDate;
    private double totalAmount;
    

    public Purchase(User user, List<Product> products) {
        this.id = UUID.randomUUID().toString();
        this.user = user;
        this.products = products;
        this.purchaseDate = LocalDateTime.now();
        this.totalAmount = products.stream()
            .mapToDouble(Product::getPrice)
            .sum();
    }

    public List<Product> getProducts() { return products; }
    public LocalDateTime getPurchaseDate() { return purchaseDate; }
}
