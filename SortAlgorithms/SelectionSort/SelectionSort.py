def quick_sort(arr):
    if len(arr) < 2:
        return arr
    else:
        mid = len(arr) // 2
        pivot = arr[mid]

        less = [x for i, x in enumerate(arr) if i != mid and x <= pivot]
        greater = [x for i, x in enumerate(arr) if i != mid and x > pivot]

        sorted_less = quick_sort(less)
        sorted_greater = quick_sort(greater)

        return sorted_less + [pivot] + sorted_greater

if __name__ == "__main__":
    array = [10, 80, 30, 90, 40, 50, 70]
    print("Array original:", array)

    sorted_list = quick_sort(array)
    print("Array ordenado:", sorted_list)
