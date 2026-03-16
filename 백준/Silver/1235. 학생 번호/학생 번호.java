import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    private static int n, len;
    private static List<String> studentIdList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        studentIdList = new ArrayList<>();
        for (int i=0; i<n; i++) {
            studentIdList.add(br.readLine());
        }

        len = studentIdList.get(0).length();
        int l = 1;
        int r = len;
        int mid;
        int ans = len;

        while (l <= r) {
            mid = (l + r) / 2;

            if (isPossible(mid)) {
                r = mid-1;
                ans = r;
            }
            else {
                l = mid+1;
            }
        }

        System.out.println(ans);
    }

    private static boolean isPossible(int k) {
        Set<String> set = new HashSet<>();

        for (String str : studentIdList) {
            String substring = str.substring(len-k+1);
            if (set.contains(substring)) return false;
            set.add(substring);
        }

        return true;
    }
}