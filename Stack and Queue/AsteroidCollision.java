import java.util.ArrayList;
import java.util.List;

public class AsteroidCollision {
        public int[] asteroidCollision(int[] asteroids) {
            // used list as stack as need to resturn sorted thing
            // stack giving reverse
            List<Integer> list=new ArrayList<>();
            int n=asteroids.length;
            int last=-1;
            for(int i=0;i<n;i++){
                if( asteroids[i] > 0 || last == -1 && asteroids[i] < 0  || list.get(last) < 0 && asteroids[i] < 0){
                    last++;
                    list.add(asteroids[i]);
                }else{
                    while(last>=0 && list.get(last) > 0  && Math.abs(list.get(last)) <  Math.abs(asteroids[i])){
                        list.remove(last);
                        last--;
                    }
                    if(last == -1 || list.get(last) == asteroids[i] || (list.get(last) < 0)){
                        last++;
                        list.add(asteroids[i]);
                    }else if(Math.abs(list.get(last)) ==  Math.abs(asteroids[i])){
                        list.remove(last);
                        last--;
                    }
                }
            }
            return list.stream().mapToInt(Integer::intValue).toArray();
        }
}
