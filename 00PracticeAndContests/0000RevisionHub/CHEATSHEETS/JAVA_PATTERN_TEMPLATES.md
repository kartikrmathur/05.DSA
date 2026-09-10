# Java Pattern Templates — Muscle Memory Sheet

Copy-paste-ready Java for every interview pattern, each with a **pseudo-algo** (the 3–5 steps to recall under pressure) and complexity.

**How to use this file:** don't read it — *rebuild from it*. Cover the code, read only the pseudo-algo, write the template from memory, then diff. Three passes and these become automatic.

Companion files: `PATTERN_THEORY.md` (which pattern to choose) · `Patterns.md`, `Trees.md`, `Graphs.md`, `Heaps.md`, `LinkedList.md` (topic notes).

---

## 0. JAVA TOOLKIT — know these cold

```java
// Frequency counting
Map<Character,Integer> charFrequency = new HashMap<>();
charFrequency.merge(currentChar, 1, Integer::sum);       // increment
charFrequency.getOrDefault(currentChar, 0);
int[] letterCount = new int[26];                          // faster for lowercase letters
letterCount[currentChar - 'a']++;

// Stack & Queue — always ArrayDeque, never java.util.Stack
Deque<Integer> stack = new ArrayDeque<>();   stack.push(value); stack.pop(); stack.peek();
Deque<Integer> queue = new ArrayDeque<>();   queue.offer(value); queue.poll(); queue.peek();

// Heaps
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
PriorityQueue<int[]> byFirstField =
        new PriorityQueue<>((first, second) -> Integer.compare(first[0], second[0]));

// Sorting
Arrays.sort(numbers);                                     // primitives: dual-pivot quicksort
Arrays.sort(intervals, (first, second) -> Integer.compare(first[0], second[0]));  // 2D by first col
Collections.sort(people, Comparator.comparingInt(person -> person.age));

// Conversions
int[] numbers = numberList.stream().mapToInt(Integer::intValue).toArray();
char[] chars = word.toCharArray();  Arrays.sort(chars);  String sortedKey = new String(chars);

// Overflow-safe middle index
int middle = low + (high - low) / 2;

// GOTCHAS
// Integer == fails above 127 → use .equals()
// s.substring() is O(n) — avoid inside loops
// Arrays are objects: == compares references, use Arrays.equals()
```

---

## 1. TWO POINTERS

### 1a. Opposite ends (sorted array)
**Pseudo-algo:** 1) `left=0, right=n-1` → 2) compute condition → 3) too small? `left++` : too big? `right--` → 4) stop when `left>=right`.
```java
int[] twoSumSorted(int[] sortedNumbers, int target) {
    int left = 0, right = sortedNumbers.length - 1;
    while (left < right) {
        int pairSum = sortedNumbers[left] + sortedNumbers[right];
        if (pairSum == target) return new int[]{left, right};
        else if (pairSum < target) left++;      // need a bigger sum
        else right--;                            // need a smaller sum
    }
    return new int[]{-1, -1};
}
```
**O(n) time, O(1) space.** → Two Sum II, Valid Palindrome, Container With Most Water.

### 1b. 3Sum (sort + fix one + two pointers)
**Pseudo-algo:** 1) sort → 2) for each `anchor`, skip duplicates → 3) two-pointer the remainder → 4) skip duplicates on both pointers after a hit.
```java
List<List<Integer>> threeSum(int[] numbers) {
    Arrays.sort(numbers);
    List<List<Integer>> triplets = new ArrayList<>();
    for (int anchor = 0; anchor < numbers.length - 2; anchor++) {
        if (anchor > 0 && numbers[anchor] == numbers[anchor-1]) continue;   // skip duplicate anchor
        int left = anchor + 1, right = numbers.length - 1;
        while (left < right) {
            int tripletSum = numbers[anchor] + numbers[left] + numbers[right];
            if (tripletSum == 0) {
                triplets.add(Arrays.asList(numbers[anchor], numbers[left], numbers[right]));
                while (left < right && numbers[left]  == numbers[left+1])  left++;   // skip duplicates
                while (left < right && numbers[right] == numbers[right-1]) right--;
                left++; right--;
            } else if (tripletSum < 0) left++;
            else right--;
        }
    }
    return triplets;
}
```
**O(n²) time.**

### 1c. Fast–slow (linked list)
**Pseudo-algo:** 1) both at head → 2) `fastRunner` moves 2, `slowRunner` moves 1 → 3) meet ⇒ cycle; fast hits null ⇒ slow is middle.
```java
boolean hasCycle(ListNode head) {
    ListNode slowRunner = head, fastRunner = head;
    while (fastRunner != null && fastRunner.next != null) {
        slowRunner = slowRunner.next;
        fastRunner = fastRunner.next.next;
        if (slowRunner == fastRunner) return true;
    }
    return false;
}
```

### 1d. Same direction (read / write, in-place)
**Pseudo-algo:** 1) `writeIndex=0` → 2) scan with `readIndex` → 3) keeper? copy to `writeIndex++` → 4) `writeIndex` = new length.
```java
int removeDuplicates(int[] sortedNumbers) {              // in-place
    int writeIndex = 1;
    for (int readIndex = 1; readIndex < sortedNumbers.length; readIndex++)
        if (sortedNumbers[readIndex] != sortedNumbers[readIndex-1])
            sortedNumbers[writeIndex++] = sortedNumbers[readIndex];
    return writeIndex;                                   // new length
}
```

---

## 2. SLIDING WINDOW

### 2a. Fixed size k
**Pseudo-algo:** 1) add element at `right` → 2) if window > k, remove element at `right-k` → 3) once window == k, record answer.
```java
double maxAverageOfWindow(int[] numbers, int windowSize) {
    long windowSum = 0;
    double maxAverage = Long.MIN_VALUE;
    for (int windowEnd = 0; windowEnd < numbers.length; windowEnd++) {
        windowSum += numbers[windowEnd];                          // add entering element
        if (windowEnd >= windowSize)
            windowSum -= numbers[windowEnd - windowSize];         // remove leaving element
        if (windowEnd >= windowSize - 1)
            maxAverage = Math.max(maxAverage, (double) windowSum / windowSize);
    }
    return maxAverage;
}
```

### 2b. Variable — LONGEST valid window
**Pseudo-algo:** 1) expand `right` always → 2) `while (invalid) shrink left` → 3) record max **after** the while loop.
```java
int lengthOfLongestSubstring(String text) {
    Map<Character,Integer> charCountInWindow = new HashMap<>();
    int windowStart = 0, maxLength = 0;
    for (int windowEnd = 0; windowEnd < text.length(); windowEnd++) {
        char enteringChar = text.charAt(windowEnd);
        charCountInWindow.merge(enteringChar, 1, Integer::sum);
        while (charCountInWindow.get(enteringChar) > 1) {          // invalid → shrink
            char leavingChar = text.charAt(windowStart++);
            charCountInWindow.merge(leavingChar, -1, Integer::sum);
            if (charCountInWindow.get(leavingChar) == 0) charCountInWindow.remove(leavingChar);
        }
        maxLength = Math.max(maxLength, windowEnd - windowStart + 1);   // record AFTER the while
    }
    return maxLength;
}
```

### 2c. Variable — SHORTEST valid window
**Pseudo-algo:** 1) expand `right` → 2) `while (valid)` { record min **inside**; shrink left } .
```java
int minSubArrayLen(int target, int[] numbers) {
    int windowStart = 0, windowSum = 0, minLength = Integer.MAX_VALUE;
    for (int windowEnd = 0; windowEnd < numbers.length; windowEnd++) {
        windowSum += numbers[windowEnd];
        while (windowSum >= target) {                                   // valid → try smaller
            minLength = Math.min(minLength, windowEnd - windowStart + 1);  // record INSIDE
            windowSum -= numbers[windowStart++];
        }
    }
    return minLength == Integer.MAX_VALUE ? 0 : minLength;
}
```
> **The #1 window bug:** recording the answer in the wrong place. Longest → after the while. Shortest → inside the while.

---

## 3. PREFIX SUM

**Pseudo-algo (count subarrays summing to k):** 1) map `{0 : 1}` → 2) keep `runningSum` → 3) `count += seenPrefixSums[runningSum - k]` → 4) record `runningSum`.
```java
int countSubarraysWithSum(int[] numbers, int targetSum) {
    Map<Integer,Integer> prefixSumFrequency = new HashMap<>();
    prefixSumFrequency.put(0, 1);                       // empty prefix seen once
    int runningSum = 0, matchingSubarrays = 0;
    for (int number : numbers) {
        runningSum += number;
        matchingSubarrays += prefixSumFrequency.getOrDefault(runningSum - targetSum, 0);
        prefixSumFrequency.merge(runningSum, 1, Integer::sum);
    }
    return matchingSubarrays;
}
```
**O(n) time/space.** Works with negatives — sliding window does not.

```java
// Range-sum array: sumOfRange(i..j) = prefixSums[j+1] - prefixSums[i]
int[] prefixSums = new int[numbers.length + 1];
for (int i = 0; i < numbers.length; i++)
    prefixSums[i+1] = prefixSums[i] + numbers[i];
```

---

## 4. BINARY SEARCH

### 4a. Classic
```java
int findTarget(int[] sortedNumbers, int target) {
    int low = 0, high = sortedNumbers.length - 1;
    while (low <= high) {
        int middle = low + (high - low) / 2;
        if (sortedNumbers[middle] == target) return middle;
        if (sortedNumbers[middle] < target) low = middle + 1;
        else high = middle - 1;
    }
    return -1;
}
```

### 4b. Leftmost / rightmost boundary
**Pseudo-algo:** use `low < high`, never `middle-1` on the side you're pinning; loop ends with `low == high` = answer.
```java
int firstIndexAtLeast(int[] sortedNumbers, int target) {   // first index where value >= target
    int low = 0, high = sortedNumbers.length;              // high is exclusive
    while (low < high) {
        int middle = low + (high - low) / 2;
        if (sortedNumbers[middle] >= target) high = middle;   // keep middle as candidate
        else low = middle + 1;
    }
    return low;
}
```

### 4c. BINARY SEARCH ON THE ANSWER ★
**Pseudo-algo:** 1) write `canFinish(candidate)` → 2) confirm it's monotonic → 3) binary-search the answer range → 4) return `low`.
```java
int minEatingSpeed(int[] pileSizes, int hoursAvailable) {
    int slowestSpeed = 1;
    int fastestSpeed = Arrays.stream(pileSizes).max().getAsInt();
    while (slowestSpeed < fastestSpeed) {
        int candidateSpeed = slowestSpeed + (fastestSpeed - slowestSpeed) / 2;
        if (canFinishInTime(pileSizes, candidateSpeed, hoursAvailable))
            fastestSpeed = candidateSpeed;            // works → try slower
        else
            slowestSpeed = candidateSpeed + 1;        // too slow → speed up
    }
    return slowestSpeed;
}

boolean canFinishInTime(int[] pileSizes, int speed, int hoursAvailable) {
    long hoursNeeded = 0;
    for (int pile : pileSizes)
        hoursNeeded += (pile + speed - 1) / speed;    // ceiling division
    return hoursNeeded <= hoursAvailable;
}
```
→ Koko Bananas, Ship Packages in D Days, Split Array Largest Sum, Aggressive Cows.

---

## 5. MONOTONIC STACK

**Pseudo-algo:** 1) iterate → 2) `while (stack not empty && violates order) pop` and resolve that popped index's answer → 3) push current index.
```java
int[] nextGreaterElement(int[] numbers) {
    int[] nextGreater = new int[numbers.length];
    Arrays.fill(nextGreater, -1);
    Deque<Integer> indicesWaitingForGreater = new ArrayDeque<>();   // values at these indices decrease
    for (int currentIndex = 0; currentIndex < numbers.length; currentIndex++) {
        while (!indicesWaitingForGreater.isEmpty()
               && numbers[indicesWaitingForGreater.peek()] < numbers[currentIndex]) {
            int resolvedIndex = indicesWaitingForGreater.pop();
            nextGreater[resolvedIndex] = numbers[currentIndex];     // current answers the popped
        }
        indicesWaitingForGreater.push(currentIndex);
    }
    return nextGreater;
}
```
**O(n)** — each index pushed and popped once. → Daily Temperatures, Stock Span, Largest Rectangle, Trapping Rain Water.

---

## 6. LINKED LIST

```java
class ListNode { int value; ListNode next; ListNode(int value){ this.value = value; } }
```

### 6a. Reverse (memorise cold)
**Pseudo-algo:** `previous = null` → save `nextNode` → point `current.next = previous` → shift both forward.
```java
ListNode reverseList(ListNode head) {
    ListNode previous = null, current = head;
    while (current != null) {
        ListNode nextNode = current.next;    // save before rewiring
        current.next = previous;             // flip the link
        previous = current;                  // shift both forward
        current = nextNode;
    }
    return previous;                         // previous is the new head
}
```

### 6b. Dummy head (use whenever the head may change)
```java
ListNode removeNthFromEnd(ListNode head, int positionFromEnd) {
    ListNode dummyHead = new ListNode(0);
    dummyHead.next = head;
    ListNode aheadPointer = dummyHead, behindPointer = dummyHead;
    for (int step = 0; step <= positionFromEnd; step++)
        aheadPointer = aheadPointer.next;                 // open a gap of n nodes
    while (aheadPointer != null) {                        // move both until ahead falls off
        aheadPointer = aheadPointer.next;
        behindPointer = behindPointer.next;
    }
    behindPointer.next = behindPointer.next.next;         // unlink target
    return dummyHead.next;
}
```

### 6c. Merge two sorted lists
```java
ListNode mergeTwoLists(ListNode firstList, ListNode secondList) {
    ListNode dummyHead = new ListNode(0), tail = dummyHead;
    while (firstList != null && secondList != null) {
        if (firstList.value <= secondList.value) { tail.next = firstList;  firstList  = firstList.next; }
        else                                     { tail.next = secondList; secondList = secondList.next; }
        tail = tail.next;
    }
    tail.next = (firstList != null) ? firstList : secondList;   // attach the remainder
    return dummyHead.next;
}
```

---

## 7. TREES

```java
class TreeNode { int value; TreeNode left, right; TreeNode(int value){ this.value = value; } }
```

### 7a. DFS traversals
**Pseudo-algo:** the recursion is identical — only the position of `visit(node)` changes.
```java
void preorder(TreeNode node, List<Integer> visitOrder) {
    if (node == null) return;
    visitOrder.add(node.value);                 // visit BEFORE children
    preorder(node.left, visitOrder);
    preorder(node.right, visitOrder);
}

void inorder(TreeNode node, List<Integer> visitOrder) {      // on a BST → sorted output
    if (node == null) return;
    inorder(node.left, visitOrder);
    visitOrder.add(node.value);                 // visit BETWEEN children
    inorder(node.right, visitOrder);
}

void postorder(TreeNode node, List<Integer> visitOrder) {
    if (node == null) return;
    postorder(node.left, visitOrder);
    postorder(node.right, visitOrder);
    visitOrder.add(node.value);                 // visit AFTER children
}
```

### 7b. BFS level order
**Pseudo-algo:** 1) queue root → 2) per level, snapshot `nodesInLevel` → 3) pop exactly that many, push their children.
```java
List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> levels = new ArrayList<>();
    if (root == null) return levels;
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
        int nodesInLevel = queue.size();                  // snapshot = one full level
        List<Integer> currentLevel = new ArrayList<>();
        for (int i = 0; i < nodesInLevel; i++) {
            TreeNode node = queue.poll();
            currentLevel.add(node.value);
            if (node.left  != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        levels.add(currentLevel);
    }
    return levels;
}
```

### 7c. Postorder "return to parent, update global" ★
**Pseudo-algo:** decide what the call *returns* vs what it *updates*. Diameter returns height, updates a global max.
```java
int maxDiameter = 0;

int diameterOfBinaryTree(TreeNode root) {
    maxDiameter = 0;
    computeHeight(root);
    return maxDiameter;
}

int computeHeight(TreeNode node) {
    if (node == null) return 0;
    int leftHeight  = computeHeight(node.left);
    int rightHeight = computeHeight(node.right);
    maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);   // update global
    return 1 + Math.max(leftHeight, rightHeight);                    // return to parent
}
```

### 7d. Validate BST (bounds passed down)
```java
boolean isValidBST(TreeNode node, long minAllowed, long maxAllowed) {
    if (node == null) return true;
    if (node.value <= minAllowed || node.value >= maxAllowed) return false;
    return isValidBST(node.left,  minAllowed, node.value)    // right bound tightens
        && isValidBST(node.right, node.value, maxAllowed);   // left bound tightens
}
// call: isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE)
```

### 7e. Lowest Common Ancestor
```java
TreeNode lowestCommonAncestor(TreeNode root, TreeNode firstTarget, TreeNode secondTarget) {
    if (root == null || root == firstTarget || root == secondTarget) return root;
    TreeNode foundInLeft  = lowestCommonAncestor(root.left,  firstTarget, secondTarget);
    TreeNode foundInRight = lowestCommonAncestor(root.right, firstTarget, secondTarget);
    if (foundInLeft != null && foundInRight != null) return root;   // split here → this is the LCA
    return (foundInLeft != null) ? foundInLeft : foundInRight;
}
```

---

## 8. GRAPHS

### 8a. Build adjacency list
```java
List<List<Integer>> neighborsOf = new ArrayList<>();
for (int node = 0; node < nodeCount; node++) neighborsOf.add(new ArrayList<>());
for (int[] edge : edges) {
    neighborsOf.get(edge[0]).add(edge[1]);
    neighborsOf.get(edge[1]).add(edge[0]);        // omit this line for a directed graph
}
```

### 8b. BFS — shortest path in unweighted graph
**Pseudo-algo:** 1) queue the start and mark visited **on push** → 2) pop, expand neighbours → 3) each level = one step of distance.
```java
int shortestPath(List<List<Integer>> neighborsOf, int startNode, int targetNode) {
    boolean[] visited = new boolean[neighborsOf.size()];
    Queue<Integer> queue = new ArrayDeque<>();
    queue.offer(startNode);
    visited[startNode] = true;
    int distanceFromStart = 0;
    while (!queue.isEmpty()) {
        int nodesAtThisDistance = queue.size();
        for (int i = 0; i < nodesAtThisDistance; i++) {
            int currentNode = queue.poll();
            if (currentNode == targetNode) return distanceFromStart;
            for (int neighbor : neighborsOf.get(currentNode))
                if (!visited[neighbor]) {
                    visited[neighbor] = true;          // mark on PUSH, not on pop
                    queue.offer(neighbor);
                }
        }
        distanceFromStart++;
    }
    return -1;                                          // unreachable
}
```

### 8c. DFS
```java
void depthFirstSearch(List<List<Integer>> neighborsOf, int currentNode, boolean[] visited) {
    visited[currentNode] = true;
    for (int neighbor : neighborsOf.get(currentNode))
        if (!visited[neighbor]) depthFirstSearch(neighborsOf, neighbor, visited);
}
```

### 8d. Grid DFS (Number of Islands)
**Pseudo-algo:** 1) scan every cell → 2) on unvisited land, `islandCount++` and flood-fill → 3) sink the land you visit.
```java
int numIslands(char[][] grid) {
    int islandCount = 0;
    for (int row = 0; row < grid.length; row++)
        for (int col = 0; col < grid[0].length; col++)
            if (grid[row][col] == '1') {
                islandCount++;
                sinkIsland(grid, row, col);
            }
    return islandCount;
}

void sinkIsland(char[][] grid, int row, int col) {
    boolean outOfBounds = row < 0 || col < 0 || row >= grid.length || col >= grid[0].length;
    if (outOfBounds || grid[row][col] != '1') return;
    grid[row][col] = '0';                               // mark visited by sinking
    sinkIsland(grid, row + 1, col);
    sinkIsland(grid, row - 1, col);
    sinkIsland(grid, row, col + 1);
    sinkIsland(grid, row, col - 1);
}
```

### 8e. Multi-source grid BFS (Rotting Oranges)
```java
int[][] FOUR_DIRECTIONS = {{1,0},{-1,0},{0,1},{0,-1}};
Queue<int[]> queue = new ArrayDeque<>();      // each entry = {row, col}
// Push ALL sources first, then BFS level by level — each level = one minute elapsed.
for (int[] direction : FOUR_DIRECTIONS) {
    int nextRow = currentRow + direction[0];
    int nextCol = currentCol + direction[1];
    // bounds-check nextRow/nextCol, then visit
}
```

### 8f. Topological sort (Kahn's)
**Pseudo-algo:** 1) compute in-degrees → 2) queue all zero-in-degree → 3) pop, append to order, decrement neighbours, queue new zeros → 4) `order.size() < n` ⇒ cycle.
```java
int[] topologicalOrder(int courseCount, int[][] prerequisites) {
    List<List<Integer>> unlockedBy = new ArrayList<>();          // prereq -> courses it unlocks
    for (int course = 0; course < courseCount; course++) unlockedBy.add(new ArrayList<>());
    int[] remainingPrereqs = new int[courseCount];

    for (int[] pair : prerequisites) {                            // pair = {course, prerequisite}
        int course = pair[0], prerequisite = pair[1];
        unlockedBy.get(prerequisite).add(course);
        remainingPrereqs[course]++;
    }

    Queue<Integer> readyToTake = new ArrayDeque<>();
    for (int course = 0; course < courseCount; course++)
        if (remainingPrereqs[course] == 0) readyToTake.offer(course);

    int[] order = new int[courseCount];
    int placedCount = 0;
    while (!readyToTake.isEmpty()) {
        int course = readyToTake.poll();
        order[placedCount++] = course;
        for (int unlockedCourse : unlockedBy.get(course))
            if (--remainingPrereqs[unlockedCourse] == 0) readyToTake.offer(unlockedCourse);
    }
    return placedCount == courseCount ? order : new int[0];       // empty ⇒ cycle exists
}
```

### 8g. Union-Find (path compression + union by rank)
```java
class DisjointSet {
    int[] parent, treeRank;

    DisjointSet(int size) {
        parent = new int[size];
        treeRank = new int[size];
        for (int node = 0; node < size; node++) parent[node] = node;   // each is its own root
    }

    int findRoot(int node) {
        if (parent[node] != node)
            parent[node] = findRoot(parent[node]);      // path compression
        return parent[node];
    }

    boolean union(int firstNode, int secondNode) {
        int firstRoot = findRoot(firstNode), secondRoot = findRoot(secondNode);
        if (firstRoot == secondRoot) return false;      // already connected → cycle
        if (treeRank[firstRoot] < treeRank[secondRoot]) {
            int temp = firstRoot; firstRoot = secondRoot; secondRoot = temp;
        }
        parent[secondRoot] = firstRoot;                 // attach shorter tree under taller
        if (treeRank[firstRoot] == treeRank[secondRoot]) treeRank[firstRoot]++;
        return true;
    }
}
```

### 8h. Dijkstra
```java
int[] shortestDistances(List<List<int[]>> weightedNeighborsOf, int sourceNode, int nodeCount) {
    // weightedNeighborsOf: node -> list of {neighbor, edgeWeight}
    int[] shortestDistance = new int[nodeCount];
    Arrays.fill(shortestDistance, Integer.MAX_VALUE);
    shortestDistance[sourceNode] = 0;

    // each heap entry = {node, distanceFromSource}, ordered by distance
    PriorityQueue<int[]> closestFirst =
            new PriorityQueue<>((first, second) -> Integer.compare(first[1], second[1]));
    closestFirst.offer(new int[]{sourceNode, 0});

    while (!closestFirst.isEmpty()) {
        int[] current = closestFirst.poll();
        int currentNode = current[0], currentDistance = current[1];
        if (currentDistance > shortestDistance[currentNode]) continue;    // stale entry

        for (int[] edge : weightedNeighborsOf.get(currentNode)) {
            int neighbor = edge[0], edgeWeight = edge[1];
            int distanceViaCurrent = currentDistance + edgeWeight;
            if (distanceViaCurrent < shortestDistance[neighbor]) {
                shortestDistance[neighbor] = distanceViaCurrent;
                closestFirst.offer(new int[]{neighbor, distanceViaCurrent});
            }
        }
    }
    return shortestDistance;
}
```

---

## 9. HEAP / TOP-K

**Pseudo-algo (K largest):** 1) **min**-heap → 2) push each number → 3) `if (size > k) poll()` → 4) root = Kth largest.
```java
int findKthLargest(int[] numbers, int k) {
    PriorityQueue<Integer> kLargestSoFar = new PriorityQueue<>();     // min-heap
    for (int number : numbers) {
        kLargestSoFar.offer(number);
        if (kLargestSoFar.size() > k)
            kLargestSoFar.poll();                    // evict the smallest survivor
    }
    return kLargestSoFar.peek();                     // root = Kth largest
}
```
**O(n log k) time, O(k) space.**

```java
// Top-K frequent elements
Map<Integer,Integer> frequencyOf = new HashMap<>();
for (int number : numbers) frequencyOf.merge(number, 1, Integer::sum);

PriorityQueue<Integer> leastFrequentFirst =
        new PriorityQueue<>((first, second) -> frequencyOf.get(first) - frequencyOf.get(second));
for (int number : frequencyOf.keySet()) {
    leastFrequentFirst.offer(number);
    if (leastFrequentFirst.size() > k) leastFrequentFirst.poll();
}
```

**Two heaps — running median:** max-heap `lowerHalf`, min-heap `upperHalf`; keep `lowerHalf.size()` equal to `upperHalf.size()` or one larger; median = `lowerHalf.peek()`, or the average of both roots when sizes match.

---

## 10. BACKTRACKING

**Universal pseudo-algo:** 1) base case → record a **copy** → 2) loop choices → 3) **choose** → 4) **recurse** → 5) **un-choose**.

### 10a. Subsets
```java
List<List<Integer>> subsets(int[] numbers) {
    List<List<Integer>> allSubsets = new ArrayList<>();
    buildSubsets(numbers, 0, new ArrayList<>(), allSubsets);
    return allSubsets;
}

void buildSubsets(int[] numbers, int startIndex,
                  List<Integer> currentSubset, List<List<Integer>> allSubsets) {
    allSubsets.add(new ArrayList<>(currentSubset));           // COPY, never the reference
    for (int index = startIndex; index < numbers.length; index++) {
        currentSubset.add(numbers[index]);                    // choose
        buildSubsets(numbers, index + 1, currentSubset, allSubsets);   // explore (index+1 = no reuse)
        currentSubset.remove(currentSubset.size() - 1);       // un-choose
    }
}
```

### 10b. Permutations
```java
void buildPermutations(int[] numbers, boolean[] isUsed,
                       List<Integer> currentPermutation, List<List<Integer>> allPermutations) {
    if (currentPermutation.size() == numbers.length) {
        allPermutations.add(new ArrayList<>(currentPermutation));
        return;
    }
    for (int index = 0; index < numbers.length; index++) {
        if (isUsed[index]) continue;
        isUsed[index] = true;
        currentPermutation.add(numbers[index]);               // choose
        buildPermutations(numbers, isUsed, currentPermutation, allPermutations);
        currentPermutation.remove(currentPermutation.size() - 1);   // un-choose
        isUsed[index] = false;
    }
}
```

### 10c. Combination Sum (reuse allowed)
```java
void buildCombinations(int[] candidates, int startIndex, int remainingTarget,
                       List<Integer> currentCombination, List<List<Integer>> allCombinations) {
    if (remainingTarget == 0) {
        allCombinations.add(new ArrayList<>(currentCombination));
        return;
    }
    if (remainingTarget < 0) return;                          // prune this branch
    for (int index = startIndex; index < candidates.length; index++) {
        currentCombination.add(candidates[index]);
        buildCombinations(candidates, index,                  // index (not index+1) → reuse allowed
                          remainingTarget - candidates[index], currentCombination, allCombinations);
        currentCombination.remove(currentCombination.size() - 1);
    }
}
```

---

## 11. GREEDY / INTERVALS

### 11a. Merge intervals
**Pseudo-algo:** 1) sort by **start** → 2) if current.start <= last.end → merge (extend end) → 3) else append.
```java
int[][] mergeIntervals(int[][] intervals) {
    Arrays.sort(intervals, (first, second) -> Integer.compare(first[0], second[0]));   // by start
    List<int[]> merged = new ArrayList<>();
    for (int[] current : intervals) {
        int[] lastMerged = merged.isEmpty() ? null : merged.get(merged.size() - 1);
        boolean overlapsLast = lastMerged != null && current[0] <= lastMerged[1];
        if (overlapsLast) lastMerged[1] = Math.max(lastMerged[1], current[1]);   // extend end
        else merged.add(current);
    }
    return merged.toArray(new int[0][]);
}
```

### 11b. Max non-overlapping (sort by END)
```java
int maxNonOverlappingIntervals(int[][] intervals) {
    Arrays.sort(intervals, (first, second) -> Integer.compare(first[1], second[1]));  // earliest finish
    int selectedCount = 0, lastSelectedEnd = Integer.MIN_VALUE;
    for (int[] interval : intervals) {
        int start = interval[0], end = interval[1];
        if (start >= lastSelectedEnd) {          // no clash with the last one we took
            selectedCount++;
            lastSelectedEnd = end;
        }
    }
    return selectedCount;
}
```

### 11c. Kadane (max subarray)
```java
int maxSubArraySum(int[] numbers) {
    int bestSumEndingHere = numbers[0], bestSumOverall = numbers[0];
    for (int index = 1; index < numbers.length; index++) {
        bestSumEndingHere = Math.max(numbers[index],                    // restart here…
                                     bestSumEndingHere + numbers[index]); // …or extend
        bestSumOverall = Math.max(bestSumOverall, bestSumEndingHere);
    }
    return bestSumOverall;
}
```

---

## 12. DYNAMIC PROGRAMMING

> **5 steps every time:** state meaning → transition → base case → iteration order → where the answer lives.

### 12a. Top-down memo (start here — easiest to derive)
```java
Map<Integer,Integer> solutionForIndex = new HashMap<>();

int solveFrom(int index) {
    if (index <= 1) return BASE_CASE_VALUE;
    if (solutionForIndex.containsKey(index)) return solutionForIndex.get(index);
    int answer = /* recurrence using solveFrom(index-1), solveFrom(index-2), ... */ 0;
    solutionForIndex.put(index, answer);
    return answer;
}
```

### 12b. 1D linear (House Robber)
*State:* best loot considering houses up to the current one.
```java
int rob(int[] houseValues) {
    int bestTwoHousesBack = 0, bestOneHouseBack = 0;
    for (int houseValue : houseValues) {
        int bestIncludingThisHouse = Math.max(bestOneHouseBack,             // skip this house
                                              bestTwoHousesBack + houseValue);  // rob this house
        bestTwoHousesBack = bestOneHouseBack;
        bestOneHouseBack = bestIncludingThisHouse;
    }
    return bestOneHouseBack;
}
```

### 12c. Unbounded knapsack (Coin Change — min coins)
*State:* `minCoinsFor[amount]` = fewest coins that make exactly `amount`.
```java
int coinChange(int[] coins, int targetAmount) {
    int impossible = targetAmount + 1;
    int[] minCoinsFor = new int[targetAmount + 1];
    Arrays.fill(minCoinsFor, impossible);
    minCoinsFor[0] = 0;                                       // base case
    for (int amount = 1; amount <= targetAmount; amount++)
        for (int coin : coins)
            if (coin <= amount)
                minCoinsFor[amount] = Math.min(minCoinsFor[amount], minCoinsFor[amount - coin] + 1);
    return minCoinsFor[targetAmount] >= impossible ? -1 : minCoinsFor[targetAmount];
}
```

### 12d. 0/1 knapsack
*State:* `bestValueForCapacity[c]` = best value achievable in capacity c.
```java
int knapsack(int[] itemWeights, int[] itemValues, int totalCapacity) {
    int[] bestValueForCapacity = new int[totalCapacity + 1];
    for (int item = 0; item < itemWeights.length; item++)
        for (int capacity = totalCapacity; capacity >= itemWeights[item]; capacity--)  // REVERSE → use each item once
            bestValueForCapacity[capacity] =
                Math.max(bestValueForCapacity[capacity],
                         bestValueForCapacity[capacity - itemWeights[item]] + itemValues[item]);
    return bestValueForCapacity[totalCapacity];
}
```

### 12e. 2D grid paths
*State:* `pathsToCol[col]` = ways to reach this cell in the current row.
```java
int uniquePaths(int rowCount, int colCount) {
    int[] pathsToCol = new int[colCount];
    Arrays.fill(pathsToCol, 1);                       // first row: one way to each cell
    for (int row = 1; row < rowCount; row++)
        for (int col = 1; col < colCount; col++)
            pathsToCol[col] += pathsToCol[col - 1];   // from above (old value) + from left
    return pathsToCol[colCount - 1];
}
```

### 12f. LCS (two-sequence template)
*State:* `lcsLength[i][j]` = LCS of first i chars of A and first j chars of B.
```java
int longestCommonSubsequence(String firstText, String secondText) {
    int[][] lcsLength = new int[firstText.length() + 1][secondText.length() + 1];
    for (int i = 1; i <= firstText.length(); i++)
        for (int j = 1; j <= secondText.length(); j++)
            lcsLength[i][j] = (firstText.charAt(i-1) == secondText.charAt(j-1))
                    ? lcsLength[i-1][j-1] + 1                              // chars match
                    : Math.max(lcsLength[i-1][j], lcsLength[i][j-1]);      // drop one char
    return lcsLength[firstText.length()][secondText.length()];
}
```

### 12g. LIS — O(n log n) via patience sorting
*State:* `smallestTailForLength[k]` = smallest possible tail of an increasing subsequence of length k+1.
```java
int lengthOfLIS(int[] numbers) {
    List<Integer> smallestTailForLength = new ArrayList<>();
    for (int number : numbers) {
        int insertPosition = Collections.binarySearch(smallestTailForLength, number);
        if (insertPosition < 0) insertPosition = -(insertPosition + 1);    // convert to insertion point
        if (insertPosition == smallestTailForLength.size())
            smallestTailForLength.add(number);                             // extends the longest run
        else
            smallestTailForLength.set(insertPosition, number);             // tightens an existing run
    }
    return smallestTailForLength.size();
}
```

---

## 13. BIT MANIPULATION

```java
value & 1                      // is odd?
value >> 1                     // divide by 2
value & (value - 1)            // clear lowest set bit → bit counting
(value & (value - 1)) == 0     // is power of two (for value > 0)
value ^ value == 0             // XOR self-cancels → finds the single non-duplicate
1 << bitPosition               // mask for a specific bit
Integer.bitCount(value)        // number of set bits
```
```java
int findSingleNumber(int[] numbers) {         // every value appears twice except one
    int runningXor = 0;
    for (int number : numbers) runningXor ^= number;   // pairs cancel out
    return runningXor;
}
```

---

## 14. COMPLEXITY QUICK TABLE

| Structure / op | Access | Search | Insert | Delete |
|---|---|---|---|---|
| Array | O(1) | O(n) | O(n) | O(n) |
| ArrayList (amortised) | O(1) | O(n) | O(1) end | O(n) |
| LinkedList | O(n) | O(n) | O(1) at node | O(1) at node |
| HashMap / HashSet | – | O(1) avg | O(1) avg | O(1) avg |
| TreeMap (red-black) | – | O(log n) | O(log n) | O(log n) |
| PriorityQueue | O(1) peek | O(n) | O(log n) | O(log n) pop |
| ArrayDeque | – | O(n) | O(1) ends | O(1) ends |

**Sorts:** Arrays.sort primitives = dual-pivot quicksort O(n log n) avg · Collections.sort objects = Timsort O(n log n) stable · counting/radix O(n+k) for bounded ints.

**Recursion space:** call stack depth counts — tree recursion O(h), and h = n for a skewed tree.

---

## 15. HOW TO DRILL THIS FILE

1. Cover the code, read the **pseudo-algo** only, write the template from memory.
2. Diff against the file. Anything you missed → mark that pattern in `PROGRESS_TRACKER.md` at confidence ≤ 2 (2-day review bucket).
3. Then solve 2 NeetCode problems using that template — code from your memory version, not this file.
4. A template you can type blind + explain the invariant aloud = confidence 5.
