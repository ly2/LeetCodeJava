import java.util.ArrayList;
import java.util.Scanner;

public class exam {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        StringBuilder ans = new StringBuilder();


        ArrayList<Character> list = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            list.add(input.charAt(i));
        }

        while (!list.isEmpty()) {
            ans.append(list.get(0));

            list.remove(0);

            if (list.isEmpty())
                break;

            char c = list.remove(0);
            list.add(c);
        }

        System.out.println(ans.toString());

    }
}
