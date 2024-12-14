import java.util.Random;

public class ClothingItem extends Item {
    private static final String[] ECO_TIPS = {
        "Opt for second-hand or sustainably made clothing to minimize textile waste.",
        "Wash clothes in cold water to save energy and preserve fabric quality.",
        "Choose clothes made from natural fibers like cotton or wool, which are biodegradable."
    };

    public ClothingItem(String name, double price, int quantity) {
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
