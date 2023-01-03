import java.util.*;

class SolutionWaterJug {
    public static void main(String args[]){
        int jug1Capacity = 7;
        int jug2Capacity=8;
        int targetCapacity = 5;
        int[] directions =  {jug1Capacity, -jug1Capacity, jug2Capacity, -jug2Capacity};
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        Map<Integer, List<Integer>> visited = new HashMap<>();
        visited.put(0,new ArrayList<>());
        int total = 0;
        boolean result = false;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            if(cur == targetCapacity){
                result = true;
                break;
            }
            for(int i=0;i<directions.length;i++){
                total = cur + directions[i];
                if(total == targetCapacity){
                    System.out.println("REached target, Values: total="+ total +" ,values in it: cur="+ cur+" and directions="+  directions[i]);

                    result = true;
                    break;

                }
                if(total < 0 || total > (jug1Capacity+jug2Capacity)){
                    continue;
                }
                if(!queue.contains(total) && !visited.containsKey(total)){
                    queue.add(total);
                    List a = new ArrayList();
                    a.add(cur);
                    a.add(directions[i]);
                    visited.put(total,a);
                    System.out.println("Values: total="+ total +" ,values in it: cur="+ cur+" and directions="+  directions[i]);
                }
            }
            if(result)
                break;
        }
        System.out.println(result);

    }
}