import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    // 패턴 P에 대한 LPS 배열(부분 일치 테이블) 만들기
    private static int[] buildLps(char[] p) {
        int m = p.length;
        int[] lps = new int[m];
        int j = 0; // 현재까지 일치한 접두사 길이

        for (int i = 1; i < m; i++) {
            // 앞에서 일치하던 것들 중, 현재 문자와 맞는 가장 긴 접두사 길이로 줄여가며 탐색
            while (j > 0 && p[i] != p[j]) {
                j = lps[j - 1];
            }
            if (p[i] == p[j]) {
                j++;
                lps[i] = j;
            }
        }
        return lps;
    }

    private static boolean kmp(char[] s, char[] p) {
        int n = s.length;
        int m = p.length;
        int[] lps = buildLps(p);
        int j = 0; // 패턴 인덱스

        for (int i = 0; i < n; i++) {
            // 불일치하면 lps를 이용해 패턴 쪽 인덱스 점프
            while (j > 0 && s[i] != p[j]) {
                j = lps[j - 1];
            }

            if (s[i] == p[j]) {
                if (j == m - 1) {
                    // 패턴 전체 일치
                    return true;
                } else {
                    j++;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String P = br.readLine();

        char[] sArr = S.toCharArray();
        char[] pArr = P.toCharArray();

        System.out.println(kmp(sArr, pArr) ? 1 : 0);
    }
}
