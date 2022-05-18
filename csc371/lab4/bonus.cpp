#include <iostream>
#include "intvector.hpp"

#define INTVECTOR_INIT_SIZE 10

int main() {
  // create initial struct
  struct intvector x;
  printf("Construct x");
  intvector_construct(&x, INTVECTOR_INIT_SIZE);
  
  // can we add?
  printf("\n\nPush 1 to x\n  ");
  intvector_push(&x, 1);

  printf("\nPrint x (data is at %p)\n  ", x.data);
  intvector_print(&x);
  
  // copy the struct
  printf("\nDeep copy x to y");
  struct intvector y;
  intvector_copy_construct(&y, &x);
    
    // can we add?
  printf("\n\nPush 2 to x\n  ");
  intvector_push(&x, 2);

  // print original struct
  printf("\nPrint x (data is at %p)\n  ", x.data);
  intvector_print(&x);

   // print new struct
  printf("\nPrint y (data is at %p)\n  ", y.data);
  intvector_print(&y);

  // destroy original struct
  printf("\nDestruct y");
  intvector_destruct(&y);

  // print original struct
  printf("\n\nPrint x (data is at %p)\n  ", x.data);
  intvector_print(&x);

  // print new struct
  printf("\nPrint y (data is at %p)\n  ", y.data);
  intvector_print(&y);
  
  
  
  // copy assignment
  
  // create a new struct
  printf("\nConstruct z with one value\b");
  struct intvector z;
  intvector_construct(&z, 5);
  intvector_push(&z, 5);

  // print original struct
  printf("\n\nPrint x (data is at %p)\n  ", x.data);
  intvector_print(&x);

  // print third struct
  printf("\nPrint z (data is at %p)\n  ", z.data);
  intvector_print(&z);
  
  // copy assign
  printf("\ncopy assign x to z\n");
  intvector_copy_assign(&z, &x);

  // print original struct
  printf("\nPrint x (data is at %p)\n  ", x.data);
  intvector_print(&x);

  // print third struct
  printf("\nPrint z (data is at %p)\n  ", z.data);
  intvector_print(&z);
}