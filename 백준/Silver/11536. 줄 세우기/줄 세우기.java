import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();

        for (int i=0; i<n; i++) {
            list.add(br.readLine());
        }

        String answer = "NEITHER";
        boolean prev = list.get(0).compareTo(list.get(1)) < 0 ? true : false;
        for (int i=2; i<n; i++) {
            boolean cur = list.get(i-1).compareTo(list.get(i)) < 0 ? true : false;

            if (prev != cur) {
                System.out.println(answer);
                return;
            }
        }

        System.out.println(prev ? "INCREASING" : "DECREASING");
    }
}