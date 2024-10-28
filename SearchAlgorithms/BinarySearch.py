def binary_search(arr, target):
    count = 0
    left = 0
    right = len(arr) - 1

    while left <= right:
        count += 1
        mid = left + (right - left) // 2

        if arr[mid] == target:
            print(f"Número de iterações: {count}")
            return mid

        if arr[mid] < target:
            left = mid + 1
        else:
            right = mid - 1

    return -1

if __name__ == "__main__":
    arr = [1, 3, 5, 7, 9, 11, 13, 15, 17, 19]
    target = 7

    result = binary_search(arr, target)

    if result == -1:
        print("Elemento não encontrado.")
    else:
        print(f"Elemento encontrado no índice: {result}")
