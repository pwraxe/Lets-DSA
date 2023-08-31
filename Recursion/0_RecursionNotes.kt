Permutation Vs TakeNotTake 
--------------------------
  
Permutation
- In the Permutation Method, We swap elements twice in a loop before and after the recursive function call
Ex. 
fun todo() {

  //Base Condition
  loop(index to input.size) {
    
    swap() //swapping for the next combination in the same depth
    todo()
    swap() //undo swapping for the next combination in the next tree branch
  }
}
===========================================================================================
  
TakeNotTake || Backtracking
  - In the take-not-take Method, we add an element in the sublist, then remove an element from the sublist and recursive call twice, 
  - In this, we call the function recursively only once, before that we add an element, and after the function, we remove an element from 

Ex. 
fun todo() {
  //base condition
  add Element
  todo(...)
  remove element
}

===========================================================================
When Body Executes before recursive function calls, input is always in sequential order
When Body Executes after recursive call input is always in reverse order
Ex. print no before and after sending half of no. to recursive call

