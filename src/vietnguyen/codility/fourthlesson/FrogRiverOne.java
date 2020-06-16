package vietnguyen.codility.fourthlesson;

public class FrogRiverOne {
	/**
	 * Problem: O(N) complexity o-o
	 * Solution: boolean array B that has X elemnents
	 * Input array A. if B[A[i]-1] == false , set it to true
	 * Key: A[i] is always >=1 and <=X, so B[A[i]-1] would never get index out-of-bound
	 */
	public static int frogRiverOne(int X, int A[]) {
		boolean[] leaves = new boolean[X];
		int uncoveredAreas = X;
		for (int i = 0; i < A.length; i++) {
			if (leaves[A[i] - 1] == false) {
				leaves[A[i] - 1] = true;
				uncoveredAreas--;
				if (uncoveredAreas == 0) {
					return i;
				}
			}
		}
		return -1;
	}
}
