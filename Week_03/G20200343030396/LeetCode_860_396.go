package main

func lemonadeChange(bills []int) bool {
	var five,ten int

	for _,f := range bills {
		switch f {
		case 5:
			five++
			break
		case 10:
			five--
			ten++
			if five < 0 {
				return false
			}
			break
		case 20:
			if ten>0 {
				ten--;
				five--;
			} else {
				five-=3
			}
			if five < 0 {
				return false
			}
		}
	}
	return five >= 0
}

func main() {
	bills := []int{5,5,5,5,20,20,5,5,5,5}
	lemonadeChange(bills)
}
