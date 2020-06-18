class SortColors {
    public void sortColors(int[] nums) {
        int count0=0, count1=0, count2=0;
        for(int n : nums){
            if(n==0){
                count0++;
            } else if(n==1) {
                count1++;
            } else {
                count2++;
            }
        }
        int j=0;
            for(j=0; j<count0; j++){
                nums[j]=0;
            }
            for(j=count0; j<count0+count1; j++){
                nums[j]=1;
            }
            for(j=count0+count1; j<count0+count1+count2; j++){
                nums[j]=2;
            }
    }

    public static void main(final String[] args) {

        // here 0,1,2 represents colors
        // this problem is known as Dutch National Flag problem
        int[] c1 = new int[]{2,0,2,1,1,0};
        int r1 = sortColors(c1);
        // output : [0,0,1,1,2,2]
        printArray(r1);

        int[] c2 = new int[]{};
        int[] r2 = twoSum(c2);
        // output : []
        printArray(r2);
    }

    public void printArray(int[] arr){
        for(int i : arr){
            System.out.print(i+", ");
        }
        System.out.println();
    }
}