package Java_Collections;

import java.util.*;

public class Maps_02 {
    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();

        if (languages.containsKey("Java")) {
            System.out.println("Java already exists");
        } else {
            languages.put("Java", "a compiled high level, object oriented, platform independent language");
            System.out.println("Java Added successfully");
        }

        languages.put("Python", "an interpreted, object-oriented, high-level programming language with dynamic semantics");
        languages.put("SQL", "a database language");
        System.out.println(languages.put("BASIC", "Beginners All Purposes Symbolic Instruction"));
        languages.put("Lisp", "Therein lies madness");
        System.out.println(languages.get("Java"));

        // checking if key exists
        if (languages.containsKey("Java")) {
            System.out.println("Java is already in the map");
        } else {
            languages.put("Java", "this course is about java");
        }

        // removing key
        languages.remove("lisp");

        if (languages.remove("SQL","a lanaguage for database")) {
            System.out.println("SQL removed");
        } else {
            System.out.println("SQL not removed");
        }

        System.out.println("=============================");

        // printing all key:value pair in map
        for (String key: languages.keySet()) {
            System.out.println(key + " : " + languages.get(key));
        }
    }
}
