fun main() {
    var rows = 10
    var ch = 'A'
    for (row in 1..rows) {
        for (col in 1 .. row) {
            print("${ch++} ")
        }
        println()
    }
}
//=============================================


/*******************
A 
B C 
D E F 
G H I J 
K L M N O 
P Q R S T U 
V W X Y Z [ \ 
] ^ _ ` a b c d 
e f g h i j k l m 
n o p q r s t u v w 
********************/
