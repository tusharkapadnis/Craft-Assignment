import java.util.Vector;

public class CraftAssignment {
  public static void main(String[] args) {

    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.right = new Node(6);
    root.right.right.left = new Node(7);

    int nodeToBeRemoved = 2;
    Vector<Integer> result = removeNode(root, nodeToBeRemoved);
    System.out.println(result);
  }

  public static Vector<Integer> removeNode(Node root, int nodeToBeRemoved) {
    Vector<Integer> remaining = new Vector<>();
    if (root.id != nodeToBeRemoved) {
      remaining.add(root.id);
    }
    removeNodeHelper(root, nodeToBeRemoved, remaining);
    return remaining;
  }

  private static Node removeNodeHelper(Node root, int nodeToBeRemoved, Vector<Integer> remaining) {
    if (root == null) return null;

    root.left = removeNodeHelper(root.left, nodeToBeRemoved, remaining);
    root.right = removeNodeHelper(root.right, nodeToBeRemoved, remaining);

    if (nodeToBeRemoved == root.id) {
      if (root.left != null) {
        remaining.add(root.left.id);
      }
      if (root.right != null) {
        remaining.add(root.right.id);
      }
      return null;
    }
    return root;
  }
}

class Node {
  int id;
  Node left;
  Node right;

  Node(int id) {
    this.id = id;
  }
}
