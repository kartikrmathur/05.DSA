# Trees — Quick Recall

Status: gap-filler starter sheet (see `GAPS_AND_ROADMAP.md`).

## Node definition

**Java**
```java
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}
```

**Kotlin**
```kotlin
class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)
```

## Traversals — recursive (memorize these cold)

**Java**
```java
void inorder(TreeNode n, List<Integer> out) {
    if (n == null) return;
    inorder(n.left, out);
    out.add(n.val);
    inorder(n.right, out);
}
// preorder: visit n, then left, then right
// postorder: left, then right, then visit n
```

**Kotlin**
```kotlin
fun inorder(n: TreeNode?, out: MutableList<Int>) {
    if (n == null) return
    inorder(n.left, out)
    out.add(n.`val`)
    inorder(n.right, out)
}
```

## Level-order traversal (BFS) — uses a Queue, this is the bridge between Trees and your existing Queue knowledge (0071)

**Java**
```java
List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
        int size = q.size();
        List<Integer> level = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            TreeNode n = q.poll();
            level.add(n.val);
            if (n.left != null) q.add(n.left);
            if (n.right != null) q.add(n.right);
        }
        result.add(level);
    }
    return result;
}
```

**Kotlin**
```kotlin
fun levelOrder(root: TreeNode?): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    if (root == null) return result
    val q: ArrayDeque<TreeNode> = ArrayDeque()
    q.add(root)
    while (q.isNotEmpty()) {
        val level = mutableListOf<Int>()
        repeat(q.size) {
            val n = q.removeFirst()
            level.add(n.`val`)
            n.left?.let { q.add(it) }
            n.right?.let { q.add(it) }
        }
        result.add(level)
    }
    return result
}
```
Kotlin's `ArrayDeque` is the idiomatic queue (Java's `LinkedList` works but `ArrayDeque` is preferred there too, actually — note this same nuance applies in Java: prefer `Deque<TreeNode> q = new ArrayDeque<>();` over `LinkedList` for performance in real code, even though tutorials often show `LinkedList`).

## Height / Max Depth

**Java**
```java
int height(TreeNode n) {
    if (n == null) return 0;
    return 1 + Math.max(height(n.left), height(n.right));
}
```

**Kotlin**
```kotlin
fun height(n: TreeNode?): Int {
    if (n == null) return 0
    return 1 + maxOf(height(n.left), height(n.right))
}
```

## Validate BST — pass down a valid (min, max) range

**Java**
```java
boolean isValidBST(TreeNode n, long min, long max) {
    if (n == null) return true;
    if (n.val <= min || n.val >= max) return false;
    return isValidBST(n.left, min, n.val) && isValidBST(n.right, n.val, max);
}
// call with isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE)
```

## Lowest Common Ancestor (binary tree, not necessarily BST)

**Java**
```java
TreeNode lca(TreeNode n, TreeNode p, TreeNode q) {
    if (n == null || n == p || n == q) return n;
    TreeNode left = lca(n.left, p, q);
    TreeNode right = lca(n.right, p, q);
    if (left != null && right != null) return n;
    return (left != null) ? left : right;
}
```
For a **BST** specifically, you can skip recursing into both sides — compare `p.val` and `q.val` against `n.val` to decide which single side to descend into. Know both versions; interviewers will ask "what if it's not a BST?"

## Balanced check (height-balanced)
Compute height bottom-up; if any subtree's left/right height differ by more than 1, propagate a sentinel (e.g. -1) up to short-circuit. Don't compute height and balance separately — that's the naive O(n²) version interviewers will push you to optimize to O(n).

## Practice queue
1. All three DFS traversals (recursive, then iterative with an explicit stack)
2. Level-order (BFS)
3. Max depth / height
4. Validate BST
5. LCA (binary tree, then BST variant)
6. Diameter of binary tree
7. Serialize/deserialize a binary tree
8. Invert a binary tree (classic "can you even do the easy one" check)
