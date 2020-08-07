import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class BinaryTreeExample<T extends Comparable<T>> {

    private Node<T> root;

    public void put(T object) {
        if (root == null) {
            root = new Node<T>(null, null, object);
            return;
        }
        compareAndAdd(new Node<T>(null, null, object), root);
    }

    public T get(T data) {
        if (root == null) return null;
        return compareAndGet(data, root);
    }

//    public long sum(){
//        long sum = (long)root.data;
//        if (root.left != null){
//            sum += calculate(root.left);
//        } if (root.right != null){
//            sum += calculate(root.right);
//        }
//        return sum;
//    }
//
//    private long calculate(Node<T> currentNode){
//        long sum = (long)currentNode.data;
//        if (root.left != null){
//            sum += calculate(root.left);
//        } if (root.right != null){
//            sum += calculate(root.right);
//        }
//        return sum;
//    }

    private T compareAndGet(T data, Node<T> currentNode) {
        if (currentNode == null) return null;
        if (data.compareTo(currentNode.data) == 0) return currentNode.data;
        else if (data.compareTo(currentNode.data) > 0) return compareAndGet(data, currentNode.right);
        else return compareAndGet(data, currentNode.left);
    }

    private void compareAndAdd(Node<T> newNode, Node<T> currentNode) {
        if (newNode.data.compareTo(currentNode.data) > 0 && currentNode.right != null) {
            compareAndAdd(newNode, currentNode.right);
        } else if (newNode.data.compareTo(currentNode.data) > 0 && currentNode.right == null) {
            currentNode.right = newNode;
            return;
        }
        if (newNode.data.compareTo(currentNode.data) < 0 && currentNode.left != null) {
            compareAndAdd(newNode, currentNode.left);
        } else if (newNode.data.compareTo(currentNode.data) < 0 && currentNode.left == null) {
            currentNode.left = newNode;
        }

    }

    private static class Node<T extends Comparable<T>> {
        Node<T> left;
        Node<T> right;
        T data;

        public Node(Node<T> left, Node<T> right, T data) {
            this.left = left;
            this.right = right;
            this.data = data;
        }
    }

    public static void main(String[] args) {
        BinaryTreeExample<Integer> numbers = new BinaryTreeExample<>();
        for (int i = 0; i < 10; i++) {
            numbers.put(ThreadLocalRandom.current().nextInt(10));
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(numbers.get(ThreadLocalRandom.current().nextInt(10)));
        }
    }
}
