# Corporate Flight Bookings

## Problem Statement
There are flights numbered 1 through N. A booking (first, last, seats) reserves seats on every flight from first through last, inclusive. Print the total seats booked on each flight.

## Input Format
    M N
    first1 last1 seats1
    ...
    firstM lastM seatsM

## Output Format
Print the booked-seat total for flights 1 through N, separated by spaces.

## Constraints
- 1 <= M, N <= 20000
- 1 <= first <= last <= N
- 1 <= seats <= 10000

## Example
Input:
    3 5
    1 2 10
    2 3 20
    2 5 25

Output:
    10 55 45 25 25

## Algorithm
Apply each inclusive booking as a difference-array boundary update, then prefix-sum the same array in place.

- Time: O(M + N)
- Space: O(N)

