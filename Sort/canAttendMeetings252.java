import java.util.Arrays;
import java.util.Comparator;

public class canAttendMeetings252 {



    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length < 2)
            return true;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i-1][1])
                return false;
        }
        return true;
    }

    // official
    public boolean canAttendMeetings1(int[][] intervals) {
        // 这个排序方法会快一秒左右！
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        //
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }

    //2 ms	38.7 MB
    public boolean canAttendMeetings2(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        for (int i=0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        for (int i=0; i < intervals.length - 1; i++) {
            if (start[i+1] < end[i]) {
                return false;
            }
        }

        return true;
    }
}
