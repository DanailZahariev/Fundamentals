import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Song {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Songs> song = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("_");
            String type = tokens[0];
            String name = tokens[1];
            String time = tokens[2];
            Songs songs = new Songs(type, name,time);
            song.add(songs);
        }
        String type = scanner.nextLine();
        if ("all".equals(type)){
            for (Songs songs : song) {
                System.out.println(songs);
            }
        } else {
            for (Songs songs : song) {
                if (songs.getType().equals(type)){
                    System.out.println(songs);
                }
            }
        }
    }
    public static class Songs{
        private String type;
        private String name;
        private String time;

        public Songs(String type, String name, String time) {
            this.type = type;
            this.name = name;
            this.time = time;
        }

        public String getType() {
            return type;
        }

        public String toString() {
            return this.name;
        }
    }
}
