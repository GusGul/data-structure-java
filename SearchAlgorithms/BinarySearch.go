package main

import (
	"fmt"
)

func binarySearch(arr []int, target int) int {
	count := 0
	left := 0
	right := len(arr) - 1

	for left <= right {
		count++
		mid := left + (right-left)/2

		if arr[mid] == target {
			fmt.Printf("Número de iterações: %d\n", count)
			return mid
		}

		if arr[mid] < target {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}

	return -1
}

func main() {
	arr := []int{1, 3, 5, 7, 9, 11, 13, 15, 17, 19}
	target := 7

	result := binarySearch(arr, target)

	if result == -1 {
		fmt.Println("Elemento não encontrado.")
	} else {
		fmt.Printf("Elemento encontrado no índice: %d\n", result)
	}
}
