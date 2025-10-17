package weapons;

public class Rifle extends Weapon {

    public Rifle() {
        super("Rifle", 30);
    }

    @Override
    public void shoot() {
        if (currentRounds > 0) {
            currentRounds--;
        }
    }

    public void stabilize() {
    }

    @Override
    public String getSpecialAbility() {
        return "Stabilize";
    }
}
