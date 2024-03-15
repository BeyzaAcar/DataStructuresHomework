import java.util.Stack;

/**
 * This class contains the functions that are used to check if the username and password are valid to enter the warehouse.
 */
public class ControlOperations
{
    /**
     * Checks if the username and password are valid.
     * @param username
     * @param password1
     * @param password2
     * @return
     */
    public boolean isValid(String username, String password1, int password2, int [] denominations)
    {
        //Checks if the username is valid and if not tells the user why it is not valid.
        if(!checkIfValidUsername(username))
            return false;
        //Checks if the password is valid and if not tells the user why it is not valid with the help of other functions.
        if(!checkIfValidPassword(username, password1 , password2, denominations))
            return false;
        System.out.println("Username and password are valid.\n");
        return true;
    }
    /**
     * Checks if the username and password are valid.(without denominations)
     * @param username
     * @param password1
     * @param password2
     * @return
     */
    public boolean isValid(String username, String password1, int password2)
    {
        //Checks if the username is valid and if not tells the user why it is not valid.
        if(!checkIfValidUsername(username))
            return false;
        //Checks if the password is valid and if not tells the user why it is not valid with the help of other functions.
        if(!checkIfValidPassword(username, password1 , password2))
            return false;
        System.out.println("Username and password are valid.\n");
        return true;
    }

    /**
     * Checks if the password is valid.
     * @param username
     * @param password1
     * @param password2
     * @param denominations
     * @return
     */
    public boolean checkIfValidPassword(String username, String password1, int password2, int [] denominations)
    {
        if(password1.length() < 8)
        {
            System.out.println("Password 1 is not valid. It must be at least 8 characters long.\n");
            return false;
        }
        if(password2<10 || password2>1000)
        {
            System.out.println("Password 2 is not valid. It must be between 10 and 1000.\n");
            return false;
        }
        if(!containsUserNameSpirit(username, password1))
        {
            System.out.println("Password 1 is not valid. It must contain at least one letter of the username.\n");
            return false;
        }
        if(!isBalancedPassword(password1))
        {
            System.out.println("Password 1 is not valid. It must be balanced with brackets.\n");
            return false;
        }
        if(!isPalindromePossible(password1))
        {
            System.out.println("Password 1 is not valid. It must be possible to make a palindrome from it.\n");
            return false;
        }
        if(!isExactDivision(password2, denominations))
        {
            System.out.println("Password 2 is not valid. It must be a summation of denominations along with arbitrary coefficients.\n");
            return false;
        }
        return true;
    }
    /**
     * Checks if the password is valid.(without denominations)
     * @param username
     * @param password1
     * @param password2
     * @return
     */
    public boolean checkIfValidPassword(String username, String password1, int password2)
    {
        if(password1.length() < 8)
        {
            System.out.println("Password 1 is not valid. It must be at least 8 characters long.\n");
            return false;
        }
        if(password2<10 || password2>1000)
        {
            System.out.println("Password 2 is not valid. It must be between 10 and 1000.\n");
            return false;
        }
        if(!containsUserNameSpirit(username, password1))
        {
            System.out.println("Password 1 is not valid. It must contain at least one letter of the username.\n");
            return false;
        }
        if(!isBalancedPassword(password1))
        {
            System.out.println("Password 1 is not valid. It must be balanced with brackets.\n");
            return false;
        }
        if(!isPalindromePossible(password1))
        {
            System.out.println("Password 1 is not valid. It must be possible to make a palindrome from it.\n");
            return false;
        }
        if(!isExactDivision(password2))
        {
            System.out.println("Password 2 is not valid. It must be a summation of denominations along with arbitrary coefficients.\n");
            return false;
        }
        return true;
    }
    /**
     * Checks if it contains only letters, and the minimum length is 1.
     * @param username
     * @return
     */
    public boolean checkIfValidUsername(String username)
    {
        if(username.length() < 1)
        {
            System.out.println("Username is not valid. Its length must be at least 1.\n");
            return false;
        }
        Character valueOfFirstChar = username.charAt(0);
        if((valueOfFirstChar >='a' && valueOfFirstChar<='z') || (valueOfFirstChar >='A' && valueOfFirstChar<='Z'))
        {
            if(username.length() != 1)
                return checkIfValidUsername(username.substring(1));
            else return true;
        }
        System.out.println("Username is not valid. It must contain only letters.\n");
        return false;
    }

    /**
     * checks if the string password contains at least one letter of the username. For example:
     * a. Username= gizem, password1= “{[(abacaba)]}” (output: False)
     * b. Username= gokhan, password1= “{[(abacaba)]}” (output: True)
     * @param username
     * @param password1
     * @return
     */
    public boolean containsUserNameSpirit(String username, String password1)
    {
        Stack<Character> passStack = new Stack<>();
        for(int i = 0;i<password1.length();i++)
        {
            passStack.push((Character) password1.charAt(i));
        }
        Character current ;
        while(!passStack.isEmpty())
        {
            current = passStack.pop();
            for(int i = 0;i<username.length();i++)
            {
                if (current.charValue() == username.charAt(i))
                    return true;
            }
        }
        return false;
    }

    /**
     * In the given string sequence, the function considers two brackets to be matching if the first bracket is an open bracket
     * (ex: (, {, or [), and the next bracket is a closed bracket of the same type.
     * String cannot start with a closed bracket. There can be letters between any two brackets.
     * @param password1
     * @return
     */
    public boolean isBalancedPassword(String password1)
    {
        if(password1.length()<1) return false;
        Stack<Character> stackArr = new Stack();
        for(char c : password1.toCharArray())
        {
            if(c == '(' || c == '[' || c == '{')
            {
                stackArr.push(c);
            }
            if(c == ')' || c == ']' || c == '}')
            {
                switch (c) {
                    case ')':
                        if(stackArr.isEmpty() || stackArr.pop() != '(')
                            return false;
                        break;
                    case ']':
                        if(stackArr.isEmpty() || stackArr.pop() != '[')
                            return false;
                        break;
                    case '}':
                        if(stackArr.isEmpty() || stackArr.pop() != '{')
                            return false;
                        break;
                }
            }
        }
        return stackArr.isEmpty();
    }

    /**
     * considers if it is possible to obtain a palindrome by rearranging the letters in the string.
     * The function ignores the brackets.
     * @param password1
     * @return
     */
    public boolean isPalindromePossible(String password1)
    {
        password1 = removeBrackets(password1);
        return isPalindromePossibleRec(password1);
    }
    private boolean isPalindromePossibleRec(String password1)
    {
        if(password1.length() == 0) return true;
        if(password1.length() == 1) return false;
        char c;
        String sub = password1.substring(1);
        c = password1.charAt(0);
        if(sub.indexOf(c) != -1)
        {
            sub = sub.replaceFirst(String.valueOf(c), "");
            return isPalindromePossible(sub);
        }
        else return false; /*if first letter in the substring has not a pair, then string can not be a palindrome*/
    }

    /**
     * Removes the brackets from the string.
     * @param password1
     */
    public String removeBrackets(String password1)
    {
        char c;
        String newPassword1 = "";
        for(int i = 0;i<password1.length();i++)
        {
            c = password1.charAt(i);
            if(!(c == '(' || c == '[' || c == '{' || c == ')' || c == ']' || c == '}')) //Deletes the brackets
                newPassword1 += c;
        }
        return newPassword1;
    }

    /**
     * Checks if the password2 is a summation of denominations along with arbitrary coefficients.
     * @param password2
     * @param denominations
     * @return
     */
    public boolean isExactDivision(int password2, int [] denominations)
    {
        if(password2 == 0) return true;
        if(password2 < 0) return false;
        for(int i = 0;i<denominations.length;i++)
        {
            if(isExactDivision(password2 - denominations[i], denominations))
                return true;
        }
        return false;
    }
    /**
     * Checks if the password2 is a summation of denominations along with arbitrary coefficients but without the parameter of denominations.
     * The default denominations are {4, 17, 29}.
     * @param password2
     * @return
     */
    public boolean isExactDivision(int password2)
    {
        int [] denominations = {4, 17, 29};
        if(password2 == 0) return true;
        if(password2 < 0) return false;
        for(int i = 0;i<denominations.length;i++)
        {
            if(isExactDivision(password2 - denominations[i], denominations))
                return true;
        }
        return false;
    }
}
