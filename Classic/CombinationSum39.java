/*
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

        The same repeated number may be chosen from candidates unlimited number of times.

        Note:

        All numbers (including target) will be positive integers.
        The solution set must not contain duplicate combinations.
*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum39 {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        backstracking(candidates, 0, target, new ArrayList<>());
        return res;
    }

    public void backstracking(int[] arr, int index, int target, ArrayList<Integer> a) {
        if (target==0){
            res.add(new ArrayList<Integer>(a));
            return;
        }
        if (index == arr.length)
            return;

        for (int i = index;i < arr.length; i++) {
            if (target-arr[i]>= 0 ) {
                a.add(arr[i]);
                backstracking(arr, i, target-arr[i], a);
                a.remove(a.size()-1);
            } else {
                break;
            }
        }

    }



}
