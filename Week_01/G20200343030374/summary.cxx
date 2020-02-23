#include <vector>
#include <queue>
#include <iostream>

using namespace std;

class MonotonicQueue {
  private:
    deque<int> data;
  public:
    void push_back(int n) {
      while (!data.empty() && data.back() < n) {
        data.pop_back();
      }
      data.push_back(n);
    }
    void pop_front(int n) {
      if (data.front() == n) data.pop_front();
    }
    int max() {
      return data.front();
    }
};

int main(int argc, char** argv) {
  MonotonicQueue mq;
  mq.push_back(3);
  mq.push_back(2); // 3
  mq.push_back(4); // 4
  mq.push_back(1); // 4
  mq.push_back(2); // 4
  cout << "max: " << mq.max() << endl;
}