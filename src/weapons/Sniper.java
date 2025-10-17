package weapons;

public class Sniper extends Weapon {
    private int targetDistance;

    public Sniper() {
        super("Sniper", 5);
        this.targetDistance = 0;
    }

    @Override
    public void shoot() {
        if (currentRounds > 0) {
            currentRounds--;
        }
    }

    public void calculateDistance(int distance) {
        this.targetDistance = distance;
    }

    @Override
    public String getSpecialAbility() {
        return "Distance Calculation";
    }

    public int getTargetDistance() {
        return targetDistance;
    }
}
