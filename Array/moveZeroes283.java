import java.util.*;

public class moveZeroes283 {


    //4 ms	38.7 MB
    public void moveZeroes2(int[] nums) {
        Queue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < nums.length;i++) {
            if (nums[i] == 0) {
                queue.offer(i);
                continue;
            }
            if (!queue.isEmpty()) {
                nums[queue.poll()] = nums[i];
                nums[i] = 0;
                queue.offer(i);
            }
        }
    }

    //1 ms	39.3 MB
    public void moveZeroes1(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length;i++) {
            if (nums[i] == 0) {
                list.add(i);
                continue;
            }
            if (!list.isEmpty()) {
                nums[list.remove(0)] = nums[i];
                nums[i] = 0;
                list.add(i);
            }
        }
    }


    //0 ms	39 MB
    public void moveZeroes(int[] nums) {
        int k = 0, c = 0;
        for (int i = 0; i < nums.length;i++) {
            if (nums[i] != 0) {
                nums[k] = nums[i];
                k++;
            } else {
                c++;
            }
        }
        for (int i = nums.length-1; i >= nums.length-c;i--) {
            nums[i] = 0;
        }

    }

}
