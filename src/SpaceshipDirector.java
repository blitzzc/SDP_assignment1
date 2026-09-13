public class SpaceshipDirector {
    private final SpaceshipBuilder builder;

    public SpaceshipDirector(SpaceshipBuilder builder) {
        this.builder = builder;
    }

    public Spaceship buildExplorerShip() {
        return builder
                .setHull("Aluminum-lithium hull")
                .setEngine("Chemical rocket engines")
                .setShieldStrength(20)
                .addLifeSupport()
                .build();
    }

    public Spaceship buildFighterShip() {
        return builder
                .setHull("Reinforced Titanium Hull")
                .setEngine("Plasma engine")
                .setShieldStrength(80)
                .setWeapons("Railguns")
                .addLifeSupport()
                .build();
    }

    public Spaceship buildCargoShip() {
        return builder
                .setHull("Stainless steel")
                .setEngine("Hyperdrive")
                .setShieldStrength(30)
                .build();
    }
}
