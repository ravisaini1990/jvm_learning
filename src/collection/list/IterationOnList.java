package collection.list;

import java.util.ArrayList;
import java.util.List;

public class IterationOnList {

    public static void main(String[] args) {

        List<String> bestLanguages = new ArrayList<>();
        bestLanguages.add("Java");
        bestLanguages.add("Kotlin");
        bestLanguages.add("Dart");
        bestLanguages.add("C#");
        bestLanguages.add("C++");

        //legacy - for loop
        for (int languageIndex =0 ; languageIndex < bestLanguages.size(); languageIndex++) {
            System.out.println(bestLanguages.get(languageIndex));

        }
        System.out.println("-------------");

        for (String language : bestLanguages) {
            System.out.println(language);

        }
        System.out.println("-------------");

        bestLanguages.forEach(language -> System.out.println(language));
        System.out.println("-------------");
        bestLanguages.forEach(System.out::println);
        System.out.println("-------------");
        bestLanguages.stream().forEach(language -> System.out.println(language));
        System.out.println("-------------");

    }
}
