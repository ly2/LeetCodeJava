import java.util.Deque;

class MovingAverage {

    private int[] nums;
    private double sum;
    private int idx;
    private int count;
    private int size;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.nums = new int[size];
        this.sum = 0;
        this.count = 0;
        this.idx = 0;
        this.size = size;
    }

    public double next(int val) {
        if (count < size) {
            nums[idx++] = val;
            sum += val;
            count++;
        } else {
            idx %= size;
            sum = sum + val - nums[idx];
            nums[idx++] = val;
        }
        return sum/count;
    }


    // general method
//    Deque<Integer> queue;
//    int size;
//    double sum;
//    /** Initialize your data structure here. */
//    public MovingAverage(int size) {
//        this.queue=new ArrayDeque<>();
//        this.size=size;
//    }
//
//    public double next(int val) {
//        queue.add(val);
//        sum+=val;
//        if(queue.size()>size) sum-= queue.poll();
//        return (double)sum/(double) queue.size();
//    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */