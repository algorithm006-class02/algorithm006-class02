class Solution:
    def toLowerCase(self, str: str) -> str:
        res = ''
        for s in str:
            code = ord(s)
            if code >= 65 and code <= 90:
                res = res + chr(code + 32)
            else:
                res = res + s
        return res