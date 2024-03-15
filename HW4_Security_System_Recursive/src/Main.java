import javax.naming.ldap.Control;

/**
 * Created by BeyzaAcar on 20.04.2023.
 * This class is the test class of the project.
 * It tests the methods of the ControlOperations class.
 * It tests the username, password1 and password2.
 */
public class Main {
    public static void main(String[] args)
    {
        ControlOperations controlOperations = new ControlOperations();
        System.out.println("-------------Username Mistakes-------------");
        System.out.println("Test1 : \nusername : \"\" \npassword1 : \"[(cbabc)a]kk\"\npassword2 : 75");
        controlOperations.isValid("","[(cbabc)a]kk",75);
        System.out.println("Test2 : \nusername : \"beyza22\" \npassword1 : \"[(cbabc)a]kk\"\npassword2 : 75");
        controlOperations.isValid("beyza22","[(cbabc)a]kk",75);
        System.out.println("Test3 : \nusername : \"beyza.acar\" \npassword1 : \"[(cbabc)a]kk\"\npassword2 : 75");
        controlOperations.isValid("beyza.acar","[(cbabc)a]kk",75);
        System.out.println("Test4 : \nusername : \"beyzaacar\" \npassword1 : \"[(cbabc)a]kk\"\npassword2 : 75");
        controlOperations.isValid("beyzaacar","[(cbabc)a]kk",75);

        System.out.println("-------------Password1 Mistakes-------------");
        System.out.println("Test 1 : \nusername : \"beyzaacar\" \npassword1 : \"(ab)\" \npassword2 : 75");
        controlOperations.isValid("beyzaacar","(ab)",75);
        System.out.println("Test 2 : \nusername : \"beyzaacar\" \npassword1 : \"{kkl(mml){}}\" \npassword2 : 75");
        controlOperations.isValid("beyzaacar","{kkl(mml){}}",75);
        System.out.println("Test 3 : \nusername : \"beyzaacar\" \npassword1 : \"[(cbabc)a]kk}\" \npassword2 : 75");
        controlOperations.isValid("beyzaacar","[(cbabc)a]kk}",75);
        System.out.println("Test 4 : \nusername : \"beyzaacar\" \npassword1 : \"{bvjs(hha)}\" \npassword2 : 75");
        controlOperations.isValid("beyzaacar","{bvjs(hha)}",75);
        System.out.println("Test 5 : \nusername : \"beyzaacar\" \npassword1 : \"[(cbabc)a]kk\" \npassword2 : 75");
        controlOperations.isValid("beyzaacar","[(cbabc)a]kk",75);

        System.out.println("-------------Password2 Mistakes-------------");
        System.out.println("Test 1 : \nusername : \"beyzaacar\" \npassword1 : \"[(cbabc)a]kk\" \npassword2 : 5");
        controlOperations.isValid("beyzaacar","[(cbabc)a]kk",5);
        System.out.println("Test 2 : \nusername : \"beyzaacar\" \npassword1 : \"[(cbabc)a]kk\" \npassword2 : 35");
        controlOperations.isValid("beyzaacar","[(cbabc)a]kk",35);
        System.out.println("Test 4 : \nusername : \"beyzaacar\" \npassword1 : \"[(cbabc)a]kk\" \npassword2 : 0");
        controlOperations.isValid("beyzaacar","[(cbabc)a]kk",0);
        System.out.println("Test 5 : \nusername : \"beyzaacar\" \npassword1 : \"[(cbabc)a]kk\" \npassword2 : -100");
        controlOperations.isValid("beyzaacar","[(cbabc)a]kk",-100);


        System.out.println("-------------Password2 mistakes with the given denominators-------------");
        System.out.println("Test 1 : \nusername : \"beyzaacar\" \npassword1 : \"[(cbabc)a]kk\" \npassword2 : 45\ndenominators : 16, 32, 12, 8");
        controlOperations.isValid("beyzaacar","[(cbabc)a]kk",45,new int[]{16,32, 12, 8});
        System.out.println("Test 2 : \nusername : \"beyzaacar\" \npassword1 : \"[(cbabc)a]kk\" \npassword2 : 45\ndenominators : 46");
        controlOperations.isValid("beyzaacar","[(cbabc)a]kk",45,new int[]{46});
        System.out.println("Test 3 : \nusername : \"beyzaacar\" \npassword1 : \"[(cbabc)a]kk\" \npassword2 : 45\ndenominators : 14, 20, 12");
        controlOperations.isValid("beyzaacar","[(cbabc)a]kk",46,new int[]{14, 20, 12});
        System.out.println("Test 4 : \nusername : \"beyzaacar\" \npassword1 : \"[(cbabc)a]kk\" \npassword2 : 35\ndenominators : 4, 17, 29");
        controlOperations.isValid("beyzaacar","[(cbabc)a]kk",35,new int[]{4, 17, 29});
        System.out.println("Test 5 : \nusername : \"beyzaacar\" \npassword1 : \"[(cbabc)a]kk\" \npassword2 : 35\ndenominators : 4, 17, 29");
        controlOperations.isValid("beyzaacar","[(cbabc)a]kk",75,new int[]{4, 17, 29});
        System.out.println("Test 6 : \nusername : \"buketgencer\" \npassword1 : \"[(a)a]kk\" \npassword2 : 35\ndenominators : 2, 17, 29");
        controlOperations.isValid("buketgencer","[(a)a]kk",35,new int[]{2, 17, 29});

        System.out.println("Test 3 : \nusername : \"gizem\" \npassword1 : \"eca(r)c}ar\" \npassword2 : 54");
        controlOperations.isValid("gizem","'eca(r)c}ar'",54);
        System.out.println("Test 1 : \nusername : \"gizem\" \npassword1 : \"eca(r)car\" \npassword2 : 54");
        controlOperations.isValid("gizem","'eca(r)car'",54);
        System.out.println("Test 5 : \nusername : \"gizem\" \npassword1 : \"eca(r)car\" \npassword2 : 35");
        controlOperations.isValid("gizem","'eca(r)car'",35);
        System.out.println("Test 7 : \nusername : \"gizem\" \npassword1 : \"recaecare\" \npassword2 : 54 ");
        controlOperations.isValid("gizem","'recaecare'",54);

        }
}