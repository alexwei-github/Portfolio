import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

public class Student {
    
    /**
     * @desc takes in a nonnegative integer n and returns its English representation up to the hundred millions
     */
    public String solutionOne(int n) {

        String number = Integer.toString(n);
        String str = "";
        String[] firstDigitList = {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
        String[] tensList = {"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String[] secondDigitList = {"Twenty","Thirty","Fourty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        
        for (int i = 0; i < number.length(); i++) {
            switch (i) { //check for digit placement
                case 0:
                    if (n%100/10 == 1){ //teens
                        str = tensList[n%10];
                        i++;
                    }
                    else if (n%10 != 0){ //ones
                        str = firstDigitList[n%10-1];
                    }
                    break;
                case 1: //tens
                    if (n%100/10 != 0){
                        str = secondDigitList[n%100/10-2] + " " + str;
                    }
                    break;
                case 2: //hundreds
                    if (n%1000/100 != 0){
                        str = firstDigitList[n%1000/100-1] + " Hundred " + str;
                    }
                    break;
                case 3: //thousands
                    if (n%1000000/1000 != 0) { //checks whether there is any numbers in the thousands
                        str = "Thousand " + str;
                    }
                    if (n%100000/10000 == 1){ //teens
                            str = tensList[n%10000/1000] + " " + str;
                        i++;
                    }
                    else if (n%10000/1000 != 0){ //ones
                            str = firstDigitList[n%10000/1000-1] + " " + str;
                    }
                    break;
                case 4: //ten thousands
                    if (n%100000/10000 != 0){
                        str = secondDigitList[n%100000/10000-2] + " " + str;
                    }
                    break;
                case 5: //hundred thousands
                    if (n%1000000/100000 != 0){
                        str = firstDigitList[n%1000000/100000-1] + " Hundred " + str;
                    }
                    break;
                case 6: //millions
                    str = "Million " + str;
                    if (n%100000000/10000000 == 1){ //teens
                        str = tensList[n%10000000/1000000] + " " + str;
                        i++;
                    }
                    else if (n%10000000/1000000 != 0){ //ones
                        str = firstDigitList[n%10000000/1000000-1] + " " + str;
                    }
                    break;
                case 7: //ten millions
                    if (n%100000000/10000000 != 0){
                        str = secondDigitList[n%100000000/10000000-2] + " " + str;
                    }
                    break;
                case 8: //hundred millions
                    if (n%1000000000/100000000 != 0){
                        str = firstDigitList[n%1000000000/100000000-1] + " Hundred " + str;
                    }
                    break;
            }
        } 
        return str;
    }
    

    /**
     * @desc returns an array of the positions of the two elements in array n that combine to add up to a target t
     */
    public int[] solutionTwo(int[] n, int t) {
        
        for (int i = 0; i < n.length; i++){
            for (int j = i+1; j < n.length; j++){
                if (n[i] + n[j] == t){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }


    /**
     * @desc takes in an int n and returns a string array a where:
     * a[i] == "BubbleGum" if i is divisible by 3 and 5.
     * a[i]== "Bubble" if i is divisible by 3.
     * a[i] == "Gum" if i is divisible by 5.
     * a[i] == i (as a string) if none of the above conditions are true.
     */
    public List<String> solutionThree(int n) {

        List<String> l = new ArrayList<>();
        for (int i = 1; i < n+1; i++){
            if (i % 3 == 0 && i % 5 == 0)
                l.add("BubbleGum");
            else if (i % 3 == 0)
                l.add("Bubble");
            else if (i % 5 == 0)
                l.add("Gum");
            else
                l.add(Integer.toString(i));
        }
        return l;
    }

    /**
     * @desc returns array containing unique groups of three integers that add up to 0
     */
    public List<List<Integer>> solutionFour(int[] n) {
        List<List<Integer>> r= new ArrayList<>();

        //find combinations
        for (int i = 0; i < n.length; i++){
            for (int j = i + 1; j < n.length; j++){
                for (int k = j + 1; k < n.length; k++){
                    if (n[i] + n[j] + n[k] == 0){
                        r.add(new ArrayList<>(List.of(n[i],n[j],n[k])));
                    }
                }
            }
        }

        //sort combinations
        for (List<Integer> l : r)
            Collections.sort(l);

        List<List<Integer>> listNoDuplicates = new ArrayList<>();
    
        //put combinations into new list while removing duplicate combinations
        for (List<Integer> combination : r){
            if (!listNoDuplicates.contains(combination)){
                listNoDuplicates.add(combination);
            }
        }
        
        return listNoDuplicates;
    }

    
    /**
     * @desc determines the longest palindromic substring in a given string
     */
    public String solutionFive(String s) {

        //loops through string with different sized substrings checking if they are palindromes
        for (int i = s.length(); i >= 2; i--){
            for (int j = 0; j <= s.length()-i; j++){
                String reverse = "";
                for (int k = s.substring(j,j+i).length()-1; k >= 0; k--) { //reverses string
                    reverse = reverse + s.substring(j,j+i).charAt(k);
                }
                if (s.substring(j,j+i).equals(reverse)){ //compares for palindrome
                    return s.substring(j,j+i);
                }
            }
        }

        return s;
    }
}