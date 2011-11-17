#include <stdio.h>
#include <stdlib.h>
#include "myhowdy.h"

int main () {
	printf("This is my test app using dynamic libhowdy\n");
	printf("------------------------------------------\n");
	
	char * myout = malloc(100 * sizeof *myout);
	char * myname = malloc( 21 * sizeof * myname);
	
	sprintf(myname,"Encik Fauzi");
	
	myout = thehowdy(myname);
	
	printf("output: %s\n",myout);
	
	return 0;
}
