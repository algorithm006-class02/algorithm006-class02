using System;
using System.Collections.Generic;
using System.Text;

namespace MaxArea
{
    /// <summary>
    /// 设计循环双端队列
    /// </summary>
    public class LeetCode_641_560
    {
        private int[] _array;
        private int _capacity;
        private int _head;
        private int _tail;
        private int _size;

        /** Initialize your data structure here. Set the size of the deque to be k. */
        public LeetCode_641_560(int k)
        {
            _capacity = k;
            _array = new int[k];
            _head = 0;
            _tail = 0;
            _size = 0;
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public bool InsertFront(int value)
        {
            if (IsFull())
            {
                return false;
            }
            _head = (_head - 1 + _capacity) % _capacity;
            _array[_head] = value;
            _size++;
            return true;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public bool InsertLast(int value)
        {
            if (IsFull())
            {
                return false;
            }
            _array[_tail] = value;
            //为什么不是直接加1
            _tail = (_tail + 1) % _capacity;
            _size++;
            return true;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public bool DeleteFront()
        {
            if (IsEmpty())
                return false;

            //_array[_head] = null;
            _head = (_head + 1) % _capacity;
            _size--;
            return true;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public bool DeleteLast()
        {
            if (IsEmpty())
                return false;

            //_array[_tail] = null;
            _tail = (_tail - 1 + _capacity) % _capacity;
            _size--;
            return true;
        }

        /** Get the front item from the deque. */
        public int GetFront()
        {
            if (IsEmpty())
            {
                return -1;
            }
            return _array[_head];
        }

        /** Get the last item from the deque. */
        public int GetRear()
        {
            if (IsEmpty())
            {
                return -1;
            }
            return _array[(_tail - 1 + _capacity) % _capacity];

        }

        /** Checks whether the circular deque is empty or not. */
        public bool IsEmpty()
        {
            return _size == 0;
        }

        /** Checks whether the circular deque is full or not. */
        public bool IsFull()
        {
            return _size == _capacity;
        }
    }
}
