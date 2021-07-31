/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package alexander.fulleringer.dvdlibrary.dao;

import alexander.fulleringer.dvdlibrary.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex
 */
public class DVDLibraryDaoFileImpl implements DVDLibraryDao {
    
    private Map<String,DVD> library = new HashMap<>();
    public static final String LIBRARY_FILE = "library.txt";
    public static final String DELIMITER = "::";
    
    
    
    public DVDLibraryDaoFileImpl() throws DVDLibraryDaoException{
        this.readFile();
    }
    
    /**
     * Reads all data from predefined file into the Map.
     *
     * @throws DVDLibraryDaoException
     */
    
    //Stretch goal: Use this and writeFile() everytime an alteration is made for better data loss protection
    private void readFile() throws DVDLibraryDaoException{
        Scanner scanner;
        try{
            scanner = new Scanner(new BufferedReader(new FileReader(LIBRARY_FILE)));
        }
        catch(FileNotFoundException e){
            //Turn the generic exception into our sapecific type so we can keep io in viewer.
            throw new DVDLibraryDaoException("File " + LIBRARY_FILE + "Could not be found :(");
        }
        
        String currentLine;
        DVD currentDVD;
        
        while(scanner.hasNextLine()){
            currentLine = scanner.nextLine();
            currentDVD = unmarshallDVD(currentLine);
            library.put(currentDVD.getTitle(),currentDVD);
        }
        scanner.close();
    }
    
    public void writeFile() throws DVDLibraryDaoException{
        PrintWriter out;
        String toWrite;
        try {
            out = new PrintWriter(new FileWriter(LIBRARY_FILE));
        }
        catch (IOException ex) {
            throw new DVDLibraryDaoException("Data could not be saved :(");
        }
        
        
        for(DVD dvd: this.getAllDVDs()){
            toWrite = getMarshallDVDString(dvd);
            out.println(toWrite);
        }
     
    }
    
    private String getMarshallDVDString(DVD dvd){
        String s = "";
        s += dvd.getTitle();
        s += DELIMITER;
        s += dvd.getDirectorName();
        s += DELIMITER;
        s += dvd.getStudio();
        s += DELIMITER;
        s += dvd.getReleaseDate();
        s += DELIMITER;
        s += dvd.getMpaaRating();
        s += DELIMITER;
        s +=  dvd.getMiscInfo();
        return s;
    }
    
    public DVD addDVD(String DVDTitle, DVD dvd) throws DVDLibraryDaoException{
        readFile();
        DVD oldDVD = library.put(DVDTitle, dvd);
        writeFile();
        
        return oldDVD;
    }
    
    
    public List<DVD> getAllDVDs() {
        return new ArrayList<>(library.values());
    }
    
    
    public DVD getDVD(String DVDTitle) {
        return library.get(DVDTitle);
    }
    
    
    @Override
    public DVD removeDVD(String DVDTitle) throws DVDLibraryDaoException {
        readFile();
        DVD dvd = library.remove(DVDTitle);
        writeFile();
        
        return dvd;
    }
    /**
     * Takes a String representation of a DVD and creates a new DVD object with it
     * @param DVDText
     * @return
     */
    public DVD unmarshallDVD(String DVDText){
        String[] tokens = DVDText.split(DELIMITER, 6);
        DVD unmarshalledDVD = new DVD(tokens[0]);
        
        unmarshalledDVD.setDirectorName(tokens[1]);
        unmarshalledDVD.setMpaaRating(tokens[2]);
        unmarshalledDVD.setReleaseDate(tokens[3]);
        unmarshalledDVD.setStudio(tokens[4]);
        unmarshalledDVD.setMiscInfo(tokens[5]);
        
        return unmarshalledDVD;
    }
    
   public void persistChanges() throws DVDLibraryDaoException{
       this.writeFile();
   }
   public void loadData() throws DVDLibraryDaoException{
       this.readFile();
   }

    @Override
    public void editDVDTitle(DVD toEdit, String newData) throws DVDLibraryDaoException {
        toEdit.setTitle(newData);
        persistChanges();
    }
}
