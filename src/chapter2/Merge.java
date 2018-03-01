package chapter2;

/**
 * Created by nanca on 3/1/2018.
 */
public class Merge {
    private static Comparable[] aux; // 归并所需的辅助数组

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length]; // 一次性分配空间
        sort(a, 0, a.length -1);
    }

    // 将数组 a[lo...hi] 排序
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid); // 将左半边排序
        sort(a, mid + 1, hi); // 将右半边排序
        merge(a, lo, mid, hi); // 归并结果
    }

    // 将 a[lo...mid] 和 a[mid+1...hi] 归并
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        // 将 a[lo...hi] 复制到 aux[lo...hi]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid)  a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}
