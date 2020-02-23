/*
 * @lc app=leetcode.cn id=42 lang=swift
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    func trap(_ height: [Int]) -> Int {
        if height.count <= 2 {
        return 0
        }
        let sortHeight = sortArr(arr: height)

        var container = 0
        var gap :(Int,Int)?

        for k in 0..<sortHeight.count-1 {
            let firstL = sortHeight[k]
            guard let gugap = gap else {
                var i = k+1

                while (gap ?? nil) == nil && i < sortHeight.count {
                    let secondL = sortHeight[i]
                    if abs(firstL.0 - secondL.0) > 1 {
                        let start = min(secondL.0, firstL.0)
                        let end = max(secondL.0, firstL.0)
                        gap = (start,end)///保存区间
                        for g in start + 1...end-1 {
                            container += secondL.1 - height[g] < 0 ? 0:secondL.1 - height[g]

                        }
                        if start <= 1 && end >= sortHeight.count - 2{
                            return container
                        }
                    }
                    i += 1
                }
                continue
            }
            if firstL.0 <= gugap.1 + 1 && firstL.0 >= gugap.0 - 1  {
                continue
            }else{
                var start = 0
                var end  = 0
                if firstL.0 > gugap.1 {
                    start = gugap.1
                    end = firstL.0
                    gap = (gugap.0,end)
                }else{
                    start = firstL.0
                    end = gugap.0
                    gap = (start,gugap.1)
                }
                for g in start + 1...end-1 {
                    container += firstL.1 - height[g] < 0 ? 0:firstL.1 - height[g]

                }
                if start <= 1 && end >= sortHeight.count - 2{
                    return container
                }
            }
        }
        return container
        }

    func sortArr(arr:[Int]) -> [(Int,Int)] {
        let count = arr.count
        var locValueTump :[(Int,Int)] = []
        for i in 0..<count {
            locValueTump.append((i,arr[i]))
        }

        var gap = count/2
        while gap > 0 {
            for i in gap..<count{
                var j = i
                let temp = locValueTump[j]
                if locValueTump[j].1 > locValueTump[j-gap].1 {
                    while j-gap>=0 && temp.1 > locValueTump[j-gap].1 {
                        locValueTump[j] = locValueTump[j-gap]
                        j -= gap
                    }
                    locValueTump[j] = temp
                }
            }
            gap /= 2
    }

        return locValueTump
    }
}



// @lc code=end

