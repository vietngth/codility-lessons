package vietnguyen.codility.secondlesson;

public class ArrayRotation {
	public int[] solution(int[] A, int K) {
		int size = A.length;
		// any size = K just rotates as the same position
		if (size == K) {
			return A;
		}

		// any size = K would make the array the same => just minus redundant rotations
		while (K > size) {
			K = K - size;
		}

		int[] B = new int[size];
		int j = 0;
		for (int i = K; i < size; i++) {
			B[i] = A[j++];
		}

		for (int i = 0; i < K; i++) {
			B[i] = A[j++];
		}
		return B;
	}
}

