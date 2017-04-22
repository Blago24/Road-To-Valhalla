package sizes;

import com.badlogic.gdx.graphics.Texture;

public class SizesOfObjectsOnTheMap {

	public float checkTheTypeForHeight(int type) {

		switch (type) {
		case 0:
			return 46;
		case 1:
			return 46;

		case 2:
			return 46;
		case 3:
			return 46;

		case 7:
			return 2 * 46;
		case 8:
			return 2 * 46;
		case 9:
			return 2 * 46;
		case 10:
			return 3*46;
		case 11:
			return 46;

		default:
			return 46;
		}

	}

	public float checkTheTypeForWidth(int type) {

		switch (type) {
		case 0:
			return 46;
		case 1:
			return 46;

		case 2:
			return 46;
		case 3:
			return 46;

		case 7:
			return 2 * 46;
		case 8:
			return 2 * 46;
		case 9:
			return 3 * 46;
		case 10:
			return  46;
		case 11:
			return 46;

		default:
			return 46;

		}
	}
}
