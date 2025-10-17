package weapons;

public class Gun extends Weapon {

    public Gun() {
        super("Gun", 15);
    }

    @Override
    public void shoot() {
        if (currentRounds > 0) {
            currentRounds--;
        }
    }

    public void rapidFire(int shots) {
        int actualShots = Math.min(shots, currentRounds);
        if (actualShots > 0) {
            currentRounds -= actualShots;
        }
    }

    public int getLastRapidFireShots() {
        return Math.min(currentRounds, currentRounds);
    }

    @Override
    public String getSpecialAbility() {
        return "Rapid Fire";
    }
}
