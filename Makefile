all: csvparser

csvparser: src/Makefile
	$(MAKE) -C src
	cp src/csvparser .

clean: src/Makefile
	$(MAKE) clean -C src
	rm -rf csvparser
