package finalexam.qanda;

import java.util.*;
import java.util.function.Predicate;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int candy : candies)
            if (candy > max)
                max = candy;

        int finalMax = max;

        return new AbstractList<>() {
            @Override
            public Boolean get(int index) {
                return candies[index] + extraCandies >= finalMax;
            }

            @Override
            public int size() {
                return candies.length;
            }
        };

        /*
        // works fine:
        int max = 0;
        for (int candy : candies)
            if (candy > max)
                max = candy;

        List<Boolean> result = new ArrayList<>(candies.length);
        for (int candy : candies)
            result.add(candy + extraCandies >= max);

        return result;
        */
    }
}

class ListOfSizeThreeContainingZeroTenTwenty extends AbstractList<Integer> {
    @Override
    public Integer get(int index) {
        return index * 10;
    }

    @Override
    public int size() {
        return 3;
    }
}

class SolutionDemo {
    public static void main(String[] args) {
        int[] candies = {2,3,5,1,3};
        int extraCandies = 3;
        List<Boolean> result = new Solution().kidsWithCandies(candies, extraCandies);

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

        List<Integer> customList = new ListOfSizeThreeContainingZeroTenTwenty();
        System.out.println(customList.contains(10));
    }
}

/*
Write an enum named Season with the following values: SPRING, SUMMER, FALL, and WINTER.
The enum should have a public getWeather() method.
For SPRING and FALL, the method should return “mild”;
for SUMMER, it should return “hot”;
for WINTER, it should return “cold”.
(You should include a constructor and a private field.)
 */

// less good options are: switch in getWeather, switch in constructor.
// but those options cause at best a runtime error when adding a season, but we prefer a compilation error

enum Season {
    SPRING("mild"), SUMMER("hot"), FALL("mild"), WINTER("cold");

    private final String weather;

    Season(String weather) {
        this.weather = weather;
    }

    public String getWeather() {
        return weather;
    }
}

class SeasonDemo {
    public static void main(String[] args) {
        for (Season season : Season.values()) {
            System.out.println(season + " is " + season.getWeather());
        }
    }
}

/*
Suppose we have the following Document class:
public class Document {
    private final String title, content;

    public Document(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // getters, equals, and hashCode
}

We would now like to write a DocumentList class.
Each DocumentList represents a list of at least one Document.
That is, an invariant of this class is that each DocumentList object
contains at least one document.


We now want to write the body of the first constructor.
For each of the following proposals, if it is safe, say so.
Otherwise, explain why it's unsafe, using a code example.
(If the explanation depends upon multithreading, you may omit the code example.)
---> See below in constructor and in main method.

Next, write the body of the second constructor.
---> See below.

We now want to write the body of the copy constructor.
For each of the following proposals, if it makes a safe independent copy, say so.
Otherwise, explain why it's unsafe or not independent, using a code example.


Finally, the getDocuments() method.
For each of the following proposals, if it is safe, say so.
Otherwise, explain why it's unsafe, using a code example.
i.
return documents;
ii.
return new ArrayList<>(documents);
iii.
return List.copyOf(documents);
iv.
return Collections.unmodifiableList(documents);

For the getDocuments() method, more than one proposal is safe. Which is the best?
--- > Not enough information, see below in method
 */

class Document {
    private final String title, content;

    public Document(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return title + ": " + content;
    }

    // getters, equals, and hashCode
}

class DocumentList {
    private final List<Document> documents;

    public DocumentList(List<Document> documents) {
        this.documents = new ArrayList<>(documents);
        if (this.documents.isEmpty()) {
            throw new IllegalArgumentException("empty documents list");
        }

        // we need to make sure of all these points:
        // 1. make a defensive copy
        // 2. check for emptiness after making the copy
        // 3. check the copy, not the original


        /*
        0.
        this.documents = documents;
        // see below in main for issue

        i.
        this.documents = documents;
        if (this.documents.isEmpty()) {
            throw new IllegalArgumentException("empty documents list");
        }
        // see below in main for issue

        ii.
        this.documents = Collections.unmodifiableList(documents);
        if (this.documents.isEmpty()) {
            throw new IllegalArgumentException("empty documents list");
        }
        // see below in main for issue

        iii.
        if (this.documents.isEmpty()) {
            throw new IllegalArgumentException("empty documents list");
        }
        this.documents = new ArrayList<>(documents);
        // compilation error, since this.documents hasn't yet been initialized.
        // if the documents field hadn't been final, then there would be a MullPointerException

        iv.
        if (documents.isEmpty()) {
            throw new IllegalArgumentException("empty documents list");
        }
        this.documents = new ArrayList<>(documents);
        // perhaps the original list was cleared in another thread after passing the test
        // but before being copied.

        v.
        this.documents = new ArrayList<>(documents);
        if (documents.isEmpty()) {
            throw new IllegalArgumentException("empty documents list");
        }
        // perhaps the original list was empty at the time it was copied, then elements
        // were added to it in another thread, so an exception doesn't get thrown.

        vi.
        this.documents = new ArrayList<>(documents);
        if (this.documents.isEmpty()) {
            throw new IllegalArgumentException("empty documents list");
        }
        // good

        vii.
        this.documents = List.copyOf(documents);
        if (this.documents.isEmpty()) {
            throw new IllegalArgumentException("empty documents list");
        }
        // see below
         */
    }

    public DocumentList(Document first, Document... rest) {
        documents = new ArrayList<>(List.of(first));
        documents.addAll(List.of(rest));
    }

    public DocumentList(DocumentList original) { // copy constructor
        this.documents = new ArrayList<>(original.documents);

        /*
        i.
        this.documents = original.documents;
        // see below in main for issue

        ii.
        this.documents = Collections.unmodifiableList(original.documents);
        // see below

        iii.
        this.documents = new ArrayList<>(original.documents);
        // good

        iv.
        this(original.getDocuments());
        // good
         */
    }

    public void add(Document document) {
        documents.add(document);
    }

    public Document remove(int documentIndexNumber) {
        if (documentIndexNumber < 0 || documentIndexNumber >= documents.size()) {
            throw new IllegalArgumentException("invalid document number");
        }

        if (documents.size() == 1) {
            throw new IllegalStateException("only one document left");
        }

        return documents.remove(documentIndexNumber);
    }

    public List<Document> getDocuments() {
        return new ArrayList<>(documents);

        /*
        i.
        return documents;
        // unsafe, see below

        ii.
        return new ArrayList<>(documents);
        // safe

        iii.
        return List.copyOf(documents);
        // safe

        iv.
        return Collections.unmodifiableList(documents);
        // safe

        As for the best, an argument can be made for either ii., iii., for iv.
        If the documentation says that getDocuments returns a modifiable list, then ii.
        If it simply says returns a list, then iii is best, since no promise of modifiability was made.
        If it says returns a "view", then iv.
         */
    }
}

class DocumentListDemo {
    public static void main(String[] args) {
        // first constructor

        // 0.
        // List<Document> list = new ArrayList<>();
        // DocumentList documentList = new DocumentList(list);

        // i.
        // List<Document> list = new ArrayList<>();
        // list.add(new Document("sample title", "sample content"));
        // DocumentList documentList = new DocumentList(list);
        // list.clear();

        // ii.
        // List<Document> list = new ArrayList<>();
        // list.add(new Document("sample title", "sample content"));
        // DocumentList documentList = new DocumentList(list);
        // list.clear();

        // vii.
        // List<Document> list = new ArrayList<>();
        // list.add(new Document("a", "b"));
        // DocumentList documentList = new DocumentList(list);
        // documentList.add(new Document("c", "d")); // UnsupportedOperationException

        // second constructor

        // i.
        // DocumentList documentList1 = new DocumentList(new Document("a", "b"));
        // DocumentList documentList2 = new DocumentList(documentList1);
        // documentList1.add(new Document("c", "d"));
        // System.out.println(documentList2.getDocuments()); // [a: b, c: d]

        // ii.
        // first of all, same issue as in i.
        // also, if we try to add to documentList2, we get an UnsupportedOperationException

        // getDocuments method

        // i.
        DocumentList documentList = new DocumentList(new Document("a", "b"));
        List<Document> list = documentList.getDocuments();
        list.clear();
        System.out.println(documentList.getDocuments()); // []
    }
}

/*
Write the following static methods.
Each method should accept an arbitrary number of arguments, but at least one.
For example, for the average method, it should be possible to say average(1.5),
average(1.5, 4.6), average(5.6, 7.8, 3.2), etc.,
but it should not be possible to say average(); the compiler should prevent this.
(You should not accomplish this by having the method throw an exception;
again, this should be prevented by the compiler.)

- The average method should accept doubles as arguments and return their average.
- The and method should accept booleans and return true if all the provided booleans are true.
- The or method should accept booleans and return true if any of the provided booleans is true.
 */

class Question6 {
    public static void main(String[] args) {
        // System.out.println(average()); // doesn't compile
        System.out.println(average(5.6));
        System.out.println(average(1, 2));
    }

    public static double average(double first, double... rest) {
        double sum = first;

        for (double number : rest) {
            sum += number;
        }

        return sum / (1 + rest.length);
    }

    public static boolean and(boolean first, boolean... rest) {
        if (!first) {
            return false;
        }

        for (boolean b : rest) {
            if (!b) {
                return false;
            }
        }

        return true;
    }

    public static boolean or(boolean first, boolean... rest) {
        if (first) {
            return true;
        }

        for (boolean b : rest) {
            if (b) {
                return true;
            }
        }

        return false;
    }
}

/*
Write a static generic method named getMatching that takes a Collection<E> and a Predicate<E> and returns a Collection<E> containing all the elements of the given Collection that satisfy the given Predicate. Make sure to return an empty Collection, not null, if none of the elements satisfy the predicate.

 */

class Question7 {
    public static <E> Collection<E> getMatching(Collection<E> collection, Predicate<E> predicate) {
        Collection<E> result = new ArrayList<>();

        for (E element : collection) {
            if (predicate.test(element)) {
                result.add(element);
            }
        }

        return result;
    }
}

/*
Write a static generic method named findFirstMatching that takes a List<E> and a Predicate<E>
and returns an Optional<E> containing the first element in the list that matches the predicate.
If there is no element matching the predicate, returns an empty Optional.
 */
class Question8 {
    public static void main(String[] args) {
        List<String> list = List.of("first", "second", "third");
        Predicate<String> predicate = s -> s.length() == 7;
        Optional<String> result = findFirstMatching(list, predicate);
        result.ifPresent(System.out::println);
    }

    public static <E> Optional<E> findFirstMatching(List<E> list, Predicate<E> predicate) {
        for (E element : list) {
            if (predicate.test(element)) {
                return Optional.of(element);
            }
        }

        return Optional.empty();
    }
}

/*
Decorator pattern: suppose we have the following interface:
public interface Counter { // an integer counter, beginning at 0, that can be incremented and decremented
    int getValue();        // returns the counter's current value
    void increment();      // increments the counter's current value by 1
    void decrement();      // decrements the counter's current value by 1
}
First, write a Counter implementation, named SimpleCounter,
that always allows the current value to be incremented or decremented.

Next, write a class named BaseCounterDecorator that both implements Counter and wraps (contains) a Counter.
The field should be private. The constructor should accept a Counter.
The methods should just delegate to the wrapped Counter.

Next, write two classes that extend BaseCounterDecorator:
UpperBoundedCounter is a type of Counter that allows itself to be incremented up to (and including)
some upper bound. The constructor should accept a Counter (which should be passed up to the superclass
constructor) and the integer upper bound.
There is no need for this class to override getValue() and decrement(), so it shouldn’t.

LowerBoundedCounter is a type of Counter that allows itself to be decremented down to (and including) some lower bound. The constructor should accept a Counter (which should be passed up to the superclass constructor) and the integer lower bound. There is no need for this class to override getValue() and increment(), so it shouldn’t.
Note that the structure of these classes follows the classic structure of the Decorator pattern. Make sure you are able to match up the classes in this example with those of the diagram at the link.
Once you’ve written the classes, the following code should work:
Counter counter = new SimpleCounter();
Counter upperBoundedCounter = new UpperBoundedCounter(counter, 3);
Counter lowerBoundedAndUpperBoundedCounter = new LowerBoundedCounter(upperBoundedCounter, -2);

// or, more concisely:
// Counter lowerBoundedAndUpperBoundedCounter = new LowerBoundedCounter(new UpperBoundedCounter(new SimpleCounter(), 3), -2);

for (int i = 0; i < 10; i++) lowerBoundedAndUpperBoundedCounter.increment();
System.out.println(lowerBoundedAndUpperBoundedCounter.getValue()); // 3

for (int i = 0; i < 10; i++) lowerBoundedAndUpperBoundedCounter.decrement();
System.out.println(lowerBoundedAndUpperBoundedCounter.getValue()); // -2
Make sure you understand the output.
Note that in this example the counter’s current value is being stored by exactly one int, not three different ones for the SimpleCounter, UpperBoundedCounter, and LowerBoundedCounter.
 */

interface Counter {   // an integer counter, beginning at 0, that can be incremented and decremented
    int getValue();   // returns the counter's current value
    void increment(); // increments the counter's current value by 1
    void decrement(); // decrements the counter's current value by 1
}

class SimpleCounter implements Counter {
    private int value;

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void increment() {
        value++;
    }

    @Override
    public void decrement() {
        value--;
    }
}

class BaseCounterDecorator implements Counter {
    private final Counter counter;

    public BaseCounterDecorator(Counter counter) {
        this.counter = counter;
    }

    @Override
    public int getValue() {
        return counter.getValue();
    }

    @Override
    public void increment() {
        counter.increment();
    }

    @Override
    public void decrement() {
        counter.decrement();
    }
}

class UpperBoundedCounter extends BaseCounterDecorator {
    private int upperBound;

    public UpperBoundedCounter(Counter counter, int upperBound) {
        super(counter);
        this.upperBound = upperBound;

        // optional
        if (getValue() > upperBound) {
            throw new IllegalStateException();
        }
    }

    @Override
    public void increment() {
        if (getValue() < upperBound) {
            super.increment();
        }
    }
}

class LowerBoundedCounter extends BaseCounterDecorator {
    private final int lowerBound;

    public LowerBoundedCounter(Counter counter, int lowerBound) {
        super(counter);
        this.lowerBound = lowerBound;
    }

    @Override
    public void decrement() {
        if (getValue() > lowerBound) {
            super.decrement();
        }
    }
}

class Question9 {
    public static void main(String[] args) {
        Counter counter = new SimpleCounter();
        Counter upperBoundedCounter = new UpperBoundedCounter(counter, 3);
        Counter lowerBoundedAndUpperBoundedCounter = new LowerBoundedCounter(upperBoundedCounter, -2);

        // or, more concisely:
        // Counter lowerBoundedAndUpperBoundedCounter = new LowerBoundedCounter(new UpperBoundedCounter(new SimpleCounter(), 3), -2);

        for (int i = 0; i < 10; i++) lowerBoundedAndUpperBoundedCounter.increment();
        System.out.println(lowerBoundedAndUpperBoundedCounter.getValue()); // 3

        for (int i = 0; i < 10; i++) lowerBoundedAndUpperBoundedCounter.decrement();
        System.out.println(lowerBoundedAndUpperBoundedCounter.getValue()); // -2
    }
}

class PeekingIterator implements Iterator<Integer> {
    private final Iterator<Integer> iterator;
    private Integer next;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        this.next = iterator.hasNext() ? iterator.next() : null;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    @Override
    public Integer next() {
        Integer result = next;
        next = iterator.hasNext() ? iterator.next() : null;
        return result;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}

/*
Adapter pattern: suppose we have a ForwardingUnmodifiableCollection class similar to the ForwardingSet class in Effective Java, Item 18; all non-modifying methods delegate to the underlying collection, and modifying methods, like add, throw an UnsupportedOperationException. Write a static generic method named toUnmodifiableCollection that takes an Iterable and adapts it so that it can be used as an unmodifiable Collection (i.e., the contains method can be called, for example).
 */

class ForwardingUnmodifiableCollection<E> implements Collection<E> {
    private final Collection<E> collection;

    public ForwardingUnmodifiableCollection(Collection<E> collection) {
        this.collection = collection;
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public boolean isEmpty() {
        return collection.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return collection.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return collection.iterator();
    }

    @Override
    public Object[] toArray() {
        return collection.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return collection.toArray(a);
    }

    @Override
    public boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return collection.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }
}

class Question11 {
    public static void main(String[] args) {
        Iterable<String> iterable = List.of("a", "b", "c");
        System.out.println(toUnmodifiableCollection(iterable).contains("b"));
    }

    public static <E> Collection<E> toUnmodifiableCollection(Iterable<E> iterable) {
        Collection<E> collection = new ArrayList<>();
        for (E item : iterable) collection.add(item);
        return new ForwardingUnmodifiableCollection<>(collection);
    }
}

interface IntSequence { // a sequence of integers
    int next(); // returns the next item in the sequence

    default List<Integer> nextN(int n) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(next());
        }

        return list;
    }
}
//Add a non-abstract method to the interface. The method should be named nextN. It should take an int parameter named n and return a List<Integer> containing the next n values of the sequence.

class Question12 {
    public static void main(String[] args) {
        IntSequence constantIntSequence = () -> 2;
        System.out.println(constantIntSequence.nextN(5));

        Random randomGenerator = new Random();
        IntSequence randomIntSequence = randomGenerator::nextInt;
        System.out.println(randomIntSequence.nextN(5));
    }
}

interface Formula {
    boolean eval();
    String toInfixString();
}

class Variable implements Formula {
    private final String name;
    private final boolean value;

    public Variable(String name, boolean value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public boolean eval() {
        return value;
    }

    @Override
    public String toInfixString() {
        return name;
    }
}

class Not implements Formula {
    private final Formula operand;

    public Not(Formula operand) {
        this.operand = operand;
    }

    @Override
    public boolean eval() {
        return ! operand.eval();
    }

    @Override
    public String toInfixString() {
        return "¬" + operand.toInfixString();
    }
}

class And implements Formula {
    private final Formula leftOperand, rightOperand;

    public And(Formula leftOperand, Formula rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    @Override
    public boolean eval() {
        return leftOperand.eval() && rightOperand.eval();
    }

    @Override
    public String toInfixString() {
        return "(" + leftOperand.toInfixString() + "∧" + rightOperand.toInfixString() + ")";
    }
}

class Or implements Formula {
    private final Formula leftOperand, rightOperand;

    public Or(Formula leftOperand, Formula rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    @Override
    public boolean eval() {
        return leftOperand.eval() || rightOperand.eval();
    }

    @Override
    public String toInfixString() {
        return "(" + leftOperand.toInfixString() + "∨" + rightOperand.toInfixString() + ")";
    }
}

class Question13 {
    public static void main(String[] args) {
        // ((P ∨ Q) ∧ (¬P ∨ R))
        Formula formula = new And(
                new Or(
                        new Variable("P", true),
                        new Variable("Q", false)
                ),
                new Or(
                        new Not(new Variable("P", true)),
                        new Variable("R", false)
                )
        );
        System.out.println(formula.eval());
        System.out.println(formula.toInfixString());
    }
}

class TimeSpan implements Comparable<TimeSpan> {
    private final int totalMinutes;

    public static final TimeSpan ZERO = new TimeSpan(0),
            ONE_MINUTE = new TimeSpan(1),
            ONE_HOUR = new TimeSpan(60);

    private TimeSpan(int totalMinutes) {
        if (totalMinutes < 0) {
            throw new IllegalArgumentException("negative totalMinutes");
        }

        this.totalMinutes = totalMinutes;
    }

    public static TimeSpan ofHours(int hours) {
        if (hours < 0) {
            throw new IllegalArgumentException("negative hours");
        }

        return ofMinutes(hours * 60);
    }

    public static TimeSpan ofMinutes(int totalMinutes) {
        // without flyweight pattern: return new TimeSpan(totalMinutes);

        // with flyweight pattern: do not create a new object when we want zero, one minute, or one hour:
        /*
        switch (totalMinutes) {
            case 0: return ZERO;
            case 1: return ONE_MINUTE;
            case 60: return ONE_HOUR;
            default: return new TimeSpan(totalMinutes);
        }
        */

        // fancy: using a switch expression:
        return switch (totalMinutes) {
            case 0 -> ZERO;
            case 1 -> ONE_MINUTE;
            case 60 -> ONE_HOUR;
            default -> new TimeSpan(totalMinutes);
        };
    }

    public static TimeSpan ofHoursAndMinutes(int hours, int minutes) {
        if (hours < 0) {
            throw new IllegalArgumentException("negative hours");
        } else if (minutes < 0) {
            throw new IllegalArgumentException("negative minutes");
        }

        return ofMinutes(hours * 60 + minutes);
    }

    public int getHours() {
        return totalMinutes / 60;
    }

    public int getMinutes() {
        return totalMinutes % 60;
    }

    public int getTotalMinutes() {
        return totalMinutes;
    }

    public TimeSpan plusHours(int hours) {
        if (hours < 0) {
            throw new IllegalArgumentException("negative hours");
        }

        return ofMinutes(this.totalMinutes + hours * 60);
    }

    public TimeSpan plusMinutes(int minutes) {
        if (minutes < 0) {
            throw new IllegalArgumentException("negative minutes");
        }

        return ofMinutes(this.totalMinutes + minutes);
    }

    public TimeSpan plus(TimeSpan other) {
        return ofMinutes(this.totalMinutes + other.totalMinutes);
    }

    @Override
    public String toString() {
        return getHours() + "h" + getMinutes() + "m";
    }

    @Override
    public boolean equals(Object o) {
        // simple:
        // return o instanceof TimeSpan && this.totalMinutes == ((TimeSpan) o).totalMinutes;

        // fancy: using a pattern variable:
        return o instanceof TimeSpan other && this.totalMinutes == other.totalMinutes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalMinutes);
    }

    @Override
    public int compareTo(TimeSpan other) {
        return Integer.compare(this.totalMinutes, other.totalMinutes);
    }
}

interface Logger {
    void log(String message);
}

class ConsoleLogger implements Logger {
    private static final ConsoleLogger INSTANCE = new ConsoleLogger();

    private ConsoleLogger() {
    }

    public static ConsoleLogger getInstance() {
        return INSTANCE;
    }

    @Override
    public void log(String message) {
        System.out.println(message);
    }
}

class Question15 {
    public static void main(String[] args) {
        Logger logger = ConsoleLogger.getInstance();
        logger.log("hello");
        logger.log("world");
    }
}