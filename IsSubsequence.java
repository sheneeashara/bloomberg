class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if((t==null && s==null) || (t.isEmpty() && s.isEmpty()))    return true;
        if(t==null || t.isEmpty())    return false;
        if(s==null || s.isEmpty())    return true;
        int i=0, j=0;
        while(i<t.length()){
            if(t.charAt(i)==s.charAt(j)){
                j++;
            }
            if(j>=s.length()){
                return true;
            }
            i++;
        }
        return false;
    }

    public static void main(final String[] args) {
        // check if s is subsequence of t
        String s1 = "abc";
        String t1 = "ahbgdc";
        // output : true
        System.out.println(isSubsequence(s1,t1));

        String s2 = "axc";
        String t2 = "ahbgdc";
        // output : false
        System.out.println(isSubsequence(s2,t2));

        String s3 = "abc";
        String t3 = "";
        // output : false
        System.out.println(isSubsequence(s3,t3));
    }
}