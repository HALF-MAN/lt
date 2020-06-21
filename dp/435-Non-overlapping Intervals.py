class Solution(object):
    def eraseOverlapIntervals(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: int
        """
        if len(intervals) <=1:
            return 0
        intervals.sort(key = lambda x : x[1])
        prev = intervals[0]
        erased = 0
        for interval in intervals[1:]:
            if interval[0] < prev[1]:
                erased += 1
            else:
                prev = interval
        return erased

[1,6],[2,8],[7,12],[10,16]