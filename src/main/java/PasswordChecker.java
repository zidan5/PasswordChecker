import sun.security.util.Length;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PasswordChecker {

    private static final byte Password_Length = 8;

    public void passwordIsValid(String password) throws  Exception {

        boolean uppercase = false;
        boolean lowercase = false;
        boolean isdigit = false;
        boolean isSpecialChar = false;

        String SpecialChars = "{<>,.!@#$%^&*()_+| \\/~`}";
        char[] convertSpecialChars = SpecialChars.toCharArray();

        if (password.length() < Password_Length) {
            throw new Exception("Password should be longer than than 8 characters");
        } else if (password.isEmpty()) {
            throw new Exception("Password should exists!");
        } else {

            char[] characters = password.toCharArray();

            for (int i = 0; i < characters.length; i++) {

                if (Character.isUpperCase(characters[i])) {
                    uppercase = true;

                }
                if (Character.isDigit(characters[i])) {
                    isdigit = true;

                }
                if (Character.isLowerCase(characters[i])) {
                    lowercase = true;

                }
                for (int j = 0; j < convertSpecialChars.length; j++) {

                    if (characters[i] == convertSpecialChars[j]) {
                        isSpecialChar = true;
                    }
                }
            }

            if (!uppercase) {
                throw new Exception("password should have at least one uppercase letter");
            }
            if (!lowercase) {
                throw new Exception("password should have at least one lowercase letter");
            }
            if (!isdigit) {
                throw new Exception("password should have at least one digit");
            }
            if (!isSpecialChar) {
                throw new Exception("password should have at least one special character");
            }


        }
    }
    public  boolean passwordIsOk(String password)throws Exception{
        String SpecialChars = "{<>,.!@#$%^&*()_+| \\/~`}";
        char[] convertSpecialChars = SpecialChars.toCharArray();

        if(password.length() < Password_Length || password.isEmpty()){
            throw new Exception("Password is never OK!");
        }

        char[] characters = password.toCharArray();
       // int[] counter = new int[4];
        int sum =0;
        int isUpper=0, isLower=0, isDigit=0, isChar=0;
       // for(int i : counter){ i=0;}


        for(int i=0; i< characters.length; i++){

            if((Character.isUpperCase(characters[i]))){
              //  counter[0] = 1;
                isUpper = 1;
            }if(Character.isDigit(characters[i])){
              //  counter[1] = 1;
                isDigit = 1;
            }if(Character.isLowerCase(characters[i])) {
               // counter[2] = 1;
                isLower = 1;
            }
            for (int j=0; j< convertSpecialChars.length; j++) {

                if (characters[i] == convertSpecialChars[j]) {
                    //counter[3] = 1;
                    isChar = 1;
                }
            }
        }
       // for(int x : counter){sum += x;}
        sum = (isChar + isDigit + isLower + isUpper);
        return sum >= 3;
    }


    public static void main(String[] Args) throws Exception {
        PasswordChecker p = new PasswordChecker();

        System.out.println("Enter your password below:");
        Scanner sc = new Scanner(System.in);
        String InputPassword = sc.next();

        try{
          //p.passwordIsValid(InputPassword);
            System.out.println(p.passwordIsOk(InputPassword));
           // p.sum(0);
        }catch( Exception e){
            System.out.println(e.getMessage());
        }finally {
            sc.close();
        }


    }
}
