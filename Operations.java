package cs250.hw1;
import java.io.File;
import java.util.Scanner;


//make sure they can add their own arguments. 3 scanner args
//if else to make sure they put right number of args
public class Operations extends helperMethods{
   public static void main(String[] args) {
      if (!task1(args)){
         return;
      }
      task2(args[0], args[1], args[2]);
      if (!task3(args[0], args[1], args[2])){
         System.out.println("Arguments not in the correct format - please try again");
         return;
      }
      task4(args[0], args[1], args[2]);
      task5(args[0], args[1], args[2]);
      task6(args[0], args[1], args[2]);
      task7(args[0], args[1], args[2]);
      task8(args[0], args[1], args[2]);
      //System.out.println("hello");
    
   }

   public static boolean task1(String[] args){
      String result = "";
      boolean goodOrNot;
      if (args.length != 3){ //task 1
         result = "Incorrect number of arguments - please try again";
         System.out.println("Task 1:");
         System.out.println(result);
         System.out.print("\n");
         goodOrNot = false;
         return goodOrNot;
      }
      else{
         result = "Correct number of arguments";
         System.out.println("Task 1:");
         System.out.println(result);
         System.out.print("\n");
         goodOrNot = true;
      }
      return goodOrNot;
   }

   public static String task2(String num1, String num2, String num3){ 
      String dec = "";
      String bin = "";
      String hex = "";
      String result = "";
      //num1 checks
      if (checkType(num1).equalsIgnoreCase("decimal"))
      {
         num1 = num1 + " = Decimal";
      }
      else if (checkType(num1).equalsIgnoreCase("hexadecimal")){
         num1 = num1 + " = Hexadecimal";
      }
      else{
         num1 = num1 + " = Binary";
      }
      //num2 checks
      if (checkType(num2).equalsIgnoreCase("decimal"))
      {
         num2 = num2 + " = Decimal";
      }
      else if (checkType(num2).equalsIgnoreCase("hexadecimal")){
         num2 = num2 + " = Hexadecimal";
      }
      else{
         num2 = num2 + " = Binary";
      }
      //num3 checks
      if (checkType(num3).equalsIgnoreCase("decimal"))
      {
         num3 = num3 + " = Decimal";
      }
      else if (checkType(num3).equalsIgnoreCase("hexadecimal")){
         num3 = num3 + " = Hexadecimal";
      }
      else{
         num3 = num3 + " = Binary";
      }
      
      result = num1 + '\n' + num2 + '\n' + num3;
      System.out.println("Task 2:");
      System.out.println(result);
      System.out.print("\n");
        return result;
   }

   public static boolean task3(String num1, String num2, String num3){
      String decForm = "";
      String binForm = "";
      String hexForm = "";
      String result = "";
      boolean decCor = false;
      boolean binCor = false;
      boolean hexCor = false;
      boolean finalResult = true;
      if (num1.startsWith("0b")){
         if (num1.matches("^0b[0-1]*"))
         {
            num1 = num1 + "=True";
            binCor = true;
         }
         else{
            num1 = num1 + "=False";
            binCor = false;
         }
      }
      else if (num1.startsWith("0x")){
         if (num1.matches("^0x[A-Fa-f0-9]*")) 
         {
            num1 = num1 + "=True";
            hexCor = true;
         }
         else
         {
            num1 = num1 + "=False";
            hexCor = false;
         }
      }
      else{
         if (num1.matches("[0-9]*"))
         {
            num1 = num1 + "=True";
            decCor = true;
         }
         else{
            num1 = num1 + "=False";
            decCor = false;
         }
      }

      if (num2.startsWith("0b")){
         if (num2.matches("^0b[0-1]*"))
         {
            num2 = num2 + "=True";
            binCor = true;
         }
         else{
            num2 = num2 + "=False";
            binCor = false;
         }
      }
      else if (num2.startsWith("0x")){
         if (num2.matches("^0x[A-Fa-f0-9]*")) 
         {
            num2 = num2 + "=True";
            hexCor = true;
         }
         else{
            num2 = num2 + "=False";
            hexCor = false;
         }
      }
      else{
         if (num2.matches("[0-9]*"))
         {
            num2 = num2 + "=True";
            decCor = true;
         }
         else{
            num2 = num2 + "=False";
            decCor = false;
         }
      }

      if (num3.startsWith("0b")){
         if (num3.matches("^0b[0-1]*"))
         {
            num3 = num3 + "=True";
            binCor = true;
         }
         else{
            num3 = num3 + "=False";
            binCor = false;
         }
      }
      else if (num3.startsWith("0x")){
         if (num3.matches("^0x[A-Fa-f0-9]*")) 
         {
            num3 = num3 + "=True";
            hexCor = true;
         }
         else{
            num3 = num3 + "=False";
            hexCor = false;
         }
      }
      else{
         if (num3.matches("[0-9]*"))
         {
            num3 = num3 + "=True";
            decCor = true;
         }
         else{
            num3 = num3 + "=False";
            decCor = false;
         }
      }



      if (!(decCor) || !(binCor) || !(hexCor))
      {
         finalResult = false;
      }
      else{
         finalResult = true;
      }
      result = num1 + '\n' +  num2 + '\n' + num3;
      System.out.println("Task 3:");
      System.out.println(result);
      System.out.print("\n");
      return finalResult;
      
   }


   public static boolean task4(String num1, String num2, String num3){
      String dec = "";
      String bin = "";
      String hex = "";
      String decToBin = "";
      String decToHex = "";
      String binToDec = "";
      String binToHex = "";
      String hexToBin = "";
      String hexToDec = "";
      System.out.println("Task 4:");
      //num1
      if (checkType(num1).equalsIgnoreCase("decimal")){
         decToBin = convertToBinary(num1);
         decToHex = convertToHex(num1);
         dec = num1;
         System.out.println("Start=" + dec + ",Binary=" + decToBin + ",Decimal=" + dec + ",Hexadecimal=" + decToHex);
         //System.out.println(decToBin);
         //System.out.println(decToHex);
      }
      if (checkType(num1).equalsIgnoreCase("binary")){
         binToDec = convertToDecimal(num1);
         binToHex = convertToHex(num1);
         bin = num1;
         System.out.println("Start=" + bin + ",Binary=" + bin + ",Decimal=" + binToDec + ",Hexadecimal=" + binToHex);
         //System.out.println(binToDec);
         //System.out.println(binToHex);
      }
      if (checkType(num1).equalsIgnoreCase("hexadecimal")){
         hexToDec = convertToDecimal(num1);
         hexToBin = convertToBinary(num1);
         hex = num1;
         System.out.println("Start=" + hex + ",Binary=" + hexToBin + ",Decimal=" + hexToDec + ",Hexadecimal=" + hex);
         //System.out.println(hexToDec);
         //System.out.println(hexToBin);
      }

      //num2
      if (checkType(num2).equalsIgnoreCase("decimal")){
         decToBin = convertToBinary(num2);
         decToHex = convertToHex(num2);
         dec = num2;
         System.out.println("Start=" + dec + ",Binary=" + decToBin + ",Decimal=" + dec + ",Hexadecimal=" + decToHex);
         //System.out.println(decToBin);
         //System.out.println(decToHex);
      }
      if (checkType(num2).equalsIgnoreCase("binary")){
         binToDec = convertToDecimal(num2);
         binToHex = convertToHex(num2);
         bin = num2;
         System.out.println("Start=" + bin + ",Binary=" + bin + ",Decimal=" + binToDec + ",Hexadecimal=" + binToHex);
         //System.out.println(binToDec);
         //System.out.println(binToHex);
      }
      if (checkType(num2).equalsIgnoreCase("hexadecimal")){
         hexToDec = convertToDecimal(num2);
         hexToBin = convertToBinary(num2);
         hex = num2;
         System.out.println("Start=" + hex + ",Binary=" + hexToBin + ",Decimal=" + hexToDec + ",Hexadecimal=" + hex);
         //System.out.println(hexToDec);
         //System.out.println(hexToBin);
      }

      //num3
      if (checkType(num3).equalsIgnoreCase("decimal")){
         decToBin = convertToBinary(num3);
         decToHex = convertToHex(num3);
         dec = num3;
         System.out.println("Start=" + dec + ",Binary=" + decToBin + ",Decimal=" + dec + ",Hexadecimal=" + decToHex);
         //System.out.println(decToBin);
         //System.out.println(decToHex);
      }
      if (checkType(num3).equalsIgnoreCase("binary")){
         binToDec = convertToDecimal(num3);
         binToHex = convertToHex(num3);
         bin = num3;
         System.out.println("Start=" + bin + ",Binary=" + bin + ",Decimal=" + binToDec + ",Hexadecimal=" + binToHex);
         //System.out.println(binToDec);
         //System.out.println(binToHex);
      }
      if (checkType(num3).equalsIgnoreCase("hexadecimal")){
         hexToDec = convertToDecimal(num3);
         hexToBin = convertToBinary(num3);
         hex = num3;
         System.out.println("Start=" + hex + ",Binary=" + hexToBin + ",Decimal=" + hexToDec + ",Hexadecimal=" + hex);
         //System.out.println(hexToDec);
         //System.out.println(hexToBin);
      }
      //System.out.println("Task 4:");
      //print Start=decimal,Binary=0bBinary,Decimal=decimal,Hexadecimal=0xHex
      //System.out.println("Start=" + dec + ",Binary=" + decToBin + ",Decimal=" + dec + ",Hexadecimal=" + decToHex);
      //print Start=0bBinary,Binary=0bBinary,Decimal=decimal,Hexadecimal=0xHex
      //System.out.println("Start=" + bin + ",Binary=" + bin + ",Decimal=" + binToDec + ",Hexadecimal=" + binToHex);
      //print Start=0xHex,Binary=0bBinary,Decimal=decimal,Hexadecimal=0xHex
      //System.out.println("Start=" + hex + ",Binary=" + hexToBin + ",Decimal=" + hexToDec + ",Hexadecimal=" + hex);
      System.out.print("\n");
      return true;
   }

   public static boolean task5(String num1, String num2, String num3){
      String decBinary = "";
      String binBinary = "";
      String hexBinary = "";
      String decComp = "";
      String binComp = "";
      String hexComp = "";
      String dec = "";
      String bin = "";
      String hex = "";
      System.out.println("Task 5:");
      //num1
      if (checkType(num1).equalsIgnoreCase("hexadecimal") || checkType(num1).equalsIgnoreCase("decimal")){
         if (checkType(num1).equalsIgnoreCase("hexadecimal")){
            hex = num1;
            hexBinary = convertToBinary(num1);
            hexBinary = hexBinary.substring(2);
            hexComp = oneComp(hexBinary);
            System.out.println(hex + "=" + hexBinary + "=>" + hexComp);
         }
         else{
            dec = num1;
            decBinary = convertToBinary(num1);
            decBinary = decBinary.substring(2);
            decComp = oneComp(decBinary);
            System.out.println(dec + "=" + decBinary + "=>" + decComp);
         }
      }
      else{
         bin = num1;
         binBinary = num1.substring(2);
         binComp = oneComp(binBinary);
         System.out.println(bin + "=" + binBinary + "=>" + binComp);
      }
      //num2
      if (checkType(num2).equalsIgnoreCase("hexadecimal") || checkType(num2).equalsIgnoreCase("decimal")){
         if (checkType(num2).equalsIgnoreCase("hexadecimal")){
            hex = num2;
            hexBinary = convertToBinary(num2);
            hexBinary = hexBinary.substring(2);
            hexComp = oneComp(hexBinary);
            System.out.println(hex + "=" + hexBinary + "=>" + hexComp);
         }
         else{
            dec = num2;
            decBinary = convertToBinary(num2);
            decBinary = decBinary.substring(2);
            decComp = oneComp(decBinary);
            System.out.println(dec + "=" + decBinary + "=>" + decComp);
         }
      }
      else{
         bin = num2;
         binBinary = num2.substring(2);
         binComp = oneComp(binBinary);
         System.out.println(bin + "=" + binBinary + "=>" + binComp);
      }
      //num3
      if (checkType(num3).equalsIgnoreCase("hexadecimal") || checkType(num3).equalsIgnoreCase("decimal")){
         if (checkType(num3).equalsIgnoreCase("hexadecimal")){
            hex = num3;
            hexBinary = convertToBinary(num3);
            hexBinary = hexBinary.substring(2);
            hexComp = oneComp(hexBinary);
            System.out.println(hex + "=" + hexBinary + "=>" + hexComp);
         }
         else{
            dec = num3;
            decBinary = convertToBinary(num3);
            decBinary = decBinary.substring(2);
            decComp = oneComp(decBinary);
            System.out.println(dec + "=" + decBinary + "=>" + decComp);
         }
      }
      else{
         bin = num3;
         binBinary = num3.substring(2);
         binComp = oneComp(binBinary);
         System.out.println(bin + "=" + binBinary + "=>" + binComp);
      }
      //iterate through the string for each result and check if it matches a 1 or 0
         //if it matches 1, add a 0 to a new string
         //if it matches 0, add a 1 to a new string
      //decComp = oneComp(decBinary);
      //binComp = oneComp(binBinary);
      //hexComp = oneComp(hexBinary);
   
      //System.out.println("Task 5:");
      //print decimal=decBinary=>one comp
      //System.out.println(dec + "=" + decBinary + "=>" + decComp);
      //print binary=binary w/o 0b=>one comp
      //System.out.println(bin + "=" + binBinary + "=>" + binComp);
      //print hex=hexBinary=>one comp
      //System.out.println(hex + "=" + hexBinary + "=>" + hexComp);
      System.out.print("\n");
      return true;
   }

   public static boolean task6(String num1, String num2, String num3){
      String decBinary = "";
      String binBinary = "";
      String hexBinary = "";
      String decComp = "";
      String binComp = "";
      String hexComp = "";
      String dec = "";
      String bin = "";
      String hex = "";
      System.out.println("Task 6:");
      //num1
      if (checkType(num1).equalsIgnoreCase("hexadecimal") || checkType(num1).equalsIgnoreCase("decimal")){
         if (checkType(num1).equalsIgnoreCase("hexadecimal")){
            hex = num1;
            hexBinary = convertToBinary(num1);
            hexBinary = hexBinary.substring(2);
            hexComp = oneComp(hexBinary);
            hexComp = twoComp(hexComp);
            System.out.println(hex + "=" + hexBinary + "=>" + hexComp);
         }
         else{
            dec = num1;
            decBinary = convertToBinary(num1);
            decBinary = decBinary.substring(2);
            decComp = oneComp(decBinary);
            decComp = twoComp(decComp);
            System.out.println(dec + "=" + decBinary + "=>" + decComp);
         }
      }
      else{
         bin = num1;
         binBinary = num1.substring(2);
         binComp = oneComp(binBinary);
         binComp = twoComp(binComp);
         System.out.println(bin + "=" + binBinary + "=>" + binComp);
      }
      //num2
      if (checkType(num2).equalsIgnoreCase("hexadecimal") || checkType(num2).equalsIgnoreCase("decimal")){
         if (checkType(num2).equalsIgnoreCase("hexadecimal")){
            hex = num2;
            hexBinary = convertToBinary(num2);
            hexBinary = hexBinary.substring(2);
            hexComp = oneComp(hexBinary);
            hexComp = twoComp(hexComp);
            System.out.println(hex + "=" + hexBinary + "=>" + hexComp);
         }
         else{
            dec = num2;
            decBinary = convertToBinary(num2);
            decBinary = decBinary.substring(2);
            decComp = oneComp(decBinary);
            decComp = twoComp(decComp);
            System.out.println(dec + "=" + decBinary + "=>" + decComp);
         }
      }
      else{
         bin = num2;
         binBinary = num2.substring(2);
         binComp = oneComp(binBinary);
         binComp = twoComp(binComp);
         System.out.println(bin + "=" + binBinary + "=>" + binComp);
      }
      //num3
      if (checkType(num3).equalsIgnoreCase("hexadecimal") || checkType(num3).equalsIgnoreCase("decimal")){
         if (checkType(num3).equalsIgnoreCase("hexadecimal")){
            hex = num3;
            hexBinary = convertToBinary(num3);
            hexBinary = hexBinary.substring(2);
            hexComp = oneComp(hexBinary);
            hexComp = twoComp(hexComp);
            System.out.println(hex + "=" + hexBinary + "=>" + hexComp);
         }
         else{
            dec = num3;
            decBinary = convertToBinary(num3);
            decBinary = decBinary.substring(2);
            decComp = oneComp(decBinary);
            decComp = twoComp(decComp);
            System.out.println(dec + "=" + decBinary + "=>" + decComp);
         }
      }
      else{
         bin = num3;
         binBinary = num3.substring(2);
         binComp = oneComp(binBinary);
         binComp = twoComp(binComp);
         System.out.println(bin + "=" + binBinary + "=>" + binComp);
      }
      /*decComp = oneComp(decBinary);
      binComp = oneComp(binBinary);
      hexComp = oneComp(hexBinary);
      decComp = twoComp(decComp);
      binComp = twoComp(binComp);
      hexComp = twoComp(hexComp);

      System.out.println("Task 6:");
      
      //print decimal=decBinary=>two comp
      System.out.println(dec + "=" + decBinary + "=>" + decComp);
      //print binary=binary w/o 0b=>two comp
      System.out.println(bin + "=" + binBinary + "=>" + binComp);
      //print hex=hexBinary=>two comp
      System.out.println(hex + "=" + hexBinary + "=>" + hexComp);*/
      System.out.print("\n");
     
      return true;
   }

   public static boolean task7(String num1, String num2, String num3){
      //check type on each number
      //depending on the type, call convert to binary on it
      String decBinary = "";
      String binBinary = "";
      String hexBinary = "";
      String or = "";
      String and = "";
      String xor = "";
      //num1
      if (checkType(num1).equalsIgnoreCase("hexadecimal") || checkType(num1).equalsIgnoreCase("decimal")){
         if (checkType(num1).equalsIgnoreCase("hexadecimal")){
            hexBinary = convertToBinary(num1);
            hexBinary = hexBinary.substring(2);
            num1 = hexBinary;
         }
         else{
            decBinary = convertToBinary(num1);
            decBinary = decBinary.substring(2);
            num1 = decBinary;
         }
      }
      else{
         binBinary = num1.substring(2);
         num1 = binBinary;
      }
      //num2
      if (checkType(num2).equalsIgnoreCase("hexadecimal") || checkType(num2).equalsIgnoreCase("decimal")){
         if (checkType(num2).equalsIgnoreCase("hexadecimal")){
            hexBinary = convertToBinary(num2);
            hexBinary = hexBinary.substring(2);
            num2 = hexBinary;
         }
         else{
            decBinary = convertToBinary(num2);
            decBinary = decBinary.substring(2);
            num2 = decBinary;
         }
      }
      else{
         binBinary = num2.substring(2);
         num2 = binBinary;
      }
      //num3
      if (checkType(num3).equalsIgnoreCase("hexadecimal") || checkType(num3).equalsIgnoreCase("decimal")){
         if (checkType(num3).equalsIgnoreCase("hexadecimal")){
            hexBinary = convertToBinary(num3);
            hexBinary = hexBinary.substring(2);
            num3 = hexBinary;
         }
         else{
            decBinary = convertToBinary(num3);
            decBinary = decBinary.substring(2);
            num3 = decBinary;
         }
      }
      else{
         binBinary = num3.substring(2);
         num3 = binBinary;
      }
      or = OR(decBinary,binBinary,hexBinary);
      and = AND(decBinary,binBinary,hexBinary);
      xor = XOR(decBinary,binBinary,hexBinary);
      System.out.println("Task 7:");
      //print num1|num2|num3|=result of OR (the binary versions)
      System.out.println(num1 + "|" + num2 + "|" + num3 + "=" + or);
      //print num1&num2&num3=result of AND
      System.out.println(num1 + "&" + num2 + "&" + num3 + "=" + and);
      //print num1^num2^num3=result of XOR
      System.out.println(num1 + "^" + num2 + "^" + num3 + "=" + xor);
      System.out.print("\n");
      return true;
   }

   public static boolean task8(String num1, String num2, String num3){
      //check type on each number
      //depending on the type, call convert to binary on it
      String decBinary = "";
      String binBinary = "";
      String hexBinary = "";
      String num1Left = "";
      String num1Right = "";
      String num2Left = "";
      String num2Right = "";
      String num3Left = "";
      String num3Right = "";

      //num1
      if (checkType(num1).equalsIgnoreCase("hexadecimal") || checkType(num1).equalsIgnoreCase("decimal")){
         if (checkType(num1).equalsIgnoreCase("hexadecimal")){
            hexBinary = convertToBinary(num1);
            hexBinary = hexBinary.substring(2);
            num1 = hexBinary;
         }
         else{
            decBinary = convertToBinary(num1);
            decBinary = decBinary.substring(2);
            num1 = decBinary;
         }
      }
      else{
         binBinary = num1.substring(2);
         num1 = binBinary;
      }
      //num2
      if (checkType(num2).equalsIgnoreCase("hexadecimal") || checkType(num2).equalsIgnoreCase("decimal")){
         if (checkType(num2).equalsIgnoreCase("hexadecimal")){
            hexBinary = convertToBinary(num2);
            hexBinary = hexBinary.substring(2);
            num2 = hexBinary;
         }
         else{
            decBinary = convertToBinary(num2);
            decBinary = decBinary.substring(2);
            num2 = decBinary;
         }
      }
      else{
         binBinary = num2.substring(2);
         num2 = binBinary;
      }
      //num3
      if (checkType(num3).equalsIgnoreCase("hexadecimal") || checkType(num3).equalsIgnoreCase("decimal")){
         if (checkType(num3).equalsIgnoreCase("hexadecimal")){
            hexBinary = convertToBinary(num3);
            hexBinary = hexBinary.substring(2);
            num3 = hexBinary;
         }
         else{
            decBinary = convertToBinary(num3);
            decBinary = decBinary.substring(2);
            num3 = decBinary;
         }
      }
      else{
         binBinary = num3.substring(2);
         num3 = binBinary;
      }
      num1Left = leftShift(num1, 2);
      num1Right = rightShift(num1, 2);
      num2Left = leftShift(num2, 2);
      num2Right = rightShift(num2, 2);
      num3Left = leftShift(num3, 2);
      num3Right = rightShift(num3, 2);
      
      
      System.out.println("Task 8:");
      //print num1Bin<<numShift=result,num1Bin>>numShift=result
      System.out.println(num1 + "<<2=" + num1Left + "," + num1 + ">>2=" + num1Right);
      //print num2Bin<<numShift=result,num2Bin>>numShift=result
      System.out.println(num2 + "<<2=" + num2Left + "," + num2 + ">>2=" + num2Right);
      //print num3Bin<<numShift=result,num3Bin>>numShift=result
      System.out.println(num3 + "<<2=" + num3Left + "," + num3 + ">>2=" + num3Right);
      System.out.print("\n");
      return true;
   }


   
}