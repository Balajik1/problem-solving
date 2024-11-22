import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopFrequency {

}
class Solution {
    class Pair implements Comparable<Pair>{
        int val;
        int ct;
        Pair(int val,int ct){
            this.val=val;
            this.ct=ct;
        }
        @Override
        public int compareTo(Pair o){
            return  ct - o.ct;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        // you have a map but how will you find which one are most frequest element (k=2)
        PriorityQueue<Pair> pq=new PriorityQueue<>();

        for(Integer key: hm.keySet()){
            pq.add(new Pair(key,hm.get(key)));
            if(pq.size()>k){
                pq.poll();
            }
        }
        int size=pq.size();
        int[] ans=new int[size];
        for(int i=0;i<size;i++){
            ans[i]=pq.poll().val;
        }
        return ans;
    }
}
