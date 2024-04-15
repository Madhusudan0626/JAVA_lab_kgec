/*
 Define a class named Student with the following properties:
Data members – 
	Name
	Roll
	Marks in CA1, CA2, CA3, CA4, PCA1 and PCA2
Member functions –
	To calculate Total of all CA marks, Total of all PCA marks, Overall Total marks and Overall percentage.
	Display the values
Take values of 5 students using array of objects and display the values one by one.
 */
import java.util.*;
class Student{
    protected int roll;
    protected String Name;
    Scanner sc = new Scanner(System.in);
    void getSTinfo(){
        System.out.println("Enter your name");
        Name = sc.nextLine();
        System.out.println("Enter your roll no.");
        roll = sc.nextInt();
    }
}

class Test extends Student{
    protected float ca1 , ca2 , ca3 , ca4 , pca1 , pca2;
    void getMarks(){
        System.out.println("Enter ca1 ca2 ca3 ca4 marks");
            ca1 = sc.nextFloat();
            ca2 = sc.nextFloat();
            ca3 = sc.nextFloat();
            ca4 = sc.nextFloat();
            System.out.println("Enter pca1 and pca2 marks");
            pca1 = sc.nextFloat();
            pca2 = sc.nextFloat();
    }
    void display(){
        System.out.println("STUDENT INFO.");
        System.out.println("Name : "+Name);
        System.out.println("Roll : "+roll);
        System.out.println("CA1 : "+ca1+"\tCA2 : "+ca2+"\tCA3 : "+ca3+"\tCA4 : "+ca4);
        System.out.println("PCA1 : "+pca1+"\tPCA2 : "+pca2);
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
        Test []t = new Test[5];
        for(Test t1:t){
            t1 = new Test();
            t1.getSTinfo();
            t1.getMarks();
            t1.display();
            calculate_percentage(t1);
            display_s();
        }
    }
    void calculate_percentage(Test t){
        float t_ca = (t.ca1+t.ca2+t.ca3+t.ca4);
        float t_pca = (t.pca1+t.pca2);

        float total = t_ca + t_pca;

        System.out.println("Total CA marks : "+t_ca);
        System.out.println("Total PCA marks : "+t_pca);
        float per = (total/180)*100;
        System.out.println("Overall percentage "+per);
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
