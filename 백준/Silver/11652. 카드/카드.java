
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int n;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		HashMap<BigInteger, Integer> map = new HashMap<>();
		for(int i=0; i<n; i++) {
			BigInteger m = new BigInteger(br.readLine());
			map.put(m, map.getOrDefault(m, 0)+1);
		}
		List<Map.Entry<BigInteger,Integer>> list = new ArrayList<>(map.entrySet());
		list.sort(new Comparator<Map.Entry<BigInteger,Integer>>() {

			@Override
			public int compare(Entry<BigInteger, Integer> o1, Entry<BigInteger, Integer> o2) {
				if(o1.getValue().equals(o2.getValue())) {
					return o1.getKey().compareTo(o2.getKey());
				}
				else {
					return o2.getValue().compareTo(o1.getValue());
				}
			}
		});
		System.out.println(list.get(0).getKey());
		
	}

}
