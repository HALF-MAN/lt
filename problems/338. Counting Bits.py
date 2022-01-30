class Solution:
    # 如果是偶数,右移一位后二进制1的个数不变，如果是奇数，就补偿一个1
    def countBits(self, num: int) -> List[int]:
        arr = [0] * (num + 1) 
        for i in range(1, num + 1):
            arr[i] = arr[i >> 1] + (i & 1)
        return arr