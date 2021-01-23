import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

class MaxStack {



    TreeMap<Integer, Integer> map;
    ArrayList<Integer> list;
    /** initialize your data structure here. */
    public MaxStack() {
        this.list = new ArrayList<>();
        this.map = new TreeMap<>();
    }

    public void push(int x) {
        list.add(x);
        if (map.getOrDefault(x, -1) == -1) {
            map.put(x, 1);
        } else {
            map.put(x, map.get(x)+1);
        }
    }

    public int pop() {
        int val = list.remove(list.size()-1);
        if (map.get(val) == 1) {
            map.remove(val);
        } else {
            map.put(val, map.get(val)-1);
        }
        return val;
    }

    public int top() {
        return list.get(list.size()-1);
    }

    public int peekMax() {
        return map.lastKey();
    }

    public int popMax() {
        int max = peekMax();
        if (map.get(max) == 1) {
            map.remove(max);
        } else {
            map.put(max, map.get(max)-1);
        }
        list.remove(list.lastIndexOf(max));
        return max;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */


