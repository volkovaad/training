import java.util.Random;

public class practice {
    public static void main(String[] args) {
        //System.out.println((int)(1 + Math.random() * 10));

        System.out.println(mid("string"));
        System.out.println(mid("hi"));
        System.out.println(mid("code"));
        System.out.println(mid("window"));


        System.out.println(mid1("string"));
        System.out.println(mid1("hi"));
        System.out.println(mid1("code"));
        System.out.println(mid1("window"));

        System.out.println(rev("string"));

        System.out.println(rever(45687));

        System.out.println(clean("str45665%$#@#@! @E$#@ing"));

        System.out.println(mixedSt("stringHithere"));

    }

    public static String mid(String str) {
String one = str.substring(0, str.length() / 2);
String two = str.substring(str.length() / 2, str.length());
return one.substring(one.length() - 1) + two.substring(0, 1);}

    //Random
    char rand = (char) (Math.random() * 26 + 'A');
    int RandomNum = (int) (10+ Math.random() * 15);//from 10 to 24
    int sameRandom = 10 + new Random().nextInt(15);
    //reverse 2 variables
    public void reverseVAR(){
        int a = 10;
        int b = 20;
        int temp = a;
        a = b;
        b = temp;
    // Swapping without a temporary variable
    a = a + b; // a now becomes 30 (10 + 20)
    b = a - b; // b now becomes 10 (30 - 20)
    a = a - b; // a now becomes 20 (30 - 10)
    }
//2 middle characters of string
    public static String mid1(String str) {
int middle = str.length() / 2;
return str.substring(middle - 1, middle + 1);}
//reverse string
public static String rev(String str) {
String ch = "";
for (int i = str.length() - 1; i >= 0; i--) {
char c = str.charAt(i);
 ch += c;}
return ch;}
//reverse String - STRINGBUILDER
public static String reverseKeepingTheOrderOfSpaces(String str){
    // Reverse the chars by omitting spaces
    StringBuilder reversed = new StringBuilder();
    for (int i = str.length()-1; i >= 0 ; i--) {
        if(str.charAt(i) != ' '){  // if the char is a space don't append to the stringbuilder
            reversed.append(str.charAt(i));}
    }for (int i = 0; i < str.length(); i++) {  // Iterate through original string and if the char is a space, insert space into a stringbuilder
        if(str.charAt(i) == ' '){
            reversed.insert(i, ' ');}} // insert space if the char at given index is a space
    return reversed.toString();
    }
//reverse number
    public static int rever(int num) {
int reversed = 0;
while (num > 0) {
int last = num % 10;
reversed = reversed * 10 + last;
num /= 10;}
return reversed;}
//clean string - leave only num and letters
    public static String clean(String str) {
String clean = "";
for (int i = 0; i < str.length(); i++) {
if (Character.isLetterOrDigit(str.charAt(i))) {
   clean += str.charAt(i);}
        }
 return clean;}
//mix characters from 2 strings
    public static String mixedSt(String str) {
String collect = "";
for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
char start = str.charAt(i);
char end = str.charAt(j);
collect = collect + start + end;
//for pallindrome checking
// if (start != end) {
//return false;
// }
 } return collect;}
    //random String
    public static String randomString(int length){
        // You can use this approach to control the characters in your random string
        String a = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String randomStr = "";
        for(int i = 0; i < length; i++){
            int randIndex = (int)(Math.random() * a.length());
            randomStr += a.charAt(randIndex);}
        return randomStr;
    }

}

