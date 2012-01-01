/*
 *      openfile.java
 *      
 *      Copyright 2012 M. Fauzilkamil Zainuddin <jerungkun@gmail.com>
 *      
 *      This program is free software; you can redistribute it and/or modify
 *      it under the terms of the GNU General Public License as published by
 *      the Free Software Foundation; either version 2 of the License, or
 *      (at your option) any later version.
 *      
 *      This program is distributed in the hope that it will be useful,
 *      but WITHOUT ANY WARRANTY; without even the implied warranty of
 *      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *      GNU General Public License for more details.
 *      
 *      You should have received a copy of the GNU General Public License
 *      along with this program; if not, write to the Free Software
 *      Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 *      MA 02110-1301, USA.
 */

package org.apogeek;
import java.io.*;


public class openfile
{
	public static void main(String args[])
	{
		try {
			// open the file
			FileInputStream myfstream = new FileInputStream("myinput.csv");
			// convert to DataInputStream
			DataInputStream dinp = new DataInputStream(myfstream);
			
			while (dinp.available() !=0)
			{
				// Print each file line to screen
				System.out.println(dinp.readLine());
			}
			
			dinp.close();
		} catch (Exception e)
		{
			System.err.println("File input error");
		}

	}
}
