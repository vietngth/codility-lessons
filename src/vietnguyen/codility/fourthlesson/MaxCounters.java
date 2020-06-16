package vietnguyen.codility.fourthlesson;

/**
 * My own rocket solution: introduce "base" value
 * If a[i] > N, set base = max
 * If a[i] <= N:
 * If a[i] > base: a[i]++;
 * Else a[i] = base + 1;
 * After finishing the loop, create another loop in the same level,
 * set all a[i] < base to base value!
 * Complexity: O(N (input array (A) length ) + M (smaller array with size of input X)) ~  O(n)
 */
public class MaxCounters {
	public static int[] naiveIncreaseMaxCounter(int[] countingArray, int max) {
		for (int i = 0; i < countingArray.length; i++) {
			countingArray[i] = max;
		}
		return countingArray;
	}

	public static int[] naiveSolution(int[] A, int N) {
		int[] countingArray = new int[N];
		int max = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] < 1) {
				throw new IllegalArgumentException("Something happened");
			}

			if (A[i] >= 1 && A[i] <= N) {
				countingArray[A[i] - 1]++;
				max = findMax(max, countingArray[A[i] - 1]);
			} else {
				naiveIncreaseMaxCounter(countingArray, max);
			}
		}
		return countingArray;
	}

	public static int findMax(int first, int second) {
		if (first >= second) {
			return first;
		}
		return second;
	}

	public static int[] lewdSolution(int[] A, int N) {
		int[] countingArray = new int[N];
		int max = 0;
		int base = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] < 1) {
				throw new IllegalArgumentException("Exception");
			}

			if (A[i] >= 1 && A[i] <= N) {
				if (countingArray[A[i] - 1] < base) {
					countingArray[A[i] - 1] = base + 1;
				} else {
					countingArray[A[i] - 1]++;
				}
				max = findMax(max, countingArray[A[i] - 1]);
			} else {
				base = max;
			}
		}

		// rocket science
		for (int i = 0; i < N; i++) {
			if (countingArray[i] < base) {
				countingArray[i] = base;
			}
		}

		return countingArray;
	}

	public static void main(String[] args) {
		int[] A = {3, 4, 4, 6, 1, 4, 4};
		int[] AA = {3, 4, 4, 6, 1, 4, 4, 1, 2, 3, 8, 1, 2};
		int[] B = lewdSolution(AA, 5);
		for (int i = 0; i < B.length; i++) {
			System.out.print(B[i] + " ");
		}
	}
}
