def generateParenthesis(n):
    """
    :type n: int
    :rtype: List[str]
    """
    def generate(A = []):
        if len(A) == n:
            ans.append("".join(A))
        else:
            A.append('(')
            generate(A)
            A.pop()
            A.append(')')
            generate(A)
            A.pop()


    ans = []
    generate()
    return ans

print generateParenthesis(3)




    



print generateParenthesis(6)