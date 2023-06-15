package order;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class PersonComparator {
    private String name;
    private int age;

    public PersonComparator(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class ComparatorTest {
    public static void main(String[] args) {
        List<PersonComparator> personComparatorList = new ArrayList<>();
        personComparatorList.add(new PersonComparator("Alice", 25));
        personComparatorList.add(new PersonComparator("Bob", 20));
        personComparatorList.add(new PersonComparator("Charlie", 35));

        personComparatorList.sort(new AgeComparator());

        for (PersonComparator personComparator : personComparatorList) {
            System.out.println("personComparator.getName() + \"-\" + personComparator.getAge() = " + personComparator.getName() + "-" + personComparator.getAge());
        }
    }

    static class AgeComparator implements Comparator<PersonComparator> {
        @Override
        public int compare(PersonComparator o1, PersonComparator o2) {
            return Integer.compare(o1.getAge(), o2.getAge());
        }
    }
}
