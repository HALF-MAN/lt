class Solution:
    def isHappy(self, n: int) -> bool:
        s = set('')
        while n != 1:
            sum = 0
            while n > 0:
                sum += (n % 10) * (n % 10)
                n = n // 10
            if sum in s:
                return False
            else:
                s.add(sum)
            n = sum
        return  True
if __name__ == "__main__":
    s = Solution()
    print(s.isHappy(19))