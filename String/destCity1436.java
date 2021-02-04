import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class destCity1436 {

    public String destCity(List<List<String>> paths) {
//        Set<String> set_dest = new HashSet<>();
//        Set<String> set_depart = new HashSet<>();
//        for (List<String> l : paths) {
//            set_dest.remove(l.get(0));
//            set_depart.add(l.get(0));
//            if (!set_depart.contains(l.get(1))) {
//                set_dest.add(l.get(1));
//            }
//
//        }
//        for (String s : set_dest)
//            return s;
//        return null;


        Set<String> set_depart = new HashSet<>();
        for (List<String> l : paths) {

            set_depart.add(l.get(0));

        }
        for (List<String> l : paths) {

            if (!set_depart.contains(l.get(1)))
                return l.get(1);

        }

        return null;

//        HashMap<String, Integer> map = new HashMap<>();
//        for (List<String> l : paths) {
//            map.put(l.get(0), map.getOrDefault(l.get(0), 0)+1);
//            map.put(l.get(1), map.getOrDefault(l.get(1), 0));
//        }
//        for (String s: map.keySet()) {
//            if (map.get(s) == 0)
//                return s;
//        }
//        return null;
    }
}
