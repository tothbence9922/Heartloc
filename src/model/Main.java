package model;

import java.io.IOException;
import java.util.Scanner;

import sequences.Seq01;
import sequences.Seq02;
import sequences.Seq03;
import sequences.Seq04;
import sequences.Seq05;
import sequences.Seq06;
import sequences.Seq07;
import sequences.Seq08;
import sequences.Seq09;
import sequences.Seq10;
import sequences.Seq11;
import sequences.Seq12;
import sequences.Seq13;
import sequences.Seq14;
import sequences.Seq15;
import sequences.Seq16;
import sequences.Seq17;
import sequences.Seq18;


public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {	
		System.out.println("Choose a sequence from 1 to 18");
		System.out.println("Only enter a number");
		
		Scanner sc = new Scanner(System.in);   
		int c = sc.nextInt();
		
		while (c != -1) {
			switch(c) {
				case 0:
					break;
				case 1:
					Seq01 seq01 = new Seq01(sc);
					break;
				case 2:
					Seq02 seq02 = new Seq02(sc);
					break;
				case 3:
					Seq03 seq03 = new Seq03(sc);
					break;
				case 4:
					Seq04 seq04 = new Seq04(sc);
					break;
				case 5:
					Seq05 seq05 = new Seq05(sc);
					break;
				case 6:
					Seq06 seq06 = new Seq06(sc);
					break;
				case 7:
					Seq07 seq07 = new Seq07(sc);
					break;
				case 8:
					Seq08 seq08 = new Seq08(sc);
					break;
				case 9:
					Seq09 seq09 = new Seq09(sc);
					break;
				case 10:
					Seq10 seq10 = new Seq10(sc);
					break;
				case 11:
					Seq11 seq11 = new Seq11(sc);
					break;
				case 12:
					Seq12 seq12 = new Seq12(sc);
					break;
				case 13:
					Seq13 seq13 = new Seq13(sc);
					break;
				case 14: 
					Seq14 seq14 = new Seq14(sc);
					break;
				case 15:
					Seq15 seq15 = new Seq15(sc);
					break;
				case 16:
					Seq16 seq16 = new Seq16(sc);
					break;
				case 17:
					Seq17 seq17 = new Seq17(sc);
					break;
				case 18:
					Seq18 seq18 = new Seq18(sc);
					break;
				default:
					break;
			}	
			System.out.println("Choose a sequence from 1 to 18");
			c = sc.nextInt();
		}
	
	}
}

