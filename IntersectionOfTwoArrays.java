import java.io.*;
import java.util.*;

public class IntersectionOfTwoArrays {
    
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length==0 || nums2.length==0 || nums1==null || nums2==null){
            return new int[0];
        }
        Set<Integer> longarr = new HashSet<>();
        Set<Integer> r = new HashSet<>();
        for(int i : (nums1.length>nums2.length ? nums1 : nums2)){
            longarr.add(i);
        }
        for(int i : (nums1.length>nums2.length ? nums2 : nums1)){
            if(longarr.contains(i)){
                r.add(i);
            }
        }
        int[] result = new int[r.size()];
        int j=0;
        for(Integer i : r){
            result[j] = i;
            j++;
        }
        return result;
    }

    public static void main(final String[] args) {
        int[] c1 = new int[]{1,2,2,1};
        int[] c2 = new int[]{2,2};
        int r1 = twoSum(c1, c2);
        // output : [2]
        printArray(r1);

        int[] c3 = new int[]{4,9,5};
        int[] c4 = new int[]{9,4,9,8,4};
        int[] r2 = twoSum(c3, c4);
        // output : [9,4]
        printArray(r2);
    }

    public void printArray(int[] arr){
        for(int i : arr){
            System.out.print(i+", ");
        }
        System.out.println();
    }
}