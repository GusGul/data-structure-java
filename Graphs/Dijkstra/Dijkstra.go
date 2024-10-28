package main

import (
	"fmt"
	"math"
)

var graph = map[string]map[string]int{
	"start": {"a": 6, "b": 2},
	"a":     {"end": 1},
	"b":     {"a": 3, "end": 5},
	"end":   {},
}

const infinity = math.MaxInt32

var costs = map[string]int{
	"a":   6,
	"b":   2,
	"end": infinity,
}

var parents = map[string]string{
	"a":   "start",
	"b":   "start",
	"end": "",
}

var processed = map[string]bool{}

func findLowestCostNode(costs map[string]int) string {
	lowestCost := infinity
	lowestCostNode := ""

	for node, cost := range costs {
		if cost < lowestCost && !processed[node] {
			lowestCost = cost
			lowestCostNode = node
		}
	}
	return lowestCostNode
}

func getPath() string {
	path := "end"
	node := parents["end"]
	for node != "" {
		path = node + " -> " + path
		node = parents[node]
	}
	return path
}

func main() {
	node := findLowestCostNode(costs)
	for node != "" {
		cost := costs[node]
		neighbors := graph[node]
		for neighbor, weight := range neighbors {
			newCost := cost + weight
			if newCost < costs[neighbor] {
				costs[neighbor] = newCost
				parents[neighbor] = node
			}
		}
		processed[node] = true
		node = findLowestCostNode(costs)
	}

	fmt.Println("Path:", getPath())
}
