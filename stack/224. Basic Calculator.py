class Solution:
    # 遇到左括号就把左边的表达式结果和符号存进栈，计算完括号中的结果再弹出栈计算结果
    def calculate(self, s: str) -> int:
        res, num, sign, stack = 0, 0, 1, []
        for ss in s:
            if ss.isdigit():
                num = 10*num + int(ss)
            elif ss in ["-", "+"]:
                res += sign*num
                num = 0
                sign = [-1, 1][ss=="+"]
            elif ss == "(":
                stack.append(res)
                stack.append(sign)
                sign, res = 1, 0
            elif ss == ")":
                res += sign*num
                res *= stack.pop()
                res += stack.pop()
                num = 0
        return res + num*sign
        
if __name__ == "__main__":
    s = Solution()
    print(s.calculate("(0-1)+(4+5+2)-3+(6+8)"))