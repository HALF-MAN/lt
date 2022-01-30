import sys
class Solution(object):
    def minWindow(self, s, t):
        if len(t) > len(s):
            return ""
        need = {}
        window = {}
        for char in t:
            if char in need:
                need[char] += 1
            else:
                need[char] = 1
            window[char] = 0
        left = right = 0
        valid = 0
        start = 0
        minL = sys.maxsize
        while right < len(s):
            c = s[right]
            right += 1
            if c in need:
                window[c] += 1
                if window[c] == need[c]:
                    valid += 1
            while valid == len(need):
                if right - left < minL:
                    start = left
                    minL = right - left
                d = s[left]
                left += 1
                if d in need:
                    if window[d] == need[d]:
                        valid -= 1
                    window[d] -= 1
        return  "" if minL == sys.maxsize else s[start:start+minL]

if __name__ == "__main__":
    S = "a"
    T = "b"
    s = Solution()
    print(s.minWindow(S,T))