package code.linkedin;

/**
 * For \textrm{num} > 2num>2 the square root aa is always less than \textrm{num} / 2num/2 and greater than 1: 1 < x < \textrm{num} / 21<x<num/2. Since xx is an integer, the problem goes down to the search in the sorted set of integer numbers. Binary search is a standard way to proceed in such a situation.
 *
 * Algorithm
 *
 * If num < 2, return True.
 *
 * Set the left boundary to 2, and the right boundary to num / 2.
 *
 * While left <= right:
 *
 * Take x = (left + right) / 2 as a guess. Compute guess_squared = x * x and compare it with num:
 *
 * If guess_squared == num, then the perfect square is right here, return True.
 *
 * If guess_squared > num, move the right boundary right = x - 1.
 *
 * Otherwise, move the left boundary left = x + 1.
 *
 * If we're here, the number is not a prefect square. Return False.
 */
public class ValidPerfectSqaure {

    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }

        long left = 2, right = num / 2, x, guessSquared;
        while (left <= right) {
            x = left + (right - left) / 2;
            guessSquared = x * x;
            if (guessSquared == num) {
                return true;
            }
            if (guessSquared > num) {
                right = x - 1;
            } else {
                left = x + 1;
            }
        }
        return false;
    }
}
