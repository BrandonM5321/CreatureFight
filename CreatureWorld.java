import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)//fortnite is the best game ever
import java.awt.Color;
import javax.swing.JOptionPane;
import java.util.List;
//
/**
 * Write a description of class MyWorld here.
 * Name: (Brandan Michelle)
 * Course: CS20S
 * Teacher: Mr. Hardman
 * Lab #2, Program #1
 * Dated Last Modified: ( October 23 )
 * @author (Brandan Micheelle) 
 * @version (a version number or a date)
 * Hi Mr Hardman, hows your day
 */
public class CreatureWorld extends World
{
    private String playerOneCreature;
    private String playerTwoCreature;
    private boolean playerOneTurn;
    private String playerOneName;
    private String playerTwoName;
    private Menu oneFightMenu;
    private Menu oneSwitchMenu;
    private Menu twoFightMenu;
    private Menu twoSwitchMenu;
    private boolean start;
    private boolean playerOneMenusAdded;
    private boolean playerTwoMenusAdded;
    private Creature[] playerOneCreatures;
    private Creature[] playerTwoCreatures;
    
    /**
     * Default constructor for objects of class MyWorld.
     * @author (Brandan Michelle)
     * @param There are no parameters
     * @return an object of class MyWorld
     */
    public CreatureWorld()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(400, 400, 1);
        playerOneCreatures = new Creature[]{ new Charmander(this), new Golem(this), new Ivysaur(this)};
        playerTwoCreatures = new Creature[]{ new Pikachu (this), new Lapras(this), new Pidgeot(this)};
        playerOneTurn = true;
        
        start = true;
        playerOneCreature = "Charmander";
        playerTwoCreature = "Pikachu";
        prepareCreature();
        Greenfoot.start();
    }
    
    /**
     * prepareCreature gets the image of the creature
     * 
     * @param There are no perameters
     * @return Nothing is returned
     */
    private void prepareCreature()
    {
        for( int i = 0; i < playerOneCreatures.length; i++ )
        {
            if( i == 0 )
            {
                addObject( playerOneCreatures[i], playerOneCreatures[i].getImage().getWidth()/2, getHeight() - playerTwoCreatures[i].getImage().getHeight()/2);
            }
            else
            {
                playerOneCreatures[i]. getImage(). setTransparency(0);
                addObject(playerOneCreatures[i], 0, getHeight() - playerOneCreatures[i].getImage().getHeight()/2);
            }
        }
        
        for( int j = 0; j < playerTwoCreatures.length; j++ )
        {
            if(  j== 0 )
            {
                addObject( playerTwoCreatures[j], getWidth() - playerTwoCreatures[j].getImage().getWidth()/2, playerTwoCreatures[j].getImage().getHeight()/2);
            }
            else
            {
                playerTwoCreatures[j]. getImage(). setTransparency(0);
                addObject(playerTwoCreatures[j], getWidth(), playerTwoCreatures[j].getImage().getHeight()/2);
            }
        }
    }
    
    /**
     * getPlayerOne is a code that switches your creature
     * 
     * @param There are no perameters
     * @return Nothing is returned
     */
    public Creature getPlayerOne()
    {
        Creature currentPlayerOne;
        
        if( playerOneCreature.equalsIgnoreCase("Charmander") )
        {
            currentPlayerOne = playerOneCreatures[0];
        }
        else if( playerOneCreature.equalsIgnoreCase("Golem") )
        {
            currentPlayerOne = playerOneCreatures[1];
        }
        else
        {
            currentPlayerOne = playerOneCreatures[2];
        }
        
        return currentPlayerOne;
    }
    
    /**
     * getPlayerOne is the code that switches your creature
     * 
     * @param There are no perameters
     * @return Nothing is returned
     */
    public Creature getPlayerTwo()
    {
        Creature currentPlayerTwo;
       
        if( playerTwoCreature.equalsIgnoreCase("Pikachu") )
        {
            currentPlayerTwo = playerTwoCreatures[0];
        }
        else if( playerTwoCreature.equalsIgnoreCase("Lapras") )
        {
            currentPlayerTwo = playerTwoCreatures[1];
        }
        else
        {
            currentPlayerTwo = playerTwoCreatures[2];
        }
        
        return currentPlayerTwo;
    }
    
    /**
     * changesPlayerOne changes playerone to a differnet creature 
     * 
     * @param There are no perameters
     * @return Nothing is returned
     */
    public void changePlayerOne( String creature )
    {
        playerOneCreature = creature;
        removeObject(oneFightMenu);
        removeObject(oneSwitchMenu);
        playerOneMenusAdded = false;
    }
    
    /**
     * changesPlayerTwo changes playertwo to a differnet creature 
     * 
     * @param There are no perameters
     * @return Nothing is returned
     */
    public void changePlayerTwo( String creature )
    {
        playerTwoCreature = creature;
        removeObject(twoFightMenu);
        removeObject(twoSwitchMenu);
        playerTwoMenusAdded = false;
    }
    
    /**
     * getNewOneCreature changes playerone to a differnet creature 
     * 
     * @param There are no perameters
     * @return Nothing is returned
     */
    public Creature getNewOneCreature(int index)
    {
        return playerOneCreatures[index];
    }
    
    /**
     * getNewTwoCreature changes playerone to a differnet creature 
     * 
     * @param There are no perameters
     * @return Nothing is returned
     */
    public Creature getNewTwoCreature(int index)
    {
        return playerTwoCreatures[index];
    }
    
    /**
     * getTurnNumber 
     * 
     * @param There is no parameters
     * @return nothing is returned
     */
    public boolean getTurnNumber()
    {
        return playerOneTurn;
    }
    
    public void setTurnNumber( boolean turn )
    {
        playerOneTurn = turn;
    }
    
    /**
     * act will complete actions that the CreatureWorld object should
     * accomplish while the scenario is running
     * @author (Brandan Michelle)
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void act()
    {
       List allObjects = getObjects(null);
       boolean playerOneLose = true;
       boolean playerTwoLose = true;
       if( start == true )
       {
           playerOneName = JOptionPane.showInputDialog( "Player One:", null );
           playerTwoName = JOptionPane.showInputDialog( "Player Two:", null );
           playerOneTurn = true;
           start = false;
       }
       else if(playerOneTurn == true)
       {
           showText ( playerOneName + " your turn", getWidth()/2, getHeight()/2 );
           showText ( "", getWidth()/2, getHeight()/2 + 26 );
       }
       else if(playerOneTurn == false)
       {
           showText ( playerTwoName + " your turn", getWidth()/2, getHeight()/2 );
           showText ( "", getWidth()/2, getHeight()/2 + 26 );
       }
       
       if( playerOneMenusAdded == false )
       {
           if ( playerOneCreature.equalsIgnoreCase ("Charmander") )
           {
               oneFightMenu = new Menu( " Fight ", " Scratch \n Flamethrower ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands());
               oneSwitchMenu = new Menu(" Switch ", " Golem \n Ivysaur ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands());
           }
           else if ( playerOneCreature.equalsIgnoreCase ("Golem") )
           {
               oneFightMenu = new Menu( " Fight ", " Tackle \n Earthquake ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands());
               oneSwitchMenu = new Menu(" Switch ", " Charmander \n Ivysaur ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands());
           }
           else
           {
               oneFightMenu = new Menu( " Fight ", " Tackle \n Razor Leaf ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands());
               oneSwitchMenu = new Menu(" Switch ", " Charmander \n Golem ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands());
           }
           addObject( oneFightMenu, 173, getHeight() - 100 ); 
           addObject( oneSwitchMenu, 241, getHeight() - 100 );
           playerOneMenusAdded = true;
       }
       
       if ( playerTwoMenusAdded == false )
       {
           if ( playerTwoCreature.equalsIgnoreCase ("Pikachu") )
           {
               twoFightMenu = new Menu( " Fight ", " Tackle \n Thunderbolt ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands());
               twoSwitchMenu = new Menu(" Switch ", " Lapras \n Pidgeot ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands());
           }
           else if ( playerTwoCreature.equalsIgnoreCase ("Lapras") )
           {
               twoFightMenu = new Menu( " Fight ", " Tackle \n Hydra Pump ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands());
               twoSwitchMenu = new Menu(" Switch ", " Pikachu \n Pidgeot ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands());
           }
           else
           {
               twoFightMenu = new Menu( " Fight ", " Tackle \n Wing Attack ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands());
               twoSwitchMenu = new Menu(" Switch ", " Pikachu \n Lapras ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands());
           }
           
           addObject( twoFightMenu, 131, 75 );
           addObject( twoSwitchMenu, 199, 75 );
           playerTwoMenusAdded = true;
       }
       
       for( int i = 0; playerOneLose == true && i < playerOneCreatures.length; i++ )
       {
           if( playerOneCreatures[i].getHealthBar().getCurrent() > 0 )
           {
               playerOneLose = false;
           }
       }
       
       for( int i = 0; playerTwoLose == true && i < playerTwoCreatures.length; i++ )
       {
           if( playerTwoCreatures[i].getHealthBar().getCurrent() > 0 )
           {
               playerTwoLose = false;
           }
       }
       
       if ( playerOneLose == true )
       {
           removeObjects(allObjects);
           showText("Player Two Wins",getWidth()/2, getHeight ()/2 );
           Greenfoot.stop();
       }
       
       if( playerTwoLose == true )
       {
           removeObjects(allObjects);
           showText("Player One Wins",getWidth()/2,getHeight()/2 );
           Greenfoot.stop();
       }
    }
}