package Graphs.BFSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearch {

    public static List<String> bfSearch(Map<String, List<String>> graph, String start, String goal) {
        Queue<List<String>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(Collections.singletonList(start));
        
        while (!queue.isEmpty()) {
            List<String> path = queue.poll();
            String node = path.get(path.size() - 1);

            if (node.equals(goal)) {
                return path;
            }

            if (!visited.contains(node)) {
                visited.add(node);

                List<String> neighbors = graph.getOrDefault(node, new ArrayList<>());

                for (String neighbor : neighbors) {
                    List<String> newPath = new LinkedList<>(path);
                    newPath.add(neighbor);
                    queue.add(newPath);
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("jato", Arrays.asList("tato", "gato"));
        graph.put("tato", Arrays.asList("chato"));
        graph.put("chato", Arrays.asList("gado"));
        graph.put("gato", Arrays.asList("gado", "grato"));
        graph.put("grato", Arrays.asList("gado"));
        graph.put("gado", new ArrayList<>());

        String startNode = "jato";
        String goalNode = "gado";

        List<String> path = bfSearch(graph, startNode, goalNode);

        if (path != null) {
            System.out.println("Menor caminho: " + path);
        } else {
            System.out.println("Caminho não encontrado.");
        }
    }
}