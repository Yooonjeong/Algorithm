
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		HashMap<String, Integer> map = new HashMap<>();
		int t, n;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<t; i++) {
			n = Integer.parseInt(br.readLine());
			map.clear();
			for(int j=0; j<n; j++) {
				String[] at = br.readLine().split(" ");
				map.put(at[1], map.getOrDefault(at[1],0)+1);
			}
			int answer = 1;
			for(Map.Entry<String, Integer> entry:map.entrySet()) {
				answer*=(entry.getValue()+1);
			}
			sb.append(answer-1).append("\n");
		}
		System.out.println(sb.toString());
	}

}
