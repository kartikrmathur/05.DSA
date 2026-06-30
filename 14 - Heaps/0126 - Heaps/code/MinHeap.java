// Rebuild scaffold — array-backed Min-Heap from scratch.

import java.util.ArrayList;

public class MinHeap {

    ArrayList<Integer> heap = new ArrayList<>();

    private int leftChildIndex(int i) { return i * 2 + 1; }
    private int rightChildIndex(int i) { return i * 2 + 2; }
    private int parentIndex(int i) { return (i - 1) / 2; }

    private void swap(int a, int b) {
        int tmp = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, tmp);
    }

    public void insert(int value) {
        // TODO: add to end of array, then "sift up" — while parent is larger, swap with parent
    }

    public Integer remove() {
        // TODO: save root, move last element to root, remove last, then "sift down"
        // sift down: repeatedly swap with the smaller child until heap property holds
        return null;
    }
}
