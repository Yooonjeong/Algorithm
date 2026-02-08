import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static int r, c, k;
    private static int[][] arr = new int[100][100];
    private static HashMap<Integer, Integer> map = new HashMap<>();
    private static int minTime = -1;
    private static int rowCnt = 3, colCnt = 3;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while (time <= 100) {
            if (arr[r-1][c-1] == k) {
                minTime = time;
                break;
            }

            if (rowCnt >= colCnt) rCalc();
            else cCalc();

            time++;
        }

        System.out.println(minTime);
    }

    private static void rCalc() {
        // 개수 세기
        // 정렬 -> 최대 50개 cut
        // arr에 정렬된 거 넣기
        List<Map.Entry<Integer, Integer>> list;
        int newColCnt = 0;

        for (int i=0; i<rowCnt; i++) {
            map.clear();
            for (int j=0; j<colCnt; j++) {
                if (arr[i][j] == 0) continue;
                map.put(arr[i][j], map.getOrDefault(arr[i][j], 0)+1);
            }

            list = sortMap();
            
            int idx = 0, j=0;
            for (j=0, idx=0; idx<Math.min(50, list.size()); j+=2, idx++) {
                arr[i][j] = list.get(idx).getKey();
                arr[i][j+1] = list.get(idx).getValue();
            }

            newColCnt = Math.max(newColCnt, j);

            for (; j<100; j++) {
                arr[i][j] = 0;
            }
        }

        colCnt = newColCnt;
    }

    private static void cCalc() {
        List<Map.Entry<Integer, Integer>> list;
        int newRowCnt = 0;

        for (int i=0; i<colCnt; i++) {
            map.clear();
            for (int j=0; j<rowCnt; j++) {
                if (arr[j][i] == 0) continue;
                map.put(arr[j][i], map.getOrDefault(arr[j][i], 0)+1);
            }

            list = sortMap();
            
            int idx = 0, j=0;
            for (j=0, idx=0; idx<Math.min(50, list.size()); j+=2, idx++) {
                arr[j][i] = list.get(idx).getKey();
                arr[j+1][i] = list.get(idx).getValue();
            }

            newRowCnt = Math.max(newRowCnt, j);

            for (; j<100; j++) {
                arr[j][i] = 0;
            }
        }

        rowCnt = newRowCnt;
    }

    private static List<Map.Entry<Integer, Integer>> sortMap() {
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getValue() == o2.getValue()) {
                    return o1.getKey() - o2.getKey();
                }
                return o1.getValue() - o2.getValue();
            }
        });

        return list;
    }

}