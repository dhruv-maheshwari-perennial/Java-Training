package OOPs_Concept;

class Movies {
    private final String name;

    Movies(String name) {
        this.name = name;
    }

    public String plot() {
        return "No plot here";
    }

    public String getName() {
        return name;
    }
}

class Jaws extends Movies {
    Jaws() {
        super("Jaws");
    }

    @Override
    public String plot() {
        return "A shark eats lots of people";
    }
}

class IndependenceDay extends Movies {
    IndependenceDay() {
        super("Independence Day");
    }

    @Override
    public String plot() {
        return "Aliens attempt to take over planet earth";
    }
}

class MazeRunner extends Movies {
    MazeRunner() {
        super("Maze Runner");
    }

    @Override
    public String plot() {
        return "Kids try & escape a maze";
    }
}

class StarWars extends Movies {
    StarWars() {
        super("Star Wars");
    }

    @Override
    public String plot() {
        return "Imperial Forces try to take over the universe";
    }
}

class Forgetable extends Movies {
    Forgetable() {
        super("Forgetable");
    }

    // no plot method
}

public class Polymorphism_05 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Movies movie =  randomMovie();
//            assert movie != null;
            System.out.println("Movie #" + i + " : " + movie.getName() + "\n" + "Plot: " + movie.plot() + "\n");
        }
    }

    public static Movies randomMovie() {
        int randomNumber = (int) (Math.random() * 5) + 1;
        System.out.println("Random Number generated was: " + randomNumber);
        return switch (randomNumber) {
            case 1 -> new Jaws();
            case 2 -> new IndependenceDay();
            case 3 -> new MazeRunner();
            case 4 -> new StarWars();
            case 5 -> new Forgetable();
            default -> null;
        };
    }
}
