package cisco;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class OddNum {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void oddNum() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Map<Integer,Integer> map = new HashMap<>();
		for(int i = 0; i<n; i++) {
			int t = sc.nextInt();
			map.put(t, map.getOrDefault(t,0)+1);
		}
		int count = 0;
		for(Entry<Integer,Integer> e : map.entrySet()) {
			if(e.getValue()%2==1) {
				count ++;
			}
		}
		System.out.print(count);
		sc.close();
		
	}
}
