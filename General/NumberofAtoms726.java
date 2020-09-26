import java.util.*;

/**
 *Given a chemical formula (given as a string), return the count of each atom.
 *
 * An atomic element always starts with an uppercase character, then zero or more lowercase letters, representing the name.
 *
 * 1 or more digits representing the count of that element may follow if the count is greater than 1. If the count is 1,
 * no digits will follow. For example, H2O and H2O2 are possible, but H1O2 is impossible.
 *
 * Two formulas concatenated together produce another formula. For example, H2O2He3Mg4 is also a formula.
 *
 * A formula placed in parentheses, and a count (optionally added) is also a formula. For example, (H2O2) and (H2O2)3 are formulas.
 *
 * Given a formula, output the count of all elements as a string in the following form: the first name (in sorted order),
 * followed by its count (if that count is more than 1),
 * followed by the second name (in sorted order), followed by its count (if that count is more than 1), and so on.
 *
 *
 */


public class NumberofAtoms726 {

    /**
     * this method is slow and inefficient.
     * 8 ms	39.5 MB
     * reason: the recursive method would process the same substring more than once.
     * use the hashtable.containsKey(atom) is better than putIfAbsent and computeIfPresent.
     */
//    HashMap<String, Integer> hashtable;
//    public String countOfAtoms(String formula) {
//
//        hashtable = new HashMap<>();
//        count(formula, 1);
//        List<String> list = new ArrayList(hashtable.keySet());
//
//        Collections.sort(list);
//        String res = "";
//        for (String s: list) {
//            res += s;
//            if (hashtable.get(s) != 1){
//                res += hashtable.get(s);
//            }
//        }
//        return res;
//    }

//    private void count(String formula, int coef) {
//        int i = 0;
//
//        while (i < formula.length()){
//
//            int start;
//            int end;
//
//
//            if (formula.charAt(i) == '(') {
//                i++;
//                start = i;
//                int brackets = 1;
//                while (brackets != 0) {
//
//                    if (formula.charAt(i) == ')') {
//                        brackets--;
//                    }
//                    if (formula.charAt(i) == '(') {
//                        brackets++;
//                    }
//                    i++;
//                }
//
//                end  = i-1;
//
//
//                String num = getnum(formula, i);
//                if (num==null) {
//                    count(formula.substring(start, end), coef);
//                    i += 1;
//                } else {
//
//                    count(formula.substring(start, end), coef*(Integer.parseInt(num)));
//                    i += num.length();
//                }
//
//            }
//
//
//            if (i < formula.length() && Character.isUpperCase(formula.charAt(i))) {
//                start = i;
//                i++;
//                while (i < formula.length()&&Character.isLowerCase(formula.charAt(i))) {
//                    i++;
//                }
//                end = i;
//                String atom = formula.substring(start, end);
//                String num = getnum(formula, i);
//                if (num== null) {
//                    if (hashtable.containsKey(atom)) {
//                        hashtable.put(atom, hashtable.get(atom)+coef);
//                    } else {
//                        hashtable.put(atom, coef);
//                    }
//
////                    hashtable.computeIfPresent(atom, (k,v)-> v+coef);
////                    hashtable.putIfAbsent(atom, coef);
//                } else {
//                    if (hashtable.containsKey(atom)) {
//                        hashtable.put(atom, hashtable.get(atom)+coef*(Integer.parseInt(num)));
//                    } else {
//                        hashtable.put(atom, coef*(Integer.parseInt(num)));
//                    }
////                    hashtable.computeIfPresent(atom, (k, v)-> v+coef*(Integer.parseInt(num)));
////                    hashtable.putIfAbsent(atom, coef*(Integer.parseInt(num)));
//                    i += num.length();
//                }
//            }
//
//        }
//    }

//    private String getnum(String formula, int index) {
//
//        if (index < formula.length() && Character.isDigit(formula.charAt(index))) {
//            int i = index+1;
//            while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
//                i++;
//            }
//            return formula.substring(index, i);
//        }
//        return null;
//    }





    /**
     * use the hashmap and stack, much easier and understandable, 10 ms	39.9 MB
     * @param formula
     * @return
     */
    HashMap<String, Integer> hashMap;
    Stack<String> stack;
    String _buffer;
    public String countOfAtoms(String formula) {
        hashMap = new HashMap<>();
        stack = new Stack<>();
        _buffer = formula;
        split();
        count(1);
        List<String> list = new ArrayList(hashMap.keySet());

        Collections.sort(list);
        String res = "";
        for (String s: list) {
            res += s;
            if (hashMap.get(s) != 1){
                res += hashMap.get(s);
            }
        }
        return res;

    }
    private void split() {
        while (!_buffer.isEmpty()) {
            if (_buffer.charAt(0)=='(') {
                stack.push(String.valueOf(_buffer.charAt(0)));
                _buffer = _buffer.substring(1);
            } else if (_buffer.charAt(0)==')') {
                stack.push(String.valueOf(_buffer.charAt(0)));
                _buffer = _buffer.substring(1);
            } else if (Character.isUpperCase(_buffer.charAt(0))) {
                int i = 1;
                while (i < _buffer.length()&&Character.isLowerCase(_buffer.charAt(i))) {
                    i++;
                }
                stack.push(_buffer.substring(0, i));
                _buffer = _buffer.substring(i);
            } else if (Character.isDigit(_buffer.charAt(0))) {
                int i = 1;
                while (i < _buffer.length() && Character.isDigit(_buffer.charAt(i))) {
                    i++;
                }
                stack.push(_buffer.substring(0, i));
                _buffer = _buffer.substring(i);
            }
        }
    }
    private void count(int coef) {
        while (!stack.empty()) {

            if (Character.isDigit(stack.peek().charAt(0))) {
                int num = Integer.parseInt(stack.pop());
                if (Character.isUpperCase(stack.peek().charAt(0))) {
                    String atom = stack.pop();
                    if (hashMap.containsKey(atom)) {
                        hashMap.put(atom, hashMap.get(atom)+coef*num);
                    } else {
                        hashMap.put(atom, coef*num);
                    }
                } else if (stack.peek().equals(")")) {
                    stack.pop();
                    count(coef*num);
                }
            } else if (Character.isUpperCase(stack.peek().charAt(0))) {
                String atom = stack.pop();
                if (hashMap.containsKey(atom)) {
                    hashMap.put(atom, hashMap.get(atom)+coef);
                } else {
                    hashMap.put(atom, coef);
                }
            } else if (stack.peek().equals(")")) {
                stack.pop();
                count(coef);
            } else if (stack.peek().equals("(")) {
                stack.pop();
                return;
            }
        }
    }


/**
 * better solution in leetcode
 * 2 ms	37.4 MB
 */
//public String countOfAtoms(String formula) {
//    Stack<Map<String,Integer>> stack= new Stack<>();
//    Map<String,Integer> map= new HashMap<>();
//    int i=0,n=formula.length();
//    while(i<n){
//        char c=formula.charAt(i);i++;
//        if(c=='('){
//            stack.push(map);
//            map=new HashMap<>();
//        }
//        else if(c==')'){
//            int val=0;
//            while(i<n && Character.isDigit(formula.charAt(i)))
//                val=val*10+formula.charAt(i++)-'0';
//
//            if(val==0) val=1;
//            if(!stack.isEmpty()){
//                Map<String,Integer> temp= map;
//                map=stack.pop();
//                for(String key: temp.keySet())
//                    map.put(key,map.getOrDefault(key,0)+temp.get(key)*val);
//            }
//        }
//        else{
//            int start=i-1;
//            while(i<n && Character.isLowerCase(formula.charAt(i))){
//                i++;
//            }
//            String s= formula.substring(start,i);
//            int val=0;
//            while(i<n && Character.isDigit(formula.charAt(i))) val=val*10+ formula.charAt(i++)-'0';
//            if(val==0) val=1;
//            map.put(s,map.getOrDefault(s,0)+val);
//        }
//    }
//    StringBuilder sb= new StringBuilder();
//    List<String> list= new ArrayList<>(map.keySet());
//    Collections.sort(list);
//    for(String key: list){
//        sb.append(key);
//        if(map.get(key)>1) sb.append(map.get(key));
//    }
//    return sb.toString();
//}


//    public static void main(String[] args) {
////        String s = countOfAtoms("((N42)24(OB40Li30CHe3O48LiNN26)33(C12Li48N30H13HBe31)21(BHN30Li26BCBe47N40)15(H5)16)14");
//        String s = countOfAtoms("Mg(OH)2");
//        System.out.println("ans is");
//        System.out.println(s);
//    }




}
