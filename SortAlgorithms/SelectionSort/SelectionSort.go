package main

import (
	"fmt"
)

func quickSort(arr []int) []int {
	if len(arr) < 2 {
		return arr
	}

	mid := len(arr) / 2
	pivot := arr[mid]

	var less []int
	var greater []int

	for i, x := range arr {
		if i != mid {
			if x <= pivot {
				less = append(less, x)
			} else {
				greater = append(greater, x)
			}
		}
	}

	sortedLess := quickSort(less)
	sortedGreater := quickSort(greater)

	return append(append(sortedLess, pivot), sortedGreater...)
}

func main() {
	array := []int{10, 80, 30, 90, 40, 50, 70}
	fmt.Println("Array original:", array)

	sortedList := quickSort(array)
	fmt.Println("Array ordenado:", sortedList)
}
