package accessories;

public class Scope implements Accesories {
    private int rangeIncrease;

    public Scope(int rangeIncrease) {
        this.rangeIncrease = rangeIncrease;
    }

    @Override
    public void apply() {
    }

    @Override
    public void disable() {
    }

    public int getRangeIncrease() {
        return rangeIncrease;
    }

    @Override
    public String getName() {
        return "Scope";
    }
}
