import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

class MyHashMap {

    /** Initialize your data structure here. */

    class pair<A , B > {
        A a;
        B b;
        pair(A a, B b) {
            this.a = a;
            this.b = b;
        }
    }


    class bucket {
        private List<pair<Integer, Integer>> list;

        bucket() {
            this.list = new ArrayList<pair<Integer, Integer>>();
        }



        void add(Integer a, Integer b) {
            boolean flag = false;
            for (pair p: list ) {
                if (p.a.equals(a)) {
                    p.b = b;
                    flag = true;
                    break;
                }
            }
            if (!flag)
                list.add(new pair(a, b));
        }

        Integer get(Integer a) {

            for (pair<Integer, Integer> p : list) {
                if (p.a.equals(a))
                    return p.b;
            }
            return -1;
        }

        void remove(Integer a) {
            for (pair p : list) {
                if (p.a.equals(a)) {
                    list.remove(p);
                    break;
                }

            }
        }

    }

    int bucketsize = 2069;
    bucket[] buckets;

    public MyHashMap() {
        buckets = new bucket[bucketsize];
        for (int i = 0; i < bucketsize;i++) {
            buckets[i] = new bucket();
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int k = key%bucketsize;
        buckets[k].add(key, value);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int k = key%bucketsize;
        return buckets[k].get(key);
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int k = key%bucketsize;
        buckets[k].remove(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
