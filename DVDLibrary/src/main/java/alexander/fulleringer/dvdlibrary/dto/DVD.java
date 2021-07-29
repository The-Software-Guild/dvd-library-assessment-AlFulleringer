/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package alexander.fulleringer.dvdlibrary.dto;

/**
 *
 * @author Alex
 */
public class DVD {
    
    public DVD(String title){
        this.title = title;
    }
    public DVD(String title, String releaseDate, String mpaaRating,
            String directorName, String studio, String miscInfo) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.mpaaRating = mpaaRating;
        this.directorName = directorName;
        this.studio = studio;
        this.miscInfo = miscInfo;
    }
    
    private String title;
    private String releaseDate;
    private String mpaaRating;
    private String directorName;
    private String studio;
    private String miscInfo;
    
    public DVD(){
        
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getReleaseDate() {
        return releaseDate;
    }
    
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    
    public String getMpaaRating() {
        return mpaaRating;
    }
    
    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }
    
    public String getDirectorName() {
        return directorName;
    }
    
    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }
    
    public String getStudio() {
        return studio;
    }
    
    public void setStudio(String studio) {
        this.studio = studio;
    }
    
    public String getMiscInfo() {
        return miscInfo;
    }
    
    public void setMiscInfo(String miscInfo) {
        this.miscInfo = miscInfo;
    }

    public String getDisplayString() {
        String s = "";
        s += "Title: " + title;
        s += " Director: " + directorName;
        s += " Studio: " + studio;
        s += " Release Date: " + releaseDate;
        s += " Misc: " + miscInfo;
        
        return s;
    }
    
    
    
    
}
