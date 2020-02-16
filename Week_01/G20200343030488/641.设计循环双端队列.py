#
# @lc app=leetcode.cn id=641 lang=python
#
# [641] 设计循环双端队列
#

# @lc code=start
class MyCircularDeque(object):

    def __init__(self, k):
        """
        Initialize your data structure here. Set the size of the deque to be k.
        :type k: int
        """
        self.front = 0
        self.rear = 0
        self.capacity = k+1
        self.arr = [0 for _ in range(self.capacity)]
        

    def insertFront(self, value):
        """
        Adds an item at the front of Deque. Return true if the operation is successful.
        :type value: int
        :rtype: bool
        """
        if self.isFull():
            return False
        self.front = (self.front-1+self.capacity)%self.capacity
        self.arr[self.front] = value
        return True

        
    def insertLast(self, value):
        """
        Adds an item at the rear of Deque. Return true if the operation is successful.
        :type value: int
        :rtype: bool
        """
        if self.isFull():
            return False
        self.arr[self.rear] = value
        self.rear = (self.rear+1)%self.capacity
        return True   

    def deleteFront(self):
        """
        Deletes an item from the front of Deque. Return true if the operation is successful.
        :rtype: bool
        """
        if self.isEmpty():
            return False
        self.front = (self.front+1)%self.capacity
        return True        

    def deleteLast(self):
        """
        Deletes an item from the rear of Deque. Return true if the operation is successful.
        :rtype: bool
        """
        if self.isEmpty():
            return False
        self.rear = (self.rear-1+self.capacity)%self.capacity
        return True           

    def getFront(self):
        """
        Get the front item from the deque.
        :rtype: int
        """
        if self.isEmpty():
            return -1
        return self.arr[self.front]

    def getRear(self):
        """
        Get the last item from the deque.
        :rtype: int
        """
        if self.isEmpty():
            return -1
        return self.arr[(self.rear-1+self.capacity)%self.capacity]      

    def isEmpty(self):
        """
        Checks whether the circular deque is empty or not.
        :rtype: bool
        """
        return self.rear == self.front

    def isFull(self):
        """
        Checks whether the circular deque is full or not.
        :rtype: bool
        """
        return (self.rear+1) % self.capacity ==self.front


# Your MyCircularDeque object will be instantiated and called as such:
# obj = MyCircularDeque(k)
# param_1 = obj.insertFront(value)
# param_2 = obj.insertLast(value)
# param_3 = obj.deleteFront()
# param_4 = obj.deleteLast()
# param_5 = obj.getFront()
# param_6 = obj.getRear()
# param_7 = obj.isEmpty()
# param_8 = obj.isFull()
# @lc code=end

