package vietnguyen.codility.thirdlesson;

/**
 * Problem: complexity -> use separate for loop to make the complexity O(N) instead of O(N^2)
 */
public class TapeEquilibrium {
	public static long sum(int[] arr) {
		long sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}

	public static long min(long first, long second) {
		if (first < second) {
			return first;
		} else {
			return second;
		}
	}

	public static int solution(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}

		long leftSum = 0;
		long rightSum = 0;

		// initial state: calculate rightSum from P=1
		for (int i = 1; i < arr.length; i++) {
			rightSum += arr[i];
		}
		leftSum = arr[0];
		long min = Math.abs(rightSum - leftSum);

		// start looping to add element to left sum one by one
		for (int i = 1; i < arr.length - 1; i++) {
			leftSum += arr[i];
			rightSum -= arr[i];
			long newTape = Math.abs(rightSum - leftSum);
			min = min(min, newTape);
		}
		return (int) min;
	}

	public static void main(String[] args) {
		int[] arr = {3, 1, 2, 4, 3};
		System.out.println(solution(arr));
	}
}
