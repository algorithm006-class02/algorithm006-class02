#!/usr/bin/env python
# -*- coding: utf-8 -*-

import math


def abc(x, n):
    # 指数等于0 直接返回
    if n == 0:
        return 0

    # 取整数
    if n > 0:
        n = abs(n)

    # 求n的 1/2 的 幂，调用的python内置方法，然后在乘自身就行了
    half = math.pow(x, n//2)

    # 被整除时
    if n % 2 == 0:
        return half*half
    # 未奇数时
    else:
        return half*half*x
    # 未负数时
    if n > 0:
        return half * half/1


# 看了下分治思想，就说把复杂的问题，分成多个小问题，然后结果合并就是这样。
# 回塑不太明白，这周就一道题，sorry，
# 最近看老师的视频，感觉应该是这样，
"""

看了下分治思想，就说把复杂的问题，分成多个小问题，然后结果合并就是这样。

回塑不太明白，这周就一道题，sorry，
最近看老师的视频，感觉应该是这样: 

应该看用到什么思想，然后去看数据结构的相关内容，
再来看老师的视频
然后在做题
不然根本看不懂，这个题为什么这样解

所以学习都用在数据上面了，下周上班。



"""
