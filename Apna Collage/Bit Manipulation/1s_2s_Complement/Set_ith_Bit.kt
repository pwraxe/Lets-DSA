//Set bit mean if i-th bit is 0 then set to 1 
//if i-th bit is 1 then it will remain as it as
//just change bit from 0 to 1

example 

num = 53
         7 6 5 4 3 2 1 0   <--- index from left to right just understanding purpose
53    =  0 0 1 1 0 1 0 1


//Why index left to right (R<--L)
//when we take binary of , then LSB is 1 rest is 0, when we shift that 1 to left side then value getting increse 

I want set 3rd bit to 1
val mask = 1 shl 3
       1 = 0 0 0 0 0 0 0 1
 1 shl 3 = 0 0 0 0 1 0 0 0

oring between num and mask  (num or mask)
by doing oring rest or remaining index/bits remains same with no change only index bit get change

num   =  0 0 1 1 0 1 0 1  == decimal = 53
mask  =  0 0 0 0 1 0 0 0  == 1 shl 3 == decimal = 8
        ____________________
oring =  0 0 1 1 1 1 0 1  
         7 6 5 4 3 2 1 0  <----- index of bits (for understanding)


                  7 6 5 4 3 2 1 0 <----- index of bits (for understanding)
num b4 oring    = 0 0 1 1 0 1 0 1  <--- decimal-- 53
num after oring = 0 0 1 1 1 1 0 1  <--- decimal-- 61
                  --------1------  <-- as you can see 3rd index is change in this output


Note: if you do same for index 0, 2, 4, 5 --> then output will be same as num becoz that index already has bit 1, 
and 1 or 1 = 1



         


