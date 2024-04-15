import java.util.Scanner;

/*
Assignment 26
An educational institute wishes to maintain a database of its employees. The database is devided into a number of classes, namely, staff, teacher, officer and clerk. The data members of the classes are as follows:
staff class - code and name
teacher class - code, name, subject and department
officer class - code, name and grade
clerk class - code, name and department
Specify all the classes and define methods to
create an array of objects and retrieve individual information using code
 */
import java.util.Scanner;

class Staff {
    protected int code;
    private String name;
    Scanner sc = new Scanner(System.in);

    public Staff getData() {
        System.out.println("Enter staff info : Code and Name");
        code = sc.nextInt();
        sc.nextLine();
        name = sc.nextLine();
        return this;
    }

    public void showInfo() {
        System.out.println("Code : " + code + "\nName : " + name);
    }
}

class Clerk extends Staff {
    private String department;

    public Clerk clerkInfo() {
        System.out.println("Clerk : ");
        getData();
        System.out.println("Department : ");
        department = sc.nextLine();
        return this;
    }

    public void Info1() {
        showInfo();
        System.out.println("Staff Type : Clerk");
        System.out.println("Clerk Department : " + department);
    }
}

class Officer extends Staff {
    private String grade;

    public Officer officerInfo() {
        System.out.println("Officer : ");
        getData();
        System.out.println("Grade : ");
        grade = sc.nextLine();
        return this;
    }

    public void Info2() {
        showInfo();
        System.out.println("Staff Type : Officer");
        System.out.println("Officer Grade : " + grade);
    }
}

class Teacher extends Staff {
    private String subject;
    private String department;

    public Teacher teacherInfo() {
        System.out.println("Teacher : ");
        getData();
        System.out.println("Subject and department:");
        subject = sc.nextLine();
        department = sc.nextLine();
        return this;
    }

    public void Info3() {
        showInfo();
        System.out.println("Staff Type : Teacher");
        System.out.println("Teacher subject " + subject + " and Department : " + department);
    }
}

public class Main {
    public static void main(String[] args) {
        Staff st[] = createEmployeeObject();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter staff code to be searched");
        int code = sc.nextInt();
        Staff re = getEmployeeInfo(st, code);
        if(re != null){
            if (re instanceof Clerk){
                ((Clerk) re).Info1();
            }
            else if(re instanceof Officer)
                ((Officer)re).Info2();
            else if(re instanceof  Teacher)
                ((Teacher) re).Info3();
        }
        else
            System.out.println("Inavlid record");

    }

    public static Staff[] createEmployeeObject() {
        Staff emp[] = {
                new Staff().getData(),
                new Clerk().clerkInfo(),
                new Officer().officerInfo(),
                new Teacher().teacherInfo(),
        };
        return emp;
    }

    public static Staff getEmployeeInfo(Staff[] s, int code) {
        for (Staff st : s) {
            if (st.code == code) {
                return st;
            }
        }
        return null;
    }
}

/*
Enter staff info : Code and Name
101
A
Clerk : 
Enter staff info : Code and Name
201
B
Department : 
Accounts
Officer : 
Enter staff info : Code and Name
301
C
Grade : 
Grade A
Teacher : 
Enter staff info : Code and Name
401
D
Subject and department:
Optics
Physics
Enter staff code to be searched
301
Code : 301
Name : C
Staff Type : Officer
Officer Grade : Grade A

Process finished with exit code 0

 */
