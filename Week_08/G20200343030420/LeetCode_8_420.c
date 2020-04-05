#define INT_MAX (2147483647)
#define INT_MIN (-2147483648)
int myAtoi(char * str) {
    if (!str) 
        return 0; 

    long res = 0; 
    int i, len = strlen(str), firstValid = 0, flag = 1;  
    for (i = 0; i < len; i++) {
        if (0 == firstValid) {
            if (isdigit(str[i])) {
                res = str[i] - '0'; 
                firstValid = 1; 
            }   
            else if ('+' == str[i]) {
                flag = 1; 
                firstValid = 1; 
            } 
            else if ('-' == str[i]) {
                flag = -1; 
                firstValid = 1; 
            } 
            else if (' ' == str[i]) 
                continue; 
            else 
                return 0; 
        }
        else {
            if (isdigit(str[i])) {                
                res = res * 10 + str[i] - '0'; 
                if ((int)res != res) 
                    return ((1 == flag) ? INT_MAX : INT_MIN); 
            } 
            else 
                break; 
        }
    }
    return (res * flag); 
}
