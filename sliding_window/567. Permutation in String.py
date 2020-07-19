class Solution(object):
    def checkInclusion(self, s1, s2):
        """
        :type s1: str
        :type s2: str
        :rtype: bool
        """
        need = {}
        window = {}
        for char in s1:
            if char in need:
                need[char] += 1
            else:
                need[char] = 1
            window[char] = 0
        left = right = 0
        valid = 0
        while right < len(s2):
            c = s2[right]
            right += 1
            if c in need:
                window[c] += 1
                if window[c] == need[c]:
                    valid += 1
            while right - left >= len(s1):
                if valid == len(need):
                    return True
                d = s2[left]
                left += 1
                if d in need:
                    if window[d] == need[d]:
                        valid -= 1
                    window[d] -= 1
        return False

if __name__ == "__main__":
    S = "ab"
    T = "blaoo"
    s = Solution()
    print(s.checkInclusion(S,T))
