package arrays;

public class LC3891 {
    public static void main(String[] args) {
        int[] ar = { 12, 23, 13, 17, 21, 3 };
        System.out.println(min(ar));
    }

    public static long min(int[] ar) {
        int val = (Math.max(ar[0], ar[2]) + 1) - ar[1];
        long[] prev1 = new long[] { 1, val > 0 ? val : 0 };
        long[] prev2 = new long[] { 0, 0 };

        for (int i = 2; i <= ar.length - 2; i++) {
            int mx = (Math.max(ar[i - 1], ar[i + 1]) + 1) - ar[i];
            long[] curr = compare(prev1, new long[] { prev2[0] + 1, prev2[1] + (mx > 0 ? mx : 0) });
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1[1];
    }

    public static long[] compare(long[] a, long[] b) {
        if (a[0] > b[0]) {
            return a;
        } else if (b[0] > a[0]) {
            return b;
        } else {
            return a[1] < b[1] ? a : b;
        }
    }
}
