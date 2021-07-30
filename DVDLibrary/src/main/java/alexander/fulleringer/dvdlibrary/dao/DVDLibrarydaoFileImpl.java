/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package alexander.fulleringer.dvdlibrary.dao;

import alexander.fulleringer.dvdlibrary.dto.DVD;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Alex
 */
public class DVDLibraryDaoFileImpl implements DVDLibraryDao {
    
    private Map<String,DVD> library = new HashMap<>();
    

    public DVD addDVD(String DVDTitle, DVD dvd) {
        DVD oldDVD = library.put(DVDTitle, dvd);
        return oldDVD;
    }
    

    public List<DVD> getAllDVDs() {
        return new ArrayList<>(library.values());
    }
    

    public DVD getDVD(String DVDTitle) {
        return library.get(DVDTitle);
    }
    

    public DVD removeDVD(String DVDTitle) {
        return library.remove(DVDTitle);
    }
    
}
