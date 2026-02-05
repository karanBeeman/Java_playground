Technique	                                        ---- When to Use

1. Iteration /Linear scan	         ----  Finding min, max, sum, count occurrences
2. Two Pointers	                     ----  Reverse array, check palindrome, pair sum problems
3. Sliding Window	                 ----  Subarray sum, max/min in subarray
4. Hashing / Frequency Count	     ----  First non-repeating, duplicates, counts
5. Sorting + Search	                 ----  Median, k-th largest/smallest, remove duplicates
6. Prefix Sum / Cumulative Sum	     ----  Range sum queries, subarray sums


| Technique / Pattern                  | Common Data Structures          | Time Complexity (Best/Avg) | Example Problems                                                                        |
| ------------------------------------ | ------------------------------- | -------------------------- | --------------------------------------------------------------------------------------- |
| **Iteration / Linear Scan**          | Array, List, variables          | O(n)                       | Find max/min, sum, count occurrences, check for element                                 |
| **Two Pointers**                     | Array, List, maybe HashSet      | O(n)                       | Reverse array, palindrome check, pair sum problems, remove duplicates from sorted array |
| **Sliding Window**                   | Array, Queue / Deque, variables | O(n)                       | Max/min subarray sum, longest substring with k distinct, sum of subarray of size k      |
| **Hashing / Frequency Count**        | HashSet, HashMap, LinkedHashMap | O(n)                       | First non-repeating element, find duplicates, count frequency, subarray sum = k         |
| **Sorting + Search**                 | Array, List, PriorityQueue, Set | O(n log n) (sorting)       | Kth largest/smallest, median, remove duplicates, two-sum (sorted)                       |
| **Prefix Sum / Cumulative Sum**      | Array, HashMap                  | O(n)                       | Range sum queries, subarray sum = k, cumulative sum problems                            |
| **Binary Search / Divide & Conquer** | Array (sorted)                  | O(log n) / O(n log n)      | Search in sorted array, find peak element, rotated sorted array search                  |
