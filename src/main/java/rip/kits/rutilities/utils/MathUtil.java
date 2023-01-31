package rip.kits.rutilities.utils;

public class MathUtil {
    /**
     *
     * @param input
     * @param min
     * @param max
     * @return
     */
    public static Boolean isBetween(Integer input, Integer min, Integer max) {
        return input >= min && input <= max;
    }

    /**
     *
     * @param input
     * @return
     */
    public static int convertToPositive(int input) {
        if (input > 0) {
            return input;
        }
        return Math.abs(input);
    }

    /**
     *
     * @param input
     * @return
     */
    public static double sigmoid(double input) {
        return 1.0 / (1.0 + Math.exp(-input));
    }

    /**
     *
     * @param first
     * @param second
     * @param separator
     */
    public static boolean isEqual(double first, double second, double separator) {
        return Math.abs(first - second) < separator; // 0.001, 0.125, 0.35
    }
}
