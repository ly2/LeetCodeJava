import java.util.Arrays;

public class generateTheString1374 {

    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        if (n % 2 == 1) {
            for (int i = 0; i < n; i++) {
                sb.append('a');
            }
        } else {
            for (int i = 0; i < n-1; i++) {
                sb.append('a');
            }
            sb.append('b');
        }

        return sb.toString();
    }


    // much clean!
    public String generateTheString2(int n) {

        char[] result = new char[n];

        // Arrays.fill(arr, value) !!!!!
        Arrays.fill(result,'p');

        if(n%2==0)
            result[0]='x';

        return new String(result);
    }
}
