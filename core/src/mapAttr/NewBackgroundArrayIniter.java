package mapAttr;

import java.io.File;
import java.util.Random;

import mapPieces.BackgroundPiece;
import mapPieces.FatRock;
import mapPieces.FatTree;
import mapPieces.Grass;
import mapPieces.Hut;
import mapPieces.PlaceHolder;
import mapPieces.RockyGrass;
import mapPieces.Sapling;
import mapPieces.SmallRock;
import mapPieces.ThinRock;
import mapPieces.ThinTree;

public class NewBackgroundArrayIniter {
	private BigMap world = null;
	File txtMap = new File("map.txt");
	
	private final int placeHolderCell = 0;
	private final int grassCell = 1;
	private final int rockyGrass= 2;
	private final int fatRock = 3;
	private final int thinRock = 4;
	private final int smallRock = 5;
	private final int fatTree = 6;
	private final int thinTree = 7;
	private final int sapling = 8;
	private final int hutCell = 9;
	
	Random rand = new Random();
	
	
	public NewBackgroundArrayIniter()
	{
	}
	
	public BigMap initBigMap()
	{
		BigMap filledMap = null;
		SmallMap currentSmall = new SmallMap();
		BackgroundPiece[][] pieces = new BackgroundPiece[currentSmall.getxRangeOfSmallMaps()][currentSmall.getyRangeOfSmallMaps()];
		int num = 0;
		for(int i=0;i<currentSmall.getxRangeOfSmallMaps();i++)
		{
			for(int j=0;j<currentSmall.getxRangeOfSmallMaps();j++)
			{
				if(i>0 && i<currentSmall.getxRangeOfSmallMaps() && j>3 && j<currentSmall.getyRangeOfSmallMaps()-1)
				{
					num = rand.nextInt(8)+1;
				}else{
					num=1;
				}
				
				switch(num)
				{
				case placeHolderCell:{
					pieces[i][j] = new PlaceHolder(i,j);
					break;
				}
				case grassCell:{
					pieces[i][j] = new Grass(i,j);
					break;
				}
				case rockyGrass:{
					pieces[i][j] = new RockyGrass(i,j);
					break;
				}
				case fatRock:{
					int freeSpaces = 0;
					if(pieces[i+1][j] instanceof Grass || pieces[i+1][j] instanceof RockyGrass || pieces[i+1][j]==null)
					{
						//pieces[i+1][j] = new PlaceHolder(i+1, j);
						freeSpaces++;
					}else{
						pieces[i][j] = new RockyGrass(i+1, j);
						break;
					}
					if(pieces[i][j+1] instanceof Grass || pieces[i][j+1] instanceof RockyGrass || pieces[i][j+1]==null)
					{
						//pieces[i][j+1] = new PlaceHolder(i,j+1);
						freeSpaces++;
					}else{
						pieces[i][j] = new RockyGrass(i, j);
						break;
					}
					if(pieces[i+1][j+1] instanceof Grass || pieces[i+1][j+1] instanceof RockyGrass || pieces[i+1][j+1]==null)
					{
						//pieces[i+1][j+1] = new PlaceHolder(i+1,j+1);
						freeSpaces++;
					}else{
						pieces[i][j] = new RockyGrass(i,j);
						break;
					}
					if(freeSpaces==3)
					{
						pieces[i][j] = new PlaceHolder(i, j);
						pieces[i+1][j] = new PlaceHolder(i+1, j);
						pieces[i][j+1] = new PlaceHolder(i, j+1);
						pieces[i][j] = new FatRock(i,j);
					}
					break;
				}
				case thinRock:{
					checkIfThinRockIsPlacable(pieces, i, j);
					break;
				}
				case smallRock:{
					pieces[i][j] = new SmallRock(i,j);
					break;
				}
				case fatTree:{
					pieces[i][j] = new FatTree(i,j);
					pieces[i+1][j] = new PlaceHolder(i+1, j);
					i++;
					break;
				}
				case thinTree:{
					pieces[i][j] = new ThinTree(i,j);
					break;
				}
				case sapling:{
					pieces[i][j] = new Sapling(i,j);
					break;
				}
				case hutCell:{
					pieces[i][j] = new Hut(i,j);
					break;
				}
				}
				
			}
		}
		
		return filledMap;
	}
	
	private void checkIfThinRockIsPlacable(BackgroundPiece[][] pieces, int i, int j)
	{
		int freeSpaces = 0;
		if(pieces[i+1][j] instanceof Grass || pieces[i+1][j] instanceof RockyGrass || pieces[i+1][j]==null)
		{
			//pieces[i+1][j] = new PlaceHolder(i+1, j);
			freeSpaces++;
		}else{
			pieces[i][j] = new RockyGrass(i+1, j);
			return;
		}
		if(pieces[i][j+1] instanceof Grass || pieces[i][j+1] instanceof RockyGrass || pieces[i][j+1]==null)
		{
			//pieces[i][j+1] = new PlaceHolder(i,j+1);
			freeSpaces++;
		}else{
			pieces[i][j] = new RockyGrass(i, j);
			return;
		}
		if(pieces[i+1][j+1] instanceof Grass || pieces[i+1][j+1] instanceof RockyGrass || pieces[i+1][j+1]==null)
		{
			//pieces[i+1][j+1] = new PlaceHolder(i+1,j+1);
			freeSpaces++;
		}else{
			pieces[i][j] = new RockyGrass(i,j);
			return;
		}
		if(freeSpaces==3)
		{
			pieces[i][j] = new PlaceHolder(i, j);
			pieces[i+1][j] = new PlaceHolder(i+1, j);
			pieces[i][j+1] = new PlaceHolder(i, j+1);
			pieces[i][j] = new ThinRock(i,j);
			return;
		}
	}
	
	
	
	
}
