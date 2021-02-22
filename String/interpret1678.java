import java.util.Arrays;

public class interpret1678 {


    public String interpret(String command) {
        char[] arr = command.toCharArray();
        int idx = 0;
        for (int i = 0; i < arr.length;i++) {
            if (arr[i] == 'G') {
                arr[idx++] = arr[i];

            } else if (arr[i] == '(' && arr[i+1] == ')') {
                arr[idx++] = 'o';
                i++;
            } else {
                arr[idx++] = 'a';
                arr[idx++] = 'l';
                i += 3;
            }
        }
        return new String(Arrays.copyOf(arr, idx));

    }


    // submission method
    public String interpret2(String command) {
        StringBuilder sb = new StringBuilder();
        int j = 0; //write head
        int i = 0; //index
        while(i < command.length()) {
            char c = command.charAt(i);
            if(c == '(') {
                if(command.charAt(i+1) == ')') {
                    sb.append('o');
                    i+=2;
                }
                else {
                    sb.append("al");
                    i += 4;
                }
            }
            else
            {
                sb.append(c);
                i++;

            }
        }
        return sb.toString();
    }
}
