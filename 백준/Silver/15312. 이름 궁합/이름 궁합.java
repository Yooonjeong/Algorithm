import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    private static int[] arr = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        ArrayDeque<Integer> cur = new ArrayDeque<>();
        ArrayDeque<Integer> next = new ArrayDeque<>();

        for (int i=0; i<a.length(); i++) {
            cur.addLast(arr[a.charAt(i)-'A']);
            cur.addLast(arr[b.charAt(i)-'A']);
        }

        while (cur.size() > 2) {
            int fst = cur.poll();
            while (!cur.isEmpty()) {
                int sec = cur.poll();
                next.addLast((fst+sec)%10);
                fst = sec;
            }
            cur.addAll(next);
            next.clear();
        }

        System.out.println(String.valueOf(cur.poll())+String.valueOf(cur.poll()));
    }
}
