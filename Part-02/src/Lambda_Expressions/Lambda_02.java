package Lambda_Expressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

class Employees {
    private String name;
    private int age;

    public Employees(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class Lambda_02 {
    public static void main(String[] args) {
        Employees kartik = new Employees("Kartik Maheshwari",30);
        Employees mayank = new Employees("Mayank Varshney",50);
        Employees dhruv = new Employees("Dhruv Maheshwari",52);
        Employees pratham = new Employees("Pratham Yadav",42);
        Employees harshit = new Employees("Harshit Kumar",35);
        Employees ekagra = new Employees("Ekagra Kumar",22);

        List<Employees> emps = new ArrayList<Employees>();
        emps.add(kartik);
        emps.add(mayank);
        emps.add(dhruv);
        emps.add(pratham);
        emps.add(harshit);
        emps.add(ekagra);

        Function<Employees, String> getLastName = (Employees emp) -> {
            return emp.getName().substring(emp.getName().indexOf(" ") + 1);
        };

        String lastName = getLastName.apply(emps.get(1));
        System.out.println(lastName);

        Function<Employees, String> getFirstName = (Employees emp) -> {
            return emp.getName().substring(0, emp.getName().indexOf(" "));
        };

        Random random = new Random();
        for (Employees emp: emps) {
            if (random.nextBoolean()) {
                System.out.println(getAName(getFirstName, emp));
            } else {
                System.out.println(getAName(getLastName, emp));
            }
        }

        // Single Parameter Function
        Function<Employees, String> upperCase = employees -> employees.getName().toUpperCase();
        Function<String, String> firstName = name -> name.substring(0, name.indexOf(' '));
        Function chainedFunctions = upperCase.andThen(firstName);
        System.out.println(chainedFunctions.apply(emps.get(0)));

        // Double Parameter Function
        BiFunction<String, Employees, String> concatAge = (String name, Employees emp) -> {
            return name.concat(" " + emp.getAge());
        };

        String upperName = upperCase.apply(emps.get(0));
        System.out.println(concatAge.apply(upperName, emps.get(0)));

        IntUnaryOperator incBy5 = i -> i + 5;
        System.out.println(incBy5.applyAsInt(10));

        Consumer<String> c1 = s -> s.toUpperCase();
        Consumer<String> c2 = s -> System.out.println(s);
        c1.andThen(c2).accept("Hello World");
    }

    private static String getAName(Function<Employees, String> getName, Employees emp) {
        return getName.apply(emp);
    }

    private static void printEmployeesByAge(List<Employees> emps, String ageText, Predicate<Employees> ageCondition) {
        System.out.println("Employees over " + ageText + ": ");
        System.out.println("===================");

        for (Employees emp: emps) {
            if (ageCondition.test(emp)) {
                System.out.println(emp.getName());
            }
        }
    }
}
