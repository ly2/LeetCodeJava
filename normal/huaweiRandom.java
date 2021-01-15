import java.util.*;
public class huaweiRandom {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            while(sc.hasNext()) {
                int N = sc.nextInt();
                TreeSet<Integer> set = new TreeSet<>();
                while (N != 0) {


                    set.add(sc.nextInt());


                    N--;
                }
                for (int i : set) {
                    System.out.println(i);
                }
            }




        }

}
