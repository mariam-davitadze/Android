fun main() {
    println(getSum(arrayOf(1,2,0,2,2,0)));
    println(isPalindrome("aba"));
    println(isPalindrome("mari"));
}

fun getSum(arr: Array<Int>): Int {
    var sum: Int = 0;
    var i: Int = 0;
    while (i < arr.size) {
        sum = sum + arr.elementAt(i);
        i = i + 2;
    };
    return sum;
}

fun isPalindrome(word: String): Boolean {
    var reversed = StringBuilder(word).reverse().toString();
   	return word == reversed;
}