package hw1.A_predicates;

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