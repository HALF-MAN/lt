class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        def neighbors(s):
            for i in range(4):
                for n in (1, -1):
                    yield s[:i] + str((int(s[i]) + n) % 10) + s[i + 1:]
            
        de = set(deadends)
        if '0000' in de: return -1
        
        q = deque([('0000', 0)])
        vis = set()
        
        while q:
            s, d = q.popleft()
            if s == target: return d
            
            for nei in neighbors(s):
                if nei not in vis and nei not in de:
                    vis.add(nei)
                    q.append((nei, d + 1))
                        
        return -1