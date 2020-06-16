package vietnguyen.codility.fourthlesson;

public class PermutationCheck {
	public static int solution(int A[]) {
		int max = 0;
		// Find the dynamic length
		for (int i = 0; i < A.length; i++) {
			// Permutation: 1 -> N AND N = 100000 at most
			if (A[i] > 100000 || A[i] < 1) {
				return 0;
			}
			if (A[i] > max) {
				max = A[i];
			}
		}

		if (max == 0) {
			return 0;
		}

		boolean[] isNumberExisted = new boolean[max];

		for (int i = 0; i < A.length; i++) {
			if (isNumberExisted[A[i] - 1] == false) {
				isNumberExisted[A[i] - 1] = true;
			} else {
				return 0;
			}
		}

		for (int i = 0; i < isNumberExisted.length; i++) {
			if (isNumberExisted[i] == false) {
				return 0;
			}
		}

		return 1;
	}
}
