// REFERENCE ONLY — see the note in 0120's Reference_ivanzykov_LinkedList.java for how to use this.
// Source: https://github.com/ivan-zykov/udemy-dsa-barrett

import java.util.*;

class Reference_ivanzykov_BinarySearchTree {

    private Node root;

    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (newNode.value == temp.value) return false;
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value) {
        Node temp = root;
        while (temp != null) {
            if (value < temp.value) {
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }

    public List<Integer> BFS() {
        Node currentNode = root;
        Queue<Node> queue = new ArrayDeque<>();
        List<Integer> results = new ArrayList<>();
        queue.offer(currentNode);
        while (queue.size() > 0) {
            currentNode = queue.poll();
            results.add(currentNode.value);
            if (currentNode.left != null) queue.offer(currentNode.left);
            if (currentNode.right != null) queue.offer(currentNode.right);
        }
        return results;
    }

    public List<Integer> DFSPreOrder() {
        List<Integer> results = new ArrayList<>();
        class Traverse {
            Traverse(Node currentNode) {
                results.add(currentNode.value);
                if (currentNode.left != null) new Traverse(currentNode.left);
                if (currentNode.right != null) new Traverse(currentNode.right);
            }
        }
        new Traverse(root);
        return results;
    }

    public List<Integer> DFSPostOrder() {
        List<Integer> results = new ArrayList<>();
        class Traverse {
            Traverse(Node currentNode) {
                if (currentNode.left != null) new Traverse(currentNode.left);
                if (currentNode.right != null) new Traverse(currentNode.right);
                results.add(currentNode.value);
            }
        }
        new Traverse(root);
        return results;
    }

    public List<Integer> DFSInOrder() {
        List<Integer> results = new ArrayList<>();
        class Traverse {
            Traverse(Node currentNode) {
                if (currentNode.left != null) new Traverse(currentNode.left);
                results.add(currentNode.value);
                if (currentNode.right != null) new Traverse(currentNode.right);
            }
        }
        new Traverse(root);
        return results;
    }
}
