class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        mp = {}
        left = right = 0
        res = 0
        for right in range(len(s)):
            if s[right] in mp:
                left = max(mp[s[right]], left)
            res = max(right - left + 1, res)
            mp[s[right]] = right + 1
        return res
if __name__ == "__main__":
    s = Solution()
    s.lengthOfLongestSubstring("tmmzuxt")