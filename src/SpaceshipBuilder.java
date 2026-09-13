public class SpaceshipBuilder {
    private static final int MIN_SHIELDSTRENGTH = 20;
    private static final String DEFAULT_WEAPONS = "None";

    private String hull;
    private String engine;
    private int shieldStrength;
    private String weapons = DEFAULT_WEAPONS;
    private boolean hasLifeSupport;

    public SpaceshipBuilder setHull(String hull) {
        this.hull = hull;
        return this;
    }

    public SpaceshipBuilder setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public SpaceshipBuilder setShieldStrength(int shieldStrength) {
        this.shieldStrength = shieldStrength;
        return this;
    }

    public SpaceshipBuilder setWeapons(String weapons) {
        this.weapons = weapons;
        return this;
    }

    public SpaceshipBuilder addLifeSupport() {
        this.hasLifeSupport = true;
        return this;
    }

    public Spaceship build() {
        if (hull == null || hull.isEmpty()) {
            throw new IllegalStateException("Cannot build a Spaceship without hull");
        }
        if (engine == null || engine.isEmpty()) {
            throw new IllegalStateException("Cannot build a Spaceship without engine");
        }
        if (shieldStrength < MIN_SHIELDSTRENGTH) {
            throw new IllegalStateException("Shield Strength must be at least " + MIN_SHIELDSTRENGTH);
        }
        return new Spaceship(hull, engine, shieldStrength, weapons, hasLifeSupport);
    }
}
