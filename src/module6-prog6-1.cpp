/*
 * Program 6.1
 * Author: M. Fauzilkamil Zainuddin
 * Matric: SX040175CKJ04
 * Lab1: Basic Sequential Search
 * 
 */

 #include <iostream.h>

 int CarianJujukan(int [], int, int);

 int main() {
 	int nom[100];
   int k, target, j;
   char ans = 'y';

   cout << "Masukkan saiz tatasusunan:";
   cin >> k;

   for (int i = 0; i < k; i++) {
   	cout << "nom[" << i << "] = ";
      cin >> nom[i];
   }
   do {
   	cout << "\nMasukkan nombor yang ingin dicari: ";
      cin >> target;

      j = CarianJujukan(nom, k, target);
      if (j == -1)
      	cout << "gagal" << endl;
      else
      	cout << "berjaya isitu unsur nom[" << j << "]\n";
         cout << "Cari nombor yang lain?: ";
         cin >> ans;

   } while (ans == 'y');
   
   return 0;
 }

 int CarianJujukan(int a[], int n, int target) {
 	int i;
   for (i=0; i < n; i++)
   	if(a[i]==target)
      	return i;

   return -1;
 }
