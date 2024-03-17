package hw1.A_predicates;

import java.util.function.*;

/*
Suppose we have the following TreeNode class:
public class TreeNode<E> {
  E element;
  TreeNode<E> left;
  TreeNode<E> right;

  public TreeNode(E element, TreeNode<E> left, TreeNode<E> right) {
    this.element = element;
    this.left = left;
    this.right = right;
  }
}
Write the following method:
public static <E> int countIf(TreeNode<E> root, Predicate<E> predicate): Returns the number of elements in the tree rooted at the given node that satisfy the given predicate.
 */
public class Question3 {
    public static <E> int countIf(TreeNode<E> root, Predicate<E> predicate) {
        if (root == null) {
            return 0;
        } else {
            return (predicate.test(root.element) ? 1 : 0)
                   + countIf(root.left, predicate)
                   + countIf(root.right, predicate);
        }
    }
}

/*
Functional interfaces and their functional methods:
- Comparator<T>         int compare(T t1, T t2)
- Consumer<T>           void accept(T t)
- BiConsumer<T, U>      void accept(T t, U u)
- Supplier<T>           T get()
- Predicate<T>          boolean test(T t)
- Function<T, R>        R apply(T t)
- UnaryOperator<T>      T apply(T t)
- BinaryOperator<T>     T apply(T t1, T t2)
*/