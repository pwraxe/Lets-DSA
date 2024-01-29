//1. You have a num, take it's Binary
//2. get 1 and left shift 1 to i'th, bit
//3. anding between mask and num 
//4. if num > 0 then i'th bit is 1 else 0


1 2 4 16  32 64
Ex. 
I want 4th (index) bit
val num = 119  == Bin == 0 1 1 1 0 1 1 1
// Note: consider binary num as 0 based index from RIGHT to LEFT (<--)
//opposite of Array(Array index from LEFT to Right)

127 = 0  1  1  1  0  1  1  1    <--- Binary Num 
      7  6  5  4  3  2  1  0    <--- Index

This becoz when you have 1 then it is in this format
     0 0 0 0 0 0 0 1    <--- 1
     this why you need to shift 1 to Left side (shl)

val mask = 1 shl 4    i.e. shift 1 to 4 bit left side
    mask   0 0 0 0 1 0 0 0


and num and mask
num  119  = 0 1 1 1 0 1 1 1
mask      = 0 0 0 0 1 0 0 0 
        _______________________
            0 0 0 0 0 0 0 0    <---- all 0's  i.e. 4th bit is 0

I want 5th bit
119       = 0 1 1 1 0 1 1 1 
1 shl 5   = 0 0 0 1 0 0 0 0
        ____________________
            0 0 0 1 0 0 0 0   <---- Decimal--- 16 i.e. Non Zero or grater than 0 Hence 5th Bit is 1

            
