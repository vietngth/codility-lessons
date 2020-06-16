package vietnguyen.codility.secondlesson;

public class OddOccurence {
    int findOddOccurance(int [] array) {
        int size = array.length;
        // XOR operation is AWESOME
        // ANY NUMBER XOR 0 = EXACT THAT NUMBER
        // X^X = 1, X^0 = 0 => all same values will make the result 0
        int result = 0;
        for (int i=0; i<size; i++) {
            result ^= array[i];
        }

        return result;
    }
}
