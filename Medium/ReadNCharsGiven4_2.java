public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */

    char[] tempBuf4 = new char[4];
    int tempPtr = 0;
    int tempCnt = 0;

    public int read(char[] buf, int n){
        int charsRead = 0;
        while(charsRead < n){
            if(tempPtr == 0)
                tempCnt = read4(tempBuf4);

            while(charsRead < n && tempPtr < tempCnt)
                buf[charsRead++] = tempBuf4[tempPtr++];

            if(tempPtr == tempCnt)  
                tempPtr = 0;
            
            if(tempCnt < 4) 
                break;
        }
        return charsRead;
    }
}