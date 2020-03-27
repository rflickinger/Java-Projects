import java.util.ArrayList;
import java.util.Arrays;
public class Fibonacci {
    /* code for
    //use args to input number, java fibonnacci <int to start at> <int total amount of trailing numbers>
    public static void main(String[] args){
        ArrayList<Integer> numbers = new ArrayList<Integer>(); //ArrayList to be returned/printed
        int startInt = Integer.parseInt(args[0]);
        int arraySize = Integer.parseInt(args[1]) + 1;
        numbers.add(0);
        numbers.add(startInt);
        //add next in sequence
        for(int i = 2; i <= arraySize + 1; i++){
            int a = numbers.get(i-2);//first number to add
            int b = numbers.get(i-1);//second number to add
            if((a+b) > 0) {
                numbers.add(a+b);
            } else {
                System.out.println("Number too large");
                break;
            }
        }
        System.out.println(numbers);
        System.out.println(numbers.size());
    }*/
    public Fibonacci(){
    }
    public String addStrings(String a, String b){ //adds the value of each int in the string
        String firstNum = a;         //first string input  ""
        String secondNum = b;        //second string input  ""
        String finalOutput = "";     //what I want to return "7023"
        int currentA = 0;            //current character in string a 0
        int currentB = 0;            //current character in string b 0
        int totalNum = 0;            //total of addition in int form 0
        int remainder = 0;           //remainder of current adding   0

        while(secondNum.length() != 0){ //stops when length of secondNum = 0
            if(firstNum.length() != 0) {
                currentA = Integer.parseInt(firstNum.substring(firstNum.length()-1)); //sets currentA to last number in string
                if(firstNum.length() > 1) {           //checks that the string has more than one character to avoid out of bounds exception
                    firstNum = firstNum.substring(0, firstNum.length()-1); //chops off last character
                } else {
                    firstNum = "";                    //if only one character in string, sets to ""
                }
            }
            currentB = Integer.parseInt(secondNum.substring(secondNum.length()-1)); //sets currentB to last number in string
            if(secondNum.length() > 1){            //same as if else for firstNum
                secondNum = secondNum.substring(0, secondNum.length()-1);
            } else{
                secondNum = "";
            }
            totalNum = currentA + currentB + remainder; //adds both current numbers and remainder from last addition
            currentA = 0;                               //sets currentA back to zero
            currentB = 0;                               //sets currentB back to zero
            remainder = 0;                              //sets remainder back to zero
            if(totalNum > 9){                           //checks if number is more than one digit
                remainder = 1;                          //sets remainder for next iteration
                totalNum = totalNum - 10;               //brings total to one digit
            }
            finalOutput = Integer.toString(totalNum) + finalOutput; //adds digit to string
        }
        if(remainder == 1){
            finalOutput = "1" + finalOutput;
        }
        return finalOutput;
    }
    public static void main(String[] args){
        ArrayList<String> numbers = new ArrayList<String>(); //ArrayList to return
        Fibonacci fib = new Fibonacci();                     //Object for calling method
        int startInt = Integer.parseInt(args[1]) + 1;            //how many numbers in sequence after zero and initial number
        numbers.add("0");
        numbers.add(args[0]);

        for(int i = 2; i <= startInt; i++){
            String a = numbers.get(i-2);
            String b = numbers.get(i-1);
            numbers.add(fib.addStrings(a, b));
        }
        System.out.println(numbers);
        System.out.println("Initiating coding_orgasm.exe");
    }
}
