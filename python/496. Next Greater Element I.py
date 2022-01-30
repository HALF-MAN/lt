class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        a = []
        result = []
        mp = {}
        for i in range(len(nums2)-1, -1, -1):
            while len(a) > 0 and a[-1] < nums2[i]:
                a.pop(-1)
            mp[nums2[i]] = -1 if len(a)<=0 else a[-1]
            a.append(nums2[i])
        for i in range(len(nums1)):
            if nums1[i] in mp:
                result.append(mp[nums1[i]])
        return result