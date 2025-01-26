package CouponRecommendation;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String id;
    private String email;
    private List<Purchase> purchaseHistory;
    private UserPreferences preferences;
    
    public User(String id, String email) {
        this.id = id;
        this.email = email;
        this.preferences = new UserPreferences();
        this.purchaseHistory = new ArrayList<>();
    }

    public void addPurchase(Purchase purchase) {
        purchaseHistory.add(purchase);
        // Update preferences based on purchase
        preferences.updateFromPurchase(purchase);
    }

    public List<String> getPreferredCategories() {
        return preferences.getPreferredCategories();
    }

    public List<Purchase> getPurchaseHistory() {
        return purchaseHistory;
    }
}

