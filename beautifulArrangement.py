class Solution:
    def countArrangement(self, n: int) -> int:
        if n == 1: return 1
        res = 0
        #sofar can be set ?
        def helper(sofar):
            if len(sofar) == n+1:
                nonlocal res
                res += 1
                return
            
            for i in range(1, n+1):
                if i not in sofar:
                    if i %(len(sofar)) == 0 or (len(sofar)) % i == 0:
                        sofar.append(i)
                        helper(sofar)
                        sofar.pop()
            return
    
        helper([0])
        return res
        
