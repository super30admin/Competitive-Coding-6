class Solution:
    def countArrangement(self, n: int) -> int:
        vac=[True]*n
        p=0
        count=0
        divisible=[]
        for _ in range(n):
            divisible.append([])
        def helper(vac, p, divisible):
            nonlocal count
            #base
            if p==len(vac):
                count+=1
                return
            #logic
            # making div list
            if len(divisible[p])==0:
                for i in range(1,n+1):
                    if (p+1)%i==0 or i%(p+1)==0:
                        divisible[p].append(i)
            
            

            for i in divisible[p]:
                if vac[i-1]:
                    vac[i-1]=False
                    #print(p, vac, i, divisible)
                    helper(vac, p+1, divisible)
                    #backtrack
                    vac[i-1]=True
        
        helper(vac, 0, divisible)
        return count
                    
        