import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *Given an integer rowIndex, return the rowIndexth row of the Pascal's triangle.
 *
 * Notice that the row index starts from 0.
 *
 *In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Follow up:
 *
 * Could you optimize your algorithm to use only O(k) extra space?
 */

public class PascalsTriangleII119 {
    /**
     * 0ms
     * 38.5 MB
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex==0) {
            Integer[] r = new Integer[]{1};
            return Arrays.asList(r);
        }
        if (rowIndex==1) {
            Integer[] r = new Integer[]{1,1};
            return Arrays.asList(r);
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        int n;
        if ((rowIndex+1)%2 == 0)
            n = (rowIndex+1)/2;
        else
            n = (rowIndex+1)/2+1;
        for (int i = 0; i< n; i++) {
            long l = 1;
            for (int j = 1; j <= i; j++ ) {
                l = l*(rowIndex-j+1)/j;
            }

            arrayList.add(new Long(l).intValue());
        }
        n = (rowIndex+1)/2-1;
        while (n >= 0) {
            arrayList.add(arrayList.get(n));
            n--;
        }

        return arrayList;
    }

//    public List<Integer> getRow(int rowIndex) {
//        List<Integer> row =
//                new ArrayList<Integer>(rowIndex + 1) {
//                    {
//                        add(1);
//                    }
//                };
//
//        for (int i = 0; i < rowIndex; i++) {
//            for (int j = i; j > 0; j--) {
//                row.set(j, row.get(j) + row.get(j - 1));
//            }
//            row.add(1);
//        }
//
//        return row;
//    }

}


