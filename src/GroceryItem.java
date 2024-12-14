import java.util.Random;

public class GroceryItem extends Item {
    private static final String[] ECO_TIPS = {
        "Opt for locally grown produce to reduce carbon footprint.",
        "Buy in bulk to minimize packaging waste.",
        "Choose organic products to support sustainable farming practices."
    };

    public GroceryItem(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public String getEcoFriendlyTip() {
        return getRandomTip(ECO_TIPS);
    }

    private String getRandomTip(String[] tips) {
        Random rand = new Random();
        return tips[rand.nextInt(tips.length)];
    }
}
