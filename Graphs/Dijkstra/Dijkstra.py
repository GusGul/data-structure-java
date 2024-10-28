graph = {
    "start": {"a": 6, "b": 2},
    "a": {"end": 1},
    "b": {"a": 3, "end": 5},
    "end": {}
}

INFINITY = float("inf")

costs = {
    "a": 6,
    "b": 2,
    "end": INFINITY
}

parents = {
    "a": "start",
    "b": "start",
    "end": None
}

processed = set()

def find_lowest_cost_node(costs):
    lowest_cost = INFINITY
    lowest_cost_node = None
    for node in costs:
        cost = costs[node]
        if cost < lowest_cost and node not in processed:
            lowest_cost = cost
            lowest_cost_node = node
    return lowest_cost_node

def get_path():
    path = ["end"]
    parent = parents["end"]
    while parent is not None:
        path.insert(0, parent)
        parent = parents[parent]
    return " -> ".join(path)

def main():
    node = find_lowest_cost_node(costs)
    while node is not None:
        cost = costs[node]
        neighbors = graph[node]
        for neighbor in neighbors:
            new_cost = cost + neighbors[neighbor]
            if costs.get(neighbor, INFINITY) > new_cost:
                costs[neighbor] = new_cost
                parents[neighbor] = node
        processed.add(node)
        node = find_lowest_cost_node(costs)
    
    print("Path:", get_path())

if __name__ == "__main__":
    main()
