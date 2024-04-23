// Write a program which will read a text and will count all occurrences of every word
import java.util.*;
public class Ocuurence {
    public static void main(String ...args){
        String s=null;
        System.out.println("Enter your text");
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();
        String st[]=s.split(" ");
        HashMap<String,Integer> d= new HashMap<>();
        
        for(String str:st){
            if (!d.containsKey(str))
                d.put(str,1);
            else
                d.put(str,d.get(str)+1);
        }
        d.forEach((key,value)->{
            System.out.println(key+" : "+value);
        });
        sc.close();
    }   
}


/*
The : 2
over : 1
hill : 1
jumped : 1
fire : 1
fox : 1
 */