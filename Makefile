#  Makefile
#
#  Copyright 2012 M. Fauzilkamil Zainuddin <jerungkun@gmail.com>
#
#  This program is free software; you can redistribute it and/or modify
#  it under the terms of the GNU General Public License as published by
#  the Free Software Foundation; either version 2 of the License, or
#  (at your option) any later version.
#
#  This program is distributed in the hope that it will be useful,
#  but WITHOUT ANY WARRANTY; without even the implied warranty of
#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#  GNU General Public License for more details.
#
#  You should have received a copy of the GNU General Public License
#  along with this program; if not, write to the Free Software
#  Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
#  MA 02110-1301, USA.
#
#  Note:
#	To build this program, you have to install
#	- libxml2
#
#	For compiling in Windows (Cygwin or MinGW), set WIN32 flag to y
#	For compiling in Linux, set the WIN32 flag to n
#

CC = gcc
WIN32 = y
all: sso-parser

sso-parser: sso-parser.c
	# compiling keyword sample
	$(CC) -o $@ $< `xml2-config --cflags --libs`

clean:
ifeq ($(WIN32),y)
	# removing *.exe in MinGW or cygwin
	rm -rf sso-parser.exe
else
	# thinking about binary in Linux (untested)
	rm -rf sso-parser
endif
