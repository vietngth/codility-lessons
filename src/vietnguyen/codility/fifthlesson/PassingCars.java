package vietnguyen.codility.fifthlesson;

public class PassingCars {
	public static int solution(int[] A) {
		int travelingEast = 0;
		int passing = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 0) {
				travelingEast++;
			} else {
				if (A[i] > 0) {
					passing += 1 * travelingEast;
				}
				if (passing > 1000000000 || passing < 0) {
					return -1;
				}
			}
		}
		return passing;
	}
}
