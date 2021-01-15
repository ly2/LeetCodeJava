import java.util.ArrayList;

public class addStrings415 {



    public String addStrings(String num1, String num2) {

        StringBuilder stringBuilder = new StringBuilder();

        int i1 = num1.length()-1;
        int i2 = num2.length()-1;
        int carry = 0;
        while (i1 >= 0 || i2 >= 0) {

            // simplify
            int d = carry;

            if (i1>= 0)
                d += num1.charAt(i1)-'0';
            if (i2 >= 0)
                d += num2.charAt(i2)-'0';

            carry = d/10;
            d = d%10;
            stringBuilder.append(d);
            i1--;
            i2--;
            //

//            if (i1>= 0 && i2 >= 0 ) {
//                int d =  num1.charAt(i1)-'0' + num2.charAt(i2)-'0' + carry;
//                carry = d/10;
//                d = d%10;
//                stringBuilder.append(d);
//
//            } else if (i1 >= 0) {
//                int d = num1.charAt(i1)-'0' + carry;
//                carry = d/10;
//                d = d%10;
//                stringBuilder.append(d);
//
//
//            } else {
//                int d = num2.charAt(i2)-'0' + carry;
//                carry = d/10;
//                d = d%10;
//                stringBuilder.append(d);
//
//            }
//            i1--;
//            i2--;
        }
        if (carry != 0)
            stringBuilder.append(carry);

        return stringBuilder.reverse().toString();
    }


}
