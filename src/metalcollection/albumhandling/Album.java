/*
 * This work is licensed under a 
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 Unported License
 */

package metalcollection.albumhandling;

import java.io.Serializable;

/**
 *
 * @author vasouv
 */
public class Album implements Serializable {
    private int id;
    private String band;
    private String title;
    private int release;
    private String genre;
    
    public Album(){}
    
    public Album(int id, String band, String title, int release, String genre) {
        this.id = id;
        this.band = band;
        this.title = title;
        this.release = release;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRelease() {
        return release;
    }

    public void setRelease(int release) {
        this.release = release;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    
}
