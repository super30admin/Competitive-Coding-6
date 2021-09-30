# // Time Complexity :O(n!)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :quite tricky


# // Your code here along with comments explaining your approach




class Solution:
    def __init__(self):
        self.count=0
        
    def countArrangement(self, n: int) -> int:
        visited=[False for i in range(n+1)]
        arr=[]
        arr.append(0)
        for i in range(n):
            arr.append(i+1)
        print(arr)
        print(visited)
        self.helper(visited,[],arr,1)
        return self.count
    def helper(self,visited,path,arr,index):
        #base
        if len(path)==(len(arr)-1):
            self.count+=1
            return
        #logic
        
        for i in range(index,len(arr)):
        
            if visited[i]==False:
                path.append(arr[i])
                
                visited[i]=True
                j=len(path)
                if (i)%j==0 or j%(i)==0:
                    self.helper(visited,path,arr,1)
                a=path[-1]
                
                path.pop(-1)
                
                visited[a]=False
                

    