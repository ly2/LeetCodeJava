public class minCostClimbingStairs746 {


    // use array
    public int minCostClimbingStairs2(int[] cost) {
        int[] arr = new int[cost.length];
        arr[0] = cost[0];
        arr[1] = cost[1];

        for(int i = 2; i < cost.length; i++) {
            arr[i] = Math.min(arr[i-2] , arr[i-1]) + cost[i];
        }
        return Math.min(arr[cost.length-2] , arr[cost.length-1]);

    }

    // just 2 integer to store the state.
    public int minCostClimbingStairs(int[] cost) {
        int f2 = cost[0];
        int f1 = cost[1];

        for(int i = 2; i < cost.length; i++) {
            int f0 = Math.min(f1,f2) + cost[i];
            f2 = f1;
            f1 = f0;

        }
        return Math.min(f1,f2);

    }
}
