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

        InputStream fileInputStream = new FileInputStream("input.txt");
        InputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);

        // note that FileInputStream, BufferedInputStream, and DataInputStream all inherit from InputStream.
        // They each have a constructor that takes any type of InputStream and "decorates" that underlying InputStream with new behavior.
        // BufferedInputStream adds buffering functionality, while DataInputStream adds the ability to read primitive data types.

        // or we can do it in one statement:
        DataInputStream dataInputStream2 = new DataInputStream(new BufferedInputStream(new FileInputStream("input.txt")));
    }
}
