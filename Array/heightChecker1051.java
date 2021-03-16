import java.util.Arrays;

public class heightChecker1051 {

    public int heightChecker(int[] heights) {
        int[] new_Heights = heights.clone();
        Arrays.sort(new_Heights);
        int count = 0;
        for (int i = 0 ; i < heights.length; i++) {
            if (heights[i] != new_Heights[i])
                count++;
        }
        return count;
    }


    // use a new array to store the heights distribution.
    // Disguised Sort method as the heights >= 1 and <= 100
    public int heightChecker2(int[] heights) {
        int[] heightToFreq = new int[101];

        for (int height : heights) {
            heightToFreq[height]++;
        }

        int result = 0;
        int curHeight = 0;

        for (int i = 0; i < heights.length; i++) {
            while (heightToFreq[curHeight] == 0) {
                curHeight++;
            }

            if (curHeight != heights[i]) {
                result++;
            }
            heightToFreq[curHeight]--;
        }

        return result;
    }
}
