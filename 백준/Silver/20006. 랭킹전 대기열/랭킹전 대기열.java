import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    private static class Room {
        boolean started;
        Map<String, Integer> players = new TreeMap<>();
        int initLevel;

        Room(String nickname, int level) {
            addPlayer(nickname, level);
            initLevel = level;
        }

        public void addPlayer(String nickname, int level) {
            players.put(nickname, level);
            if (players.size() >= m) started = true;
        }

        public boolean isFull() {
            return players.size() >= m;
        }

        public boolean isPossible(String nickname, int level) {
            if (isFull() || level < initLevel - 10 || level > initLevel + 10) return false;
            addPlayer(nickname, level);
            return true;
        }

        public void print(StringBuilder sb) {
            for (Map.Entry<String, Integer> player : players.entrySet()) {
                sb.append(player.getValue()+" "+player.getKey()).append("\n");
            }
        }
    }
    private static int p, m;
    private static List<Room> rooms = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i=0; i<p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String nickname = st.nextToken();

            boolean entranced = false;
            for (Room room : rooms) {
                if (room.isPossible(nickname, level)) {
                    entranced = true;
                    break;
                }
            }

            if (!entranced) {
                rooms.add(new Room(nickname, level));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Room room : rooms) {
            sb.append(room.started ? "Started!" : "Waiting!").append("\n");
            room.print(sb);
        }

        System.out.println(sb.toString());
    }
}