<?php

class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function removeDuplicates(&$nums) {  
        $count = count($nums);
        if ($count <= 0) {
            return 0;
        }
        
        $number = $nums[0];
        for ($i=1; $i<$count; $i++) {
            if ($number != $nums[$i]) {
                $number = $nums[$i];
            } else {
                unset($nums[$i]);
            }
        }
        return count($nums);
    }
}
