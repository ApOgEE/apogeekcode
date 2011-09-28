#!/usr/bin/perl

my @tests = ( "314-555-4000",
              "800-555-4400",
	      "(314)555-4000",
              "314.555.4000",
              "555-4000",
              "aasdklfjklas",
              "1234-123-12345"          
            );

foreach my $test (@tests) {
    if ( $test =~ m/
                   \(?     # optional parentheses
                     \d{3} # area code required
                   \)?     # optional parentheses
                   [-\s.]? # separator is either a dash, a space, or a period.
                     \d{3} # 3-digit prefix
                   [-\s.]  # another separator
                     \d{4} # 4-digit line number
                   /x ) {
        print "Matched on $test\n";
     }
     else {
        print "Failed match on $test\n";
     }
}
