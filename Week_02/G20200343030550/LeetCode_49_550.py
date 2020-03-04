"""
1、创建空字典；
2、循环列表，并对元素内的字母排序-->转换为元组；
3、在字典内添加k,v：k为转换后的元组，例如：K为（'a','e','u'）,v为['aue','eua','uea'];
4、返回字典的value;
"""

def groupAnagrams(strs):
    """
    :type strs: List[str]
    :rtype: List[List[str]]
    """
    d = {}
    for i in strs:
        key = tuple(sorted(i))
        d[key] = d.get(key, []) + [i]
    return d.values()

