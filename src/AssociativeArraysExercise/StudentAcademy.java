import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> students = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());
            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).add(grade);
        }
        students.entrySet().stream().sorted((k, v) -> {
            double first = k.getValue().stream()
                    .mapToDouble(Double::doubleValue)
                    .average().getAsDouble();
            double second = v.getValue().stream()
                    .mapToDouble(Double::doubleValue)
                    .average().getAsDouble();
            return Double.compare(second, first);
        }).forEach(s -> {
            double average = s.getValue().stream().mapToDouble(Double::doubleValue)
                    .average().getAsDouble();
            if (average >= 4.50) {
                System.out.printf("%s -> %.2f%n",s.getKey(),average);
            }
        });
    }
}
