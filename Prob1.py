class Solution:
    def countArrangement(self, n: int) -> int:
        #SC O(n) and TC O(n!)
        # temp=[i+1 for i in range(n)]
        # perm=itertools.permutations(temp) # n! time taken here
        # count=0

        # for p in perm:
        #     flag=True
        #     for i,v in enumerate(p):
        #         if (i+1)%v!=0 and v%(i+1)!=0:
        #             flag=False
        #             break

        #     if flag:
        #         count+=1
        # return count

        #SC O(n) and O(k) TC, where k=number of valid patterns
        count=0
        nums=[0 for i in range(n+1)]
        def helper(val):
            nonlocal count
            #base
            if val>n:
                count+=1
                return

            #logic
            for i in range(1,n+1):
                if nums[i]==0 and (i%val==0 or val%i==0):
                    nums[i]=val
                    helper(val+1)
                    nums[i]=0
        helper(1)
        return count
                

        