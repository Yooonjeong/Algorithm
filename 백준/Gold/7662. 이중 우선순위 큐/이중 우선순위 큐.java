import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int t, k, num, key, value;
        char order;

        t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++){
            k = Integer.parseInt(br.readLine());
            treeMap.clear();
            for(int j=0; j<k; j++){
                st = new StringTokenizer(br.readLine());
                order = st.nextToken().charAt(0);
                num = Integer.parseInt(st.nextToken());

                switch(order){
                case 'I':
                    treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
                    break;
                case 'D':
                    if(num == 1 && !treeMap.isEmpty()){
                        key = treeMap.lastEntry().getKey();
                        value = treeMap.lastEntry().getValue();
                        if(value > 1){
                            treeMap.replace(key, value - 1);
                        }
                        else{
                            treeMap.pollLastEntry();
                        }
                    }
                    else if(!treeMap.isEmpty()){
                        key = treeMap.firstEntry().getKey();
                        value = treeMap.firstEntry().getValue();
                        if(value > 1){
                            treeMap.replace(key, value - 1);
                        }
                        else{
                            treeMap.pollFirstEntry();
                        }
                    }
                    break;
                }
            }
            if(treeMap.isEmpty()) sb.append("EMPTY\n");
            else sb.append(treeMap.lastEntry().getKey() + " " + treeMap.firstEntry().getKey()).append("\n");
        }
        System.out.println(sb.toString());
    }
}
