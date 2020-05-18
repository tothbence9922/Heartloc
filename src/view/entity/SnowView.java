package view.entity;

import javax.swing.ImageIcon;

/**
 * Az MVC modell alapjan a megjelelenitesert felelos egyik osztaly. Ebben az esetben a
 * Snow megjeleniteseert felel.
 * @author cserik
 *
 */

import controller.GameController;
/**
 * 
 * A ho megjelenitessert felelos osztaly, ez jeleniti meg a atekos szamara kis hogolyok formajaban, mennyit
 * kell meg asnia, hogy felvehessse a tablan talalhato eszozoket.
 * @author Gabor
 *
 */
public class SnowView extends EntityView {

	private static final long serialVersionUID = -8536002127200621216L;
	
	public SnowView(GameController baseGameController){
		super(baseGameController);
		this.w = this.h = 32;
		//Beolvassuk a hogolyok megjeleniteseert felelos kepet
		icon = new ImageIcon(SnowView.class.getResource("../images/snowBallBig-32x32.png"));
		this.setIcon(icon);
	}
}
