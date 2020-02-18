<?php

class Solution {

    /**
     * @param Integer[] $digits
     * @return Integer[]
     */
    function plusOne($digits) {
        for($i=count($digits)-1;$i>=0;$i--){
            if($digits[$i]==9){
                $digits[$i]=0;
                continue;
            }
            if($digits[$i]!=9){
                $digits[$i]+=1;
                break;
            }
        }

        if($digits[0]==0) {
            for($i=0;$i<=count($digits);$i++) {
                $ans[]=0;     
            }
            $ans[0]=1;
        	return $ans;
        } else {
        	return $digits;
        }  	
    }
}
