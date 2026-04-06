import java.util.HashSet;
import java.util.Set;

public class PracticeProblem {

	public static void main(String[] args) {
		int n = 6;
		int[] seq = recaman(n);
		for (int i = 0; i < seq.length; i++) {
			System.out.print(seq[i] + (i == seq.length - 1 ? "" : ", "));
		}
		System.out.println();
	}

	public static int[] recaman(int n) {
		if (n <= 0) {
			return new int[0];
		}

		int[] result = new int[n];
		Set<Integer> seen = new HashSet<>();
		int currentVal = 1;
		result[0] = currentVal;
		seen.add(currentVal);

		for (int index = 2; index <= n; index++) {
			int candidate = currentVal - index;
			if (candidate <= 0 || seen.contains(candidate)) {
				candidate = currentVal + index;
			}
			currentVal = candidate;
			result[index - 1] = currentVal;
			seen.add(currentVal);
		}

		return result;
	}
}

