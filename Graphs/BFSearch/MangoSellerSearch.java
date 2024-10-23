package Graphs.BFSearch;

import java.util.*;

public class MangoSellerSearch {

    private static Map<String, List<String>> graph = new HashMap<>();

    static {
        graph.put("you", Arrays.asList("alice", "bob", "claire"));
        graph.put("bob", Arrays.asList("anuj", "peggy"));
        graph.put("alice", Arrays.asList("peggy"));
        graph.put("claire", Arrays.asList("thom", "jonny"));
        graph.put("anuj", new ArrayList<>());
        graph.put("peggy", new ArrayList<>());
        graph.put("thom", new ArrayList<>());
        graph.put("jonny", new ArrayList<>());
    }

    public static boolean search(String name) {
        Queue<String> queue = new LinkedList<>(graph.get(name));
        List<String> checked = new ArrayList<>();

        while (!queue.isEmpty()) {
            String person = queue.poll();

            if (!checked.contains(person)) {
                if (isMangoSeller(person)) {
                    System.out.println(person + " is a mango seller!");
                    return true;
                } else {
                    queue.addAll(graph.get(person));
                    checked.add(person);
                }
            }
        }
        return false;
    }

    public static boolean isMangoSeller(String person) {
        return person.endsWith("m");
    }

    public static void main(String[] args) {
        search("you");
    }
}

