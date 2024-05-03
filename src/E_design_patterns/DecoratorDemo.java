package E_design_patterns;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class DecoratorDemo {
    public static void main(String[] args) throws FileNotFoundException {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4));

        List<Integer> unmodifiableList = Collections.unmodifiableList(list);

        // unmodifiableList.add(5); // throws UnsupportedOperationException

        // not sure about this...
        InputStream fileInputStream = new FileInputStream("input.txt");
        InputStream dataInputStream = new DataInputStream(fileInputStream);
        InputStream bufferedInputStream = new BufferedInputStream(dataInputStream);

        // note that FileInputStream, DataInputStream, and BufferedInputStream all inherit from InputStream.
        // They each have a constructor that takes any type of InputStream and "decorates" that underlying InputStream with new behavior.

        // or we can do it in one statement:
        InputStream inputStream = new BufferedInputStream(new DataInputStream(new FileInputStream("input.txt")));
    }
}
