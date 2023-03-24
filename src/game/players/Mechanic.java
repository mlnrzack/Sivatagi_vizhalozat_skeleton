package game.players;

import java.util.Date;

import game.*;
import game.elements.*;
import game.interfaces.*;
import game.players.*;

public class Mechanic extends Player
{	
    public IPipe pipeInInventory = null;
    public IPump pumpInInventory = null;
    
    public Mechanic() 
    {
        GameController.AddMechanic(this);
    }
   
    public boolean BuildPumpIntoPipe()
    {
        if (pumpInInventory != null)
        {
            if (GetCurrentPosition().TryBuildPumpInto(pumpInInventory))
            {
                pumpInInventory = null;

                GameController.ActionExecuted();
                return true;
            }
        }

        System.out.println("Nem sikerül az akció. Próbálkozz úgy, hogy csövön állsz és van nálad pumpa.");
        return false;
    }
    
    public boolean ConnectPipe()
    {
        if (pipeInInventory != null)
        {
            if (GetCurrentPosition().TryConnectPipe(pipeInInventory))
            {
                pipeInInventory = null;

                GameController.ActionExecuted();
                return true;
            }
        }

        System.out.println("Nem sikerül az akció. Próbálkozz úgy, aktív elemen állsz és van nálad csővég.");
        return false;
    }

    public boolean DisconnectNeighbourPipe(int neighbourIdx)
    {
        if (pipeInInventory == null)
            pipeInInventory = GetCurrentPosition().DisconnectNeighbourPipe(neighbourIdx);

        if (pipeInInventory != null)
        {
            GameController.ActionExecuted();
            return true;
        }

        return false;
    }

    public boolean PickUpFreePipeEnd()
    {
        if (pipeInInventory == null)
        {
            var pickedUpPipe = GetCurrentPosition().PickUpFreePipeEnd();

            if (pickedUpPipe != null)
            {
                pipeInInventory = pickedUpPipe;

                GameController.ActionExecuted();
                return true;
            }
        }

        System.out.println("Nem sikerül a felvétel. Próbálkozz ciszternán állva.");
        return false;
    }

    public boolean PickUpPump()
    {
        if (pipeInInventory == null)
        {
            IPump pickedUpPump = GetCurrentPosition().PickUpPump();

            if (pickedUpPump != null)
            {
                pumpInInventory = pickedUpPump;

                GameController.ActionExecuted();
                return true;
            }
        }

        System.out.println("Nem sikerül a felvétel. Próbálkozz ciszternán állva.");
        return false;
    }
    
    public boolean Repair()
    {
        if (GetCurrentPosition().TryRepair())
        {
            GameController.ActionExecuted();
            return true;
        }

        return false;
    }
}