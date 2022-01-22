package Lambda_Expressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

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
