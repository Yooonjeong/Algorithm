import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Team {
        int num;
        int pos;

        Team(int num, int pos) {
            this.num = num;
            this.pos = pos;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int r, c;
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        List<Team> teams = new ArrayList<>();

        for (int i=0; i<r; i++) {
            String in = br.readLine();

            for (int j=c-2; j>0; j--) {
                char at = in.charAt(j);
                if (at >= '1' && at <= '9') {
                    teams.add(new Team(at-'0', j));
                    break;
                }
            }
        }

        teams.sort((a, b) -> b.pos - a.pos);

        int[] answer = new int[10];
        int rank = 1;
        int prevPos = teams.get(0).pos;
        answer[teams.get(0).num] = rank;

        for (int i=1; i<teams.size(); i++) {
            Team cur = teams.get(i);

            if (cur.pos != prevPos) rank++;

            answer[cur.num] = rank;
            prevPos = cur.pos;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=9; i++) {
            sb.append(answer[i]).append("\n");
        }

        System.out.println(sb.toString());
    }
}