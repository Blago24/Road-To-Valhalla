package movement;

import java.util.Random;

import entity.Entity;
import models.Hero;

public class MovementRandomiser {
	private static MovementRandomiser mover;
	Random rand = new Random();
	
	private MovementRandomiser()
	{
		
	}
	
	public static MovementRandomiser getInstance()
	{
		if(mover==null)
		{
			mover= new MovementRandomiser();
		}
		return mover;
	}
	
	public boolean decideIfWillMove(Hero hero, Entity entity)
	{
		int num = pickARandomNumber(10);
		if(num>=coefRisk(hero, entity))
		{
			return true;
		}else{
			return false;
		}
	}
	
	private double coefRisk(Hero hero,Entity entity) {
		int heroX = hero.getHeroMapRowPositionForMovement();
		int heroY = hero.getHeroMapColPositionForMovement();
		int entX = entity.getOnX();
		int entY = entity.getOnY();
		
		int distOnX = Math.abs(heroX-entX);
		int distOnY = Math.abs(heroY-entY);
		
		double absDist = Math.sqrt(distOnY^2+distOnX^2);
		
		return absDist;
	}
	
	public int pickARandomNumber(int bound)
	{
		return rand.nextInt(bound);
	}
	
}
