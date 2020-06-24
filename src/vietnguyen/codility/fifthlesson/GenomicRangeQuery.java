package vietnguyen.codility.fifthlesson;

/**
 * S: [0][1][...][n-1]
 * N is an integer within the range [1..100,000];
 * M is an integer within the range [1..50,000];
 * each element of arrays P, Q is an integer within the range [0..N − 1];
 * P[K] ≤ Q[K], where 0 ≤ K < M;
 * string S consists only of upper-case English letters A, C, G, T - 1, 2, 3, 4.
 */
public class GenomicRangeQuery {
	public static int[] naiveSolution(String S, int[] P, int[] Q) {
		// Convert string to int array
		int stringSize = S.length();
		int[] dna = new int[stringSize];
		for (int i = 0; i < stringSize; i++) {
			switch (S.charAt(i)) {
				case 'A':
					dna[i] = 1;
					break;
				case 'C':
					dna[i] = 2;
					break;
				case 'G':
					dna[i] = 3;
					break;
				case 'T':
					dna[i] = 4;
					break;
				default:
					dna[i] = 0;
					break;
			}
		}

		//Prefix Array
		int[][] prefixArrays = new int[stringSize][stringSize];
		for (int i = 0; i < stringSize; i++) {
			int min = dna[i];
			for (int j = i; j < stringSize; j++) {
				if (min > dna[j]) {
					min = dna[j];
				}
				prefixArrays[i][j] = min;
			}
		}

		// Result array
		int resultSize = Q.length;
		int[] resultArray = new int[resultSize];
		for (int i = 0; i < resultSize; i++) {
			int pIndex = P[i];
			int qIndex = Q[i];
			resultArray[i] = prefixArrays[pIndex][qIndex];
		}
		return resultArray;
	}

	/**
	 * In the lesson, m slices of [x...y] with 0 <= x <= y <=n with sum = a_x, a_x+1, ... + a_y-1, a_y
	 * Formula of 1 slice: P[y+1] - P[x]
	 */
	public static int[] moreSufficientSolution(String S, int[] P, int[] Q) {
		int stringLength = S.length();
		int[][] genoms = new int[3][stringLength + 1];
		// genoms[n][0] = 0 with any integer n > 0
		for (int i = 0; i < stringLength; i++) {
			short a = 0, c = 0, g = 0;
			switch (S.charAt(i)) {
				case 'A':
					a = 1;
					break;
				case 'C':
					c = 1;
					break;
				case 'G':
					g = 1;
					break;
				default:
					break;
			}

			// calculate prefix sums
			genoms[0][i + 1] = genoms[0][i] + a;
			genoms[1][i + 1] = genoms[1][i] + c;
			genoms[2][i + 1] = genoms[2][i] + g;
		}

		int[] result = new int[P.length];
		for (int i = 0; i < P.length; i++) {
			// Apply formula of 1 slice
			int from = P[i];
			int to = Q[i] + 1;

			// A appears in the range
			if (genoms[0][to] - genoms[0][from] > 0) {
				result[i] = 1;
			} else if (genoms[1][to] - genoms[1][from] > 0) {
				result[i] = 2;
			} else if (genoms[2][to] - genoms[2][from] > 0) {
				result[i] = 3;
			} else {
				result[i] = 4;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String s = "A";
		int[] P = {0};
		int[] Q = {0};
		int[] result = moreSufficientSolution(s, P, Q);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
