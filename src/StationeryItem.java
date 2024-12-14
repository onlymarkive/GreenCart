import java.util.Random;

public class StationeryItem extends Item {
    private static final String[] ECO_TIPS = {
        "Choose recycled paper or refillable pens to cut down on waste.",
        "Opt for digital note-taking to reduce paper usage.",
        "Support brands that use eco-friendly inks and sustainable materials."
    };

    public StationeryItem(String name, double price, int quantity) {
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
