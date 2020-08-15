package cisco;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MeanAndMode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(mode());
		System.out.println(mode1());
	}

	public static double mean(double[] m) {
		double sum = 0;
		for (int i = 0; i < m.length; i++) {
			sum += m[i];
		}
		return sum / m.length;
	}

	public static double median(double[] m) {
		int middle = m.length / 2;
		if (m.length % 2 == 1) {
			return m[middle];
		} else {
			return (m[middle - 1] + m[middle]) / 2.0;
		}
	}

	static int N = 20;

	static int[] sequence = new int[] {4,7,1,3,7,7,7};

	public static int mode() {
		int maxValue = 0, maxCount = 0;
		for (int i = 0; i < sequence.length; ++i) {
			int count = 0;
			for (int j = 0; j < sequence.length; ++j) {
				if (sequence[j] == sequence[i])
					++count;
			}
			if (count > maxCount) {
				maxCount = count;
				maxValue = sequence[i];
			}
		}
		return maxValue;
	}
	
	public static int mode1() {
		int maxValue=0, maxCount=0;
		Map<Integer,Integer> map = new HashMap<>();
		
		for(int i:sequence) {
			map.put(i, map.getOrDefault(i, 0)+1);
		}
		for(Entry<Integer,Integer> e : map.entrySet()) {
			if(e.getValue()>maxCount) {
				maxCount = e.getValue();
				maxValue=e.getKey();
			}			
		}
		return maxValue;
	}

}
