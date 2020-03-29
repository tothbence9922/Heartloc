package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import sequences.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {	
		System.out.println("Choose");
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int c = -10;

		c = Integer.parseInt(br.readLine());
		
		while (c != -1) {
			
			switch(c) {
				case 0:
					break;
				case 1:
					Seq01 seq01 = new Seq01();
					break;
				case 2:
					Seq02 seq02 = new Seq02();
					break;
				case 3:
					Seq03 seq03 = new Seq03();
					break;
				case 4:
					Seq04 seq04 = new Seq04();
					break;
				case 5:
					Seq05 seq05 = new Seq05();
					break;
				case 6:
					Seq06 seq06 = new Seq06();
					break;
				case 7:
					Seq07 seq07 = new Seq07();
					break;
				case 8:
					Seq08 seq08 = new Seq08();
					break;
				case 9:
					Seq09 seq09 = new Seq09();
					break;
				case 10:
					Seq10 seq10 = new Seq10();
					break;
				case 11:
					Seq11 seq11 = new Seq11();
					break;
				case 12:
					Seq12 seq12 = new Seq12();
					break;
				case 13:
					Seq13 seq13 = new Seq13();
					break;
				case 14: 
					Seq14 seq14 = new Seq14();
					break;
				case 15:
					Seq15 seq15 = new Seq15();
					break;
				case 16:
					Seq16 seq16 = new Seq16();
					break;
				case 17:
					Seq17 seq17 = new Seq17();
					break;
				case 18:
					Seq18 seq18 = new Seq18();
					break;
				default:
					break;
			}	
			
			c = Integer.parseInt(br.readLine());
			br.readLine();
		}
	
	}
}

