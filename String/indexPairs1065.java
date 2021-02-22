import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class indexPairs1065 {

    public int[][] indexPairs(String text, String[] words) {
        int[][] ans = new int[words.length * 100][2];
        int i = 0;
        for (String w : words) {
            int idx = text.indexOf(w);

            while (idx!= -1) {
                ans[i][0] = idx;
                ans[i++][1] = idx + w.length()-1;
                idx = text.indexOf(w, idx+1);
            }

        }
        int[][] arr = Arrays.copyOf(ans, i);

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1]-o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        return arr;
    }

    // opt, 1 ms	39.5 MB
    public int[][] indexPairs1(String text, String[] words) {
ArrayList<int[]> list = new ArrayList<>();

        for (String w : words) {
            int idx = text.indexOf(w);

            while (idx!= -1) {
                list.add(new int[]{idx, idx + w.length()-1});
                idx = text.indexOf(w, idx+1);
            }

        }
        int[][] arr = new int[list.size()][2];
        list.toArray(arr);

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1]-o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        return arr;
    }


    // submission method
    TrieNode root = null;
    public int[][] indexPairs2(String text, String[] words) {
        for(String word: words) {
            add(word);
        }

        List<int[]> res = new ArrayList<>();
        for(int i = 0; i < text.length(); i++) {
            List<int[]> list = new ArrayList<>();
            search(text, i, list);
            if(!list.isEmpty()) res.addAll(list);
        }
        return res.toArray(new int[res.size()][2]);
    }

    void add(String word) {
        if(root == null) {
            root = new TrieNode();
        }

        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            if(current.children[word.charAt(i)-'a'] == null) {
                current.children[word.charAt(i)-'a'] = new TrieNode();
            }
            current = current.children[word.charAt(i)-'a'];
        }
        current.isWord = true;
    }

    void search(String word, int index, List<int[]> list) {
        TrieNode current = root;
        for(int i = index; i < word.length(); i++) {
            if(current.children[word.charAt(i)-'a'] == null) {
                break;
            }

            if(current.children[word.charAt(i)-'a'].isWord) {
                list.add(new int[] {index, i});
            }
            current = current.children[word.charAt(i)-'a'];
        }
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isWord;

    public TrieNode() {
        children = new TrieNode[26];
    }

}
