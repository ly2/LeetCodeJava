import java.util.*;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * Note:
 *
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */


public class Triangle120 {

    /**
     *  use dp, which from top to bottom, but more extra spaces
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] paths = new int[1];
        paths[0] = triangle.get(0).get(0);
        if (triangle.size() ==1)
            return paths[0];
        for (int i = 1; i < triangle.size();i++) {
            // len of row is i+1
            int[] tmp = paths.clone();
            paths = new int[i+1];
            paths[0] = triangle.get(i).get(0)+tmp[0];
            paths[i] = triangle.get(i).get(triangle.get(i).size()-1)+tmp[i-1];
            for (int j = 1; j < triangle.get(i).size()-1; j++) {
                paths[j] = triangle.get(i).get(j)+Math.min(tmp[j-1],tmp[j]);
            }
        }
        int min = paths[0];
        for (int n: paths) {
            if ( min > n)
                min = n;
        }

        return min;
    }


    /**
     *  use dp, but from bottom to top
     * @param triangle
     * @return
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle.size() ==1)
            return triangle.get(0).get(0);
        int len = triangle.size();
        int[] sum = new int[len];
        for  (int i = 0; i < triangle.get(len-1).size(); i++) {
            sum[i] = triangle.get(len-1).get(i);
        }

        for (int j = len-2; j >= 0; j--) {
            for (int k = 0; k < triangle.get(j).size(); k++) {
                sum[k] = Math.min(sum[k], sum[k+1]) + triangle.get(j).get(k);
            }
        }

        return sum[0];
    }




    //    Time Limit Exceeded
//    public int minimumTotal(List<List<Integer>> triangle) {
//        if (triangle.isEmpty())
//            return 0;
//        int origi = triangle.get(0).get(0);
//        if (triangle.size() <2) {
//            return origi;
//        }
//        return origi + Math.min(path(triangle, 1, 0), path(triangle, 1,1));
//    }
//
//    private int path(List<List<Integer>> triangle, int row, int index) {
//        if (row>= triangle.size())
//            return 0;
//        return triangle.get(row).get(index) + Math.min(path(triangle, row+1, index), path(triangle, row+1, index+1));
//    }

}
