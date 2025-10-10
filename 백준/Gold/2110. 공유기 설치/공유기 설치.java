import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    private static TreeSet<Integer> treeSet = new TreeSet<>();
    private static List<Integer> house;
    private static int n, c, ans;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++) {
            treeSet.add(Integer.parseInt(br.readLine()));
        }
        house = new ArrayList<>(treeSet);
        
        parametricSearch();

        System.out.println(ans);
    }
    
    private static void parametricSearch() {
        int left = 1;
        int right = house.get(n-1) - house.get(0);
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;

            if (canInstall(mid)) {
                left = mid + 1;
                ans = mid;
            }
            else {
                right = mid - 1;
            }
        }
    }
    
    private static boolean canInstall(int dist) {
        int cnt = 1;
        int lastInstalled = house.get(0);

        for (int i=1; i<n; i++) {
            if (house.get(i) - lastInstalled >= dist) {
                cnt++;
                lastInstalled = house.get(i);
            }
        }
        return cnt >= c;
    }
}
