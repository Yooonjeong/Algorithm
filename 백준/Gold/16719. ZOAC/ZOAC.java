import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static String in;
    private static boolean[] visited;
    private static StringBuilder ans = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        in = br.readLine();
        visited = new boolean[in.length()];

        split(0, in.length()-1);
        System.out.println(ans.toString());
    }

    private static void split(int start, int end) {
        if (end < start) return;

        int mid = start;
        for (int i=start; i<=end; i++) {
            if (in.charAt(mid) > in.charAt(i)) {
                mid = i;
            }
        }
        visited[mid] = true;
        print();

        split(mid+1, end);
        split(start, mid-1);
    }
    private static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<in.length(); i++) {
            if (visited[i]) sb.append(in.charAt(i));
        }
        ans.append(sb).append("\n");
    }
}
