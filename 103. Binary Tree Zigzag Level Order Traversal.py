#space: O(h- recursive stack height)
#Time: O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None:
            return []
        self.main = list(list())
        self.dfs(root, 0)
        return self.main

    def dfs(self, root, lvl):
        if root == None:
            return
        
        while( len(self.main) <= lvl):
            self.main.append([])
        print('main', self.main)
        if lvl %2 != 0:
            tmp= self.main[lvl]
            tmp.insert(0, root.val)  
            self.main[lvl]= tmp
        else:
            tmp= self.main[lvl]
            tmp.append(root.val) 
            self.main[lvl]= tmp

        self.dfs(root.left, lvl+1)
        self.dfs(root.right, lvl+1)

        return
        
        #BFS solution
        #q= list()
        # q.append(root)
        # lvl=0
        # main= list(list())
        # while( len(q) != 0):
        #     temp= list()
        #     size= len(q)
        #     # print('q size', size)
        #     if lvl %2 == 0 :
        #         for i in range(size):
        #             tmpnode= q[i]
        #             temp.append(tmpnode.val)
        #     else:
        #         for i in range(size-1,-1,-1):
        #             tmpnode= q[i]
        #             temp.append(tmpnode.val)
        #     main.append(temp)
        #     for _ in range(size):
        #         node= q.pop(0)
        #         if node.left != None:
        #             q.append(node.left)
        #         if node.right != None:
        #             q.append(node.right)
        #     lvl+=1
