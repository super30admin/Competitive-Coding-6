# Solution

# // Time Complexity : O(n!) - Factorial since we need to check almost all permuations to decide if the result is Beautiful
# // Space Complexity : O(n) max size of implicit stack due to recursion
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Made a mistake on deciding global/local variable. The check on deciding if path is
# complete I had done it before checking the validity of last element added to list, resulting in giving more answers than actual


# // Your code here along with comments explaining your approach
# Approach is to use a backtracking(with for loop based recurison) to come up with all the possible permutations. But for each
# permuation, as we are adding the element we can keep checking if that is satisfying the beautiful conditions, if not then just
# return and ignore that particular permutaion. This helps save some time. If the first element itself is not working then we come
# out

count = 0
def countArrangement(n):
    input = [i+1 for i in range(n)]
    indexDict = {}
    global count
    count = 0    

    def helper(input,indexDict,n,path):
        global count
        
        index = len(path)
        if index>0 and path[index-1]%index != 0 and index%path[index-1] != 0:
            return

        if len(path) == n:
            count += 1
            return

        for i in range(n):
            if i not in indexDict:
                path.append(input[i])
                indexDict[i] = True
                helper(input,indexDict,n,path)
                del indexDict[i]
                path.pop()

    helper(input,indexDict,n,[])
    return count

if __name__ == "__main__":
    n = 4
    print(countArrangement(n))