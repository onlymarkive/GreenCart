import java.util.Random;

public class HouseholdItem extends Item {
    private static final String[] ECO_TIPS = {
        "Look for eco-friendly cleaning supplies and reusable household items.",
        "Use natural materials like bamboo for home products to reduce plastic waste.",
        "Opt for energy-efficient appliances to reduce your household's carbon footprint."
    };

    public HouseholdItem(String name, double price, int quantity) {
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
