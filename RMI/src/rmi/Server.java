/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rmi;

/**
 *
 * @author Orion
 */
import java.rmi.*;
import java.rmi.server.*;
public class Server extends UnicastRemoteObject implements RemoteInterface
{
    public Server() throws RemoteException
    {    }
    
    public String getOwner()
    {
        return "Vasanth Kumar V";
    }

    public static void main (String[] args)
    {
        try
        {
            RemoteInterface service = new Server();
            Naming.bind("RemoteOwner", service);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
