/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package alexander.fulleringer.dvdlibrary.ui;

import alexander.fulleringer.dvdlibrary.dao.DVDLibraryDaoException;
import alexander.fulleringer.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author Alex
 */
public class DVDLibraryView {
    
    private UserIO io;
    private final int NUM_MAIN_MENU_OPTIONS = 6;
    private final int NUM_EDIT_MENU_OPTIONS = 7;
    
    public DVDLibraryView(UserIO io){
        this.io=io;
    }
    
    public int printMenuGetSelection(){
        this.printMenu();
        return this.getMenuChoice(NUM_MAIN_MENU_OPTIONS);
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
        System.out.println("6. Exit your DVD library");
    }
    public void displayCreateDVDBanner(){
        io.print("--- Add a DVD to your library ---");
    }
    
    public void displayLibrary(List<DVD> theLibrary){
        for( DVD dvd : theLibrary){
            displayDVD(dvd);
        }
    }
    public void displayDVD(DVD dvd){
        if (dvd != null){
            String s = "";
            s += "Title: " + dvd.getTitle();
            s += ", Director: " + dvd.getDirectorName();
            s += ", Studio: " + dvd.getStudio();
            s += ", Release Date: " + dvd.getReleaseDate();
            s += ", MPAA Rating: " + dvd.getMpaaRating();
            s += ", Misc: " + dvd.getMiscInfo();
            io.print(s);
        }
        else{
            io.print("You don't own that dvd.");
        }
    }
    
    public void displayDisplayDVDBanner(){
        io.print("--- Search for a DVD ---");
    }
    
    public void displayCreateSuccessBanner() {
        io.readString("DVD creation successful!\nPlease hit enter to continue.\n");
    }
    
    public void displayDisplayAllBanner(){
        System.out.println("Here are all the DVDs in your collection!");
    }
    
    public int getMenuChoice(int numOptions){
        return io.readInt("Please select one of the above choices.",1,numOptions);
    }
    
    
    public String getDVDTitle() {
        return io.readString("What is the title of the DVD you are looking for?");
    }
    
    public void displayFindDVDCompletion() {
        io.readString("Press enter to continue\n");
    }
    
    public void displayDropDVDBanner() {
        io.print("--- Drop a DVD ---");
    }
    
    public void displayDropSuccessBanner() {
        io.readString("Please hit enter to continue.\n");
    }
    
    public void displayDisplayLibrarySuccess() {
        io.readString("Library display complete.\nPlease hit enter to continue.\n");
    }
    
    public void displayDropResult(DVD toDrop) {
        if (toDrop!=null){
            displayDVD(toDrop);
            io.print("DVD successfully removed from library");
        }
        else{
            io.print("No such DVD is in your library");
        }
        
        io.readString("Please press enter to continue");
    }
    
    public void displayEditDVDBanner() {
        io.print("---Edit an existing entry DVD---");
        
    }
    
    public int displayEditMenuGetSelection() {
        System.out.println("Which information would you like to edit?");
        System.out.println("Your options are as follows:");
        
        System.out.println("1. Title");
        System.out.println("2. Director");
        System.out.println("3. MPAA Rating");
        System.out.println("4. Release Date");
        System.out.println("5. Studio");
        System.out.println("6. Additional Information");
        System.out.println("7. Exit editor");
        
        return this.getMenuChoice(NUM_EDIT_MENU_OPTIONS);
    }
    
    public String getNewDVDTitle() {
        return (io.readString("Enter the new title"));
        
    }
    
    public void displayPressEnter(){
        io.readString("Press enter to continue.");
        io.print("");
    }
    
    public void editDVDDirector(DVD toEdit) {
        toEdit.setDirectorName(io.readString("Enter the new director"));
    }
    
    public void editDVDMpaaRating(DVD toEdit) {
        toEdit.setMpaaRating(io.readString("Enter the new rating"));
    }
    
    public void editDVDReleaseDate(DVD toEdit) {
        toEdit.setReleaseDate(io.readString("Enter the new release date"));
    }
    
    public void editDVDStudio(DVD toEdit) {
        toEdit.setStudio(io.readString("Enter the new studio"));
    }
    
    public void editDVDMiscInfo(DVD toEdit) {
        toEdit.setMiscInfo(io.readString("Enter the new misc information"));
    }
    
    public void displayDVDToEditNotFound() {
        io.readString("The DVD you wanted to edit was not in your library\n"
                + "Press enter to continue.");
    }
    public void printErrorMessage(DVDLibraryDaoException e){
        io.print("ERROR");
        io.print(e.getMessage());
    }
    
    public void displayGoodBye() {
        io.print("Good Bye!");
    }
    
    public void displayUnkownCommandBanner() {
        io.print("UNKNOWN COMMAND");
    }
}
