package TwoPointers;

import java.util.Arrays;

public class TwoSumII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(tp(new int[] { 3, 24, 50, 79, 88, 150, 345 }, 200)));
        System.out.println(Arrays.toString(bs(new int[] { 3, 24, 50, 79, 88, 150, 345 }, 200)));
    }

    // valid combination always exists
    public static int[] bs(int[] ar, int target) {
        int[] idx = new int[2];
        for (int i = 0; i < ar.length; i++) {
            int l = Arrays.binarySearch(ar, 0, i, target - ar[i]);
            int r = Arrays.binarySearch(ar, i + 1, ar.length, target - ar[i]);
            if (l > 0) {
                idx[0] = l + 1;
                idx[1] = i + 1;
                break;

            } else if (r > 0) {
                idx[0] = i + 1;
                idx[1] = r + 1;
                break;
            }
        }
        return idx;

    }

    public static int[] tp(int[] ar, int target) {
        int[] idx = new int[2];
        int i = 0, j = ar.length - 1;
        while (i < j) {

            if (ar[i] + ar[j] > target) {
                j--;
            } else if (ar[i] + ar[j] < target) {
                i++;
            } else if (ar[i] + ar[j] == target) {
                idx[0] = i + 1;
                idx[1] = j + 1;
                break;
            }
        }
        return idx;
    }

}
