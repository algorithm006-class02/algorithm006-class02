package xmaths

import "fmt"

/*
 * @lc app=leetcode.cn id=860 lang=golang
 *
 * [860] 柠檬水找零
 */

// @lc code=start
func LemonadeChange(bills []int) bool {
	if len(bills) == 0 {
		return true
	}
	m_5, m_10 := 0, 0
	for _, v := range bills {
		if v == 5 {
			m_5++
		}
		if v == 10 {
			m_5--
			m_10++
			if m_5 < 0 {
				return false
			}
		}
		if v == 20 {
			if m_10 > 0 {
				m_10--
				m_5--
			} else {
				m_5 = m_5 - 3
			}

			if m_10 < 0 || m_5 < 0 {
				return false
			}

		}
		fmt.Println(m_5, m_10)
	}
	return true

}

// @lc code=end
