/**
 * main.c - CSV Parser in C
 *
 * Author: M. Fauzilkamil Zainuddin <apogee@apogeek.com>
 * Copyright (C) 2012, M. Fauzilkamil Zainuddin
 *
 */
#include <stdio.h>
#include "csvparser.h"

void printUsage(char **arg) {
	printf("Usage: %s csvfile\n", arg[0]);
}

CSVRow *ParseCSV(char *filename)
{
	CSVRow *csvrow;
	//CSVCol col;

	// manual add for testing
	//col->count = 1; // 1st column
	//col->

	return csvrow;
}

int main(int argc, char **argv) {
	char *filename;
	CSVRow csv_rows;

	printf("ApOgEE's Simple CSV Parser\n");

	if (argc < 2) {
		printUsage(argv);
		return -1;
	}
	
	filename = argv[1];

	printf("Filename: %s\n", filename);

	return 0;
}
