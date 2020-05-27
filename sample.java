import java.io.*;
import java.util.*;

/**
 * Write a function to crush candy in a one dimensional board.
 *
 * In candy crushing games, groups of like items are removed from the board. In this problem, any sequence of 3 or more like
 * items should be removed and any items adjacent to that sequence should now be considered adjacent to each other. This
 * process should be repeated as many times as possible.
 */
public class Solution {
    private interface ICrusher<T> {
        /**
         * Inline crusher of candies.
         * @param candy to crush; a non-null array of non-nulls, but the crushed result may contain a null sentinel.
         */
        void crush(T[] candy);
    }
    
    private static class Crusher<T> implements ICrusher<T> {
        @Override
        public void crush(final T[] candy) {
            throw new UnsupportedOperationException("TODO!");
        }
    }
    
    private static String crush(String s){
        int k = 3;
        int i=0;
        StringBuilder r = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        for(i=1; i<r.length(); i++){
            System.out.println("i : " + i);
            if(i==0){
                stack.push(1);
            } else if(r.charAt(i)==r.charAt(i-1)){
                // increment the counter in stack
                int temp = stack.pop()+1;
                System.out.println("temp : " + temp);
                stack.push(temp);
            } else {
                int temp = stack.pop();
                System.out.println("temp : " + temp);
                if(temp>=k){
                    r.delete(i-temp, i);
                    i=i-temp;
                }
                System.out.println("-- inside i : " + i);
                if(i!=0 && r.charAt(i)==r.charAt(i-1)){
                    int temp1 = stack.pop()+1;
                    // System.out.println("temp : " + temp);
                    stack.push(temp1);              
                } else {
                    stack.push(1); // AABBBA (no), AABBBC (yes)
                }
            }
        }
        if(stack.size()!=0){
            int temp = stack.pop();
            if(temp>=k){
                r.delete(i-temp, i);
            }
        }
        
        return r.toString();
    }
    
    private static final Collection<Case<String>> cases = Arrays.asList(
        // Optionally add more test cases here.
        new Case<>("", ""),
        new Case<>("A", "A"),
        new Case<>("AA", "AA"),
        new Case<>("AAA", ""),
        new Case<>("AAAA", ""),
        new Case<>("AAABBB", ""),
        new Case<>("AABBBA", ""),
        new Case<>("ABBCCCBBA", "AA"),
        new Case<>("AAABBCCCDD", "BBDD")
    );
    
    /*
        // ABBBBAA
        String result = ""
        stack : [{}]
    */

    public static void main(final String... args) {
        for (final Case<String> c : cases) {
            System.out.println(c.input);
            final String result = crush(c.input);
            if (!Objects.equals(c.expected, result.toString())) {
                throw new RuntimeException("Expected '" +  c.expected +"' but received '" + result + "'");
            }
        }

        System.out.println("Successfully finished crushing candy.");
    }

    private static final class Case<T> {
        final T input;
        final T expected;

        private Case(final T input, final T expected) {
            this.input = input;
            this.expected = expected;
        }
    }
}