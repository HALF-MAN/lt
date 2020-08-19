class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        lenN1 = len(num1)
        lenN2 = len(num2)
        result = [0 for _ in range(lenN1 + lenN2)]
        for i in range(lenN1 - 1, -1, -1):
            for j in range(lenN2 - 1, -1, -1):
                p1 = i + j
                p2 = i + j + 1
                tmp = result[p2] + int(num1[i]) * int(num2[j])
                result[p2] = tmp % 10
                result[p1] += tmp // 10
        index = 0
        while index < len(result) and result[index] == 0:
            index += 1
        return "0" if len(result[index:]) <= 0 else''.join([str(i) for i in result[index:]])
if __name__ == "__main__":
    s = Solution()
    s.multiply("2", "3")