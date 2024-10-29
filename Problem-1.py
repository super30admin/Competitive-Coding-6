# T.C = O(n!)(for the worst case otherwise it will be less than that) S.C = O(n)(the stack space)
class Solution(object):
    def countArrangement(self, n):
        """
        :type n: int
        :rtype: int
        """
        self.arr = []
        for i in range(1,n+1):
            self.arr.append(i)
        self.result = 0
        self.used = [None] * n
        self.helper(n,[])
        return (self.result)

    def helper(self,n,path):

        if(len(path) == len(self.arr)):
                self.result += 1  
                return

        #logic
        for j in range(len(self.arr)):
            if not self.used[j]:
                position = len(path) + 1
                if (self.arr[j] % position == 0 or position % self.arr[j] == 0):
                    self.used[j] = True
                    path.append(self.arr[j])
                    self.helper(n,path)
                    path.pop()
                    self.used[j] = False

        