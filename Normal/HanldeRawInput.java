import java.util.Scanner;

public class HanldeRawInput {
    public static void main(String[] args) {
        // int
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }


        // double
        in = new Scanner(System.in);
        while (in.hasNextDouble()) {
            double a = in.nextDouble();
            System.out.println(getIntFromDouble(a));
        }


    }


    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        //获取输入的整数序列
        String str = sc.nextLine();
        String[] strings = str.split(" ");
        //转为整数数组
        int[] ints = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            ints[i] = Integer.parseInt(strings[i]);
        }
        System.out.println(ints);
    }

    public static int getIntFromDouble(double a) {
        return (int) (a + 0.5);
    }

    public class Main2 {

        public void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNextLine()) {
                int m = sc.nextInt();
                int n = sc.nextInt();
                System.out.println(m);
                System.out.println(n);
                char[][] matrix = new char[m][n];

                int x = sc.nextInt();
                int y = sc.nextInt();
                System.out.println(x);
                System.out.println(y);
                sc.nextLine(); // 这一行非常重要！！！！ nextInt 完了之后一定要加这个不然会出错！！！

                for (int i = 0; i < m; i++) {
                    String line = sc.nextLine();
                    matrix[i] = line.toCharArray();
                    System.out.println(line);
                }
            }

        }
    }
}
