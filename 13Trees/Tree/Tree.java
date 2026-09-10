
public class Tree{

//    A single node of the tree
    static class Node {
        int data;
        Node left,right;
        Node(int data) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private Node root ;
    //    The top of the tree

    // ---------- INSERT ----------

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node node, int value) {
        if(node == null) return new Node(value);    // Empty spot found

        if(value < node.data){
            node.left = insertRec(node.left,value); //  smaller -> go left
        }else if(value > node.data){
            node.right = insertRec(node.right,value); //  bigger -> go right
        }

        return node;
    }

    // ---------- SEARCH ----------

    public boolean search(int value){
        return searchRec(root, value);
    }

    private boolean searchRec(Node node, int value) {
        if(node == null) return false;
        if(node.data == value) return true;

        return value < node.data
                ? searchRec(node.left,value)
                : searchRec(node.right,value);
    }

    // ---------- DELETE ----------
    public void delete(int value) {
        root = deleteRec(root, value);
    }

    private Node deleteRec(Node node, int value) {
        if (node == null) return null;

        if (value < node.data) {
            node.left = deleteRec(node.left, value);
        } else if (value > node.data) {
            node.right = deleteRec(node.right, value);
        } else {
            // Found the node to delete
            if (node.left == null) return node.right;   // 0 or 1 child
            if (node.right == null) return node.left;   // 1 child

            // 2 children: replace with smallest value in the right subtree
            node.data = minValue(node.right);
            node.right = deleteRec(node.right, node.data);
        }
        return node;
    }

    // ---------- MIN / MAX ----------
    public int min() { return minValue(root); }

    private int minValue(Node node) {
        int m = node.data;
        while (node.left != null) {   // keep going left
            node = node.left;
            m = node.data;
        }
        return m;
    }

    public int max() {
        Node node = root;
        while (node.right != null) node = node.right;  // keep going right
        return node.data;
    }


}