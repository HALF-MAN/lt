class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        self.backtrack(board, 0, 0)
    def backtrack(self, board, row, col):
        if col == 9:
            return self.backtrack(board, row + 1, 0)
            
        if row == 9:
            return True
        
        if board[row][col] != ".":
            return self.backtrack(board, row, col + 1)
        
        for ch in "123456789":
            if self.isvalid(board, row, col, ch):
                board[row][col] = ch
                if self.backtrack(board, row, col + 1):
                    return True
                board[row][col] = "."
    def isvalid(self, board, row, col, ch):
        for i in range(0,9):
            if board[row][i] == ch:
                return False
            if board[i][col] == ch:
                return False
            if board[(row//3)*3 + i//3][(col//3) * 3 + i % 3] == ch:
                return False
        return True