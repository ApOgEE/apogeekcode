# Author: M. Fauzilkamil Zainuddin <apogee@apogeek.com>
CC=gcc

all: sso-parser

sso-parser: sso-parser.c
	# compiling keyword sample
	$(CC) -o $@ $< `xml2-config --cflags --libs`

clean:
	# removing keyword.exe in MinGW
	rm -rf sso-parser.exe
	# thinking about keyword binary in Linux (untested)
	rm -rf sso-parser
