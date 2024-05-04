package leetcode.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 1436: Destination City

 * You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path
 * going from cityAi to cityBi. Return the destination city, that is, the city without any path outgoing to another city.

 * It is guaranteed that the graph of paths forms a line without any loop, therefore, there will
 * be exactly one destination city.

 * Example 1:
 * Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
 * Output: "Sao Paulo"
 * Explanation: Starting at "London" city you will reach "Sao Paulo" city which is the destination city. Your trip consist of: "London" -> "New York" -> "Lima" -> "Sao Paulo".

 * Example 2:
 * Input: paths = [["B","C"],["D","B"],["C","A"]]
 * Output: "A"
 * Explanation: All possible trips are:
 * "D" -> "B" -> "C" -> "A".
 * "B" -> "C" -> "A".
 * "C" -> "A".
 * "A".
 * Clearly the destination city is "A".

 * Example 3:
 * Input: paths = [["A","Z"]]
 * Output: "Z"
 *
 * @author rathi.prakhar@outlook.com
 */
public class DestinationCity {

    /**
     * Build an adjacency list (key, value) using a HashMap that stores paths from each city.
     * Iterate over the map to find which key (city) does not have a path to any city (empty list in value)
     */
    public String destCity(List<List<String>> paths) {
        if (paths == null || paths.isEmpty()) return "";

        Map<String, List<String>> graph = new HashMap();

        for (List<String> path: paths) {
            String from = path.get(0);
            String to = path.get(1);

            List<String> adj = graph.getOrDefault(from, new ArrayList<>());
            adj.add(to);
            graph.put(from, adj);

            if (!graph.containsKey(to)) {
                graph.put(to, new ArrayList<>());
            }
        }

        for (Map.Entry<String, List<String>> entry: graph.entrySet()) {
            if (entry.getValue().isEmpty()) {
                return entry.getKey();
            }
        }

        return "";
    }


    /**
     * Same approach as above, we replace the value in (key, value) by the count of out degree.
     * if (value == 0) ==> no out degree ==> answer
     */
    private String destCityTwo(List<List<String>> paths) {
        if (paths == null || paths.isEmpty()) return "";

        Map<String, Integer> graph = new HashMap<>();

        for (List<String> path : paths) {
            String from = path.get(0);
            String to = path.get(1);

            graph.put(from, graph.getOrDefault(from, 0) + 1);

            if (!graph.containsKey(to)) {
                graph.put(to, 0);
            }
        }

        for (Map.Entry<String, Integer> entry: graph.entrySet()) {
            if (entry.getValue() == 0) return entry.getKey();
        }

        return "";
    }
}
