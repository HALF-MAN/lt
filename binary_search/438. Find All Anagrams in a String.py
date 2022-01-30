class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        need = {}
        window = {}
        left = right = 0
        valid = 0
        result = []
        for k in p:
            if k in need:
                need[k] += 1
            else:
                need[k] = 1
            window[k] = 0        
        while right < len(s):
            c = s[right]
            right += 1
            if c in need:
                window[c] += 1
                if window[c] == need[c]:
                    valid += 1
            while right - left >= len(p):
                if valid == len(need):
                    result.append(left)
                b = s[left]
                left += 1
                if b in need:
                    if window[b] == need[b]:
                        valid -= 1
                    window[b] -= 1
        return result
if __name__ == "__main__":
    s = "baa"
    p = "aa"
    ob = Solution()
    print(ob.findAnagrams(s,p))