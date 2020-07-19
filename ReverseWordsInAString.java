class ReverseWordsInAString {
    public String reverseWords(String s) {
        // remove leading spaces
        s = s.trim();
        // split by multiple spaces
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        // reverse the list and join
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    public static void main(final String[] args) {
        // here the time complexity would be O(n) as we are traversing through the string only once
        // also the space complexity would be O(n) to store the result of split by spaces

        String s1 = "the sky is blue";
        // output : "blue is sky the"
        System.out.println(reverseWords(s1));

        String s2 = "  hello world!  ";
        // output : "world! hello"
        System.out.println(reverseWords(s2));
    }
}