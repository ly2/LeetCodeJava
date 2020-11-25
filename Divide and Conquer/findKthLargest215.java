import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class findKthLargest215 {

    public int findKthLargest(int[] nums, int k) {

        Arrays.sort(nums);
        return nums[nums.length - k];

    }


    public int findKthLargest2(int[] nums, int k)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int ele : nums)
        {
            pq.add(ele);

            if(pq.size()>k)
            {
                pq.remove();
            }
        }

        return pq.peek();


    }
}
