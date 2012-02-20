typedef struct _CSVCol {
	int count;
	char *value[1];
} CSVCol;

typedef struct _CSVRow {
	int count;
	CSVCol rows[1];
} CSVRow;


void printUsage(char **);
CSVRow *ParseCSV(char *);

