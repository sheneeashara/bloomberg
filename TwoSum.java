import java.io.*;
import java.util.*;

public class TwoSum {
    
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i]) && map.get(target-nums[i]) != i) {
                result[0]=i;
                result[1]=map.get(target-nums[i]);
            }
        }
        return result;
    }

    public static void main(final String... args) {
        int[] c1 = new int[]{2,7,11,15};
        int[] r1 = twoSum(c1, 9);
        // output : [0,1]
        printArray(r1);

        int[] c2 = new int[]{2,7,11,15};
        int[] r2 = twoSum(c2, 3);
        printArray(r2);

        int[] c3 = new int[4];
        int[] r3 = twoSum(c3, 9);
        printArray(r3);
    }

    public void printArray(int[] arr){
        for(int i : arr){
            System.out.print(i+", ");
        }
        System.out.println();
    }
}