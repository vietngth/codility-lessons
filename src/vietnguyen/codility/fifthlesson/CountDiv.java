package vietnguyen.codility.fifthlesson;

public class CountDiv {
	public static int solution(int A, int B, int K) {
		// Numbers divisible by K from [1, B]
		int bDivK = (int) (B / K);

		// Numbers divisible by K from [1, A]
		int aDivK = (int) (A / K);

		// If A is divisible by K
		if (A % K == 0) {
			return bDivK - aDivK + 1;
		}

		return bDivK - aDivK;
	}
}
