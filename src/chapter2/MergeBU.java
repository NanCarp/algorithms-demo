package chapter2;

import static chapter2.Merge.merge;

/**
 * Created by nanca on 3/2/2018.
 */
public class MergeBU {
    private static Comparable[] aux;  // 归并所需辅助函数

    public static void sort(Comparable[] a) {
        // 进行 lgN 次两两归并
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz) { // 子数组大小
            for (int lo = 0; lo < N -sz; lo += sz + sz) { // lo: 子数组索引
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz, N - 1));
            }
        }
    }


}
