import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    private static int[] sort = {
        10, 5, 9, 8, 3, 2, 7, 6, 1, 4
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        TreeSet<Integer> set = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int[] arr1 = getNum(o1);
                int[] arr2 = getNum(o2);

                int len = Math.min(arr1.length, arr2.length);

                for (int i=0; i<len; i++) {
                    if (arr1[i] != arr2[i]) {
                        return Integer.compare(arr1[i], arr2[i]);
                    }
                }

                return Integer.compare(arr1.length, arr2.length);
            }
        });

        for (int i=m; i<=n; i++) {
            set.add(i);
        }

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        while (!set.isEmpty()) {
            sb.append(set.pollFirst()).append(" ");
            cnt++;
            if (cnt % 10 == 0) sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static int[] getNum(int n) {
        String str = String.valueOf(n);
        int[] arr = new int[str.length()];

        for (int i=0; i<str.length(); i++) {
            char at = str.charAt(i);
            arr[i] = sort[at - '0'];
        }

        return arr;
    }
}