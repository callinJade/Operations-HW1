package cs250.hw1;
import java.util.ArrayList;

public class helperMethods {
    public static String checkType(String num1){
        String type = "";
        if (num1.startsWith("0b")){
           type = "Binary";
        }
        else if (num1.startsWith("0x")){
           type = "Hexadecimal";
        }
        else{
           type = "Decimal";
        }
        return type;
     }

     public static ArrayList<Integer> convertCode(String arg){
      //char[] code = new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
      int temp = -1;
      //char[] args = arg.toCharArray();
      ArrayList<Integer> arr = new ArrayList<>();
      for (int i = 0; i< arg.length(); i++){
         temp = convertChar(arg.charAt(i));
         arr.add(temp);
      }
      return arr;
   }

     public static int convertChar(char a){
      char[] code = new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
      int temp = -1;
      for (int i = 0; i< code.length; i++){
         char c = code[i];
         if (Character.toLowerCase(a) == c){
            temp = i;
         }         
     }
     return temp;
   }

     public static String convertToBinary(String num1){
        if (checkType(num1).equalsIgnoreCase("decimal")){
            int temp = 0;
            //reverse the string num1
            StringBuilder num = new StringBuilder();
            num.append(num1);
            num.reverse();
            String con = num.toString();
            //char[] arr = con.toCharArray();
            //parse through the reversed string until the end
            for (int i = 0;i < con.length(); i++){
               if (con.charAt(i) == '9'){
                  temp += 9 * Math.pow(10, i);
               }
               if (con.charAt(i) == '8'){
                  temp += 8 * Math.pow(10, i);
               }
               if (con.charAt(i) == '7'){
                  temp += 7 * Math.pow(10, i);
               }
               if (con.charAt(i) == '6'){
                  temp += 6 * Math.pow(10, i);
               }
               if (con.charAt(i) == '5'){
                  temp += 5 * Math.pow(10, i);
               }
               if (con.charAt(i) == '4'){
                  temp += 4 * Math.pow(10, i);
               }
               if (con.charAt(i) == '3'){
                  temp += 3 * Math.pow(10, i);
               }
               if (con.charAt(i) == '2'){
                  temp += 2 * Math.pow(10, i);
               }
               if (con.charAt(i) == '1'){
                  temp += 1 * Math.pow(10, i);
               }
               if (con.charAt(i) == '0'
               ){
                  temp += 0 * Math.pow(10, i);
               }
            }
            String conversion = decimalToBinary(temp);
            return "0b" + conversion;
            //get the value of the string and check if it matches 0,1,2...9
            //set int temp = the value it matches
            //multiple temp by the correct place number
            //if i = 0, it's the 1's place so temp * 1
            //if i = 1, temp * 10
            //add these
            //now you have the int version of num1
            //call decimalToBinary()
            //return the string "0b" + the result values as a string

        }
        else{ //converting a hexadecimal
            //each hex value has a 4-bit compliment in binary
            int dec = 0;
            int count = 0;
            String hex = num1.substring(2); //put the values of num1 into a string, ignorning 0x
            ArrayList<Integer> arr = convertCode(hex);
            for (int i = arr.size() - 1; i >= 0; i-- ){
               dec += arr.get(i) * Math.pow(16, count);
               count++;
            }
            String str = decimalToBinary(dec);
            return "0b" + str;

        }
        
     }

     public static String decimalToBinary(int num){
        ArrayList<String> remainders = new ArrayList<String>();
        int quotient = -1;
        String result = "";
        //divide it by two and add the remainder to remainders arraylist at the front
        quotient = num/2;
        int rem = num % 2;
        String remStr = intToString(rem);
        remainders.add(0, remStr);
        while (quotient != 0){
         //rem = quotient % 2;
         remStr = intToString(quotient % 2);
         remainders.add(0, remStr);
         quotient = quotient/2;
         
         
        }
        for (String s : remainders){
         result += s;
        }
         
        //keep going until quotient is 0
        //match the array values with chars
        //return a string version of remainders
        return result;
     }

     public static String decimalToHex(int num){
      ArrayList<String> remainders = new ArrayList<String>();
      int quotient = -1;
      String result = "";
      //divide it by two and add the remainder to remainders arraylist at the front
      quotient = num/16;
      int rem = num % 16;
      String remStr = intToString(rem);
      remainders.add(0, remStr);
      while (quotient != 0){
       //rem = quotient % 2;
       remStr = intToString(quotient % 16);
       remainders.add(0, remStr);
       quotient = quotient/16;
       
       
      }
      for (String s : remainders){
       result += s;
      }
       
      //keep going until quotient is 0
      //match the array values with chars
      //return a string version of remainders
      return result;
   }

     public static String convertToDecimal(String num1){
        if (checkType(num1).equalsIgnoreCase("binary")){
         String bin = num1.substring(2);
         int count = 0;
         int dec = 0;
         ArrayList<Integer> arr = convertCode(bin);// returns binary number exactly as an int array
         for (int i = arr.size() - 1; i >= 0; i-- ){
            dec += arr.get(i) * Math.pow(2, count);
            count++;
         }
         String result = intToString(dec);
         return result;

         //check if each char in the string matches 1 or 0
            //add the int value to an array at the end
         //iterate through the array backwards
            //if number == 1, then add 2^i to a result value
         //change result value to string by checking what char it matches and adding it to the string str+=char
         //return str

        }
        else{ //converting a hexadecimal
         /*reverse num1
          *iterate through num1 and see what char it matches
          *    multiply the value the char represents by 16^i and add it to a result int
          *change result value to string by checking what char it matches and adding it to the string str+=char
          *return str
          */
            int dec = 0;
            int count = 0;
            String hex = num1.substring(2); //put the values of num1 into a string, ignorning 0x
            ArrayList<Integer> arr = convertCode(hex);
            for (int i = arr.size() - 1; i >= 0; i-- ){
               dec += arr.get(i) * Math.pow(16, count);
               count++;
            }
            String str = intToString(dec);
            return str;

        }
     }

     public static String convertToHex(String num1){
        if (checkType(num1).equalsIgnoreCase("decimal")){
         //decimal to binary
         //binary to hex
            ArrayList<Integer> arr = convertCode(num1);
            int dec = 0;
            int count = 0;
            for (int i = arr.size() - 1; i >= 0; i-- ){
               dec += arr.get(i) * Math.pow(10, count);
               count++;
            }
            String str = decimalToHex(dec);
            return "0x" + str;

            
         /*reverse the string
          * iterate through it and see what number each char matches
            add the numbers to a temp int:
            multiple the value by 10^i
               if i = 0, the number it matches * 10^0 (1)
               if i = 1, the number it matches * 10^1 (10)
            now have an int version of num1
            divide it by 16 and put the remainders in an arraylist
            keep dividing until quotient is 0
            iterate through arraylist and see what number 0-15 it matches
               put the characters 0-9 and a-f that it matches in another arraylist at the front
            convert arraylist to string
            return the string

          */

        }
        else{ //converting a binary
         //convert binary to decimal, then decimal to hex
         String dec = convertToDecimal(num1);
         String hex = convertToHex(dec);
         return hex;

        }
     }

     public static String oneComp(String arg){
      //arg = arg.substring(2);
      char[] att = arg.toCharArray();
      String newBin = "";
      for (char c : att){
         if (c == '1'){
            newBin += 0;
         }
         else{
            newBin += 1;
         }
      }
      
      //arg = value(att); 
      return newBin;
     }

     public static String twoComp(String arg){ //changing all 0s to 1s
      //in a loop
         //start at right side of binary
         //if right most number is 0, change to 1 and exit
         //in not, move on to next digit and check again
         //if get to end and all the digits are 1, return. Won't add another bit; ignore overflow
      //String newBin = arg;
      //ones compliment = arg
      
      /*
      int count = 0;
      for (int i = arg.length() - 1; i > 0; i--){
         if (count == 0){
            if (arg.charAt(i) == '0'){
               arg = arg.substring(0, i) + '1' + arg.substring(i + 1, arg.length());

               count++;
            }
         }
      }
      if (count == 0){
         if (arg.charAt(0) == '0'){
            arg = '1' + arg.substring(1, arg.length());
            //count++;
         }
      }
      
      return arg;
     }*/
      
     char[] att = arg.toCharArray();
      String newBin = "";
      int count = 0;
      for (int i = att.length - 1; i >= 0; i--){
         if (count == 0){
            if (att[i] == '0'){
               att[i] = '1';
               count++;
            }
            else {
               att[i] = '0';
            }
         }
         
      }
      /*StringBuilder num = new StringBuilder();
      num.append(newBin);
      num.reverse();
      String con = num.toString();*/
      newBin = value(att);
      
      return newBin;
   }

   public static String value(char[] arr){
      String str = "";
      for (char c : arr){
         str += c;
      }
      return str;
   }

   public static String intToString(int num){
      //integer array of all the ints
      //char[] code = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
      char[] numChar = ("" + num).toCharArray();
      String str = "";
      for (char c : numChar){
         if (c == '9'){
            str += "9";
         }
         if (c == '8'){
            str += "8";
         }
         if (c == '7'){
            str += "7";
         }
         if (c == '6'){
            str += "6";
         }
         if (c == '5'){
            str += "5";
         }
         if (c == '4'){
            str += "4";
         }
         if (c == '3'){
            str += "3";
         }
         if (c == '2'){
            str += "2";
         }
         if (c == '1'){
            str += "1";
         }
         if (c == '0'){
            str += "0";
         }
      }
      //iterate through the num 
         //if the int at place i is equal to 9...
         //str += "9";
      return str;
   }

   public static String OR(String num1, String num2, String num3){
      String result = "";
      String longest = maxString(num1,num2,num3);
      //you will need to convert them to be the same length, 
      //the length of the longest one. For this, you will just pad the left side with 0's, 
      //because that doesn't change the value.
      for (int i = num1.length(); i < longest.length(); i++){
         num1 = "0" + num1;
      }
      //System.out.println(num1);
      for (int i = num2.length(); i < longest.length(); i++){
         num2 = "0" + num2;
      }
      //System.out.println(num2);
      for (int i = num3.length(); i < longest.length(); i++){
         num3 = "0" + num3;
      }
      //System.out.println(num3);
      for (int i = 0; i < longest.length(); i++){
         if (num1.charAt(i) == '1' || num2.charAt(i) == '1' || num3.charAt(i) == '1'){
            result += "1";
         }
         else{
            result += "0";
         }
      }
      return result;
      
   }

   public static String AND(String num1, String num2, String num3){
      String result = "";
      String longest = maxString(num1,num2,num3);
      for (int i = num1.length(); i < longest.length(); i++){
         num1 = "0" + num1;
      }
      //System.out.println(num1);
      for (int i = num2.length(); i < longest.length(); i++){
         num2 = "0" + num2;
      }
      //System.out.println(num2);
      for (int i = num3.length(); i < longest.length(); i++){
         num3 = "0" + num3;
      }
      //System.out.println(num3);
      for (int i = 0; i < longest.length(); i++){
         if (num1.charAt(i) == '1' && num2.charAt(i) == '1' && num3.charAt(i) == '1'){
            result += "1";
         }
         else{
            result += "0";
         }
      }
      return result;
   }

   public static String XOR(String num1, String num2, String num3){
      String result = "";
      String longest = maxString(num1,num2,num3);
      for (int i = num1.length(); i < longest.length(); i++){
         num1 = "0" + num1;
      }
      //System.out.println(num1);
      for (int i = num2.length(); i < longest.length(); i++){
         num2 = "0" + num2;
      }
      //System.out.println(num2);
      for (int i = num3.length(); i < longest.length(); i++){
         num3 = "0" + num3;
      }
      //System.out.println(num3);
      for (int i = 0; i < longest.length(); i++){
         if ((num1.charAt(i) == '1' && num2.charAt(i) == '1' && num3.charAt(i) == '1') || 
         (num1.charAt(i) == '1' && num2.charAt(i) == '0' && num3.charAt(i) == '0') || 
         (num1.charAt(i) == '0' && num2.charAt(i) == '1' && num3.charAt(i) == '0') ||
         (num1.charAt(i) == '0' && num2.charAt(i) == '0' && num3.charAt(i) == '1')){
            result += "1";
         }
         else{
            result += "0";
         }
      }
      return result;
   }

   public static String maxString(String s1, String s2, String s3){
      String longest = s1;
      if (s2.length() > longest.length()) {
      longest = s2;
      }
      if (s3.length() > longest.length()) {
         longest = s3;
      }
      return longest;
   }

   public static String leftShift(String num, int shift){
      //call leftshift method (binary, the number of shifts)
         //append number of shifts onto the binary number
         //loop through with a loop counter <= numShifts
            //append 0 to end of binary string
         //return it
         for (int i = 0; i < shift; i++){
            num += "0";
         }
      return num;
   }

   public static String rightShift(String num, int shift){
      //call rightshift method (binary, numShift)
         //loop through with a loop counter <= numShift
            //delete the rightmost number by using substring
            //or create a new string and add to it until numShift
         //return it
      String result = "";
      for (int i = 0; i < num.length() - shift; i++){
         result += num.charAt(i);
      }
      return result;
   }

}
