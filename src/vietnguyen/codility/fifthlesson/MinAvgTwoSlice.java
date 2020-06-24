package vietnguyen.codility.fifthlesson;

/**
 * Basically, slice of 2 and slice of 3 are guarantee to form a minimal avg
 * For slice > 3, slices can be made up from slice of 2 and slice of 3
 * For that reason, only need to check slice of 2/ slice of 3 at each iteration
 */
public class MinAvgTwoSlice {
	public static int solution(int[] A) {
		double minVal = 1000000;
		int minPos = 0;
		for (int i = 0; i < A.length - 2; i++) {
			double sliceTwo = A[i] + A[i + 1];
			if (sliceTwo / 2 < minVal) {
				minVal = sliceTwo / 2;
				minPos = i;
			}

			double sliceThree = A[i] + A[i + 1] + A[i + 2];
			if (sliceThree / 3 < minVal) {
				minVal = sliceThree / 3;
				minPos = i;
			}
		}

		// last elements
		double sliceTwo = A[A.length - 2] + A[A.length - 1];
		if (sliceTwo / 2 < minVal) {
			minVal = sliceTwo / 2;
			minPos = A.length - 2;
		}

		return minPos;
	}

	public static void main(String[] args) {
		int[] arr = {-3, -5, -8, -4, -10};
		System.out.println(solution(arr));
	}
}
