package Exercise;

// Exercise 24 - Composition
class Lamp {
    private String style;
    private boolean battery;
    private int globalRating;

    public Lamp(String style, boolean battery, int globalRating) {
        this.style = style;
        this.battery = battery;
        this.globalRating = globalRating;
    }

    public void turnOn() {
        System.out.println("Lamp -> Turning On");
        System.out.println("The lamp is being turned on.");
    }

    public String getStyle() {
        return style;
    }

    public int getGlobalRating() {
        return globalRating;
    }

    public boolean isBattery() {
        return battery;
    }
}

class Bed {
    private String style;
    private int pillows, height, sheets, quilt;

    public Bed(String style, int pillows, int height, int sheets, int quilt) {
        this.style = style;
        this.pillows = pillows;
        this.height = height;
        this.sheets = sheets;
        this.quilt = quilt;
    }

    public void make() {
        System.out.println("Bed -> Making | ");
        System.out.println("The Bed is being made: ");
    }

    public String getStyle() {
        return style;
    }

    public int getPillows() {
        return pillows;
    }

    public int getHeight() {
        return height;
    }

    public int getSheets() {
        return sheets;
    }

    public int getQuilt() {
        return quilt;
    }
}

class Ceiling {
    private int height, paintedColor;

    public Ceiling(int height, int paintedColor) {
        this.height = height;
        this.paintedColor = paintedColor;
    }

    public int getHeight() {
        return height;
    }

    public int getPaintedColor() {
        return paintedColor;
    }
}

class RoomWall {
    private String direction;

    public RoomWall(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }
}

class Bedroom {
    private String name;
    private RoomWall wall1, wall2, wall3, wall4;
    private Ceiling ceiling;
    private Bed bed;
    private Lamp lamp;

    public Bedroom(String name, RoomWall wall1, RoomWall wall2, RoomWall wall3, RoomWall wall4, Ceiling ceiling, Bed bed, Lamp lamp) {
        this.name = name;
        this.wall1 = wall1;
        this.wall2 = wall2;
        this.wall3 = wall3;
        this.wall4 = wall4;
        this.ceiling = ceiling;
        this.bed = bed;
        this.lamp = lamp;
    }

    public Lamp getLamp() {
        return lamp;
    }

    public void makeBed() {
        System.out.println("Bedroom => Making bed | ");
        bed.make();
    }
}

public class Exercise_24 {
    public static void main(String[] args) {
        RoomWall wall1 = new RoomWall("West");
        RoomWall wall2 = new RoomWall("East");
        RoomWall wall3 = new RoomWall("South");
        RoomWall wall4 = new RoomWall("North");

        Ceiling ceiling = new Ceiling(12, 55);

        Bed bed = new Bed("Modern", 4, 3,2,1);

        Lamp lamp = new Lamp("Classic", false, 75);

        Bedroom bedRoom = new Bedroom("Dhruv Maheshwari", wall1, wall2, wall3, wall4, ceiling, bed, lamp);
        bedRoom.makeBed();
        bedRoom.getLamp().turnOn();
    }
}
