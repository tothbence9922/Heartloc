package model;

import java.util.Scanner;

import entity.item.Item;
import entity.item.optionalitem.Food;
import entity.item.optionalitem.Rope;
import entity.item.optionalitem.Wetsuit;
import entity.item.targetitem.Beacon;
import entity.player.Eskimo;

import sequences.Seq04;
import sequences.Seq10;
import sequences.Seq18;
import sequences.Seq02;
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
			sc.close();
			break;
		case 1:
			Seq01 seq01 = new Seq01();
			break;
		case 2:
			Seq02 seq02 = new Seq02();
			sc.close();
			break;

		case 4:
			Seq04 seq04 = new Seq04();
			sc.close();
			break;
		case 10:
			Seq10 seq10 = new Seq10();
			sc.close();
			break;

		case 14: 
			Seq14 seq14 = new Seq14();
        sc.close();
			break;
		case 16:
			Seq16 seq16 = new Seq16();
      sc.close();
			break;
		case 18:
			Seq18 seq18 = new Seq18();
			sc.close();
			break;
		default:
			sc.close();
		}
	}
}

