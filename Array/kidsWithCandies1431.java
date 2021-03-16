import java.util.ArrayList;
import java.util.List;

public class kidsWithCandies1431 {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max_candy = Integer.MIN_VALUE;
        for (int cand : candies) {
            if (cand > max_candy)
                max_candy = cand;
        }
        List<Boolean> list = new ArrayList<>();
        for (int cand : candies) {
            if (cand+extraCandies >= max_candy)
                list.add(true);
            else
                list.add(false);
        }
        return list;
    }
}
