import java.util.*;

class Student{

    long roll;
    private float ca1 , ca2 , ca3 , ca4 , pca1 , pca2;
    float total; 
    Scanner sc = new Scanner(System.in);
    void getInfo(long r){
        roll =r;
    }

    void getMarks(){
        System.out.println("Enter the ca1 ca2 ca3 ca4 marks");
        ca1 = sc.nextFloat();
        ca2 = sc.nextFloat();
        ca3 = sc.nextFloat();
        ca4 = sc.nextFloat();

        System.out.println("Enter the pca1 and pca2");

        pca1 = sc.nextFloat();
        pca2 = sc.nextFloat();
    }

    float totalMarks(){
        return total = ca1 + ca2 + ca3 + ca4 + pca1 + pca2;
    }

    void highestOf(){
        System.out.println("Roll : "+roll);
        float[] c={ca1,ca2,ca3,ca4};
        Arrays.sort(c);
        System.out.println("Highest of CAs "+c[c.length - 1]);
        
        float max;
        if(pca1 > pca2)
            max = pca1;
        else
            max = pca2;
        System.out.println("Highest of PCAs "+max);
    }  

}

class Main{
    public static void main(String ...args){
        Scanner sc = new Scanner(System.in);
        Student s[]=new Student[2];
        float max = 0;
        long roll_h=0;
        for(Student st : s){
            st = new Student();
            System.out.println("Enter roll no.");
            long r = sc.nextLong();
            st.getInfo(r);
            st.getMarks();
            st.highestOf();
            System.out.println("Total obtained marks "+st.totalMarks());
            if (st.total > max){
                roll_h = st.roll;
                max = st.total;
            }
        }
        sc.close();
        System.out.println("Highest marks obatined by student\nRoll : "+roll_h+"\tMarks : "+max);
    }
}
