/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Student
 */
import java.util.*;
class Student{
    protected int roll;
    Scanner sc = new Scanner(System.in);
    void getRollNo(){
        System.out.println("Enter your roll no.");
        roll = sc.nextInt();
    }
}

class Test extends Student{
    protected float ca1 , ca2 , ca3 , ca4;
    Scanner sc = new Scanner(System.in);
    void getMarks(){
        System.out.println("Enter ca1 ca2 ca3 ca4 marks");
            ca1 = sc.nextFloat();
            ca2 = sc.nextFloat();
            ca3 = sc.nextFloat();
            ca4 = sc.nextFloat();
    }
    void display(){
        System.out.println("STUDENT INFO.");
        System.out.println("Roll : "+roll+"\nCA1 : "+ca1+"\tCA2 : "+ca2+"\tCA3 : "+ca3+"\tCA4 : "+ca4);
    }
}
 interface Sports{
     float soprtsswt = 6.0f;
     void display_s();
 }

class Result_pro extends Test implements Sports{
    public void display_s(){
        System.out.println("Sports weight "+soprtsswt);
    }
    void makeSystem(){
        Test []t = new Test[2];
        for(Test t1:t){
            t1 = new Test();
            t1.getRollNo();
            t1.getMarks();
            t1.display();
            System.out.println(calculate_percentage(t1));
            display_s();
        }
    }
    float calculate_percentage(Test t){
        return (t.ca1+t.ca2+t.ca3+t.ca4);
    }
    
}

public class Result{

    /**
     * @param args the command line arguments
     */
    public static void main(String ...args) {
        Result_pro r = new Result_pro();
        r.makeSystem();
    }
}
