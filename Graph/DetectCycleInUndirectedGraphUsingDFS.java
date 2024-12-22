import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetectCycleInUndirectedGraphUsingDFS {
    public static boolean dfs(List<List<Integer>> adjList,int[] vis,int src,int parent){
        vis[src]=1;
        System.out.println(" current node : "+src);
        List<Integer> list=adjList.get(src);
        System.out.println("list : "+list);
        for(int i=0;i<list.size();i++){
            int nextNode=list.get(i);
            System.out.println(" node : "+nextNode+" vis: "+vis[nextNode]);
            if(vis[nextNode]==1 && nextNode!=parent){
                return true;
            }
            //skip for parent node
            if(vis[nextNode]==1) continue;
            boolean isCycle=dfs(adjList,vis,nextNode,src);
            if(isCycle) return true;
        }
        return false;
    }
    public static void main(String[] args){
        List<List<Integer>> adjList=new ArrayList<>();

        adjList.add(new ArrayList<>());
        adjList.add(new ArrayList<>(Arrays.asList(2,3)));
        adjList.add(new ArrayList<>(Arrays.asList(1,5)));
        adjList.add(new ArrayList<>(Arrays.asList(1,6,4)));
        adjList.add(new ArrayList<>(Arrays.asList(3)));
        adjList.add(new ArrayList<>(Arrays.asList(2,7)));
        adjList.add(new ArrayList<>(Arrays.asList(3,7)));
        adjList.add(new ArrayList<>(Arrays.asList(5,6)));

        int[] vis=new int[8];

        boolean isCycle=dfs(adjList,vis,1,-1);
        System.out.println(" is cycle is present in given graph : "+isCycle);

    }
}
