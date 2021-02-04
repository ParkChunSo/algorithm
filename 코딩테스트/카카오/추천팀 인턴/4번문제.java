import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'order' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. UNWEIGHTED_INTEGER_GRAPH city
     *  2. INTEGER company
     */

    /*
     * For the unweighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] and <name>To[i].
     *
     */

    public static List<Integer> order(int cityNodes, List<Integer> cityFrom, List<Integer> cityTo, int company) {
        List<List<Integer>> map = new ArrayList<>();
        for(int i = 0 ; i <= cityNodes ; i++){
            map.add(new ArrayList<>());
        }
        for(int i = 0 ; i < cityFrom.size() ; i++){
            map.get(cityFrom.get(i)).add(cityTo.get(i));
            map.get(cityTo.get(i)).add(cityFrom.get(i));
        }
        
        for(int i = 1 ; i <map.size() ; i++){
            map.get(i).sort(Comparator.naturalOrder());
        }
        
        List<Integer> answer = new ArrayList<>();
        boolean[] visited = new boolean[cityNodes+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(company);
        visited[company] = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            PriorityQueue<Integer> q = new PriorityQueue<>();
            for(int k = 0 ; k < size ; k++){
                int poll = queue.poll();
                List<Integer> list = map.get(poll);
                for(int i = 0 ; i < list.size() ; i++){
                    if(visited[list.get(i)])
                        continue;
                    queue.offer(list.get(i));
                    q.offer(list.get(i));
                    visited[list.get(i)] = true;
                }
            }
            while(!q.isEmpty()){
                int poll = q.poll();
                if(poll != company)
                    answer.add(poll);
            }
        }
        return answer;
    }

}
public class Solution {