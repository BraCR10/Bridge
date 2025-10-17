package accessories;

public class ExtendedMagazine implements Accesories {
    private int additionalAmount;

    public ExtendedMagazine(int additionalAmount) {
        this.additionalAmount = additionalAmount;
    }

    @Override
    public void apply() {
    }

    @Override
    public void disable() {
    }

    public int getAdditionalAmount() {
        return additionalAmount;
    }

    @Override
    public String getName() {
        return "Extended Magazine";
    }
}
