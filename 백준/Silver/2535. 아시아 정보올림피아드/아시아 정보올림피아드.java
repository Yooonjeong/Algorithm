import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    private static class Student {
        int country;
        int number;
        int score;

        Student(int country, int number, int score) {
            this.country = country;
            this.number = number;
            this.score = score;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        TreeSet<Student> set = new TreeSet<>((a, b) -> Integer.compare(b.score, a.score));

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            set.add(new Student(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (cnt >= 3) break;

            Student student = set.pollFirst();
            if (map.getOrDefault(student.country, 0) >= 2) continue;

            sb.append(student.country+" "+student.number).append("\n");
            map.put(student.country, map.getOrDefault(student.country, 0)+1);
            cnt++;
        }

        System.out.println(sb.toString());
    }
}