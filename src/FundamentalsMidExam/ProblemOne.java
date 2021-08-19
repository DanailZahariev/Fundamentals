import java.util.Scanner;

public class ProblemOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double neededExperience = Double.parseDouble(scanner.nextLine());
        int battleCount = Integer.parseInt(scanner.nextLine());
        double currentExperience = 0;
        boolean isDone = false;
        int count = 0;
        for (int i = 1; i <= battleCount; i++) {
            double experienceEarnedPerBattle = Double.parseDouble(scanner.nextLine());
            count++;
            if (i % 3 == 0) {
                currentExperience += experienceEarnedPerBattle * 1.15;
            } else if (i % 5 == 0) {
                currentExperience += experienceEarnedPerBattle * 0.9;
            } else {
                currentExperience += experienceEarnedPerBattle;
            }
            if (currentExperience >= neededExperience) {
                isDone = true;
                break;
            }
        }
        if (isDone) {
            System.out.printf("Player successfully collected his needed experience for %d battles."
                    , count);
        } else {
            System.out.printf("Player was not able to collect the needed experience, %.2f more needed."
                    , neededExperience - currentExperience);
        }
    }
}

