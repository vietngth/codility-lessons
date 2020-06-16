package vietnguyen.codility.thirdlesson;

import  java.lang.Math;

public class FrogJump {
    /**
     * Basically, it's just pure mathematics, nothing is special
     * @param X initial position
     * @param Y destination
     * @param D fixed leap
     * @return
     */
    public static int frogJump(int X, int Y, int D) {
        double XX = X;
        double YY = Y;
        double DD = D;
        if (D == 0) {
            return 0;
        }

        return (int) Math.ceil((YY-XX)/DD);
    }

    public static void main(String[] args) {
        System.out.println(frogJump(0, 1000000000, 20));
    }
}
