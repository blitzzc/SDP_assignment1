# SDP_assignment1 — Spaceship Builder

## What is this project

For this assignment I implemented the Builder design pattern in Java. I picked a Spaceship as my product because it has a lot of parts that make sense to add one by one instead of all at once: hull, engine, shield strength, weapons, and life support. Some ships need weapons and some don't, some need life support and some don't, so building it step by step and combining the parts differently felt like a good fit for this pattern.

## How the code is organized

Everything is inside the src folder.

Spaceship.java is the Product. It just stores the final data of a spaceship (hull, engine, shield strength, weapons, life support) and has a toString() so I can print it nicely. It has no setters and all fields are final, so once a Spaceship is created it can't be changed anymore.

SpaceshipBuilder.java is the Builder. It has one method per part (setHull, setEngine, setShieldStrength, setWeapons, addLifeSupport) and each of them returns "this" so I can chain the calls one after another. It also has a build() method that checks if the important parts (hull, engine, shield strength) are actually set before creating the Spaceship, and throws an error if not.

SpaceshipDirector.java is the Director. It just knows a few ready configurations so I don't have to repeat the same setter calls every time: an Explorer Ship, a Fighter Ship, and a Cargo Ship. It uses the builder that is passed to it in the constructor.

Main.java is the Client. It builds all three ships using the Director, then builds one more custom ship directly with the Builder without the Director, and at the end it tries to build a broken ship on purpose (without a hull) to show that the validation actually works.

## Clean Code principles I used

1. Meaningful names. All my classes and methods say exactly what they do, like setHull, addLifeSupport, buildFighterShip. I avoided short unclear names like s1 or tmp.

2. Small methods that do one thing. Every setter in SpaceshipBuilder only sets one value and returns itself, nothing more. The build() method only checks the values and creates the object, it doesn't print anything or do extra work.

3. No magic numbers or strings. Instead of writing the number 20 or the word "None" directly in the code, I made constants for them at the top of SpaceshipBuilder: MIN_SHIELDSTRENGTH and DEFAULT_WEAPONS. This way if I ever need to change the minimum shield value I only change it in one place.

Before:
if (shieldStrength < 20) { throw new IllegalStateException("..."); }

After:
private static final int MIN_SHIELDSTRENGTH = 20;
if (shieldStrength < MIN_SHIELDSTRENGTH) { throw new IllegalStateException("..."); }

4. Validated construction. Before build() actually creates a Spaceship, it checks that hull and engine are not empty and that shield strength is above the minimum. If something is missing it throws an IllegalStateException with a message explaining what went wrong, instead of creating a broken object.

Before:
return new Spaceship(hull, engine, shieldStrength, weapons, hasLifeSupport);

After:
if (hull == null || hull.isEmpty()) {
    throw new IllegalStateException("Cannot build a Spaceship without hull");
}
return new Spaceship(hull, engine, shieldStrength, weapons, hasLifeSupport);

5. Small, focused classes. Each class only has one job. Spaceship only holds data, SpaceshipBuilder only builds, SpaceshipDirector only stores ready configurations, and Main only runs everything and prints results. I didn't mix these responsibilities together in one big class.

## A couple of design decisions

I made every setter in the builder return "this" so I could chain them like setHull(...).setEngine(...).build() instead of writing a separate line for every single part.

The Director is not required to use the builder, it's just there to save time for common ships. In Main I show both ways: using the Director for the three presets, and using the Builder directly for a fully custom ship.

I decided that life support should be optional and not required in build(), because a cargo ship without crew doesn't necessarily need it, but hull, engine and shield strength are required since a ship can't really work without them.
