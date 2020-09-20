
/*
Given an array of integers A, a move consists of choosing any A[i], and incrementing it by 1.

        Return the least number of moves to make every value in A unique.
*/


public class MinimumIncrementtoMakeArrayUnique945 {
    public int minIncrementForUnique(int[] A) {

        //official solution 1 : brute force
        int[] count = new int[100000];
        for (int x: A) count[x]++;

        int ans = 0, taken = 0;

        for (int x = 0; x < 100000; ++x) {
            if (count[x] >= 2) {
                taken += count[x] - 1;
                ans -= x * (count[x] - 1);
            }
            else if (taken > 0 && count[x] == 0) {
                taken--;
                ans += x;
            }
        }

        return ans;

    }

}
