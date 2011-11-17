Kisah Pertama: Cubaan mengkompil
===============================

Ketika aku cuba mengkompil slibtest, ada kesengalan berlaku dimana, aku dapat error

    cannot find -lhowdy 
    collect2: ld returned 1 exit status

setelah aku puas mengejas2 dan mencari puncanya, akhirnya aku agak je sebab aku declare libhowdy.so.1 masa compile tu.
So, aku cuba buat link

    $ ln -s libhowdy.so.1.0.1 libhowdy.so.1

aku cuba compile lagi... pun tak jadi juga. Hampagas betul!
Kemudian aku cuba lagi buat satu link

    $ ln -s libhowdy.so.1.0.1 libhowdy.so

lepastu aku compile, Pergh... terus menjadi... yeayyy!!



Kisah kedua: Cubaan run binary tu
----

kisah seterusnya sebelum aku run, aku delete libhowdy.so.1 yang tak pernah digunakan
kemudian aku run la...

    $ ./slibtest

dan seperti yang dijangkakan, akan keluar error:
    
    ./slibtest: error while loading shared libraries: libhowdy.so.1: cannot open shared object file: No such file or directory

maka dengan konfidennya kerana aku ikut tutorial, maka aku pun taip camni...

    $ LD_LIBRARY_PATH=.
    $ ./slibtest

sekali, keluar juga error yang sama. Chisss!!! apakah yang berlaku ni?
lalu aku suspect, sebab aku delete libhowdy.so.1 tu.
sebab aku tengok kat error tu tulis camtu.
Jadi aku pun buat balik libhowdy.so.1 dan run lagi mcm tadi.

Hampas... masih tak berjaya juga.

Setelah berjam-jam aku memikirkannya. Tetiba aku teringat pasal export.
Aku pun main cuba-cuba je tambah export pulak,

    $ export LD_LIBRARY_PATH=. 
    $ ./slibtest

Walaweiiii.... berjaya juga untuk kesekian kalinya!!



Kesimpulan eksperimen ini
-------------------------

Kesimpulannya:

1. kena buat link bernama *.so sebelum compile
2. kena buat link bernama *.so.1 sebelum run
3. kena export LD_LIBRARY_PATH
4. Cara paling senang nak buat dan run aplikasi kecik ialah toksah mengada nak pakai shared library
5. Kalau apps yang nak dibuat adalah berskala besar dan banyak modul yang mungkin berubah, boleh la kita nak mengada2 buat shared library. 
6. Pengalaman yang diperoleh dari eksperimen ini berguna untuk pakai shared library orang lain. Open source punya library ada banyak.
7. Punca aku membuat eksperimen ini adalah kerana geram tengok zoiper (aplikasi SIP Phone) untuk linux yang guna satu binary je, dan tak payah install pun. Maka, aku suspek dia pakai static library sebab dia ada banyak pakai library-library open source juga.
8. static link library akan menjadikan binary kita besar. tapi yang bagusnya, kita boleh jadikannya portable


Notakaki
---------------------------------------

Untuk melarikan slibtest, kene include library dia dulu...

    export LD_LIBRARY_PATH=.
    ./slibtest

aku dah buat script untuk melarikannya kat `runtest.h`
