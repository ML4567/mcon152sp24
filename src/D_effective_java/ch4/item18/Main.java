package D_effective_java.ch4.item18;

/*
Item 18: Favor composition over inheritance

(Here, inheritance means specifically inheriting from a class,
as opposed to inheriting from an interface.)

Two ways to achieve code reuse: composition and inheritance. Prefer the former.

Inheritance violates encapsulation:
a subclass depends on the implementation details of its superclass for its proper function.
The superclass’s implementation may change from release to release,
and if it does, the subclass may break, even though its code has not been touched.
As a consequence, a subclass must evolve in tandem with its superclass,
unless the superclass’s authors have designed and documented it specifically for the purpose of being extended.

Inheritance is okay within the same package.

The "fragile base class problem" (really should've been called the "fragile derived class problem")

Example: InstrumentedHashSet extends HashSet; InstrumentedSet; ForwardingSet
 */

import java.util.*;

class AddCountHashSetUsingInheritance<E> extends HashSet<E> {
    private int addCount = 0;

    public AddCountHashSetUsingInheritance() {
        super();
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}

class AddCountSetUsingComposition<E> implements Set<E> {
    private Set<E> elements;
    private int addCount = 0;

    public AddCountSetUsingComposition(Set<E> elements) {
        this.elements = elements;
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return elements.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return elements.iterator();
    }

    @Override
    public Object[] toArray() {
        return elements.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return elements.toArray(a);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return elements.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return elements.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return elements.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return elements.addAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return elements.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return elements.removeAll(c);
    }

    @Override
    public void clear() {
        elements.clear();
    }
}

class DelegatingSet<E> implements Set<E> {
    private Set<E> elements;

    public DelegatingSet(Set<E> elements) {
        this.elements = elements;
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return elements.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return elements.iterator();
    }

    @Override
    public Object[] toArray() {
        return elements.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return elements.toArray(a);
    }

    @Override
    public boolean add(E e) {
        return add(e);
    }

    @Override
    public boolean remove(Object o) {
        return remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return elements.addAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return elements.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return elements.removeAll(c);
    }

    @Override
    public void clear() {
        elements.clear();
    }
}

class AddCountSetUsingOurDelegatingSet<E> extends DelegatingSet<E> {
    private int addCount = 0;

    public AddCountSetUsingOurDelegatingSet(Set<E> elements) {
        super(elements);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }
}



public class Main {
    public static void main(String[] args) {
        AddCountHashSetUsingInheritance<String> set = new AddCountHashSetUsingInheritance<>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.remove("b");
        System.out.println(set.size()); // 2
        System.out.println(set.getAddCount()); // 3
        set.addAll(List.of("d", "e", "f"));
        System.out.println(set.getAddCount()); // should print 6
    }
}
