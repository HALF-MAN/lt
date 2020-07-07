from typing import List
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        s = ""
        for _ in range(n):
            s = s + "."
        self.board = [s] * n
        self.result = []
        self.backtrack(self.board, 0)
        return self.result
    def backtrack(self, board, row):
        if row == len(board):
            self.result.append(board[:])
        n = len(board[row])    
        for col in range(n):
            if not self.valid(board, row, col):
                continue
            board[row][col] = board[row][:col] + 'Q' + board[row][(col+1):]
            self.backtrack(board, row + 1)
            board[row][col] = board[row][col].repalce('Q', '.')
    def valid(self, board, row, col):
        for i in range(len(board)):
            if board[i][col] == 'Q':
                return False
        for i in range(row - 1, -1, -1):
            for j in range(col + 1, len(board)):
                if board[i][j] == 'Q':
                    return False
        for i in range(row - 1, -1, -1):
            for j in range(col - 1, -1, -1):
                if board[i][j] == 'Q':
                    return False
        return True
if __name__ == "__main__":
    s = Solution()
    s.solveNQueens(3)
    pass