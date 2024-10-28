package main

import (
	"fmt"
)

func bfSearch(graph map[string][]string, start, goal string) []string {
	queue := [][]string{{start}}
	visited := make(map[string]bool)

	for len(queue) > 0 {
		path := queue[0]
		queue = queue[1:]

		node := path[len(path)-1]

		if node == goal {
			return path
		}

		if !visited[node] {
			visited[node] = true
			neighbors := graph[node]

			for _, neighbor := range neighbors {
				newPath := append([]string{}, path...)
				newPath = append(newPath, neighbor)
				queue = append(queue, newPath)
			}
		}
	}

	return nil
}

func main() {
	graph := map[string][]string{
		"jato":  {"tato", "gato"},
		"tato":  {"chato"},
		"chato": {"gado"},
		"gato":  {"gado", "grato"},
		"grato": {"gado"},
		"gado":  {},
	}

	startNode := "jato"
	goalNode := "gado"

	path := bfSearch(graph, startNode, goalNode)

	if path != nil {
		fmt.Println("Menor caminho:", path)
	} else {
		fmt.Println("Caminho não encontrado.")
	}
}
