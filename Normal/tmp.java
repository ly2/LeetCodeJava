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


            // 用最大公约数 更快！
            for (int i = d; i > 1; i--) {
                if (ans_b%i == 0 && ans_a%i == 0) {
                    ans_a /= i;
                    ans_b /= i;
                    System.out.println(ans_a+" / "+ans_b);
                    break;
                }
            }

//        int i = 10;
//        i = i >> 1;
//        //转为2进制之后,右移了一位,相当于除以2^n,是最快速的除法方式
//        System.out.println("i >> 1 :" + i);
//
//        i = 10;
//        i = i << 1; // 左移1(n)位
//        //转为2进制之后,左移了1位,相当于乘以2^n,是最快速的乘法方式
//        System.out.println("i << 1:" + i);
    }

    public static int getGCD(int a, int b) {
        if (a < 0 || b < 0) {
            return -1; // 数学上不考虑负数的约数
        }
        if (b == 0) {
            return a;
        }
        while (a % b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return b;
    }

}
