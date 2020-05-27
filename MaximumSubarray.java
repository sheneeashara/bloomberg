import java.io.*;
import java.util.*;

public class MaximumSubarray {
    
    public int maxSubArray(int[] nums) {
      int max = nums[0];
      int sum = nums[0];
      for(int i=1; i<nums.length; i++){
          sum = Math.max(nums[i], sum+nums[i]);
          max = Math.max(max, sum);
      }
      return max;
  }

    public static void main(final String[] args) {
        int[] c1 = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int r1 = maxSubArray(c1);
        // output : 6
        System.out.println(r1);
    }
}
