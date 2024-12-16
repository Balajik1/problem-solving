import java.util.*;

public class DetectCycleInUndirectedGraphUsingBFS {

    public  static  void main(String[] args){
        boolean noCycle=true;
        class Pair{
            int node,parent;
            public Pair(int node,int parent){
                this.node=node;
                this.parent=parent;
            }
            @Override
            public String toString(){
                return "("+node+","+parent+")";
            }
        }
        List<List<Integer>> adjList=new ArrayList<>();

        // making adjency list
        adjList.add(null);
        adjList.add(new ArrayList<>(Arrays.asList(2,3)));
        adjList.add(new ArrayList<>(Arrays.asList(5,1)));
        adjList.add(new ArrayList<>(Arrays.asList(1,6,4)));
        adjList.add(new ArrayList<>(Arrays.asList(3)));
        adjList.add(new ArrayList<>(Arrays.asList(2,7)));
        adjList.add(new ArrayList<>(Arrays.asList(3,7)));
        adjList.add(new ArrayList<>(Arrays.asList(5,6)));

        for(int i=0;i<adjList.size();i++){
            List<Integer> l=adjList.get(i);
            System.out.println(" list for idx : "+i+" = "+l);
        }

        Queue<Pair> q=new LinkedList<>();
        int[] vis=new int[8];// total 7 element
        q.add(new Pair(1,-1));//intializing with src and parent , as its a start parent is -1
        vis[1]=1;

        while(!q.isEmpty()){
            Pair pair=q.poll();
            int node=pair.node,parent=pair.parent;
            System.out.println(" currnet pair is "+pair);
            List<Integer> list=adjList.get(pair.node);
            for(int i=0;i<list.size();i++){
                int val=list.get(i);
                System.out.println("val : "+val);
                if(vis[val]==1 && val!=parent){
                    System.out.println(" inside if for val"+val);
                    noCycle=false;break;
                }

                if(vis[val]==0){
                    vis[val]=1;
                    q.add(new Pair(val,node));
                }
            }
        }

        if(noCycle){
            System.out.println("cycle is not present in Graph!");
        }else{
            System.out.println("cycle is present in Graph!");
        }
    }
}
