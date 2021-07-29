/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package alexander.fulleringer.dvdlibrary.ui;

import alexander.fulleringer.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author Alex
 */
public class DVDLibraryView {
    
    //To be injected later
    private UserIO io = new UserIOConsoleImpl();
    private final int NUM_OPTIONS = 7;
    public int printMenuGetSelection(){
        this.printMenu();
        return this.getMenuChoice();
    }
    /**
     * This function asks a user for input to fill out the required fields to make and return a new DVD
     *
     * @return
     */
    public DVD getNewDVD(){
        DVD newDVD = new DVD(io.readString("Please enter the DVD title"));
        
        newDVD.setDirectorName(io.readString("Please enter the director's name"));
        newDVD.setReleaseDate(io.readString("Please enter the release date"));
        newDVD.setStudio(io.readString("Please enter the Studio name"));
        newDVD.setMpaaRating(io.readString("Please enter the MPAA Rating"));
        newDVD.setMiscInfo(io.readString("Please enter any additional information of note"));
        
        return newDVD;
    }
    public void printMenu(){
        System.out.println("Welcome to your DVD Library Application!");
        System.out.println("Your options are as follows:");
        
        System.out.println("1. Add a DVD to your collection");
        System.out.println("2. Remove a DVD from your collection");
        System.out.println("3. Edit information on an existing DVD");
        System.out.println("4. See a list of all DVDs in your collection");
        System.out.println("5. Display information on a specific DVD");
        System.out.println("6. Display info for a particular DVD");
        System.out.println("7. Exit your DVD library"); //Combine 5 and 6?
    }
    public void displayCreateDVDBanner(){
        io.print("--- Add a DVD to your library ---");
    }
    
    public void print(String s){
        io.print(s);
    }
    
    public String getString(String s){
        return io.readString(s);
    }
    
    public void displayCreateSuccessBanner() {
        io.readString("DVD creation successful!\nPlease hit enter to continue.");
    }
    
    public void displayDisplayAllBanner(){
        System.out.println("Here are all the DVDs in your collection!");
    }
    
    public int getMenuChoice(){
        return io.readInt("Please select one of the above choices.",1,NUM_OPTIONS);
    }
    public void displayLibrary(List<DVD> theLibrary){
        for( DVD dvd : theLibrary){
            System.out.println(dvd.getDisplayString());
        }
    }
    public void displayDVD(DVD dvd){
        System.out.println(dvd.getDisplayString());
    }
}
