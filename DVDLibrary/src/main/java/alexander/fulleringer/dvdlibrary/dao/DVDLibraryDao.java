/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alexander.fulleringer.dvdlibrary.dao;

import alexander.fulleringer.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface DVDLibraryDao {
    /**
     * Adds the given DVD to the roster and associates it with the given
     * DVD id. If there is already a DVD associated with the given
     * DVD id it will return that DVD object, otherwise it will
     * return null.
     *
     * @param DVDId id with which DVD is to be associated
     * @param DVD DVD to be added to the roster
     * @return the DVD object previously associated with the given  
     * DVD id if it exists, null otherwise
     */
    DVD addDVD(String DVDId, DVD dvd)throws DVDLibraryDaoException;

    /**
     * Returns a List of all DVDs in the roster.
     *
     * @return List containing all DVDs in the roster.
     */
    List<DVD> getAllDVDs();

    /**
     * Returns the DVD object associated with the given DVD id.
     * Returns null if no such DVD exists
     *
     * @param DVDId ID of the DVD to retrieve
     * @return the DVD object associated with the given DVD id,  
     * null if no such DVD exists
     */
    DVD getDVD(String DVDId);

    /**
     * Removes from the roster the DVD associated with the given id.
     * Returns the DVD object that is being removed or null if
     * there is no DVD associated with the given id
     *
     * @param DVDId id of DVD to be removed
     * @return DVD object that was removed or null if no DVD
     * was associated with the given DVD id
     */
    DVD removeDVD(String DVDId)throws DVDLibraryDaoException;
    
    void persistChanges() throws DVDLibraryDaoException;
    void loadData() throws DVDLibraryDaoException;

    public void editDVDTitle(DVD toEdit, String newData) throws DVDLibraryDaoException;

}
