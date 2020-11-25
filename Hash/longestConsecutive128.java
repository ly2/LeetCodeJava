import java.util.HashSet;
import java.util.Set;

public class longestConsecutive128 {

    public int longestConsecutive(int[] nums) {

        if (nums.length == 0)
            return 0;

        Set<Integer> set = new HashSet<>();
        for (int n: nums)
            set.add(n);

        int longest = 0;
        int currentStreak = 1;
        for (int n: nums) {
            if (!set.contains(n-1)) {

                int current = n;
                while (set.contains(current+1)) {
                    current++;
                    currentStreak++;
                }
                longest = Math.max(currentStreak, longest);

                currentStreak = 1;

            }
        }

        return Math.max(currentStreak, longest);
    }
}
