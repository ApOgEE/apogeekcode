#include <stdio.h>
#include <stdlib.h>
#include "../libhowdy/myhowdy.h"

int main () {
	printf("This is my test app using libhowdy\n");
	printf("----------------------------------\n");
	
	char * myout = malloc(100 * sizeof *myout);
	char * myname = malloc( 21 * sizeof * myname);
	
	sprintf(myname,"Mr. ApOgEE");
	
	myout = thehowdy(myname);
	
	printf("output: %s\n",myout);
	
	return 0;
}
