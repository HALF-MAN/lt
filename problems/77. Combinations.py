class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        self.result = []
        track = []
        self.backtrack(n, 1, track, k)
        return self.result
    def backtrack(self, n, start, track, k):
        if len(track) == k:
            self.result.append(track[:])
            return
        for i in range(start, n + 1):
            track.append(i)
            self.backtrack(n, i + 1, track, k)
            track.pop()