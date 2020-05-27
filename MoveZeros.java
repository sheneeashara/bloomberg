import java.io.*;
import java.util.*;

public class MoveZeros {
    
    public void moveZeroes(int[] nums) {
        int count=0;
        for(int i : nums){
            if(i==0)    count++;
        }
        int j=0;
        for(int i : nums){
            if(i==0){
                continue;
            } else {
                nums[j]=i;
                j++;
            }
        }
        for(int i=j; i<nums.length; i++){
            nums[i]=0;
        }
    }

    public static void main(final String... args) {
        int[] c1 = new int[]{0,1,0,3,12};
        int[] r1 = moveZeroes(c1);
        // output : [1,3,12,0,0]
        printArray(r1);

        int[] c2 = new int[]{1,3,6,0,2,0,6,0,1};
        int[] r2 = moveZeroes(c2);
        // output : [1,3,6,2,6,1,0,0,0]
        printArray(r2);
    }

    public void printArray(int[] arr){
        for(int i : arr){
            System.out.print(i+", ");
        }
        System.out.println();
    }
}