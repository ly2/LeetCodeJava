public class isMonotonic896 {

    public boolean isMonotonic(int[] A) {
        boolean inc = true;
        boolean dec = true;
        for (int i = 1; i < A.length; i++) {

            if (A[i] < A[i-1])
                inc = false;


            if (A[i-1] < A[i])
                dec = false;

            if (!(inc||dec))
                return false;
        }


        return true;
    }
}
