#include <stdio.h>
#include <stdlib.h>

char * thehowdy(char * name) {
	char * sHowdy;
	
	sHowdy = malloc( 100 * sizeof * sHowdy);
		
	sprintf(sHowdy, "Yo, Howdy %s !!", name);
	
	return sHowdy;
}
