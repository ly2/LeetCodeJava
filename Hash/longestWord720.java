import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class longestWord720 {

    public String longestWord(String[] words) {
        Set<String> wordset = new HashSet();
        for (String word: words) wordset.add(word);
        Arrays.sort(words, (a, b) -> a.length() == b.length()
                ? a.compareTo(b) : b.length() - a.length());
        for (String word: words) {
            boolean good = true;
            for (int k = 1; k < word.length(); ++k) {
                if (!wordset.contains(word.substring(0, k))) {
                    good = false;
                    break;
                }
            }
            if (good) return word;
        }

        return "";
    }

    // faster!! 5ms
    public String longestWord1(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word:words){
            set.add(word);
        }
        //Arrays.sort();
        int n = words.length;
        String max = "";
        for (int i = 0;i<n;i++){
            String word = words[i];
            if (max.length()<word.length()
                    ||(max.length()==word.length() && word.compareTo(max)<0)){
                StringBuilder sb = new StringBuilder();
                int j = 0;
                boolean good = true;
                for (;j<word.length()-1;j++){
                    sb.append(word.charAt(j));
                    if (!set.contains(sb.toString())){
                        good = false;
                        break;
                    }

                }
                if (good){
                    max = word;
                }
            }
        }
        return max;
    }

    public String longestWord2(String[] words) {
        Arrays.sort(words);
        trie t = new trie();
        for (String word : words) {
            t.insert(word);

        }
        return t.longest;
    }



    class Node {
        char c;
        boolean isWord;

        HashMap<Character, Node> children = new HashMap<>();

        public Node(char c, boolean isWord) {
            this.c = c;
            this.isWord = isWord;
        }
    }


    class trie {
        Node root;
        public String longest;

        public trie() {
            root = new Node('0', true);
            longest = "";
        }

        public void insert(String w) {
            char[] word = w.toCharArray();
            Node curr = root;
            boolean isword = true;
            for(int i = 0; i < word.length; i++) {
                if (curr.children.getOrDefault(word[i], null) == null ) {
                    if ( i != word.length-1) {
                        isword = false;
                        curr.children.put(word[i], new Node(word[i], false));
                    } else {
                        curr.children.put(word[i], new Node(word[i], true));
                    }


                }
                if(!curr.isWord){isword = false;}
                curr = curr.children.get(word[i]);
            }
            if(isword) {
                if(w.length() > this.longest.length())
                    this.longest = w;
                else if(w.length() == this.longest.length()) {

                    if (w.compareTo(this.longest) < 0)
                        this.longest = w;
                }
            }

        }
    }
}
