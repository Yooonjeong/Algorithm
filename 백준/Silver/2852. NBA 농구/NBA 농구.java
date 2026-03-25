import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] score = new int[3];
        int[] minutes = new int[3];

        StringTokenizer st;
        int prev = 0;
        int target = 0;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            int team = Integer.parseInt(st.nextToken());
            int cur = parseTime(st.nextToken());
            target = score[1] == score[2] ? 0 : score[1] > score[2] ? 1 : 2;
            minutes[target] += cur - prev;
            score[team]++;
            prev = cur;
        }
        target = score[1] == score[2] ? 0 : score[1] > score[2] ? 1 : 2;
        minutes[target] += parseTime("48:00") - prev;

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=2; i++) {
            sb.append(formatTime(minutes[i])).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static int parseTime(String time) {
        String[] arr = time.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }

    private static String formatTime(int minute) {
        return String.format("%02d:%02d", minute/60, minute%60);
    }
}