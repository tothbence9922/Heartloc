package model;

public class Game {
	/**
	 *  A j�t�k megnyer�sekor megh�v�d� met�dus, mag�val vonzza
	 *	az EndGame() met�dus megh�v�s�t, ekkor a j�t�kos gy�zelm�t k�nyvelhetj�k
	 *	el.
	 */
	public void victory(){
		System.out.println("Game\tvoid victory()\tparam: -");
	}
	/**
	 *  A j�t�k v�gekor megh�v�d� met�dus, mellyel
	 *  v�gleges�thetj�k a j�t�k �ll�s�t �s lez�rhatjuk a j�t�kot.
	 */
	public void EndGame() {
		System.out.println("Game\tvoid EndGame()\tparam: -");
	}
}
