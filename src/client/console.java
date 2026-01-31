package client;

import weapons.*;
import accessories.*;
import java.util.Scanner;
//Test
public class console {
    private Weapon currentWeapon;
    private Scanner scanner;

    public console() {
        scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("=== WEAPON SYSTEM ===\n");

        while (true) {
            showMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    createWeapon();
                    break;
                case "2":
                    addAccessory();
                    break;
                case "3":
                    removeAccessory();
                    break;
                case "4":
                    shootWeapon();
                    break;
                case "5":
                    reloadWeapon();
                    break;
                case "6":
                    useSpecialAbility();
                    break;
                case "7":
                    showWeaponInfo();
                    break;
                case "0":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option");
            }
            System.out.println();
        }
    }

    private void showMenu() {
        System.out.println("--- MENU ---");
        System.out.println("1. Create Weapon");
        System.out.println("2. Add Accessory");
        System.out.println("3. Remove Accessory");
        System.out.println("4. Shoot");
        System.out.println("5. Reload");
        System.out.println("6. Use Special Ability");
        System.out.println("7. Show Weapon Info");
        System.out.println("0. Exit");
        System.out.print("Choose option: ");
    }

    private void createWeapon() {
        System.out.println("\n--- Create Weapon ---");
        System.out.println("1. Rifle (30 rounds, stabilize)");
        System.out.println("2. Sniper (5 rounds, distance calculation)");
        System.out.println("3. Gun (15 rounds, rapid fire)");
        System.out.print("Choose: ");

        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1":
                currentWeapon = new Rifle();
                System.out.println("Rifle created!");
                break;
            case "2":
                currentWeapon = new Sniper();
                System.out.println("Sniper created!");
                break;
            case "3":
                currentWeapon = new Gun();
                System.out.println("Gun created!");
                break;
            default:
                System.out.println("Invalid weapon type");
        }
    }

    private void addAccessory() {
        if (currentWeapon == null) {
            System.out.println("No weapon created yet!");
            return;
        }

        System.out.println("\n--- Add Accessory ---");
        System.out.println("1. Silencer");
        System.out.println("2. Scope");
        System.out.println("3. Extended Magazine");
        System.out.print("Choose: ");

        String choice = scanner.nextLine().trim();

        Accesories newAccessory = null;
        String accessoryName = "";

        switch (choice) {
            case "1":
                newAccessory = new Silencer(75);
                accessoryName = "Silencer";
                break;
            case "2":
                newAccessory = new Scope(200);
                accessoryName = "Scope";
                break;
            case "3":
                newAccessory = new ExtendedMagazine(10);
                accessoryName = "Extended Magazine";
                break;
            default:
                System.out.println("Invalid accessory type");
                return;
        }

        if (currentWeapon.getAccessory() != null) {
            System.out.println(currentWeapon.getAccessory().getName() + " removed");
        }
        currentWeapon.setAccessory(newAccessory);
        System.out.println(accessoryName + " added!");
    }

    private void removeAccessory() {
        if (currentWeapon == null) {
            System.out.println("No weapon created yet!");
            return;
        }

        if (currentWeapon.getAccessory() == null) {
            System.out.println("No accessory attached!");
            return;
        }

        currentWeapon.removeAccessory();
        System.out.println("Accessory removed!");
    }

    private void shootWeapon() {
        if (currentWeapon == null) {
            System.out.println("No weapon created yet!");
            return;
        }

        int beforeRounds = currentWeapon.getCurrentRounds();
        currentWeapon.shoot();
        int afterRounds = currentWeapon.getCurrentRounds();

        if (beforeRounds == afterRounds && beforeRounds == 0) {
            System.out.println("Click! Out of rounds. Reload needed.");
        } else if (beforeRounds != afterRounds) {
            System.out.println(currentWeapon.getName() + " fires!");
            if (currentWeapon.getAccessory() != null) {
                System.out.println("  +" + currentWeapon.getAccessory().getName() + " effect applied");
            }
        }
    }

    private void reloadWeapon() {
        if (currentWeapon == null) {
            System.out.println("No weapon created yet!");
            return;
        }

        if (currentWeapon.reload()) {
            System.out.println("Weapon reloaded!");
        } else {
            System.out.println("Weapon already fully loaded!");
        }
    }

    private void useSpecialAbility() {
        if (currentWeapon == null) {
            System.out.println("No weapon created yet!");
            return;
        }

        if (currentWeapon instanceof Rifle) {
            ((Rifle) currentWeapon).stabilize();
            System.out.println("Rifle stabilized for better accuracy!");
        } else if (currentWeapon instanceof Sniper) {
            System.out.print("Enter target distance (meters): ");
            try {
                int distance = Integer.parseInt(scanner.nextLine().trim());
                ((Sniper) currentWeapon).calculateDistance(distance);
                System.out.println("Distance calculated: " + distance + "m");
            } catch (NumberFormatException e) {
                System.out.println("Invalid distance");
            }
        } else if (currentWeapon instanceof Gun) {
            System.out.print("Enter number of shots: ");
            try {
                int shots = Integer.parseInt(scanner.nextLine().trim());
                int beforeRounds = currentWeapon.getCurrentRounds();
                ((Gun) currentWeapon).rapidFire(shots);
                int afterRounds = currentWeapon.getCurrentRounds();
                int actualShots = beforeRounds - afterRounds;

                if (actualShots > 0) {
                    System.out.println("Gun fires " + actualShots + " rapid shots!");
                    if (currentWeapon.getAccessory() != null) {
                        System.out.println("  +" + currentWeapon.getAccessory().getName() + " effect applied");
                    }
                } else {
                    System.out.println("Click! Out of rounds. Reload needed.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number");
            }
        }
    }

    private void showWeaponInfo() {
        if (currentWeapon == null) {
            System.out.println("No weapon created yet!");
            return;
        }

        System.out.println("\n--- Weapon Info ---");
        System.out.println(currentWeapon.getInfo());
        System.out.println("Special: " + currentWeapon.getSpecialAbility());
    }
}
