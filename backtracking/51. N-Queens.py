from typing import List
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        
        board = [['.'] * n for _ in range(n)]
        self.n = n
        self.result = []
        self.col = [False] * n
        self.diag, self.codiag = set(), set()
        self.backtrack(board, 0)
        return self.result
    def backtrack(self, board, row):
        if row == self.n:
            strTmp = [''.join(row) for row in board]
            self.result.append(strTmp)
        for c in range(self.n):
            if self.valid(row, c):
                board[row][c] = 'Q'
                self.col[c] = True
                self.diag.add(row+c)
                self.codiag.add(row-c)
                self.backtrack(board, row + 1)
                board[row][c] = '.'
                self.col[c] = False
                self.diag.remove(row+c)
                self.codiag.remove(row-c)
    def valid(self, row, col):
        return not (self.col[col] or row+col in self.diag or row-col in self.codiag)
if __name__ == "__main__":
    s = Solution()
    s.solveNQueens(3)
    pass