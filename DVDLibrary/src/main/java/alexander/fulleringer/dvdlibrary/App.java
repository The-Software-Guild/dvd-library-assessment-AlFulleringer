/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package alexander.fulleringer.dvdlibrary;

import alexander.fulleringer.dvdlibrary.controller.DVDLibraryController;
import alexander.fulleringer.dvdlibrary.dao.DVDLibraryDao;
import alexander.fulleringer.dvdlibrary.dao.DVDLibraryDaoException;
import alexander.fulleringer.dvdlibrary.dao.DVDLibraryDaoFileImpl;
import alexander.fulleringer.dvdlibrary.ui.DVDLibraryView;
import alexander.fulleringer.dvdlibrary.ui.UserIO;
import alexander.fulleringer.dvdlibrary.ui.UserIOConsoleImpl;

/**
 *
 * @author Alex
 */
public class App {
    public static void main(String[] args){
        DVDLibraryDao dao;
        DVDLibraryView view;
        UserIO io;
        
        io = new UserIOConsoleImpl();
        view = new DVDLibraryView(io);
        
        try{
            dao = new DVDLibraryDaoFileImpl();
            DVDLibraryController controller = new DVDLibraryController(dao, view, io);
            controller.run();
        }
        catch(DVDLibraryDaoException e){
            view.printErrorMessage(e);
            System.exit(0);
        }
        
        
    }
}
