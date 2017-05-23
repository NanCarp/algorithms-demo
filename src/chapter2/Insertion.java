package chapter2;

import algs4.StdOut;

import java.util.Comparator;


/**
 * Created by NanCarp on 2017/5/6.
 */
public class Insertion {
    public static void sort(Comparable[] a) {
        // 将a[]按升序排列
        int N = a.length;
        for (int i = 1; i < N; i++) {
            // 将 a[i] 插入到 a[i-1]、a[i-2]、a[i-3]...之中
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--)
                exch(a, j, j-1);
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    // 在单行中打印数组
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    // 测试数组元素是否有序
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    /*// 从标准输入读取字符串，将它们排序并输出
    public static void main(String[] args) {
        String[] a = In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }*/
}






