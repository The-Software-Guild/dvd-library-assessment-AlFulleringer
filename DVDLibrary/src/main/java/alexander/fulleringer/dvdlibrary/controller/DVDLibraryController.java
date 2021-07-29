/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package alexander.fulleringer.dvdlibrary.controller;

import alexander.fulleringer.dvdlibrary.dao.DVDLibraryDao;
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

    public DVDLibraryController() {
        this.dao = new DVDLibraryDaoFileImpl();
        this.view = new DVDLibraryView();
        this.io = new UserIOConsoleImpl();

    }
    
    public void run(){
        boolean loop= true;
        while(loop){
            int option = this.view.printMenuGetSelection();
            
            switch (option) {
                case 1:
                    createAndAddDVD();
                    break;
                case 2:
                    io.print("DROP DVD");
                    break;
                case 3:
                    io.print("EDIT DVD");
                    break;
                case 4:
                    listDVDs();
                    break; 
                case 5:
                    io.print("DISPLAY DVD INFO");
                    findDVD();
                    break;
                case 6:
                    io.print("DVD SEARCH");
                    break;
                case 7:
                    loop = false;
                    break;
                default:
                    io.print("UNKNOWN COMMAND");
            }
            
        }
        io.print("GOOD BYE");
        
    }

    private void createAndAddDVD() {
        view.displayCreateDVDBanner();
        DVD newDVD = view.getNewDVD();
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.displayCreateSuccessBanner();
    }

    private void listDVDs() {
        view.displayDisplayAllBanner();
        view.displayLibrary(dao.getAllDVDs());
    }
    private void findDVD(){
        String dvdTitle = view.getString("Please enter the title of the DVD you'd like to learn more about!");
        DVD toDisplay = dao.getDVD(dvdTitle);
        view.displayDVD(toDisplay);
    }
   
}


