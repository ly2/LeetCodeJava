public class addBinary67 {


    public String addBinary2(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }



    public String addBinary(String a, String b) {
        int len_a = a.length()-1, len_b = b.length()-1, carry = 0;

        StringBuilder sb = new StringBuilder();
        while (len_a >=0 || len_b >= 0) {
            int da = 0, db = 0;
            if (len_a >= 0)
                da = a.charAt(len_a)-'0';
            if (len_b >= 0)
                db = b.charAt(len_b)-'0';
            int d =  da+db+ carry;
            carry = d/2;
            d %= 2;
            sb.append(d);
            len_a--;
            len_b--;
        }
        if (carry!=0)
            sb.append(carry);


        return sb.reverse().toString();


    }


    // trick method, a is always the longer string then cal.
    public String addBinary3(String a, String b) {
        int n = a.length(), m = b.length();
        if (n < m) return addBinary(b, a);
        int L = Math.max(n , m);
        StringBuilder sb = new StringBuilder();

        int carry = 0, j = m - 1;
        for (int i = L - 1; i > -1; --i) {
            if (a.charAt(i) == '1') carry++;
            if (j > -1 && b.charAt(j--) == '1') carry++;

            if (carry % 2 == 1) sb.append('1');

            else sb.append('0');

            carry /= 2;
        }

        if (carry == 1) sb.append('1');
        sb.reverse();

        return sb.toString();
    }
}
