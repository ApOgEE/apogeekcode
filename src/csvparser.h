typedef struct _CSVCol {
	int count;
	char **value;
} CSVCol;

typedef struct _CSVRow {
	int count;
	CSVCol *rows;
} CSVRow;


void printUsage(char **);
