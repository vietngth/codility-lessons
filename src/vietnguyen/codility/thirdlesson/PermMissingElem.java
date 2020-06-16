package vietnguyen.codility.thirdlesson;

public class PermMissingElem {
    // 1 + 2 + 3 + ... + n = n(n+1)/2
    // => 1 + 2 + 3 + ... + n + (n+1) = (n+1)(n+2)/2
    // PROBLEM: OVERFLOW INTEGER => LONG
    public static long generalSum(long N) {
        return ((N+1)*(N+2))/2;
    }

    public static int missingNumber(int[] A) {
        if (A == null) {
            return 0;
        }
        long N = A.length;
        long total = generalSum(N);
        long arraySum = 0;
        for (int i=0 ; i<A.length; i++) {
            arraySum += A[i];
        }
        return (int) (total - arraySum);
    }

    public static void main(String[] args) {
        int[] A = new int[300000];
        for (int i=0; i<300000; i++) {
            A[i] = i+1;
        }

        System.out.println(missingNumber(A));
    }
}
