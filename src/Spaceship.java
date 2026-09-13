public class Spaceship {
    private final String hull;
    private final String engine;
    private final int shieldStrength;
    private final String weapons;
    private final boolean hasLifeSupport;

    public Spaceship(String hull, String engine, int shieldStrength, String weapons,
               boolean hasLifeSupport) {
        this.hull = hull;
        this.engine = engine;
        this.shieldStrength = shieldStrength;
        this.weapons = weapons;
        this.hasLifeSupport = hasLifeSupport;
    }

    @Override
    public String toString() {
        return "Spaceship {" +
                "\n Hull: " + hull +
                "\n Engine: " + engine +
                "\n Shield Strength: " + shieldStrength +
                "\n Weapons: " + weapons +
                "\n Has Life Support: " + hasLifeSupport +
                "\n}";
    }
}
