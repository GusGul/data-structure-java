package Graphs.Dijkstra;

import java.util.HashMap;
import java.util.Map;

public class Dijkstra {
    private static Map<String, Map<String, Integer>> graph = new HashMap<>();

    static {
        graph.put("start", new HashMap<>());
        graph.get("start").put("a", 6);
        graph.get("start").put("b", 2);

        graph.put("a", new HashMap<>());
        graph.get("a").put("end", 1);
        
        graph.put("b", new HashMap<>());
        graph.get("b").put("a", 3);
        graph.get("b").put("end", 5);

        graph.put("end", new HashMap<>());
    }

    private static final int INFINITY = Integer.MAX_VALUE;

    private static Map<String, Integer> costs = new HashMap<>();

    static {
        costs.put("a", 6);
        costs.put("b", 2);
        costs.put("end", INFINITY);
    }

    private static Map<String, String> parents = new HashMap<>();

    static {
        parents.put("a", "start");
        parents.put("b", "start");
        parents.put("end", null);
    }

    private static Map<String, Boolean> processed = new HashMap<>();

    public static void main(String[] args) {
        String node = findLowestCostNode(costs);

        while (node != null) {
            int cost = costs.get(node);
            Map<String, Integer> neighbors = graph.get(node);

            for (String neighbor : neighbors.keySet()) {
                int newCost = cost + neighbors.get(neighbor);
                if (costs.get(neighbor) > newCost) {
                    costs.put(neighbor, newCost);
                    parents.put(neighbor, node);
                }
            }

            processed.put(node, true);
            node = findLowestCostNode(costs);
        }

        System.out.println("Path: " + getPath());
    }

    private static String findLowestCostNode(Map<String, Integer> costs) {
        int lowestCost = INFINITY;
        String lowestCostNode = null;

        for (Map.Entry<String, Integer> entry : costs.entrySet()) {
            String node = entry.getKey();
            int cost = entry.getValue();
            if (cost < lowestCost && !processed.containsKey(node)) {
                lowestCost = cost;
                lowestCostNode = node;
            }
        }

        return lowestCostNode;
    }

    private static String getPath() {
        StringBuilder path = new StringBuilder("end");
        String parent = parents.get("end");

        while (parent != null) {
            path.insert(0, parent + " -> ");
            parent = parents.get(parent);
        }

        return path.toString();
    }
}
