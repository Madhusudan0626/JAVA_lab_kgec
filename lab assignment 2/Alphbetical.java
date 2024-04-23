// Write a program which will read a string and rewrite it in the alphabetical order.
//  For example, the word STUDENT should be written as DENSTTU.

import java.util.Arrays;

public class Alphbetical {
    public static void main(String ...args){
        String s="STUDENT";
        char a[]=s.toCharArray();

        Arrays.sort(a);
        System.out.println(s+ " In Alphabetical Order "+new String(a));
    }
}
/*
 * STUDENT In Alphabetical Order DENSTTU
 */