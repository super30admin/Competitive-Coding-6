class Solution:
    def countArrangement(self, n: int) -> int:
        arr = []
        for i in range(n):
            arr.append(i+1)
        self.count = 0
        def checkDiv(i: int, temp: list):
            if i<= 1:
                self.count = self.count+1
                return
            for j,k in enumerate(temp):
                if i%k ==0 or k%i ==0:
                    checkDiv(i-1, temp[:j] + temp[j+1:])
        checkDiv(n, arr)
        return self.count
