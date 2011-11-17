#include <stdio.h>
#include <stdlib.h>
#include "myhowdy.h"

int main() {
	
	char * myname;
	myname = malloc( 21 * sizeof * myname);
	sprintf(myname,"Ahmad");
	printf("the name is %s\n",myname);
	
	char * hoho = malloc(100 * sizeof * hoho);
	
	hoho = thehowdy(myname);
	
	printf("out: %s\n",hoho);
	
	return 0;
	
}
