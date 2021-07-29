/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alexander.fulleringer.dvdlibrary;

import alexander.fulleringer.dvdlibrary.controller.DVDLibraryController;
import alexander.fulleringer.dvdlibrary.dao.DVDLibraryDao;
import alexander.fulleringer.dvdlibrary.dao.DVDLibraryDaoFileImpl;

/**
 *
 * @author Alex
 */
public class App {
   public static void main(String[] args){
       DVDLibraryDao dao = new DVDLibraryDaoFileImpl();
       DVDLibraryController controller = new DVDLibraryController();
       
      controller.run();
   } 
}
