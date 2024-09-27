#Problem 2: Letter Case Permutation
#Time Complexity: O(n*2^n)
#Space Complexity: O(n*2^n)
'''
We iterate through S, start with index 0. If it's a number
we add it to the memory and call the recursion on the next index
and then backtrack. If it's a letter, we do the same thing, one
time with upper case, and second time with lower case, while backtracking
accordingly.
'''
class Solution:
    def letterCasePermutation(self, S: str) -> List[str]:
        #edge case
        if not S:
            return []
        #initialisation
        res=[]
        memory=[]
        #recursive function
        def helper(index):
            #base case
            if index==len(S):
                res.append("".join(memory))
                return
            #recurse
            if S[index].isalpha():
                letter=S[index].lower()
                memory.append(letter)
                helper(index+1)
                memory.pop()

                letter=letter.upper()
                memory.append(letter)
                helper(index+1)
                memory.pop()
            else:
                memory.append(S[index])
                helper(index+1)
                memory.pop()

        #call function
        helper(0)
        return res
