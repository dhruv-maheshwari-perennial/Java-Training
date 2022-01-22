package Lambda_Expressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda_03 {
    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g64",
                "I26", "I17", "I29",
                "O71");

        List<String> gNumbers = new ArrayList<>();

//        someBingoNumbers.forEach(number -> {
//            if (number.toUpperCase().startsWith("G")) {
//                gNumbers.add(number);
////                System.out.println(number);
//            }
//        });
//
//        gNumbers.sort((String s1, String s2) -> s1.compareTo(s2));
//        gNumbers.forEach((String s) -> System.out.println(s));

        someBingoNumbers
                .stream()
                .map(String :: toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);

        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "O71");
        Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I17", "I29", "O71");
        Stream<String> concateStream = Stream.concat(ioNumberStream, inNumberStream);
        System.out.println("--------------------------------");
        System.out.println(concateStream
                .distinct()
                .peek(System.out::println)
                .count());

        Emp dhruv = new Emp("Dhruv Maheshwari", 30);
        Emp mayank = new Emp("Mayank Varshney", 25);
        Emp harshit = new Emp("Harshit Kumar", 40);
        Emp vaibhav = new Emp("Vaibhav Singh", 22);

        Dept hr = new Dept("Human Resources");
        hr.addEmp(dhruv);
        hr.addEmp(mayank);
        hr.addEmp(vaibhav);

        Dept acc = new Dept("Accounts");
        acc.addEmp(harshit);

        List<Dept> depts = new ArrayList<Dept>();
        depts.add(hr);
        depts.add(acc);

        System.out.println("-----------------------");

        depts.stream()
                .flatMap(d -> d.getEmps().stream())
                .forEach(System.out::println);

        System.out.println("-----------------------");

        List<String> sortedGNumbers = someBingoNumbers
                .stream()
                .map(String :: toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        for (String s: sortedGNumbers) {
            System.out.println(s);
        }

        Map<Integer, List<Emp>> groupedByAge = depts.stream()
                .flatMap(d -> d.getEmps().stream())
                .collect(Collectors.groupingBy(e -> e.getAge()));

        depts.stream()
                .flatMap(d -> d.getEmps().stream())
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
                .ifPresent(System.out::println);

        Stream.of("ABC", "AC", "BAA", "CCCC", "XY", "ST")
                .filter(s -> {
                    System.out.println(s);
                    return s.length() == 3;
                })
                .count();
    }
}

class Emp {
    private String name;
    private int age;

    public Emp(String name, int age) {
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

    @Override
    public String toString() {
        return name;
    }
}

class Dept {
    private String deptName;
    private List<Emp> emps;

    public Dept(String deptName) {
        this.deptName = deptName;
        this.emps = new ArrayList<Emp>();
    }

    public void addEmp(Emp emp) {
        emps.add(emp);
    }

    public List<Emp> getEmps() {
        return emps;
    }
}