package arrays;

import java.util.Arrays;

class PartitionArrayMaxDiff {

    public static void main(String[] args) {
        System.out.println(func(new int[] { 2, 2, 4, 5 }, 0));

    }

    public static int func(int[] ar, int k) {
        Arrays.sort(ar);

        int i = 0, j = 0;
        int max = 0;
        while (i < ar.length && j < ar.length) {
            if (j < ar.length && Math.abs(ar[i] - ar[j]) <= k) {
                j++;
            }
            max++;
            i = j;
        }

        return max;
    }
}