#!/usr/bin/perl

my @tests = ( "http://v21.lscache6.c.youtube.com/videoplayback?sparams=id%2Cexpire%2Cip%2Cipbits%2Citag%2Calgorithm%2Cburst%2Cfactor%2Coc%3AU0hPRVFMVl9FSkNOOV9JRlpF&algorithm=throttle-factor&itag=34&ipbits=0&burst=40&sver=3&signature=CB42270D9BB77DDB5FB8B5F2C460DAFDC2ACCCBD.5D9F73A894DAD926C6F2D98D1D8A82EA8553D87C&expire=1300118400&key=yt1&ip=0.0.0.0&factor=1.25&id=9720a51b08130c5d",
              "314-555-4000",
              "800-555-4400",
              "(314)555-4000",
              "314.555.4000",
              "555-4000",
              "aasdklfjklas",
              "1234-123-12345"
            );

foreach my $test (@tests) {

my $url = $test;
if ($url=~s@^http://(.*?)/videoplayback\?(.*)id=(.*?)&.*@squid://videos.youtube.INTERNAL/ID=$3@){
	print "Matched1 on $test\n";
} elsif ($url=~s@^http://(.*?)/videoplayback\?(.*)id=(.*?)@squid://videos.youtube.INTERNAL/ID=$3@){
	print "Matched2 on $test\n";

} elsif ($url=~s@^http://(.*?)/videoplay\?(.*)id=(.*?)&.*@squid://videos.youtube.INTERNAL/ID=$3@){
	print "Matched3 on $test\n";

} elsif ($url=~s@^http://(.*?)/videoplay\?(.*)id=(.*?)@squid://videos.youtube.INTERNAL/ID=$3@){
	print "Matched4 on $test\n";

} elsif ($url=~s@^http://(.*?)/get_video\?(.*)video_id=(.*?)&.*@squid://videos.youtube.INTERNAL/ID=$3@){
	print "Matched5 on $test\n";
} else {
	print "No Match!";
}

print "$url\n"; }

