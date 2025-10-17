package accessories;

public class Silencer implements Accesories {
    private int noiseReduction;

    public Silencer(int noiseReduction) {
        this.noiseReduction = noiseReduction;
    }

    @Override
    public void apply() {
    }

    @Override
    public void disable() {
    }

    public int getNoiseReduction() {
        return noiseReduction;
    }

    @Override
    public String getName() {
        return "Silencer";
    }
}
