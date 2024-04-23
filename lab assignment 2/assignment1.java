import java.util.Scanner;

class ElectionCount{

    public static void main(String ...args){
        Scanner sc = new Scanner(System.in);
        int [] count = new int[5];

        int noOfspoiltballots = 0;
        System.out.println("Enter the number of ballots");
        int n=sc.nextInt();

        System.out.println("Enter the ballots");

        for(int i=0;i<n;i++){
            int ballot = sc.nextInt();
            if(ballot >0 && ballot <6){
                count[ballot - 1]++;
            }
            else
                noOfspoiltballots++;   
        }
        display(count, noOfspoiltballots);
        sc.close();
    }

    public static void display(int []c,int spoilt){
        for(int i=0;i<5;i++){
            System.out.println("Candidate "+(i+1)+" received "+c[i]+" votes");
        }
        System.out.println("Number of spoilt ballots "+spoilt);
    }
}