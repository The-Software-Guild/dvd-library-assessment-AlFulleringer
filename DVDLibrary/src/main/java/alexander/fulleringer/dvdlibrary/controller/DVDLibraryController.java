/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package alexander.fulleringer.dvdlibrary.controller;

import alexander.fulleringer.dvdlibrary.dao.DVDLibraryDao;
import alexander.fulleringer.dvdlibrary.dao.DVDLibraryDaoException;
import alexander.fulleringer.dvdlibrary.dao.DVDLibraryDaoFileImpl;
import alexander.fulleringer.dvdlibrary.dto.DVD;
import alexander.fulleringer.dvdlibrary.ui.DVDLibraryView;
import alexander.fulleringer.dvdlibrary.ui.UserIO;
import alexander.fulleringer.dvdlibrary.ui.UserIOConsoleImpl;


/**
 *
 * @author Alex
 */
public class DVDLibraryController {
    DVDLibraryDao dao;
    DVDLibraryView view;
    UserIO io;
    
    public DVDLibraryController(DVDLibraryDao dao, DVDLibraryView view, UserIO io) {
        this.dao = dao;
        this.view = view;
        this.io = io;
    }

    //Used for testing before implementing Dependency Injection
    public DVDLibraryController() {
        this.io = new UserIOConsoleImpl();
        this.view = new DVDLibraryView(io);
        
        try{
            this.dao = new DVDLibraryDaoFileImpl();
        }
        catch(DVDLibraryDaoException e){
            view.printErrorMessage(e);
        }
        
       

    }
    
    public void run() throws DVDLibraryDaoException{
        boolean loop= true;
        while(loop){
            int option = this.view.printMenuGetSelection();
            
            switch (option) {
                case 1:
                    createAndAddDVD();
                    break;
                case 2:
                    dropDVD();
                    break;
                case 3:
                    editDVD();
                    break;
                case 4:
                    listDVDs();
                    break; 
                case 5:
                    findDVD();
                    break;
                case 6:
                    loop = false;
                    break;
                default:
                    io.print("UNKNOWN COMMAND");
            }
            
        }
        dao.persistChanges();
        view.displayGoodBye();
        
    }

    private void createAndAddDVD() throws DVDLibraryDaoException {
        view.displayCreateDVDBanner();
        DVD newDVD = view.getNewDVD();
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.displayCreateSuccessBanner();
    }

    private void listDVDs() {
        view.displayDisplayAllBanner();
        view.displayLibrary(dao.getAllDVDs());
        view.displayDisplayLibrarySuccess();
    }
    private void findDVD(){
        view.displayDisplayDVDBanner();
        String dvdTitle = view.getDVDTitle();
        DVD toDisplay = dao.getDVD(dvdTitle);
        view.displayDVD(toDisplay);
        view.displayFindDVDCompletion();
    }

    private void dropDVD() throws DVDLibraryDaoException{
        view.displayDropDVDBanner();
        String titleToDrop = view.getDVDTitle();
        DVD toDrop = dao.removeDVD(titleToDrop);
        view.displayDropResult(toDrop);

    }

    private void editDVD() throws DVDLibraryDaoException{
        view.displayEditDVDBanner();
        String titleToEdit = view.getDVDTitle();
        DVD toEdit = dao.getDVD(titleToEdit);
        boolean loop = true;
        
        if(toEdit!= null) {
            
            while(loop){
               
            view.displayDVD(toEdit);
            int option = view.displayEditMenuGetSelection();
            switch (option) {
                //Edit Title
                case 1:
                    String newData = view.getNewDVDTitle();
                    dao.editDVDTitle(toEdit, newData);
                    break;
                //Edit Director
                case 2:
                    view.editDVDDirector(toEdit);
                    dao.persistChanges();
                    break;
                //Edit Rating
                case 3:
                    view.editDVDMpaaRating(toEdit);
                    dao.persistChanges();
                    break;
                //Edit Release Date
                case 4:
                    view.editDVDReleaseDate(toEdit);
                    dao.persistChanges();
                    break; 
                //Edit Studio
                case 5:
                    view.editDVDStudio(toEdit);
                    dao.persistChanges();
                    break;
                //Edit Misc Info
                case 6:
                    view.editDVDMiscInfo(toEdit);
                    dao.persistChanges();
                    break;
                //Break loop
                case 7:
                    loop = false;
                    break;
                default:
                    io.print("UNKNOWN COMMAND");
            }
            //Save edits to file.
            
            //dao.readFile();
            view.displayPressEnter();
        }
    }
        else{
            view.displayDVDToEditNotFound();
        }
        
    }
    
   
}