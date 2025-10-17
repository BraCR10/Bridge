package weapons;

import accessories.Accesories;

public abstract class Weapon {
    protected String name;
    protected int currentRounds;
    protected int magazineCapacity;
    protected Accesories accessory;

    public Weapon(String name, int magazineCapacity) {
        this.name = name;
        this.magazineCapacity = magazineCapacity;
        this.currentRounds = magazineCapacity;
        this.accessory = null;
    }

    public abstract void shoot();

    public abstract String getSpecialAbility();

    public boolean reload() {
        if (currentRounds < magazineCapacity) {
            currentRounds = magazineCapacity;
            return true;
        }
        return false;
    }

    public void setAccessory(Accesories accessory) {
        if (this.accessory != null) {
            this.accessory.disable();
        }
        this.accessory = accessory;
        if (accessory != null) {
            accessory.apply();
        }
    }

    public void removeAccessory() {
        if (accessory != null) {
            accessory.disable();
            accessory = null;
        }
    }

    public String getName() {
        return name;
    }

    public int getCurrentRounds() {
        return currentRounds;
    }

    public int getMagazineCapacity() {
        return magazineCapacity;
    }

    public Accesories getAccessory() {
        return accessory;
    }

    public String getInfo() {
        String info = name + " [" + currentRounds + "/" + magazineCapacity + "]";
        if (accessory != null) {
            info += " + " + accessory.getName();
        }
        return info;
    }
}
