package D_effective_java.ch4.item20;

import java.util.*;

class Person {
    public String getInfo() {
        return "person";
    }

    public int getMagicNumber() {
        return 33;
    }
}

public class Main {
    public static void main(String[] args) {
        String[] arr = {"a", "b", "c"};
        List<String> list = new UnmodifiableList<>(arr);
        System.out.println(list); // [a, b, c]

//        Iterator<String> iter = list.iterator();
//        while (iter.hasNext()) {
//            System.out.println(iter.next());
//        }

        for (Iterator<String> iter = list.iterator(); iter.hasNext(); ) {
            System.out.println(iter.next());
        }

//        Comparator<String> myComparator = new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return Integer.compare(o1.length(), o2.length());
//            }
//        };

        Comparator<String> myComparator = (o1, o2) -> Integer.compare(o1.length(), o2.length());

        // anonymous class
        var p = new Person() {
            @Override
            public String getInfo() {
                return "student";
            }

            public void doSomething() {
                System.out.println("doing something...");
            }
        };

        System.out.println(p.getMagicNumber()); // 33
        System.out.println(p.getInfo()); // student
        System.out.println(p.getClass().getName()); // D_effective_java.ch4.item20.Main$1
        p.doSomething();

        int[] intArr = {1, 3, 2, 6, 7, 3, 4};
        List<Integer> listViewOfIntArr = IntArrays.asList(intArr);
        System.out.println(listViewOfIntArr.lastIndexOf(3)); // 5

        // adaptor pattern

        List<String> listViewOfArr = Arrays.asList(arr);
        listViewOfArr.set(1, "new element");
        arr[2] = "another new element";
        System.out.println(Arrays.toString(arr));
        System.out.println(listViewOfArr);

        List<String> listOfArr = List.of(arr);
        arr[1] = "a very new element";
        System.out.println(listOfArr);

//        List<String> separateList = new ArrayList<>(Arrays.asList(arr));

    }
}

class IntArrays {
    public static List<Integer> asList(int[] arr) {
        return new AbstractList<>() {
            @Override
            public int size() {
                return arr.length;
            }

            @Override
            public Integer get(int index) {
                return arr[index];
            }

            @Override
            public Integer set(int index, Integer element) {
                Integer removed = arr[index];
                arr[index] = element;
                return removed;
            }
        };
    }
}

class UnmodifiableList<E> extends AbstractList<E> implements List<E> {
    private final E[] elements;

    public UnmodifiableList(E[] elements) {
        this.elements = Arrays.copyOf(elements, elements.length);
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= elements.length) {
            throw new IndexOutOfBoundsException();
        }

        return elements[index];
    }

    @Override
    public int size() {
        return elements.length;
    }
}