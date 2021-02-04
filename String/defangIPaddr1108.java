public class defangIPaddr1108 {

    public String defangIPaddr(String address) {

        StringBuilder sb = new StringBuilder();

        for (char c : address.toCharArray() ) {
            if (c == '.') {
                sb.append('[').append('.').append(']');
            } else
                sb.append(c);
        }
        return sb.toString();

    }
}
