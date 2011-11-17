CC=gcc

libhowdy: 
	$(CC) -c myhowdy.c -o myhowdy.o
	ar rcs libhowdy.a myhowdy.o
	
clean:
	rm -f myhowdy.o
	rm -f libhowdy.a
	rm -f testhowdy
	rm -f myshowdy.o
	
test:
	$(CC) testhowdy.c myhowdy.c -o testhowdy
	
myshowdy.o:
	$(CC) -c -fPIC myhowdy.c -o myshowdy.o
	
shared: myshowdy.o
	$(CC) -shared -Wl,-soname,libhowdy.so.1 -o libhowdy.so.1.0.1  myshowdy.o
