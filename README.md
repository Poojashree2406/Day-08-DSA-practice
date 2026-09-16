# Two Pointers & Sliding Window — Java

## Study Date

**16 September 2026**

## Topic

**Two Pointers & Sliding Window Technique**

---

## Problems Covered

| No.   | LeetCode Problem                                                           | Difficulty | Main Technique         |
| ----- | -------------------------------------------------------------------------- | ---------- | ---------------------- |
| #881  | Boats to Save People                                                       | Medium     | Sorting + Two Pointers |
| #1004 | Max Consecutive Ones III                                                   | Medium     | Sliding Window         |
| #1208 | Get Equal Substrings Within Budget                                         | Medium     | Sliding Window         |
| #713  | Subarray Product Less Than K                                               | Medium     | Sliding Window         |
| #992  | Subarrays with K Different Integers                                        | Hard       | Sliding Window         |
| #1438 | Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit | Medium     | Sliding Window + Deque |

---

# 1. Boats to Save People — #881

### Problem Summary

Given an array representing people's weights and a boat weight limit, determine the minimum number of boats required when each boat can carry at most two people.

### Approach

Use **sorting + two pointers**.

* Sort the people by weight.
* `left` points to the lightest person.
* `right` points to the heaviest person.
* If both can fit together, move both pointers.
* Otherwise, send the heaviest person alone.
* Count each boat.

### Complexity

* Time: **O(n log n)**
* Space: **O(log n)**

### Key Concept

**Two Pointers after Sorting**

---

# 2. Max Consecutive Ones III — #1004

### Problem Summary

Given a binary array and an integer `k`, find the longest sequence of consecutive `1`s after changing at most `k` zeros into ones.

### Approach

Use a **variable-size sliding window**.

* Maintain a window using `left` and `right`.
* Count the zeros inside the window.
* If zeros exceed `k`, move `left` forward.
* Keep track of the maximum valid window length.

### Complexity

* Time: **O(n)**
* Space: **O(1)**

### Key Concept

**Sliding Window with At Most K Invalid Elements**

---

# 3. Get Equal Substrings Within Budget — #1208

### Problem Summary

Given two strings `s` and `t`, find the maximum length of a substring that can be changed from `s` to `t` without exceeding `maxCost`.

### Approach

Use a **sliding window**.

The cost for each position is:

`abs(s[i] - t[i])`

* Expand the window using `right`.
* Add the character conversion cost.
* If total cost exceeds `maxCost`, move `left`.
* Track the largest valid window.

### Complexity

* Time: **O(n)**
* Space: **O(1)**

### Key Concept

**Sliding Window with a Cost Constraint**

---

# 4. Subarray Product Less Than K — #713

### Problem Summary

Given an array of positive integers and an integer `k`, count the number of contiguous subarrays whose product is strictly less than `k`.

### Approach

Use a **sliding window**.

* Maintain a running product.
* Expand the window using `right`.
* If product becomes greater than or equal to `k`, move `left` until the product is valid.
* For every valid `right`, the number of new valid subarrays is:

`right - left + 1`

### Complexity

* Time: **O(n)**
* Space: **O(1)**

### Key Concept

**Sliding Window + Running Product**

### Important Edge Case

If `k <= 1`, the answer is `0` because all numbers are positive.

---

# 5. Subarrays with K Different Integers — #992

### Problem Summary

Count the number of contiguous subarrays containing exactly `k` distinct integers.

### Approach

Use the relationship:

`Exactly K = At Most K - At Most (K - 1)`

Create a helper function that counts subarrays containing **at most `k` distinct values**.

For each window:

* Add the current value to a frequency map.
* If the number of distinct values exceeds `k`, move `left`.
* Add `right - left + 1` to the result.

Finally:

`atMost(k) - atMost(k - 1)`

### Complexity

* Time: **O(n)**
* Space: **O(n)**

### Key Concept

**Sliding Window + Frequency Map + At Most K**

---

# 6. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit — #1438

### Problem Summary

Find the longest contiguous subarray where the difference between the maximum and minimum values is at most `limit`.

### Approach

Use a **sliding window with two monotonic deques**.

Maintain:

* A decreasing deque for maximum values.
* An increasing deque for minimum values.

For every new element:

1. Add it to both deques.
2. Check `max - min`.
3. If the difference exceeds `limit`, move `left`.
4. Remove elements that leave the window.
5. Track the maximum window length.

### Complexity

* Time: **O(n)**
* Space: **O(n)**

### Key Concept

**Sliding Window + Monotonic Deque**

---

# Techniques Learned

## Two Pointers

Two pointers are useful when processing an array from both ends or maintaining two positions.

Example:

```text
left →       ← right
[1, 2, 3, 4, 5]
```

Used in:

* #881 Boats to Save People

---

## Sliding Window

A sliding window maintains a contiguous portion of an array or string.

```text
left → [ window elements ] ← right
```

When the window becomes invalid, move `left`.

Used in:

* #1004
* #1208
* #713
* #992
* #1438

---

## Frequency Map

A frequency map stores how many times each value appears inside the current window.

Used in:

* #992

---

## Monotonic Deque

A monotonic deque maintains elements in increasing or decreasing order so that the minimum or maximum can be obtained efficiently.

Used in:

* #1438

---

# Complexity Summary

| Problem |       Time |    Space |
| ------- | ---------: | -------: |
| #881    | O(n log n) | O(log n) |
| #1004   |       O(n) |     O(1) |
| #1208   |       O(n) |     O(1) |
| #713    |       O(n) |     O(1) |
| #992    |       O(n) |     O(n) |
| #1438   |       O(n) |     O(n) |

---

# Test Cases

## #881 — Boats to Save People

```text
people = [1,2], limit = 3
Output = 1

people = [3,2,2,1], limit = 3
Output = 3

people = [3,5,3,4], limit = 5
Output = 4
```

## #1004 — Max Consecutive Ones III

```text
nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output = 6

nums = [1,1,1,1], k = 0
Output = 4

nums = [0,0,0], k = 1
Output = 1
```

## #1208 — Get Equal Substrings Within Budget

```text
s = "abcd", t = "bcdf", maxCost = 3
Output = 3

s = "abcd", t = "cdef", maxCost = 3
Output = 1

s = "abc", t = "abc", maxCost = 0
Output = 3
```

## #713 — Subarray Product Less Than K

```text
nums = [10,5,2,6], k = 100
Output = 8

nums = [1,2,3], k = 0
Output = 0

nums = [1,1,1], k = 2
Output = 6
```

## #992 — Subarrays with K Different Integers

```text
nums = [1,2,1,2,3], k = 2
Output = 7

nums = [1,2,1,3,4], k = 3
Output = 3

nums = [1,1,1], k = 1
Output = 6
```

## #1438 — Longest Continuous Subarray

```text
nums = [8,2,4,7], limit = 4
Output = 2

nums = [10,1,2,4,7,2], limit = 5
Output = 4

nums = [4,2,2,2,4,4,2,2], limit = 0
Output = 3
```

---

# Learning Outcomes

After completing these problems, I learned:

* How to use two pointers efficiently.
* How sorting can enable a two-pointer solution.
* How to build variable-size sliding windows.
* How to maintain constraints inside a window.
* How to count subarrays using `right - left + 1`.
* How to use frequency maps with sliding windows.
* How to solve **Exactly K** using **At Most K**.
* How monotonic deques maintain minimum and maximum values efficiently.
* How to analyze time and space complexity.

---



# Conclusion

These six LeetCode problems provide practice with different variations of the **Two Pointers and Sliding Window** techniques.

The problems progress from basic two-pointer movement to advanced sliding-window techniques involving frequency maps, running products, and monotonic deques.
