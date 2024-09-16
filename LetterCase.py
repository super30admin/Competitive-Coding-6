"""
The approach here is to start from the first index of the string, if it's a alphabet then call the lower 
and upper case functions on the alphabets recursively, else if it is a number we move on. this way we 
explore all paths and find the all possible combinations.
Time complexity - O(N)
Space complexity - O(N)
"""
def letterCasePermutation(self, S):
		self.res = []
		self.dfs(S,'',0)
		return self.res

	def dfs(self,S,path,index):
		if index==len(S):
			self.res.append(path)            
			return

		if S[index].isalpha():
			self.dfs(S,path+S[index].lower(),index+1)
			self.dfs(S,path+S[index].upper(),index+1)
		else:
			self.dfs(S,path+S[index],index+1)