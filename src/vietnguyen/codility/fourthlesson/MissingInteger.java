package vietnguyen.codility.fourthlesson;

public class MissingInteger {
	public static int solution(int[] A) {
		int max = 0;
		// Find max value first: O(n)
		for (int i = 0; i < A.length; i++) {
			if (A[i] > max) {
				max = A[i];
			}
		}

		// In case array contains all negative numbers
		if (max == 0) {
			return 1;
		}

		boolean[] positiveIntegers = new boolean[max];
		// If value appears, set it as true: O(n)
		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0) {
				positiveIntegers[A[i] - 1] = true;
			}
		}

		// If a positive value is false, it means the missing integer: O(m)
		for (int i = 0; i < max; i++) {
			if (positiveIntegers[i] == false) {
				return (i + 1);
			}
		}

		// In case like (1,2,3) then return 4
		return (max + 1);
	}
}
