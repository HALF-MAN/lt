class Solution(object):
    def findMinArrowShots(self, points):
        """
        :type points: List[List[int]]
        :rtype: int
        """
        if len(points) <= 1 :
            return len(points)
        points.sort(key = lambda x : x[1])
        prev = points[0]
        minNum = 1
        for point in points[1:] :
            if prev[1] < point[0]:
                minNum += 1
                prev = point
        return minNum