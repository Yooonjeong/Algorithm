import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static int l, c;
    private static String[] arr;
    private static StringBuilder ans = new StringBuilder();
    static final Set<Character> vowels = Set.of('a','e','i','o','u');
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = br.readLine().split(" ");
        Arrays.sort(arr);

        dfs(0, 0, new StringBuilder());
        System.out.println(ans.toString());
    }

    private static void dfs(int idx, int depth, StringBuilder cur) {
        if (depth == l) {
            if (isValid(cur.toString())) {
                ans.append(cur).append("\n");
            }
        }
        for (int i=idx; i<c; i++) {
            int len = cur.length();
            cur.append(arr[i]);
            dfs(i+1, depth+1, cur);
            cur.setLength(len);
        }
    }

    private static boolean isValid(String str) {
        int vowel = 0;
        int consonant = 0;

        for (char c : str.toCharArray()) {
            if (vowels.contains(c)) vowel++;
            else consonant++;
        }
        return vowel >= 1 && consonant >= 2;
    }
}
