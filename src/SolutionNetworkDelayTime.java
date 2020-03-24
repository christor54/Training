import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SolutionNetworkDelayTime {

    public static void main(String[] args) {
        int[][] times = new int[][]{{2,1,1},{2,3,1},{3,4,1}};
        SolutionNetworkDelayTime sol = new SolutionNetworkDelayTime();
        sol.networkDelayTime(times, 4, 2);
    }


    public int networkDelayTime(int[][] times, int N, int K) {
        if(times == null) return 0;
        int [] max = new int [1];
        //2 -> [1, 1], [3, 1]
        Map<Integer, List<int[]>> graph = buildGraphMap(times);
        Set<Integer> visited = new HashSet<>();
        dfs(graph, K, 0, max, visited, N);
        if(visited.size() < N) max[0] =-1;
        return max[0];
    }

    void dfs(Map<Integer, List<int[]>> graph, int K, int acc, int[] max, Set<Integer> visited, int N){
        System.out.println("visiting "+ K);
        visited.add(K);
        if(graph.get(K) == null){
            max[0] = Math.max(acc, max[0]);
            return;
        }
        for(int i=0; i< graph.get(K).size(); i++){
            int [] dest = graph.get(K).get(i);
            int next = dest[0];//label of the dest
            if(visited.contains(next)){
                continue;
            }
            dfs(graph, next, acc + dest[1], max, visited, N);
        }

    }

    Map<Integer, List<int[]>> buildGraphMap(int[][] times){
        Map<Integer, List<int[]>> map = new HashMap();
        for(int i=0; i < times.length; i++){
            int [] dest = new int[] {times[i][1], times[i][2]};
            if(!map.containsKey(times[i][0])){
                List<int[]> list = new ArrayList<>();
                list.add(dest);
                map.put(times[i][0], list);
            }else {
                map.get(times[i][0]).add(dest);
//                List<int[]> list = map.get(times[i][0]);
//                list.add(dest);
//                map.put(times[i][0], list);
            }
            System.out.println(times[i][0] + " -> [" + dest[0] + "," + dest[1] + "]");
        }
        return map;
    }

}
