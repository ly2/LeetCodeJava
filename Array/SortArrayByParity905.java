import java.util.ArrayList;

/**
 *
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
 *
 * You may return any answer array that satisfies this condition.
 */



public class SortArrayByParity905 {
    public int[] sortArrayByParity(int[] A) {
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        for (int a: A) {
//            if (iseven(a))
//                arrayList.add(0,a);
//            else
//                arrayList.add(a);
//        }
//        Integer[] res = arrayList.toArray(new Integer[arrayList.size()]);

        int i= 0;
        int j = A.length-1;
        while (i < j) {
            if (!iseven(A[i] )&& iseven(A[j])) {
//                System.out.println(i+" "+j);
                int tmp= A[i];
                A[i] = A[j];
                A[j] = tmp;
                i++;
                j--;
            }

            if (iseven(A[i])) {
//                System.out.println(i);
                i++;
            }
            if (!iseven(A[j])) {
                j--;
            }


        }

        return A;

    }
    private boolean iseven(int x) {
        return x%2 == 0;
    }

//    public static void main(String[] args) {
//        int[] A = {3,1,2,4};
//        int[] r = sortArrayByParity(A);
//        for (int i : r) {
//            System.out.println(i);
//        }
//        System.out.println(0%2);
//    }
}
