from collections import OrderedDict
class LRUCache(OrderedDict):

    def __init__(self, capacity: int):
        """
        :type capacity: int
        """
        self.capacity = capacity
        super().__init__()
        

    def get(self, key: int) -> int:
        """
        :type key: int
        :rtype: int
        """
        if key in self:
            self.move_to_end(key)
            return self[key]
        else:
            return -1

    def put(self, key: int, value: int) -> None:
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        if key in self:
            self.move_to_end(key)
        super().__setitem__(key, value)
        if len(self) > self.capacity:
            lru = next(iter(self))
            del self[lru]