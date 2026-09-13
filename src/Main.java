public class Main {
    public static void main(String[] args) {
        SpaceshipDirector director = new SpaceshipDirector(new SpaceshipBuilder());
        Spaceship explorerShip = director.buildExplorerShip();
        System.out.println("Explorer Ship: ");
        System.out.println(explorerShip);

        director = new SpaceshipDirector(new SpaceshipBuilder());
        Spaceship fighterShip = director.buildFighterShip();
        System.out.println("\nFighter Ship: ");
        System.out.println(fighterShip);

        director = new SpaceshipDirector(new SpaceshipBuilder());
        Spaceship cargoShip = director.buildCargoShip();
        System.out.println("\nCargo Ship: ");
        System.out.println(cargoShip);

        Spaceship customShip = new SpaceshipBuilder()
                .setHull("Experimental Alloy Hull")
                .setEngine("Warp Drive")
                .setShieldStrength(80)
                .setWeapons("Photon Torpedoes")
                .addLifeSupport()
                .build();
        System.out.println("\nCustom Ship:");
        System.out.println(customShip);

        try {
            new SpaceshipBuilder()
                .setEngine("Ion Engine").build();
        } catch (IllegalStateException e) {
            System.out.println("\nValidation works! Error: " + e.getMessage());
        }
    }
}