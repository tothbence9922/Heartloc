package model;

import java.util.Scanner;

import sequences.Seq01;
import sequences.Seq04;
import sequences.Seq14;
import sequences.Seq16;

public class Main {
	public static void main(String[] args) {
		System.out.println("Choose");
		Scanner sc = new Scanner(System.in);
		int  c = sc.nextInt();
		
		switch(c) {
		case 0:
			break;
		case 1: 
			Seq01 seq01 = new Seq01();
			break;
		case 2: 
			break;
		case 4:
			Seq04 seq04 = new Seq04();
			break;
		case 14: 
			Seq14 seq14 = new Seq14();
			break;
		case 16:
			Seq16 seq16 = new Seq16();
			break;
		default:
			sc.close();
		}
	}
}

