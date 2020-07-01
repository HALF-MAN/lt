import queue
import threading
import time
postSeq = 0
class Tweet:
    def __init__(self, id: int, timestamp: int):
        self.id = id 
        self.timestamp = timestamp
        self.next = None
    def __lt__(self, other):
        return self.timestamp > other.timestamp
q = queue.PriorityQueue(5)
q.put(Tweet(1,int(time.time())))
q.put(Tweet(2,int(time.time())))
q.put(Tweet(3,int(time.time())))
q.put(Tweet(4,int(time.time())))
# 1是级别最高的，
while not q.empty():  # 不为空时候执行
    print(q.get().id)