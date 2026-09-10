// Rebuild scaffold — "Binary Trees" section. See ../notes/CHECKLIST.md for the accuracy caveat:
// exact lecture names weren't retrievable from the public course page, this is a standard structure.

public class BinaryTree {

    Node root;

    class Node {
        int value;
        Node left;
        Node right;
        Node(int value) {
            this.value = value;
        }
    }

    public void insert(int value) {
        // TODO: BST insert — walk left/right based on comparison until you hit a null slot
    }

    public boolean contains(int value) {
        // TODO: BST search — same walk as insert, return true if found
        return false;
    }

    public void preOrder() {
        // TODO: visit node, then left, then right (recursive)
    }

    public void inOrder() {
        // TODO: left, then visit node, then right — gives sorted order for a BST
    }

    public void postOrder() {
        // TODO: left, then right, then visit node
    }

    public void bfs() {
        // TODO: level-order traversal using a Queue — see CHEATSHEETS/Trees.md for the template
    }
}
