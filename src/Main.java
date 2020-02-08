import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Main {

    public static void main(String[] args) {
//        System.out.println(fibonacci(10));
        int[] arrayToSort = {4, 3, 2, 1, 6, 6, 0, -1};
//        bubbleSortWhile(arrayToSort);
        bubbleSortFor(arrayToSort);
        System.out.println(Arrays.toString(arrayToSort));
        personsNames(List.of(new Person("Marcin", 18)));

        final Person one = new Person("A", 18);
        final Person two = new Person("B", 16);
        final Person three = new Person("B", 20);
//        changeReference(one, two);
//        System.out.println(one.getName());

        List<Person> persons = new ArrayList<>();
        persons.add(one);
        persons.add(two);
        persons.add(three);
        removeAdults(persons);
    }

    public static void removeAdults(List<Person> personList) {
        final Iterator<Person> iterator = personList.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            if (person.getAge() >= 18) {
                iterator.remove();
            }
        }
    }

    public static void bubbleSortFor(int[] arrayToSort) {
        for (int i = 0; i < arrayToSort.length; i++) {
            for (int j = 0; j < arrayToSort.length - 1; j++) {
                int firstNumber = arrayToSort[j];
                int secondNumber = arrayToSort[j + 1];
                if (firstNumber > secondNumber) {
                    arrayToSort[j + 1] = firstNumber;
                    arrayToSort[j] = secondNumber;
                }
            }
        }
    }

    public static void bubbleSortWhile(int[] arrayToSort) {
        boolean hasChanged = true;
        while(hasChanged) {
            hasChanged = false;
            for (int i = 0; i < arrayToSort.length - 1; i ++) {
                int firstNumber = arrayToSort[i];
                int secondNumber = arrayToSort[i + 1];
                if (firstNumber > secondNumber) {
//                    int swap = secondNumber;
                    arrayToSort[i + 1] = firstNumber;
//                    arrayToSort[i] = swap;
                    arrayToSort[i] = secondNumber;
                    hasChanged = true;
                }
            }
        }
    }

    public static int fibonacci(int number) {
        return number <= 2 ? 1 : fibonacci(number - 1) + fibonacci(number - 2);
    }

    private static List<String> personsNames(List<Person> persons) {
        return persons.stream()
            .map(person -> person.getName())
            .map(name -> name.toUpperCase())
            .collect(Collectors.toList());
    }

    private static void changeReference(Person one, Person two) {
        one = two;
        two = one;
    }

    private static class Person {
        private String name;
        private int age;

        public Person(final String name, final int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(final String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(final int age) {
            this.age = age;
        }
    }
}
