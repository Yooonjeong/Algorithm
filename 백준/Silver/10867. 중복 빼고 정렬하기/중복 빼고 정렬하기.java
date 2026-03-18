import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        TreeSet<Integer> set = new TreeSet<>();
        for (int i=0; i<n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        Iterator<Integer> iter = set.iterator();

        StringBuilder sb = new StringBuilder();
        while (iter.hasNext()) {
            sb.append(iter.next()).append(" "); 
        }

        System.out.println(sb.toString());
    }
}