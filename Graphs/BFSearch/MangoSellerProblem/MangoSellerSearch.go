package main

import (
	"fmt"
)

var graph = map[string][]string{
	"you":    {"alice", "bob", "claire"},
	"bob":    {"anuj", "peggy"},
	"alice":  {"peggy"},
	"claire": {"thom", "jonny"},
	"anuj":   {},
	"peggy":  {},
	"thom":   {},
	"jonny":  {},
}

func search(name string) bool {
	queue := append([]string{}, graph[name]...)
	checked := make(map[string]bool)

	for len(queue) > 0 {
		person := queue[0]
		queue = queue[1:]

		if !checked[person] {
			if isMangoSeller(person) {
				fmt.Println(person, "is a mango seller!")
				return true
			} else {
				queue = append(queue, graph[person]...)
				checked[person] = true
			}
		}
	}
	return false
}

func isMangoSeller(person string) bool {
	return len(person) > 0 && person[len(person)-1] == 'm'
}

func main() {
	search("you")
}
