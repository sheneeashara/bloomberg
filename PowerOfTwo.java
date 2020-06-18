class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n<=0)    return false;
        while(n>1){
            if(n%2!=0){
                return false;
            }
            n=n/2;
        }
        return true;
    }

    public static void main(final String[] args) {
        // check if the number is valid power of 2
        // output : true
        System.out.println(isPowerOfTwo(1));

        // output : true
        System.out.println(isPowerOfTwo(16));

        // output : false
        System.out.println(isPowerOfTwo(218));
    }
}