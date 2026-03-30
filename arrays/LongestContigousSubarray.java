package arrays;

import java.util.ArrayDeque;

public class LongestContigousSubarray {
    public static void main(String[] args) {

        System.out.println(varMinMax(new int[] {8,2,4,7}, 4));

    }

    public static int varMinMax(int[] ar, int k) {
        int ret = 0;
        ArrayDeque<Integer> min = new ArrayDeque<>();
        ArrayDeque<Integer> max = new ArrayDeque<>();
    
        int start = 0;
    
        for (int end = 0; end < ar.length; end++) {
    
            while (!max.isEmpty() && ar[end] > ar[max.peekLast()]) {
                max.pollLast();
            }
    
            while (!min.isEmpty() && ar[end] < ar[min.peekLast()]) {
                min.pollLast();
            }
    
            max.offerLast(end);
            min.offerLast(end);
    
            while (ar[max.peekFirst()] - ar[min.peekFirst()] > k) {
    
                if (max.peekFirst() == start) max.pollFirst();
                if (min.peekFirst() == start) min.pollFirst();
    
                start++;
            }
    
            ret = Math.max(ret, end - start + 1);
        }
    
        return ret;
    }

    // 2 1 3 4 -1 6
    public static void fixedMax(int[] ar) {
        ArrayDeque<Integer> aq = new ArrayDeque<>();

        int i = 0, n = ar.length, k = 2;

        while (i < n) {
            while (!aq.isEmpty() && ar[i] > ar[aq.peekLast()]) {
                aq.pollLast();
            }

            aq.offerLast(i);

            if (aq.getFirst() < i - k + 1) {
                aq.pollFirst();
            }

            if (i >= k - 1) {
                System.out.println("Till Index: " + i + " -> " + ar[aq.peekFirst()]);
            }

            i++;
        }

    }

    // 2 1 3 4 -1 6
    public static void fixedMin(int[] ar) {
        ArrayDeque<Integer> aq = new ArrayDeque<>();

        int i = 0, n = ar.length, k = 2;

        while (i < n) {
            while (!aq.isEmpty() && ar[i] < ar[aq.peekLast()]) {
                aq.pollLast();
            }

            aq.offerLast(i);

            if (aq.getFirst() < i - k + 1) {
                aq.pollFirst();
            }

            if (i >= k - 1) {
                System.out.println("Till Index: " + i + " -> " + ar[aq.peekFirst()]);
            }

            i++;
        }

    }
}
