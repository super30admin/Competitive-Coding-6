# 515. Find Largest Value in Each Tree Row

# TC : O(n), where n is the number of nodes in the binary tree. Each node is processed exactly once.
# SC : O(w), where w is the maximum width of the tree, which in the worst case could be n/2 (when the last level is full).
# Did this code successfully run on Leetcode : Yes

# Approach :
# Using a Breadth-First Search (BFS) approach to traverse the tree level by level.
# For each level, I find the maximum value among all nodes at that level.
# I use a queue to keep track of nodes to process, ensuring I handle them level by level.
# At each level, I process all nodes currently in the queue, find the maximum value, and add children to the queue for the next level.

# Key Points:
    # BFS is the natural choice here because we need to process the tree level by level.
    # Using deque from the collections module provides efficient O(1) operations for both sides of the queue.
    # The algorithm correctly handles special cases like an empty tree.
    # This approach efficiently finds the maximum value for each level without requiring additional data structures to track level information.
# The resulting list contains the maximum value from each level, starting from the root level (level 0) and continuing downward.

from collections import deque
from typing import List, Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        # Handle empty tree case
        if not root:
            return []
        
        # Initialize result list to store maximum values for each level
        result = []
        
        # Queue for BFS traversal, starting with the root
        queue = deque([root])
        
        # Level-by-level BFS traversal
        while queue:
            # Track the maximum value at the current level
            level_max = float('-inf')
            
            # Process all nodes at current level
            level_size = len(queue)
            for _ in range(level_size):
                node = queue.popleft()
                
                # Update the maximum value for this level
                level_max = max(level_max, node.val)
                
                # Add children to the queue for the next level
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            
            # Add the maximum value for this level to the result
            result.append(level_max)
        
        return result