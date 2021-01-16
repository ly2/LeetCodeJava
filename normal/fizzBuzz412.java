import java.util.ArrayList;
import java.util.List;

public class fizzBuzz412 {

    public List<String> fizzBuzz(int n) {

        List<String> ans = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            //
            sb.append(i%3==0? "Fizz": "").append(i%5==0? "Buzz": "");
            sb.append(sb.length()==0?  i: "");
            ans.add(sb.toString());

            //



        }
        return ans;
    }


    //1 ms	39.6 MB
    public List<String> fizzBuzz2(int n) {
        List<String> list = new ArrayList<>();
        for(int i=1; i<=n; i++){
            if(i%5==0){
                if(i%3 == 0)
                    list.add("FizzBuzz");
                else
                    list.add("Buzz");
            }
            else if(i%3 == 0)
                list.add("Fizz");
            else
                list.add(String.valueOf(i));
        }
        return list;
    }
}
