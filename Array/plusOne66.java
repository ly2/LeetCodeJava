public class plusOne66 {

    public int[] plusOne(int[] digits) {

        digits[digits.length-1]++;

        int index = digits.length-1;
        int carry = 0;
        while (digits[index] >= 10) {
            if (index == 0) {
                carry = digits[index] /10;
                digits[index] %= 10;
                break;
            }
            digits[index--] %= 10;
            digits[index]++;
        }
        if (carry != 0) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
            return digits;
        }


        return digits;
    }


    // simplify
    public int[] plusOne2(int[] digits) {
        int n = digits.length;

        // move along the input array starting from the end
        for (int idx = n - 1; idx >= 0; --idx) {
            // set all the nines at the end of array to zeros
            if (digits[idx] == 9) {
                digits[idx] = 0;
            }
            // here we have the rightmost not-nine
            else {
                // increase this rightmost not-nine by 1
                digits[idx]++;
                // and the job is done
                return digits;
            }
        }
        // we're here because all the digits are nines
        digits = new int[n + 1];
        digits[0] = 1;
        return digits;
    }
}
