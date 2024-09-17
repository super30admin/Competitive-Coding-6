import heapq
class MedianFinder:
    # heap solution
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.minH=[]
        self.maxH = []
        

    def addNum(self, num: int) -> None:
        heapq.heappush(self.maxH,-1*num)
        heapq.heappush(self.minH,-1*heapq.heappop(self.maxH))
        
        if(len(self.maxH)<len(self.minH)):
            heapq.heappush(self.maxH,-1*heapq.heappop(self.minH))

    def findMedian(self) -> float:
        if(len(self.minH)<len(self.maxH)):
            # odd elements in the list
            return -1*heapq.nsmallest(1,self.maxH)[0]
        else:
            n1 = -1*heapq.nsmallest(1,self.maxH)[0]
            n2 = heapq.nsmallest(1,self.minH)[0]
            return (n1+n2)/2


# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()
