package Java_Collections;

import java.util.*;

class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addMoon(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        System.out.println("obj.getClass() --> " + obj.getClass());
        System.out.println("this.getClass() --> " + this.getClass());

        if ((obj == null) || (obj.getClass() != this.getClass())) return false;

        String objName = ((HeavenlyBody) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
//        System.out.println("hashcode");
        return this.name.hashCode() + 57;
    }
}

public class Set_HashSet_03 {
    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {
        HeavenlyBody temp = new HeavenlyBody("Mercury", 88);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Venus", 225);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Earth", 365);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        HeavenlyBody tempMoon = new HeavenlyBody("Moon", 27);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);

        temp = new HeavenlyBody("Mars", 687);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new HeavenlyBody("Deimos", 1.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp ---> Mars

        tempMoon = new HeavenlyBody("Phobos", 0.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp ---> Mars

        temp = new HeavenlyBody("Jupiter", 4332);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new HeavenlyBody("Io", 1.8);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp ---> Jupiter

        tempMoon = new HeavenlyBody("Europa", 3.5);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp ---> Jupiter

        tempMoon = new HeavenlyBody("Ganymede", 7.1);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp ---> Jupiter

        tempMoon = new HeavenlyBody("Callisto", 16.7);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp ---> Jupiter

        temp = new HeavenlyBody("Saturn", 10759);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Uranus", 30660);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Neptune", 165);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Pluto", 248);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        System.out.println("Planets: ");
        for (HeavenlyBody planet: planets) {
            System.out.println(planet.getName());
        }

        System.out.println("===========================");

        HeavenlyBody body = solarSystem.get("Jupiter");
        System.out.println("Moons of " + body.getName() + ": ");
        for (HeavenlyBody jupiterMoon: body.getSatellites()) {
            System.out.println(jupiterMoon.getName());
        }

        System.out.println("===========================");

        Set<HeavenlyBody> moons = new HashSet<>();
        for (HeavenlyBody planet: planets) {
            moons.addAll(planet.getSatellites());
        }

        System.out.println("All moons");
        for (HeavenlyBody moon: moons) {
            System.out.println(moon.getName());
        }

        System.out.println("===========================");

        HeavenlyBody pluto = new HeavenlyBody("Pluto", 842);
        planets.add(pluto);

        for (HeavenlyBody planet: planets) {
            System.out.println(planet.getName() + ": " + planet.getOrbitalPeriod());
        }

        // equals() & hashcode() methods
        Object o = new Object();
        o.equals(o);
        "pluto".equals("");
    }
}
