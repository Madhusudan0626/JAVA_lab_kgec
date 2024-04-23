import java.util.Scanner;

public class assignment4 {
    public static void main(String[] args) {
        String correctAnswer = "James Gosling";
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        do {
            System.out.println("Who is the inventor of Java ?");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase(correctAnswer)) {
                System.out.println("Good");
                break;
            } else {
                attempts++;
                if (attempts < 3) {
                    System.out.println("Try Again");
                } else {
                    System.out.println("The correct answer is: " + correctAnswer);
                    break;
                }
            }
        } while (attempts < 3);
        scanner.close();
    }
}
