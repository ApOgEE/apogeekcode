#!/usr/bin/perl

# Pengarang: M. Fauzilkamil Zainuddin <apogee@apogeek.com>
# Sinopsis: Ketika bosan, aku pun membuat skrip perl "Hello World!" 
#           versi Melayu  

# memberi salam 
print "Salam Sejahterai Dunia!\n";
print "-----------------------\n";

# bermain dengan Array
@bulan = ("Januari", "Februari", "Mac", "April", "Mei");

foreach (@bulan) {
	print "Bulan " . $_ . "\n";
}

@lagibulan = qw(Jun Julai Ogos September Oktober November Disember);

foreach $bulanan (@lagibulan) {
	print "Bulan " . $bulanan . "\n";
}

print "-----------------------\n";
print "Kesimpulannya, takde apa yang berfaedah pun dilakukan oleh skrip ini... hahahaha!\n";
