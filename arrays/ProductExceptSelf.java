package arrays;

import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExSelf(new int[]{0,0})));
    }
    public static int[] productExSelf(int[] nums){
        int[] ar = new int[nums.length];
        int i = 0;
        int[] l = new int[nums.length];
        l[0] = nums[0];
        int[] r = new int[nums.length];
        r[nums.length-1] = nums[nums.length-1];
        for (int j = 1; j < nums.length; j++) {
            int ri = nums.length - 1 -j;
            r[ri] = r[ri+1] * nums[ri];
            l[j] = l[j-1] * nums[j];
        }   
        for (int j = 0; j < nums.length; j++) {
            if (j == nums.length - 1) {
                ar[i++] = l[j-1];
            }else if (j == 0) {
                ar[i++] = r[j+1];
            }else{
                ar[i++] = l[j-1] * r[j+1];
            }
        }
        return ar;
    }
}
