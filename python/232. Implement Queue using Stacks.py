class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.inStack = []
        self.outStack = []

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.inStack.append(x) 

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        result = None
        if len(self.outStack) > 0:
            result = self.outStack.pop()
        else:
            while len(self.inStack) > 0:
                self.outStack.append(self.inStack.pop())
            result = self.outStack.pop()
        return result

    def peek(self) -> int:
        """
        Get the front element.
        """
        result = self.pop()
        if None != result:
            self.outStack.append(result)
        return result

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return len(self.inStack) == 0 and len(self.outStack) == 0
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
if __name__ == "__main__":
    obj = MyQueue()
    obj.push(1)
    obj.push(2)
    a = obj.peek()
    b = obj.pop()
    c = obj.empty
    pass