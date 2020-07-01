import time
import queue
postSeq = 0
class Twitter:
    
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.userMap = {}
        
        

    def postTweet(self, userId: int, tweetId: int) -> None:
        """
        Compose a new tweet.
        """
        if userId not in self.userMap:
            self.userMap[userId] = User(userId)
        u = self.userMap[userId]
        u.post(tweetId)
        
        

    def getNewsFeed(self, userId: int) -> List[int]:
        """
        Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
        """
        result = []
        if userId not in self.userMap:
            return result
        users = self.userMap[userId].followed
        pq = queue.PriorityQueue(len(users))

        for id in users:
            h = self.userMap[id].head
            if h != None:
                pq.put(h)
        while pq.qsize() > 0:
            if len(result) == 10:
                break
            twt = pq.get()
            result.append(twt.id)
            if None != twt.next:
                pq.put(twt.next)
        return result

    def follow(self, followerId: int, followeeId: int) -> None:
        """
        Follower follows a followee. If the operation is invalid, it should be a no-op.
        """
        if followerId not in self.userMap:
            self.userMap[followerId] = User(followerId)
        if followeeId not in self.userMap:
            self.userMap[followeeId] = User(followeeId)
        self.userMap[followerId].follow(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        """
        Follower unfollows a followee. If the operation is invalid, it should be a no-op.
        """
        if followerId in self.userMap:
            self.userMap[followerId].unfollow(followeeId)
        
class User:

    def __init__(self, userId: int):
        self.id = userId
        self.head = None
        self.followed = set()
        self.follow(self.id)

    def follow(self, userId: int):
        self.followed.add(userId)

    def unfollow(self, userId: int):
        if userId != self.id and userId in self.followed:
            self.followed.remove(userId)

    def post(self, tweetId: int):
        global postSeq
        postSeq += 1
        twt = Tweet(tweetId, postSeq)
        twt.next = self.head
        self.head = twt

class Tweet:
    def __init__(self, id: int, postSeq: int):
        self.id = id 
        self.postSeq = postSeq
        self.next = None
    def __lt__(self, other):
        return self.postSeq > other.postSeq
    def __le__(self, other):
        return self.postSeq > other.postSeq

# Your Twitter object will be instantiated and called as such:
# obj = Twitter()
# obj.postTweet(userId,tweetId)
# param_2 = obj.getNewsFeed(userId)
# obj.follow(followerId,followeeId)
# obj.unfollow(followerId,followeeId)