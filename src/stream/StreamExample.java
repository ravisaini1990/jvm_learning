package stream;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class StreamExample {

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        //System.out.print("Hello and welcome!");

        List<String> names = Arrays.asList("John", "Alice", "Bob");

        names.forEach(System.out::println);
        List<String> filteredList = names.stream().filter(item -> item.startsWith("A")).toList();

        for (String item: filteredList) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println(item);
        }

        //Method Referencing instead of i -> Sop(i)
        filteredList.forEach(System.out::println);

        List<stream.Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(new stream.Employee(23, "Sanjeev", 25000));
        employeeList.add(new stream.Employee(33, "Rajeev", 22000));
        employeeList.add(new stream.Employee(43, "Kan", 15000));
        employeeList.add(new stream.Employee(32, "Chin", 55000));

        List<stream.Employee> finalList =  employeeList.stream().sorted().toList();
        System.out.println(finalList);

        List<String> names2 = Arrays.asList("peter", null, "anna", "mike", "xenia");
        names2.sort(Comparator.nullsLast(String::compareTo));
        System.out.println(names2);

        List<String> names3 = null;

        Optional.ofNullable(names3).ifPresent(list -> list.sort(Comparator.naturalOrder()));

        //System.out.println(names3);
    }
}

class Employee {
    int age;
    String name;
    double salary;

    Employee(int age, String name, double salary) {
        this.salary = salary;
        this.age = age;
        this.name = name;
    }
}