package StockSpanProblem;

// class StockSpanner {
//      List<Integer> arr;
//     public StockSpanner() {
//        arr=new ArrayList<>();
//     }

//     public int next(int price) {
//         arr.add(price);
//         int ct=1;

//         for(int i=arr.size()-2;i>=0;i--){
//             if(arr.get(i)<=price)
//                 ct++;
//             else break;
//         }

//         return ct;
//     }
// }

import java.util.Stack;

class StockSpanner {
    private class Pair{
        int val,ind;
        Pair(int val,int ind){
            this.val=val;
            this.ind=ind;
        }
    }
    int ind;
    Stack<Pair> st;
    public StockSpanner() {
        ind=-1;
        st=new Stack<>();
    }
    public int next(int price) {
        ind++;
        while(!st.isEmpty() && st.peek().val <=price){
            st.pop();
        }
        int ct=ind-(st.isEmpty() ? -1 : st.peek().ind);
        st.push(new Pair(price,ind));
        return ct;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
