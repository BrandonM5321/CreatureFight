import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Creature here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Creature extends Actor
{
    private int healthNumber;
    private boolean playerOneCreature;
    private HealthBar creatureBar;
    private String type;
    
    /**
     * Default constructor for objects of the Creature class
     * @autor (Brandan MIchelle)
     * @param There are no parameters
     * @return an object of the Creature class
     */
    public Creature()
    {
        healthNumber = 500;
        playerOneCreature = true;
        creatureBar = new HealthBar(healthNumber, healthNumber, 10);
    }
    

    /**
     * Constructor that allows customization of objects of the Creature class
     * 
     * @param health is the amount of health the Creature object will have
     * @param whichPlayer discusses whether the creature belongs to player 1 or player 2
     * @return an object of the Creature class
     */
    public Creature( int health, boolean isPlayerOne, String creatureType )
    {
        healthNumber = health;
        playerOneCreature = isPlayerOne;
        creatureBar = new HealthBar ( healthNumber, healthNumber, 10);
        type = creatureType;
    }
    
    /**
     * HealthBar is the code that get the creatrues healthbar 
     * 
     * @param There are no perameters
     * @return Returns the creatures healthbar
     */
    protected HealthBar getHealthBar()
    {
        return creatureBar;
    }
    
    /**
     * HealthBar is the code that check whether its player one
     * 
     * @param There are no perameters
     * @return Returns playeronecreature
     */
    public boolean getWhetherPlayerOne()
    {
        return playerOneCreature;
    }
   
    /**
     * attack is the code that is run when the Creature attacks its enemy
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void attack( int idx )
    {
        //empty method that will get overriden in subclasses
    }
    
    /**
     * attack is the code that is run when the Creature attacks its enemy
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void switchCreature( int idx )
    {
        //empty method that will get overriden in subclasses
    }
    
    /**
     * attack is the code that is run when the Creature attacks its enemy
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void switchedIn()
    {
        //empty method that will get overriden in subclasses.
    }
    
    /**
     * type is the code that allows you to type 
     * 
     * @param There are no parameters
     * @returns type
     */
    public String getType()
    {
        return type;
    }

    /**
     * act will complete actions that the Creature object should
     * accomplish while the scenario is running
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void act() 
    {
        //empty method that will get overriden in subclasses
    }
}
