import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class reformatNumber1694 {

    public String reformatNumber(String number) {
        Queue<Character> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (char c : number.toCharArray()) {
            if (Character.isDigit(c)) {
                queue.offer(c);
                if (queue.size() > 4) {
                    sb.append(queue.poll());
                    count++;
                    if (count == 3){
                        sb.append('-');
                        count = 0;
                    }
                }
            }
        }
        if (count == 0) {
            sb.append(queue.poll()).append(queue.poll());
            if (!queue.isEmpty())
                sb.append('-').append(queue.poll()).append(queue.poll());
        } else if (count == 1){
            sb.append(queue.poll()).append(queue.poll());
            sb.append('-').append(queue.poll()).append(queue.poll());
        } else if (count == 2) {
            sb.append(queue.poll()).append('-');
            sb.append(queue.poll()).append(queue.poll()).append(queue.poll());
        }

        return sb.toString();
    }


    // operation on stringbuilder
    public String reformatNumber2(String number) {
        StringBuilder re = new StringBuilder();
        for (char c: number.toCharArray()) {
            if (c >= '0' && c <= '9') {
                re.append(c);
            }
        }
        int i = 0;
        int count = re.length();
        while (count > 4) {
            re.insert(i + 3, '-');
            count -= 3;
            i += 4;
        }
        if (count == 4) {
            re.insert(re.length() - 2, '-');
        }
        return re.toString();

    }
}
