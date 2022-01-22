package Lambda_Expressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
        Employees kartik = new Employees("Kartik",30);
        Employees mayank = new Employees("Mayank",50);
        Employees dhruv = new Employees("Dhruv",52);
        Employees pratham = new Employees("Pratham",42);
        Employees harshit = new Employees("Harshit",35);
        Employees ekagra = new Employees("Ekagra",22);

        List<Employees> emps = new ArrayList<Employees>();
        emps.add(kartik);
        emps.add(mayank);
        emps.add(dhruv);
        emps.add(pratham);
        emps.add(harshit);
        emps.add(ekagra);

        printEmployeesByAge(emps, "30", employees -> employees.getAge()>30);
        printEmployeesByAge(emps, "30 and under", employees -> employees.getAge()<=30);
        printEmployeesByAge(emps, "younger than 25", new Predicate<Employees>() {
            @Override
            public boolean test(Employees emps) {
                return emps.getAge() < 25;
            }
        });

        IntPredicate intp = i -> i > 15;
        IntPredicate intp2 = i -> i < 100;
        System.out.println(intp.test(10));

        int a = 20;
        System.out.println(intp.test(a+5));

        System.out.println(intp.and(intp2).test(50));
        System.out.println(intp.and(intp2).test(15));

        Random random = new Random();
        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);
        for (int i = 0; i < 10; i++) {
            System.out.println(randomSupplier.get());
        }
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
