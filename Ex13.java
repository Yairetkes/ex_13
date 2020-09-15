
/**
 * This is maman 13 at course 20454.
 *
 * @author Yair Etkes
 * ID - 308224518
 * Date - 19/5/18
 */
public class Ex13
{

    /**
     * This method check where a digit is located inside a given number, for example if digit is located in the tens digit, the method 
     * returns 10.
     *
     * @param   num   the given number
     * @param   digit   the digit to check where it is located in num.
     * @return    the place of the digit - for example 100 if it is located in the houndreds digit.
     */
    public static int weight (int num, int digit)
    {

        int j = 10;
        if (digit > 9 || digit <= 0 || num == 0)// a check to make sure that the input values are ok.
            return 0;

        else if (num%10 == num)
            return 1;

        else if (num%10 == digit)
            return 1;

        else
        {
            for(int i = 1; i < 11; j=j*10)// this loop is calculating where's digit located in number, if it's not in the ones digit.
            {
                if (((num/j)%10) == digit)
                    return j;
            }
        }
        return 0;       
    }

    /**
     * This method is performing the same as the previous method only by recursion.
     *
     * @param   num   the given number
     * @param   digit   the digit to check where it is located in num.
     * @return    the place of the digit - for example 100 if it is located in the houndreds digit.
     */
    public static int weightRec(int num, int digit)
    {
        if (num == 0) // a stoping condition for the recursion.
            return 0;

        if (num%10 == digit) // another stoping condition for the recursion.
            return 1;

        return weightRec(num/10,digit)*10; // the use of the method itself, which is the basic of recursion.

    } 

    /**
     * This method is reversing the digits of a given number.
     *
     * @param    num    the given number
     * @return    the number reversed
     */
    public static int reverse (int num)
    {
        String numString = String.valueOf(num); // converting int to String.
        int length = numString.length(); // getting the length of the String.
        char [] arr = new char[length]; // creating a new array which will contain the digits of the number (as chars).
        String reversedNum = "";
        for (int i = length - 1; i >= 0; i--)
        {
            arr[length - 1 - i] = numString.charAt(i); // this loop is inserting the digits into the array. 
        }

        for (int k = 0; k < length; k++)  
        {
            reversedNum += Character.toString(arr[k]); // this loop is rebuilding the number.
        }
        return Integer.valueOf(reversedNum); // and finally the reversed num is returned.
    }

    /**
     * This method is performing the same as the previous method only by recursion.
     *
     * @param    num    the given number
     * @return    the number reversed
     */
    public static int reverseRec (int num, int digit) // the need of variable "digit" wasn't clear to me, but I had to write the method
    // the same as instructed. so I had to write the next method (overloading)
    {
        if(num == 0) // a stoping condition to the recursion
            return digit;
        digit = (digit * 10) +  (num%10);

        return reverseRec (num/10, digit); //the recursion step.
    }

    /**
     * This method is basically using the previous method, if the variable "digit" from the previous method is unnecessary...
     *
     * @param    num    the given number
     * @return    the number reversed
     */
    public static int reverseRec (int num) 
    {
        return reverseRec (num, 0);
    }
    
    /**
     * This method is calculating the number of possible ways in which spiderman can climb a New- York building (if he can only climb 
     * 2 or 1 floors at a time).
     *
     * @param    n    the number of floors in the building.
     * @return    the number of possible ways in which spiderman can climb the building
     */
    public static int spiderman (int n)
    {
        int ans; //this variable will contain the number of ways to climb.
        if (n==0)
        ans = 1; // a stopping condition for the recursion.
        else if (n==1)
        ans = 1; // another stopping condition for the recursion.
        else 
        ans = spiderman(n-1)+spiderman(n-2);// the recursion step.
        return ans;  
    }
    
    /**
     * This method is performing the same as the previous method until floor 20, only - if spiderman stops at floor 20, he has to 
     * take the elevator to the last floor. if he does not stops at floor 20 he can keep climb like before.
     *
     * @param    n    the number of floors in the building. has to be smaller than 30.
     * @return    the number of possible ways in which spiderman can climb the building
     */
    public static int spidermanPhoneBooth20 (int n) //
    {
        if (n<=20) //if the number of floors is smaller or equals to 20 it's the same as spiderman method.
        return spiderman(n);
        else if (n==21)
        return spiderman(19) + spidermanPhoneBooth20 (20);
        else if (n==22)
        return spidermanPhoneBooth20 (n-1);// the number of ways in this case is the same as the with 21 floors.
        else
        return
        spidermanPhoneBooth20 (n-1) + spidermanPhoneBooth20 (n-2) - spiderman(20); // the recursion step.
    }
}