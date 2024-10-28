from collections import deque, defaultdict

def bf_search(graph, start, goal):
    queue = deque([[start]])
    visited = set()

    while queue:
        path = queue.popleft()
        node = path[-1]

        if node == goal:
            return path

        if node not in visited:
            visited.add(node)

            neighbors = graph.get(node, [])

            for neighbor in neighbors:
                new_path = list(path)
                new_path.append(neighbor)
                queue.append(new_path)

    return None

if __name__ == "__main__":
    graph = {
        "jato": ["tato", "gato"],
        "tato": ["chato"],
        "chato": ["gado"],
        "gato": ["gado", "grato"],
        "grato": ["gado"],
        "gado": []
    }

    start_node = "jato"
    goal_node = "gado"

    path = bf_search(graph, start_node, goal_node)

    if path:
        print("Menor caminho:", path)
    else:
        print("Caminho não encontrado.")
