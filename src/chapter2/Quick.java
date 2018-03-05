package chapter2;

import algs4.StdRandom;

/**
 * Created by nanca on 3/5/2018.
 */
public class Quick {

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    // 将数组切分为 a[lo...i-1], a[i], a[i+1...hi]
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1; // 左右扫描指针
        Comparable v = a[lo]; // 切分元素
        while (true) {
            // 扫描左右，检查扫描是否结束并交换元素
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j); // 将 v = a[j] 放入这缺德位置
        return j; // a[lo...j-1] <= a[j] <= a[j+1..hi] 达成
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
