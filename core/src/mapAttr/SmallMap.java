package mapAttr;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import mapPieces.BackgroundPiece;
import mapPieces.Grass;
import textures.TextureInitializer;

public class SmallMap {
	private BackgroundPiece[][] pieces;
	
	private final float pieceSize = 46;
	private final int xRangeOfSmallMaps = 15;
	private final int yRangeOfSmallMaps = 10;
	TextureInitializer textures = TextureInitializer.getInstance();
	
	SpriteBatch batch = new SpriteBatch();
	
	public SmallMap(BackgroundPiece[][] cells)
	{
		this.pieces = cells;
	}
	
	public SmallMap()
	{
		
	}
	
	public void showSmallMap()
	{
		for(int i=0;i<xRangeOfSmallMaps;i++)
		{
			for(int j=0;j<yRangeOfSmallMaps;j++)
			{
				if(pieces[i][j] instanceof Grass)
				{
					batch.draw(textures.getGrass(), i*pieceSize, j*pieceSize, pieceSize, pieceSize);
				}
			}
		}
	}
	
	public BackgroundPiece getPieceAt(int x, int y)
	{
		return pieces[x][y];
	}
	
	public BackgroundPiece[][] geAllPieces()
	{
		return pieces;
	}
	
	public int getxRangeOfSmallMaps() {
		return xRangeOfSmallMaps;
	}

	public int getyRangeOfSmallMaps() {
		return yRangeOfSmallMaps;
	}
	
	public void setPieces(BackgroundPiece[][] pieces)
	{
		this.pieces=pieces;
	}
}
