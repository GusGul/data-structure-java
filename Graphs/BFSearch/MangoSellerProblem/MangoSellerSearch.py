from collections import deque

# Define o grafo como um dicionário de listas
graph = {
    "you": ["alice", "bob", "claire"],
    "bob": ["anuj", "peggy"],
    "alice": ["peggy"],
    "claire": ["thom", "jonny"],
    "anuj": [],
    "peggy": [],
    "thom": [],
    "jonny": []
}

def search(name):
    queue = deque(graph[name])
    checked = []

    while queue:
        person = queue.popleft()

        if person not in checked:
            if is_mango_seller(person):
                print(person + " is a mango seller!")
                return True
            else:
                queue.extend(graph[person])
                checked.append(person)

    return False

def is_mango_seller(person):
    return person.endswith("m")

if __name__ == "__main__":
    search("you")
