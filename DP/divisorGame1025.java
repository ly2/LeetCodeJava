

public class divisorGame1025 {


    public boolean divisorGame(int N) {

        // the best solution, math quesiton
//        return N %2 == 0;

        boolean[] res = new boolean[N+1];

        for (int i = 2; i < N+1; i++) {

            for (int j = 1; j*j < i; j++) {
                if (i % j == 0 && !res[i-j] ) {
                    res[i] = true;
                    break;
                }
            }


        }
        return res[N];
    }



}
