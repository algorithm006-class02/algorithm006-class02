
def rotate( nums, k:int):
    def ref(arr):
        arr = arr[::-1]
        return arr

    n = len(nums)

    if k > n:
        k %= n
    nums[:] = ref(nums)
    nums[:k] = ref(nums[:k])
    nums[k:] = ref(nums[k:])


# 首先将整个数组翻转一次,再将0-k个元素翻转一次，最后将k到最后的元素翻转一次