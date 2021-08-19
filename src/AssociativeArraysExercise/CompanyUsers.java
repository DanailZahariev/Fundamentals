import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" -> ");
        Map<String, List<String>> companies = new TreeMap<>();
        while (!input[0].equals("End")) {
            String company = input[0];
            String id = input[1];
            if (!companies.containsKey(company)) {
                companies.put(company, new ArrayList<>());
                companies.get(company).add(id);
            } else {
                if (companies.get(company).contains(id)) {
                    companies.get(company).remove(company);
                } else {
                    companies.get(company).add(id);
                }
            }
            input = scanner.nextLine().split(" -> ");
        }
        for (Map.Entry<String,List<String>> entry:companies.entrySet()) {
            System.out.println(entry.getKey());
            for (String id: entry.getValue()) {
                System.out.println("-- " + id);
            }
        }
    }
}
