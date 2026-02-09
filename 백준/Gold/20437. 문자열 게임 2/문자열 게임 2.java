import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<t; i++) {
            String in = br.readLine();
            int k = Integer.parseInt(br.readLine());

            sb.append(getLength(in, k)).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static String getLength(String str, int k) {
        int min = Integer.MAX_VALUE, max = -1;
        List<Integer>[] pos = new ArrayList[26];

        for (int i=0; i<26; i++) {
            pos[i] = new ArrayList<>();
        }

        for (int i=0; i<str.length(); i++) {
            pos[str.charAt(i) - 'a'].add(i);
        }

        for (int i=0; i<26; i++) {
            if (pos[i].size() < k) continue;

            for (int j=0; j+k-1 < pos[i].size(); j++) {
                int len = pos[i].get(j+k-1) - pos[i].get(j) + 1;
                min = Math.min(min, len);
                max = Math.max(max, len);
            }
        }

        return max == -1 ? "-1" : new String(min+" "+max);
    }
}