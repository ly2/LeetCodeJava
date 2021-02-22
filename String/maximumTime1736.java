public class maximumTime1736 {


    // original 0 ms	37 MB
    public String maximumTime(String time) {
        StringBuilder sb = new StringBuilder();
        if (time.charAt(0) == '?') {
            if (time.charAt(1) == '?') {
                sb.append(23);
            } else if (time.charAt(1) - '0' > 3) {
                sb.append(1).append(time.charAt(1));
            } else {
                sb.append(2).append(time.charAt(1));
            }
        } else {
            if (time.charAt(1) != '?') {
                sb.append(time.charAt(0)).append(time.charAt(1));
            } else if (time.charAt(0) == '2') {
                sb.append(23);
            } else
                sb.append(time.charAt(0)).append(9);
        }

        sb.append(':');
        if (time.charAt(3) == '?') {
            sb.append(5);
            if (time.charAt(4) == '?')
                sb.append(9);
            else
                sb.append(time.charAt(4));

        } else {
            sb.append(time.charAt(3));
            if (time.charAt(4) != '?') {
                sb.append(time.charAt(4));
            }else
                sb.append(9);
        }

        return sb.toString();

    }


}
