class Solution:
    def test(self, exp: str):
        num = 0
        stack = []
        sign = '+'
        for i in range(len(exp)):
            ch = exp[i]
            if ch.isdigit():
                num = num * 10 + int(ch)
            if not ch.isdigit() or i == len(exp) - 1:
                if sign == '+':
                    stack.append(num)
                elif sign == '-':
                    stack.append(-num)
                elif sign == '*':
                    pre = stack.pop()
                    stack.append(pre * num)
                elif sign == '/':
                    pre = stack.pop()
                    stack.append(pre / num)
                sign = ch
                num = 0
if __name__ == "__main__":
    s = Solution()
    s.test("2-3*4+5")