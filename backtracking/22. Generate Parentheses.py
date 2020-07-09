class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        track = []
        self.n = n
        self.result = []
        self.backtrack(n, n, track)
        return self.result
    def backtrack(self, left, right, track):
        if right < left:
            return
        if left < 0 or right < 0:
            return
        if left == 0 and right == 0:
            self.result.append(''.join(track[:]))
            return
        track.append('(')
        self.backtrack(left - 1, right, track)
        track.pop()

        track.append(')')
        self.backtrack(left, right - 1, track)
        track.pop()



    def backtrack1(self, i, track):
            if i == 2 * self.n:
                print(track)
            for ch in "()":
                track.apped(ch)
                self.backtrack(i + 1, track)
                track.pop()