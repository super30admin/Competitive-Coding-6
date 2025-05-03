# 36. Valid Sudoku

# TC : O(1) because the board size is fixed at 9x9, which means we're always checking exactly 81 cells, each constant time.
# SC : O(1) because we're using a fixed amount of extra space (at most 9 elements in each set).
# Did this code successfully run on Leetcode : Yes

# Approach :
    # First, validate the board dimensions (though this is likely unnecessary for the problem).
    # Check each row to ensure it contains no duplicate digits (1-9).
    # Check each column to ensure it contains no duplicate digits.
    # Check each 3x3 sub-box to ensure it contains no duplicate digits.
    # Return true if all checks pass.

# Line-by-Line Explanation:
    # The first check validates that the board has the correct dimensions (9x9).
    # For each row, we create a set to track seen digits. If we find a duplicate or invalid digit, we return False.
    # Similarly, for each column, we check for duplicates.
    # For the 3x3 sub-boxes, we use nested loops to check each box. The outer loops (box_row, box_col) identify the top-left cell of each 3x3 box, and the inner loops check all cells within that box.
    # If all checks pass, we return True.

from typing import List, Optional

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        # Check if the board dimensions are valid
        if not board or len(board) != 9 or len(board[0]) != 9:
            return False
            
        # Check each row
        for row in range(9):
            row_set = set()
            for col in range(9):
                # Skip empty cells
                if board[row][col] == '.':
                    continue
                # Check if the digit is valid (1-9) and not repeated in the row
                digit = board[row][col]
                if not digit.isdigit() or int(digit) < 1 or int(digit) > 9 or digit in row_set:
                    return False
                row_set.add(digit)
        
        # Check each column
        for col in range(9):
            col_set = set()
            for row in range(9):
                # Skip empty cells
                if board[row][col] == '.':
                    continue
                # Check if the digit is not repeated in the column
                digit = board[row][col]
                if digit in col_set:
                    return False
                col_set.add(digit)
        
        # Check each 3x3 sub-box
        for box_row in range(0, 9, 3):
            for box_col in range(0, 9, 3):
                box_set = set()
                # Check all cells in the current 3x3 box
                for row in range(box_row, box_row + 3):
                    for col in range(box_col, box_col + 3):
                        # Skip empty cells
                        if board[row][col] == '.':
                            continue
                        # Check if the digit is not repeated in the box
                        digit = board[row][col]
                        if digit in box_set:
                            return False
                        box_set.add(digit)
        
        # If all checks pass, the board is valid
        return True