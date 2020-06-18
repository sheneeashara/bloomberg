class MaximumWidthRamp {
    public int maxWidthRamp(int[] A) {
        int ans=0;
        Integer[] temp = new Integer[A.length];
        for(int i=0; i<A.length; i++){
            temp[i]=i;
        }
        Arrays.sort(temp, (a,b)->(Integer)A[a]-(Integer)A[b]);
        int m = A.length;
        for(int i : temp){
            ans=Math.max(ans, i-m);
            m=Math.min(m,i);
        }
        return ans;
    }

    public static void main(final String[] args) {
        int[] c1 = new int[]{6,0,8,2,1,5};
        // output : 4
        // Explanation: The maximum width ramp is achieved at (i, j) = (1, 5): A[1] = 0 and A[5] = 5.
        System.out.println(maxWidthRamp(c1));

        int[] c2 = new int[]{9,8,1,0,1,9,4,0,4,1};
        // output : 7
        // Explanation: The maximum width ramp is achieved at (i, j) = (2, 9): A[2] = 1 and A[9] = 1.
        System.out.println(maxWidthRamp(c2));
    }
}