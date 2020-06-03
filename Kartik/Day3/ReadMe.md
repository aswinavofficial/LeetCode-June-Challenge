Question:

There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].

Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.

 

Example 1:

Input: [[10,20],[30,200],[400,50],[30,20]]
Output: 110
Explanation: 
The first person goes to city A for a cost of 10.
The second person goes to city A for a cost of 30.
The third person goes to city B for a cost of 50.
The fourth person goes to city B for a cost of 20.

The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
 

Note:

1 <= costs.length <= 100
It is guaranteed that costs.length is even.
1 <= costs[i][0], costs[i][1] <= 1000

Approach:

1. Add the cost of going to city A for all attendants.
2. Find the difference between going to B and going to A.This will give us the cost of going to city B instead of A.
3. Sort #2. We find those N cities where we'd rather go to B over A.
4. Add first N of array from #2 to #1 and return.

Reference: https://leetcode.com/problems/two-city-scheduling/discuss/667786/Java-or-C%2B%2B-or-Python3-or-With-detailed-explanation
