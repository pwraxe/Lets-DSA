fun main() {	
    timer(5)
}

fun timer(n: Int) {
    if(n == 0) {
        print("$n ")
    	return
    }
    print("$n ")
    timer(n-1)
}

