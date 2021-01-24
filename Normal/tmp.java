import java.util.Scanner;

public class tmp {


    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        String[] line1 = sc.nextLine().split("/");
        String[] line2 = sc.nextLine().split("/");


        int a1 = Integer.valueOf(line1[0].trim());
        int b1 = Integer.valueOf(line1[1].trim());
        int a2 = Integer.valueOf(line2[0].trim());
        int b2 = Integer.valueOf(line2[1].trim());


        int ans_a = a1*b2+a2*b1;
        int ans_b = b1*b2;

        int d = Math.min(ans_a,ans_b);

            for (int i = d; i > 1; i--) {
                if (ans_b%i == 0 && ans_a%i == 0) {
                    ans_a /= i;
                    ans_b /= i;
                    System.out.println(ans_a+" / "+ans_b);
                    break;
                }
            }


    }
}
