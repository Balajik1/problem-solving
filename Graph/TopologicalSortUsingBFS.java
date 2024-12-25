import java.util.*;

public class TopologicalSortUsingBFS {
    public static void main(String[] args){
        //adjancency list
        List<List<Integer>> adjList=new ArrayList<>();

        adjList.add(Arrays.asList());
        adjList.add(Arrays.asList());//1
        adjList.add(Arrays.asList(3));//2
        adjList.add(Arrays.asList(1));//3
        adjList.add(Arrays.asList(0,1));//4
        adjList.add(Arrays.asList(0,2));//5

        // calculate indegree of all nodes
        int[] inDeg=new int[adjList.size()];
        for(List<Integer> list:adjList){
            for(int val:list){
                inDeg[val]++;
            }
        }

        System.out.println("inDeg[0] : "+inDeg[0]);


        Queue<Integer> q=new LinkedList<>();
        // add element with inDegree 0 to queue
        for(int i=0;i<inDeg.length;i++){
            if(inDeg[i]==0) q.add(i);
        }

        while(!q.isEmpty()){
            int node=q.poll();
            System.out.print(" "+node);
            //traversing through adj List of it
            for(int i: adjList.get(node)){
                inDeg[i]--;
                // if inDegree became 0 add it to queue
                if(inDeg[i]==0) q.add(i);
            }
        }
    }
}
