class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        s = set()
        st = []
        count = 0
        for i in range(0, len(M)):
            if i not in s:
                st.append(i)
                count += 1
            while len(st) > 0:
                a = st.pop()
                s.add(a)
                for j in range(0, len(M[a])):
                    if M[a][j] == 1 and j not in s:
                        st.append(j)
        return count