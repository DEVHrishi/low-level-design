package CouponRecommendation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserPreferences {
    private List<String> preferredCategories;
    private Map<String, Integer> categoryFrequency;

    public UserPreferences() {
        this.preferredCategories = new ArrayList<>();
        this.categoryFrequency = new HashMap<>();
    }

    public void updateFromPurchase(Purchase purchase) {
        for (Product product : purchase.getProducts()) {
            String category = product.getCategory();
            categoryFrequency.put(category, 
                categoryFrequency.getOrDefault(category, 0) + 1);
        }

        // Update preferred categories based on frequency
        preferredCategories = categoryFrequency.entrySet().stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            .limit(3)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    }

    public List<String> getPreferredCategories() {
        return preferredCategories;
    }
}
