'''
526 Beautiful Arrangement
https://leetcode.com/problems/beautiful-arrangement/

Suppose you have n integers labeled 1 through n. A permutation of those n integers perm (1-indexed) is considered a beautiful arrangement if for every i (1 <= i <= n), either of the following is true:

perm[i] is divisible by i.
i is divisible by perm[i].
Given an integer n, return the number of the beautiful arrangements that you can construct.

Example 1:
Input: n = 2
Output: 2
Explanation:
The first beautiful arrangement is [1,2]:
    - perm[1] = 1 is divisible by i = 1
    - perm[2] = 2 is divisible by i = 2
The second beautiful arrangement is [2,1]:
    - perm[1] = 2 is divisible by i = 1
    - i = 2 is divisible by perm[2] = 1

Example 2:
Input: n = 1
Output: 1

Constraints:
1 <= n <= 15

Solution:
1. Backtracking using for-loop recursion (brute force):
Generate all possible permutations from numbers 1...n using a for loop based recursion. At the terminating condition (where a permutation sequence of length n has been generated), check if the permutation is a beautiful arrangement or not. The beautiful arrangement condition is:
number % index == 0 or index % number == 0
If it is, increase the count of beautiful arrangements by 1.

Time is O(n!) = O(n^n) since there are n! permutations for a given n.
Space is n for visited array and n for the recursion call stack.
Time: O(n!), Space: O(n+n) = O(n)

2. Backtracking using for-loop recursion (optimal):
Insteaad of generate all possible permutations from numbers 1...n using a for loop based recursion, recurse only if the current number being explored in the permutation sequence satisfies the beautiful arrangement property. For eg, if n = 4, and the perm seq is [1,3,*,*], index = 2, current number = 3, then we are in the process of exploring the 2nd number (index = 2) in the permutation sequence. We know that this number will not satisfy the beautiful arrangement condition since 3%2 !=0, 2%3 !=0. Hence, we discard this sequence at this step and don't traverse further.

Time is O(m), where m = number of beautiful arrangements, then m << n! since there much fewer beautiful arrangements than the no. of permutations.
Space is n for visited array and n for the recursion call stack.
Time: O(m), Space: O(n+n) = O(n)
'''

def countArrangement_1(n):
    ''' Time: O(n!), Space: O(n) '''
    def is_beautiful(arr, n):
        for i in range(n):
            v1, v2 = arr[i]%(i+1), (i+1)%arr[i]
            if  v1 == 0 or v2 == 0:
                continue
            else:
                return False
        return True

    def recurse(path):
        nonlocal count
        # base
        if len(path) == n:
            if is_beautiful(path, n):
                #result.append(path.copy())
                count += 1
            return

        # logic
        for i in range(n):
            if not visited[i]:
                path.append(i+1)
                visited[i]=True
                recurse(path)
                path.pop()
                visited[i]=False
        return

    if n <= 0:
        return 0

    count=0
    visited= [False]*n
    #result=[] # store all the beautifuls in result
    path=[]
    recurse(path)
    return count#, result

def countArrangement_2(n):
    ''' Time: O(m), Space: O(n)
        m = no. of beautiful arrangements << 2^n
    '''
    def recurse(index):
        nonlocal count
        # base
        if index > n:
            count += 1
            return

        # logic
        for i in range(1,n+1):
            number = i
            if not visited[i-1] and (index%number==0 or number%index == 0):
                visited[i-1] = True # Action
                #print(f"Accept: ind={index}, num={number}, visit={visited}")
                recurse(index+1) # Recursion
                visited[i-1] = False # Backtrack
            #else:
                #print(f"Reject: ind={index}, num={number}, visit={visited}")
        return

    visited = [False]*n
    count=0
    # start recursion by passing the first index. For a 1-indexed seq., first index = 1
    recurse(1)
    return count

def run_countArrangement():
    tests = [(2, [[1,2], [2,1]]),
             (3, [[1,2,3], [2,1,3], [3,2,1]]),
             (4, [[1,2,3,4],[1,4,3,2],[2,1,3,4],[2,4,3,1],[3,2,1,4],[3,4,1,2], [4,1,3,2],[4,2,3,1]]),
             (1, [[1]]),
             (5, [[1,2,3,4,5], [1,4,3,2,5], [2,1,3,4,5], [2,4,3,1,5], [3,2,1,4,5], [3,4,1,2,5], [4,1,3,2,5], [4,2,3,1,5], [5,2,3,4,1], [5,4,3,2, 1]]),]
    for test in tests:
        n, ans = test[0], test[1]
        print(f"\nn = {n}")
        for method in ['for-loop-backtrack-1', 'for-loop-backtrack-2']:
            if method == 'for-loop-backtrack-1':
                count = countArrangement_1(n)
            elif method == 'for-loop-backtrack-2':
                count = countArrangement_2(n)
            print(f"{method}: Number of permutations = {count}")
            print(f"Pass: {len(ans) == count}")

run_countArrangement()