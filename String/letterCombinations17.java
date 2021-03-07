import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class letterCombinations17 {

    // after opt, 0ms
    Map<Character, String> map = new HashMap<>();
    ArrayList<String> combs = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return new ArrayList<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        dfs(0, digits, new char[digits.length()]);
        return combs;
    }


    private void dfs(int idx, String digits, char[] arr) {
        if (idx >= digits.length()) {
            combs.add(new String(arr));
            return;
        }

        String s = map.get(digits.charAt(idx));
        for (int i = 0; i < s.length(); i++) {
            arr[idx] = s.charAt(i);
            dfs(idx+1, digits, arr);
        }
    }


    // original
//    Map<Character, ArrayList<Character>> map = new HashMap<>();
//    ArrayList<String> combs = new ArrayList<>();
//    public List<String> letterCombinations(String digits) {
//        if (digits.isEmpty())
//            return new ArrayList<>();
//        generateMap();
//        dfs(0, digits, new char[digits.length()]);
//        return combs;
//    }
//
//
//    private void dfs(int idx, String digits, char[] arr) {
//        if (idx >= digits.length()) {
//            combs.add(new String(arr));
//            return;
//        }
//
//        ArrayList<Character> list = map.get(digits.charAt(idx));
//        for (char c : list) {
//            arr[idx] = c;
//            dfs(idx+1, digits, arr);
//        }
//    }
//    private void generateMap() {
//        map.put('2', new ArrayList<Character>(){
//            {
//                add('a');
//                add('c');
//                add('b');
//            }
//        });
//        map.put('3', new ArrayList<Character>(){
//            {
//                add('d');
//                add('e');
//                add('f');
//            }
//        });
//        map.put('4', new ArrayList<Character>(){
//            {
//                add('g');
//                add('h');
//                add('i');
//            }
//        });
//        map.put('5', new ArrayList<Character>(){
//            {
//                add('l');
//                add('j');
//                add('k');
//            }
//        });
//        map.put('6', new ArrayList<Character>(){
//            {
//                add('m');
//                add('n');
//                add('o');
//            }
//        });
//        map.put('7', new ArrayList<Character>(){
//            {
//                add('p');
//                add('q');
//                add('r');
//                add('s');
//            }
//        });
//        map.put('8', new ArrayList<Character>(){
//            {
//                add('t');
//                add('u');
//                add('v');
//            }
//        });
//        map.put('9', new ArrayList<Character>(){
//            {
//                add('w');
//                add('x');
//                add('y');
//                add('z');
//            }
//        });
//    }




}
