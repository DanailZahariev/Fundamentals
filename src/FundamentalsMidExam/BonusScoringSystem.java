import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentsCount = Integer.parseInt(scanner.nextLine());
        int countLectures = Integer.parseInt(scanner.nextLine());
        int bonus = Integer.parseInt(scanner.nextLine());
        double maxBonus = 0;
        int maxAttendance = 0;
        for (int i = 0; i < studentsCount; i++) {
            int attendanceStudent = Integer.parseInt(scanner.nextLine());
            double totalBonus = attendanceStudent * 1.0 / countLectures * (5 + (bonus));

            if (totalBonus > maxBonus) {
                maxBonus = totalBonus;
                maxAttendance = attendanceStudent;
            }
        }
        System.out.printf("Max Bonus: %.0f.%n", maxBonus);
        System.out.printf("The student has attended %d lectures.", maxAttendance);
    }
}
