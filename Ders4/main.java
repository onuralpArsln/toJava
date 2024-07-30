import Devices.Screen;
import Pieces.*;

public class main {
	public static void main(String[] args) {

		LPiece testPiece = new LPiece();
		testPiece.Define();
		SPiece testsPiece = new SPiece();
		testsPiece.Define();

		Screen testScreen = new Screen(100, 100);
		testScreen.Define();

	}

}
