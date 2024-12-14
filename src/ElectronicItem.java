import java.util.Random;

public class ElectronicItem extends Item {
    private static final String[] ECO_TIPS = {
        "Choose energy-efficient electronics to reduce power consumption.",
        "Recycle your old electronics to keep them out of landfills.",
        "Buy products with minimal packaging to reduce waste."
    };

    public ElectronicItem(String name, double price, int quantity) {
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
