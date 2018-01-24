import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
/**
 * Write a description of class Charmander here.
 * 
 * @author (Brandan Michelle) 
 * @version (a version number or a date)
 */
public class Ivysaur extends Creature
{
    public Ivysaur( World w )
    {
        super(720,true, "Grass");
        getImage().scale(150, 100);
        w.addObject( getHealthBar(), 300,w.getHeight() - 50 );
        getHealthBar().getImage().setTransparency(0);
    }
    
    /**
     * void attack is the creature attacking another creature
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void attack ( int idx )
    {
        CreatureWorld world = ( CreatureWorld)getWorld();
        Creature enemy = world.getPlayerTwo();
        String enemyType = enemy.getType();
        attackAnimation();
        if ( idx == 0 )
        {
            enemy.getHealthBar().add( -30 );
        }
        else
        {
            if( enemyType.equalsIgnoreCase ("Electric") )
            {
                enemy.getHealthBar().add( -60/2 );
                getWorld().showText("It's Not Very Effective...", getWorld().getWidth()/2, getWorld().getHeight()/2 + 26);
                Greenfoot.delay(30);
            }
            else if( enemyType.equalsIgnoreCase ("Flying") )
            {
                enemy.getHealthBar().add( -60/2 );
                getWorld().showText("It's Not Very Effective...", getWorld().getWidth()/2, getWorld().getHeight()/2 + 26);
                Greenfoot.delay(30);
            }
            else if( enemyType.equalsIgnoreCase ("Water") )
            {
                enemy.getHealthBar().add( -60*2 );
                getWorld().showText("It's Super Effective!", getWorld().getWidth()/2, getWorld().getHeight()/2 + 26);
                Greenfoot.delay(30);
            }
            else
            {
                enemy.getHealthBar().add( -60 );
            }
        }
        world.setTurnNumber(false);
    }
    
    /**
     * void attackanimation is the code that make the creature move
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void attackAnimation()
    {
        int originalX = getX();
        int originalY = getY();
        originalX = getX();
        originalY = getY();
        for(int i = 0; i < 15;i++)
        {
            setLocation( getX() + 1, getY() -2 );
            Greenfoot.delay(1);
        }
        setLocation( originalX, originalY );
    }
    
    /**
     * void switchCreature is the code that switchs your creature to another
     * 
     * @param int idx
     * @return Nothing is returned
     */
    public void switchCreature( int idx )
    {
        CreatureWorld world = ( CreatureWorld)getWorld();
        Creature switchCreature;
        
        if ( idx == 0 )
        {
            switchCreature = world.getNewOneCreature(0);
        }
        else 
        {
            switchCreature = world.getNewTwoCreature(1);
        }
        
        if ( switchCreature.getHealthBar().getCurrent() <= 0 )
        {
            JOptionPane.showMessageDialog( null, "This creature has fainted! Please select a different creature." );
        }
        else
        {
            while( getX() > 0 )
            {
                setLocation( getX() - 5, getY() );
                Greenfoot.delay(2);
            }
            getImage().setTransparency(0);
            getHealthBar().getImage().setTransparency(0);
            if( idx == 0 )
            {
                world.changePlayerOne("Charmander");
            }
            else
            {
                world.changePlayerOne("Golem");
            }
            switchCreature.switchedIn();
            world.setTurnNumber(false);
        }
        
        
    }
    
    /**
     * void switchedIn is the code that makes your ceature fade away then add a new
     * 
     * @param int idx
     * @return Nothing is returned
     */
    public void switchedIn()
    {
        getImage().setTransparency(255);
        getHealthBar().getImage().setTransparency(255);
        while( getX() < 75 )
        {
            setLocation( getX() +5, getY() );
            Greenfoot.delay(2);
        }
    }
    
    /**
     * Act - do whatever the Charmander wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        CreatureWorld playerWorld = (CreatureWorld)getWorld();
        
        if( getHealthBar().getCurrent() <= 0)
        {
           getWorld().showText("Ivysaur has fainted...", getWorld().getWidth()/2, getWorld().getHeight()/2 + 26);
           Greenfoot.delay(30);
           if( playerWorld.getNewOneCreature(0).getHealthBar().getCurrent() > 0 )
           {
               switchCreature(0);
               playerWorld.setTurnNumber(true);
               getWorld().showText("",getWorld().getWidth()/2, getWorld().getHeight()/2 + 26);
           }
           else if( playerWorld.getNewOneCreature(1).getHealthBar().getCurrent() > 0 )
           {
               switchCreature(1);
               playerWorld.setTurnNumber(true);
               getWorld().showText("",getWorld().getWidth()/2, getWorld().getHeight()/2 + 26);
           }
        }
    }
}
