/**
 *
 * 已知数组A[0..n-1]和数组大小n（升序数组，元素值各不相同），若存在A[i]=i则称该数组有魔术索引，请判断该数组是否存在魔术索引，返回值为bool，要求复杂度优于o(n)。
 *
 * 测试样例：
 * [1,2,3,4,5]
 * 返回：false
 */

public class MagicIndex {

    /**
     * this method is still O(n)
     * @param A
     * @param n
     * @return
     */
//    public boolean findMagicIndex(int[] A, int n) {
//
//        if (n==0) return true;
//        for (int i = 0; i < n;i++) {
//            if (A[i] == i)
//                return true;
//            if (A[i]> i)
//                i = A[i];
//        }
//        return false;
//
//    }

    /**
     * this method is O(logn)
     * @param A
     * @param start
     * @param end
     * @return
     */
    private boolean isMagic(int[] A, int start, int end) {
        if (start >= end) return false;
        int mid = (start+end)/2;
        if (A[mid] == mid) return true;
        else if (A[mid] < mid) return isMagic(A, mid+1, end);
        else return isMagic(A, start,mid);
    }
    public boolean findMagicIndex(int[] A, int n) {
        if (n == 0) return true;
        else return isMagic(A, 0, n);
    }
}
