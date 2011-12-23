CC=gcc
LIBS=`pkg-config --cflags --libs gtk+-2.0`

all: cpu.o
	$(CC) $(LIBS) -o cpuwidget main.c cpu.o 

cpu.o:
	$(CC) $(LIBS) -c -o cpu.o cpu.c

clean:
	rm -f *.o

cleanall: clean
	rm -f cpuwidget
