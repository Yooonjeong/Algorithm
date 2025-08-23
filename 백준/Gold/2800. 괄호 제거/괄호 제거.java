import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    private static String in;
    private static boolean[] visited;
    private static List<int[]> brackets;
    private static Set<String> resultSet;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        in = br.readLine();
        ArrayDeque<Integer> open = new ArrayDeque<>();
        brackets = new ArrayList<>();
        resultSet = new HashSet<>();

        for(int i=0; i<in.length(); i++){
            char at = in.charAt(i);
            if(at == '(') open.push(i);
            else if(at == ')') brackets.add(new int[]{open.pop(), i});
        }

        visited = new boolean[brackets.size()];
        generateCombinations(0);

        List<String> sortedList = new ArrayList<>(resultSet);
        Collections.sort(sortedList);

        StringBuilder sb = new StringBuilder();
        for(String s : sortedList){
            sb.append(s).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void generateCombinations(int index){
        if(index == brackets.size()){
            boolean removed = false;
            for(boolean v : visited){
                if(v){
                    removed = true;
                    break;
                }
            }
            if(!removed) return;
            
            boolean[] toRemove = new boolean[in.length()];
            for(int i=0; i<brackets.size(); i++){
                if(visited[i]){
                    int[] pair = brackets.get(i);
                    toRemove[pair[0]] = true;
                    toRemove[pair[1]] = true;
                }
            }

            StringBuilder sb = new StringBuilder();
            for(int i=0; i<in.length(); i++){
                if(!toRemove[i]) sb.append(in.charAt(i));
            }
            resultSet.add(sb.toString());
            return;
        }
        visited[index] = true;
        generateCombinations(index + 1);
        visited[index] = false;
        generateCombinations(index + 1);
    }
}
