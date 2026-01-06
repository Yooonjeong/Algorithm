import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static List<Character[]> list = new ArrayList<>();
    private static int[] startIdx = new int[4];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<4; i++) {
            String in = br.readLine();
            Character[] arr = new Character[8];
            for(int j=0; j<8; j++) {
                arr[j] = in.charAt(j);
            }
            list.add(arr);
        }

        int k = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int idx, dir;

        for (int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            idx = Integer.parseInt(st.nextToken());
            dir = Integer.parseInt(st.nextToken());

            spinAll(idx-1, dir);
        }

        System.out.println(calScore());
    }

    private static void spinAll(int idx, int dir) {
        int[] rotateDir = new int[4];
        rotateDir[idx] = dir;
        
        for (int cur = idx; cur > 0; cur--) {
            int left = cur - 1;
            int curIdx = (startIdx[cur] + 6) % 8;
            int leftIdx = (startIdx[left] + 2) % 8;

            if (list.get(cur)[curIdx] == list.get(left)[leftIdx]) break;

            rotateDir[left] = -rotateDir[cur];
        }

        for (int cur = idx; cur < 3; cur++) {
            int right = cur + 1;

            int curIdx = (startIdx[cur] + 2) % 8;
            int rightIdx = (startIdx[right] + 6) % 8;

            if (list.get(cur)[curIdx] == list.get(right)[rightIdx]) break;

            rotateDir[right] = -rotateDir[cur];
        }

        for (int i=0; i<4; i++) {
            spin(i, rotateDir[i]);
        }
    }

    private static void spin(int idx, int dir) {
        switch (dir) {
            case 1:
                startIdx[idx] = (startIdx[idx] + 7) % 8;
                break;
            case -1:
                startIdx[idx] = (startIdx[idx] + 1) % 8;
                break;
        }
    }

    private static int calScore() {
        int[] score = {1, 2, 4, 8};

        int sum = 0;
        for (int i=0; i<4; i++) {
            if (list.get(i)[startIdx[i]] == '1') {
                sum += score[i];
            }
        }
        return sum;
    }
}
