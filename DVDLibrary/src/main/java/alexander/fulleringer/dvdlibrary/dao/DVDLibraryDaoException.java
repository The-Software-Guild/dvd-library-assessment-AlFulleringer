/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alexander.fulleringer.dvdlibrary.dao;

/**
 *
 * @author Alex
 */
public class DVDLibraryDaoException extends Exception {
    
    public DVDLibraryDaoException(String s){
        super(s);
    }
     
    public DVDLibraryDaoException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
