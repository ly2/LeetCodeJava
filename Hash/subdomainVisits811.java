import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class subdomainVisits811 {


    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();


        // 此处如果直接对string 循环耗时会更短！
        // just iterate the string sub domain will cosume less time.
        for (String s : cpdomains) {
            String[] cp = s.split(" ");
            int count = Integer.valueOf(cp[0]);

            map.put(cp[1], map.getOrDefault(cp[1], 0)+ count);
            while (cp[1].contains(".")) {
                cp[1] = cp[1].substring(cp[1].indexOf(".")+1);
                map.put(cp[1], map.getOrDefault(cp[1], 0)+ count);
            }
        }

        List<String> ans = new ArrayList<>();


//        for (String sub_dom : map.keySet()) {
//            ans.add( map.get(sub_dom) + " "+ sub_dom);
//        }


        // using the StringBuilder would faster than the above method at least one time.
        // 用stringbuilder 快一倍
        map.forEach((sub_dom, count) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(count).append(" ").append(sub_dom);
            ans.add(sb.toString());

                });

        return ans;
    }


    HashMap<String, Integer> visitedSites = new HashMap<>();
    public void splitter(String s) {
        int visited = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                visited = Integer.parseInt(s.substring(0, i));
                String link = s.substring(i + 1);
                visitedSites.put(link, visitedSites.getOrDefault(link, 0) + visited);
            }
            if (s.charAt(i) == '.') {
                String link = s.substring(i + 1);
                visitedSites.put(link, visitedSites.getOrDefault(link, 0) + visited);
            }
        }
    }

}
