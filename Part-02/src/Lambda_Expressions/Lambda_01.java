package Lambda_Expressions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lambda_01 {
    public static void main(String[] args) {

        Employee john = new Employee("John Doe",30);
        Employee e = new Employee("E",50);
        Employee f = new Employee("F",52);
        Employee a = new Employee("A",42);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(e);
        employees.add(f);
        employees.add(a);

        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });

//        for (Employee employee: employees) {
//            System.out.println(employee.getName());
//            System.out.println(employee.getAge());
//        }

//        System.out.println("-----------------");
//
//        for (int i = 0; i < employees.size(); i++) {
//            Employee employee = employees.get(i);
//            System.out.println(employee.getName());
//            new Thread(()-> System.out.println(employee.getAge())).start();
//        }
    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1,s2);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
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

interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}

class AnotherClass {
    public String doSomething() {
        int i = 0;

        UpperConcat uc = (s1, s2) -> {
            System.out.println("Lambda Class: " + getClass().getSimpleName());
            System.out.println("i: " + i);
            String s = s1.toUpperCase() + " " + s2.toUpperCase();
            return s;
        };

        System.out.println("Another Class Name: " + getClass().getSimpleName());
        return Lambda_01.doStringStuff(uc, "String1","String2");
    }

    public void printValue() {
        int number = 25;

        Runnable r = () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Value: " + number);
        };

        new Thread(r).start();
    }
}

// calling CodeToRun class
//        new Thread(new CodeToRun()).start();

// anonymous class
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Printing Main Runnable");
//            }
//        }).start();

// lambda Expression
//        new Thread(()-> {
//            System.out.println("Lambda Runnable");
//            System.out.println("Line 2");
//            System.out.println("Line 3");
//        }).start();

    // lambda expression
//        Collections.sort(employees, (Employee emp1, Employee emp2) ->
//            emp1.getName().compareTo(emp2.getName())
//        );
//
//        for (Employee emp: employees) {
//            System.out.println(emp.getName());
//        }
//
//        UpperConcat uc = (s1, s2) -> {
//            String result = s1.toUpperCase() + " " + s2.toUpperCase();
//            return result;
//        };
//        String sillyString = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());
//        System.out.println(sillyString);

//    AnotherClass ac = new AnotherClass();
//    String s = ac.doSomething();
//        System.out.println(s);