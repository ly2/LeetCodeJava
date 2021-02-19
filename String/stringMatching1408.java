import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class stringMatching1408 {


    // genius!!
    public List<String> stringMatching(String[] words) {
        StringBuilder sb = new StringBuilder();
        for(String str : words)
            sb.append(" ").append(str);
        String allstr = sb.toString();

        List<String> result = new LinkedList<>();
        for(String str : words)
            if(allstr.indexOf(str) != allstr.lastIndexOf(str))
                result.add(str);

        return result;
    }


    // original
    public List<String> stringMatching2(String[] words) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if (words[i].length() >= words[j].length()) {
                    if (words[i].contains(words[j]))
                        set.add(words[j]);
                } else {
                    if (words[j].contains(words[i]))
                        set.add(words[i]);
                }
            }
        }
        ArrayList<String> list = new ArrayList<>();
        list.addAll(set);
        return list;
    }

    // improved   2ms  use boolean to identify if the word has been store in list
    public List<String> stringMatching3(String[] words) {
        List<String> list = new ArrayList();
        int n = words.length;
        boolean[] valid = new boolean[n];
        for(int i=0; i< n; i++){
            if(valid[i]){
                continue;
            }
            for(int j =i+1; j < n; j++){
                if(valid[j] || valid[i]){
                    continue;
                }
                if(words[i].length() < words[j].length()){
                    if(words[j].indexOf(words[i]) !=-1){
                        list.add(words[i]);
                        valid[i]= true;
                    }
                }else{
                    if(words[i].indexOf(words[j]) !=-1){
                        list.add(words[j]);
                        valid[j] = true;
                    }
                }
            }
        }
        return list;
    }
}
