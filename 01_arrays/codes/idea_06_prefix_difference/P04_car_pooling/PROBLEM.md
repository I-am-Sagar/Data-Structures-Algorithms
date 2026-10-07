# Car Pooling

## Problem Statement
A trip is (passengers, from, to): passengers are picked up at from and dropped before location to. Given all trips and vehicle capacity, print whether the vehicle can complete every trip without exceeding capacity.

## Input Format
    M capacity
    passengers1 from1 to1
    ...
    passengersM fromM toM

## Output Format
Print true if capacity is never exceeded; otherwise print false.

## Constraints
- 1 <= M <= 1000
- 1 <= capacity <= 100000
- 0 <= from < to <= 1000

## Example
Input:
    2 4
    2 1 5
    3 3 7

Output:
    false

## Algorithm
Use a timeline difference array: add passengers at pickup and subtract them at drop-off. A prefix sweep gives the current load at each location.

- Time: O(M + 1001)
- Space: O(1001)

