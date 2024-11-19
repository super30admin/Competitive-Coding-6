class Solution:
    count =0
    
    def countArrangement(self, n: int) -> int:
        
        if not n:
            return
        
        array = list(range(n))
        print (array)
        path = set()
        
        #print (visited)    
        self.helper(array,1,path)
        return Solution.count
    
    def helper(self,array,index,path):
        
       
    #base
        if index == len(array)+1:
            Solution.count += 1
            return

    #logic
        
        for i in range(1,len(array)+1):
            if i not in path and (index %  i == 0 or  i % index == 0):  
                path.add(i)
                #print(path)
                self.helper(array,index+1,path)
                path.remove(i)
