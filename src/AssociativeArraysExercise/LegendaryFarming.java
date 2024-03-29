import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> keyMaterials = new HashMap<>();
        Map<String, Integer> junkMaterials = new TreeMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);
        boolean obtained = false;
        while (!obtained) {
            String[] tokens = scanner.nextLine().split("\\s+");
            for (int i = 0; i < tokens.length; i += 2) {
                int quantity = Integer.parseInt(tokens[i]);
                String material = tokens[i + 1].toLowerCase();
                if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                    keyMaterials.put(material, keyMaterials.get(material) + quantity);
                    if (keyMaterials.get(material) >= 250) {
                        keyMaterials.put(material, keyMaterials.get(material) - 250);
                        if (material.equals("shards")) {
                            System.out.println("Shadowmourne obtained!");
                        } else if (material.equals("fragments")) {
                            System.out.println("Valanyr obtained!");
                        } else {
                            System.out.println("Dragonwrath obtained!");
                        }
                        obtained = true;
                        break;
                    }
                } else {
                    junkMaterials.putIfAbsent(material, 0);
                    int currentJunk = junkMaterials.get(material);
                    junkMaterials.put(material, currentJunk + quantity);

                }
            }
        }
        keyMaterials.entrySet().stream().sorted((k, v) -> {
            int result = v.getValue().compareTo(k.getValue());
            if (result == 0) {
                result = k.getKey().compareTo(v.getKey());
            }
            return result;
        }).forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
        junkMaterials.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
