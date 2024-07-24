import java.util.Arrays;
import java.util.Random;

public class Arr {

    public static void main(String[] args) {

        //sum - average
        int [] arr = new int[100];
        int sum = 0 ;
        for(int i = 0; i  < arr.length; i++){
            arr[i] = 1 + new Random().nextInt(25);//from 1 to 25 (1+25 and last digit not incl)
            sum += arr[i];}
        double average = (double) sum/arr.length;

        //finding larger number
        int [] arrr = {16, 13, 3, 8, 9, 6, 3, 10, 21, 19, 17, 7, 10, 25, 18, 6, 0, 24, 8, 4, 15, 10};
        int max = arrr[0];
        for (int i = 1; i < arrr.length; i++){
            if(arrr[i]> max){
                max = arrr[i]; }}
        //finding smaller number
        int [] minArr = {16, 13, 3, 8, 9, 6, 3, 10, 21, 19, 17, 7, 10, 25, 18, 6, 0, 24, 8, 4, 15, 10};
        int min = minArr[0];
        for (int i = 1; i < minArr.length; i++){
            if(minArr[i]< min){
                min = minArr[i]; }}
        //2 arrays - mix them - 1-1
        String[] firstarr = { "Pluto TV Kids", "CNET", "Pluto TV Sports", "Naturescape", "Fear Factor"};
        String[] secondarr = { "5c12fe49", "5c12fe44", "5c12fe4gr", "hgtykkjhh", "5c12feuyt" };
        for (int i = 0; i<firstarr.length && i<secondarr.length; i++){
            System.out.println(firstarr[i] + " , " + secondarr[i]);}
        //string into char arrays - str.toCharArray
        String str = "bottle";
        char [] chArrOFstr = str.toCharArray();
        System.out.println(Arrays.toString(chArrOFstr));
        //reverse array
        for (int i = 0, j = chArrOFstr.length-1; i <j; i++, j--){
        char temp = chArrOFstr[i];
        chArrOFstr[i] = chArrOFstr[j];
        chArrOFstr [j] = temp;
        }System.out.println(Arrays.toString(chArrOFstr));
        //to convert anything to String - VALUEOF
        String reversed = String.valueOf(chArrOFstr);

        //min and max with forEach loop
        int [] prices = {15432,234,3345,444,5556,6356,75,844,909};
        int mIn = Integer.MAX_VALUE;
        int mAx = Integer.MIN_VALUE;
        for (int price : prices) {
            if(price>mAx){
                mAx = price;}
            if (price<mIn){
                mIn = price;}}




    }
//check if num in array is sorted in ascending order
    public static boolean numsIncreasing(int[] arr) {
        for(int i = 0 ; i < arr.length-1; i++){
            if (arr[i]> arr[i+1]){
                return false;}
        }
        return true;}
//Arrays.equals(arr1, arr2); - to compare arrays
    // Check for adjacent duplicates in  array
    public static boolean duplicate(int[] arr) {
        Arrays.sort(arr);
        for(int i = 0 ; i < arr.length-1; i++){
            if (arr[i] == arr[i+1]){ //.equals for Strings
                return true;
            }}return false;}
//split string to array of single words perfom operations on them and join them back to string
    public static String  pigLatin(String str){
        String[] words = str.split(" ");
        for(int i =0; i< words.length; i++){
            String each = words[i];
            words[i] = each.substring(1) + each.substring(0,1)  + "ay";
        } return String.join(" ", words);}
    //words have same characters
    public static boolean isAnagram(String str1, String str2) {
        if(str1.length()!= str2.length()){
            return false;}
        char[]arr1 = str1.toCharArray();
        char[]arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return  (Arrays.equals(arr1, arr2));}
    //multidimensional array [][innerArray] - Arrays.deepTpString(arr)
    int[][] arr2D =  new int[][]{
            {0,1,2,3,4},
            {2,3,4,5,6},
            {3,4,5,6,7},
    };// Iterate over a 2d array
    public static void iterate2DArray(int[][] arr2D){
        for (int i = 0; i < arr2D.length ; i++) {
        for (int j = 0; j < arr2D[i].length ; j++) {
            // arr2D[i][j] = arr2D[i][j] * 10; - if we need to do some operations
            System.out.print(arr2D[i][j] + " ");}
        System.out.println();}
//        forEach loop iteration
//        for (int[] row: arr2D){
//            for(int cell: row){
//                System.out.print(cell + "\t");}
//            System.out.println();}
    }



}


