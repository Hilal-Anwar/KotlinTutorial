package algorithems

import java.util.*

/*
My approach to solve this problem:
     # First i ask the user to enter the data in string format
     #Then i ask the number of elements for the data that he/she want to permuted(because every it is not necessary to permute the full elements)
     #Then i find the permutations using the method permutationValue.
 */
object Combination {
    @JvmStatic
    fun main(args: Array<String>) {
        var Value = 1.0
        var Size = 0
        val `in` = Scanner(System.`in`)
        var FinalValue = StringBuilder()
        val DigitHolder = LinkedList<Int>()
        val NumberHolder = HashSet<String>()
        val DataHolder = HashSet<String>()
        println("Enter your Data")
        val Data = `in`.nextLine()
        println("Enter the number of Element you want to choose from your data")
        val SizeLimit = `in`.nextInt()
        while (Value <= permutationValue(Data, SizeLimit)) {
            Size = 1
            while (Size <= SizeLimit) {
                val digit = (Math.random() * Data.length).toInt()
                if (!DigitHolder.contains(digit)) {
                    DigitHolder.add(digit)
                    Size++
                }
            }
            Collections.sort(DigitHolder)
            if (!NumberHolder.contains(DigitHolder.toString())) {
                NumberHolder.add(DigitHolder.toString())
                for (j in 0 until SizeLimit) {
                    FinalValue.append(Data[DigitHolder[j]])
                }
                if (!DataHolder.contains(FinalValue.toString())) {
                    print("$FinalValue   ")
                    if (Value % 10 == 0.0) println()
                    DataHolder.add(FinalValue.toString())
                }
                FinalValue = StringBuilder()
                Value++
            }
            DigitHolder.clear()
        }
    }

    fun permutationValue(d: String, limit: Int): Long {
        var fac1: Long = 1
        var fac2: Long = 1
        var fac3: Long = 1
        for (i in 1..d.length) {
            fac1 *= i
            if (i <= d.length - limit) fac2 *= i
            if (i <= limit) fac3 *= i
        }
        return fac1 / (fac2 * fac3)
    } /*
    static String CheckForSolve(String input){
        int count=0;
        for (int i=0;i<input.length();i++){
            for (int j=i+1;j<input.length()-1;j++)
            {
                if((int) input.charAt(i) > (int) input.charAt(j))
                    count++;
            }
        }
        if (count%2==0)
        return "Solvable";
        else return "Non-Solvable";
    }*/
}