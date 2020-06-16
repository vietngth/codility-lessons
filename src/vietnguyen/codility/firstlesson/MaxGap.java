package vietnguyen.codility.firstlesson;

import java.util.ArrayList;
import java.util.List;

public class MaxGap {
    public List<Integer> getBinaryNumber(int number) {
        List<Integer> binaryNumber = new ArrayList<>();
        while (number/2 != 0) {
            binaryNumber.add(number%2);
            number = number / 2;
            if (number == 1) {
                binaryNumber.add(1);
            }
        }
        return binaryNumber;
    }

    public int maxNumber (int first, int second) {
        if (first >= second) {
            return first;
        } else {
            return second;
        }
    }

    public int maxGap(int number) {
        List<Integer> list = getBinaryNumber(number);
        int count = 0;
        int maxGap = 0;
        for (int i=list.size()-1; i>=0; i--) {
            if (list.get(i) == 1) {
                maxGap = maxNumber(maxGap, count);
                count = 0;
            } else {
                count++;
            }
        }
        return maxGap;
    }
}
