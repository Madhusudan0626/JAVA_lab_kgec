import java.util.Scanner;
import java.util.Vector;

class MakeVector{
    private Vector<Integer> v=new Vector<>(5);
    void display(){
        v.forEach((value) -> {
            System.out.println(value);
        });
    }
    boolean isEmpty(){
        return v.size()==0;
    }
    boolean isFull(){
        return v.size()==5;
    }
    void DeleteChoice(int index){

        if (isEmpty())
            System.out.println("Empty vector");
        else {
            System.out.println("Deleted item " + v.elementAt(index));
            v.remove(index);
        }
    }
    void addItem(int loc,int data){
        if (isFull())
            System.out.println("Vector is full");
        else if(loc > v.size())
            System.out.println("Invalid");
        else if (loc >= 0 || loc <= v.size()-1){
            v.add(loc, data);
            System.out.println("Data inserted");
        }

        else {
            System.out.println("Invalid location");
        }
    }
    void addItemEnd(int data){
        if (isFull())
            System.out.println("Vector is full");
        else {
            v.add(data);
            System.out.println("Data item inserted at end");
        }

    }

}

public class Main {
    public static void main(String[] args) {
        MakeVector m = new MakeVector();
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("1.Delete item");
            System.out.println("2.Insert at specific loc");
            System.out.println("3.Insert at end");
            System.out.println("4.Display");
            System.out.println("5.Exit");

            System.out.print("Enter your choice : ");
            int ch = sc.nextInt();

            switch (ch){
                case 1:
                    System.out.println("Enter index ");
                    ch=sc.nextInt();
                    m.DeleteChoice(ch);
                    break;
                case 2:
                    System.out.println("Enter location and data to be inserted");
                    int loc = sc.nextInt();
                    int data = sc.nextInt();
                    m.addItem(loc,data);
                    break;
                case 3:
                    System.out.println("Enter data to be inserted at end");
                    data = sc.nextInt();
                    m.addItemEnd(data);
                    break;
                case 4:
                    System.out.println("Content in vector");
                    m.display();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Wrong choice");
            }
        }

    }
}