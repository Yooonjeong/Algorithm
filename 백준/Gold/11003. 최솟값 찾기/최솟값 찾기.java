import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int value;
        int index;

        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n, l;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Deque<Node> deque = new ArrayDeque<>();

        for (int i=1; i<=n; i++) {
            int in = Integer.parseInt(st.nextToken());

            while(!deque.isEmpty() && deque.peekLast().value > in) {
                deque.pollLast();
            }

            deque.addLast(new Node(in, i));

            if (deque.peekFirst().index <= i-l) {
                deque.pollFirst();
            }

            sb.append(deque.peekFirst().value).append(" ");
        }
        System.out.println(sb.toString());
    }
}
