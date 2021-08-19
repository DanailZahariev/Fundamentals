import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HeroesOfCodeAndLogic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> heroHp = new TreeMap<>();
        Map<String, Integer> heroMp = new TreeMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            String[] commandArray = input.split("\\s+");
            String heroName = commandArray[0];
            int hp = Integer.parseInt(commandArray[1]);
            int mp = Integer.parseInt(commandArray[2]);
            if (hp <= 100) {
                heroHp.put(heroName, hp);
            }
            if (mp <= 200) {
                heroMp.put(heroName, mp);
            }
        }
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] commandArray = command.split(" - ");
            String commandName = commandArray[0];
            String heroName = commandArray[1];
            switch (commandName) {
                case "CastSpell":
                    int neededMp = Integer.parseInt(commandArray[2]);
                    String nameSpell = commandArray[3];
                    int currentMp = heroMp.get(heroName);
                    if (currentMp >= neededMp) {
                        int lefMp = currentMp - neededMp;
                        heroMp.put(heroName, lefMp);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, nameSpell, lefMp);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, nameSpell);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(commandArray[2]);
                    String attacker = commandArray[3];
                    int currentHp = heroHp.get(heroName) - damage;
                    if (currentHp > 0) {
                        heroHp.put(heroName, currentHp);
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damage, attacker, currentHp);
                    } else {
                        System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                        heroHp.remove(heroName);
                        heroMp.remove(heroName);
                    }
                    break;
                case "Recharge":
                    int amount = Integer.parseInt(commandArray[2]);
                    int mpCurrent = heroMp.get(heroName);
                    int rechargedMp = mpCurrent + amount;
                    if (rechargedMp > 200) {
                        rechargedMp = 200;
                    }
                    heroMp.put(heroName, rechargedMp);
                    System.out.printf("%s recharged for %d MP!%n", heroName, rechargedMp - mpCurrent);
                    break;
                case "Heal":
                    int amountHp = Integer.parseInt(commandArray[2]);
                    int hpCurrent = heroHp.get(heroName);
                    int rechargedHp = hpCurrent + amountHp;
                    if (rechargedHp > 100) {
                        rechargedHp = 100;
                    }
                    heroHp.put(heroName, rechargedHp);
                    System.out.printf("%s healed for %d HP!%n", heroName, rechargedHp - hpCurrent);
                    break;
            }

            command = scanner.nextLine();
        }
        heroHp.entrySet().stream().sorted((hero1, hero2) -> Integer.compare(hero2.getValue(), hero1.getValue()))
                .forEach(hero -> {
                    String name = hero.getKey();
                    System.out.println(hero.getKey());
                    System.out.println("  HP: " + hero.getValue());
                    System.out.println("  MP: " + heroMp.get(name));
                });
    }
}
