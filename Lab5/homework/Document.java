package homework;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * clasa Document contine ID, nume, path si link pentru documentele din catalogul nostru si settere si gettere care
 * ne sunt necesare pentru ce am implementat pana acum contine de asemenea si o metoda toString pentru un document anume, de
 * care se foloseste metoda toString aplicata asupra intregului catalog
 */
public class Document implements Serializable {

    private String ID;
    private String name;
    private String path;
    private String link;
    private Map<String, String> tags;

    public void setLink(String link) {

        this.link = link;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {

        return ID;
    }

    public String getName() {

        return name;
    }

    public Map<String, String> getTags() {
        return tags;
    }

    public String getPath() {
        return path;
    }

    public void addTag(String name, String value)
    {

        tags.put(name, value);
    }


    public Document(String ID, String name){
        this.ID = ID;
        this.name = name;
        tags = new HashMap<>();
    }

    public Document(String ID, String name, String path){
        this.ID = ID;
        this.name = name;
        this.path = path;
        tags = new HashMap<>();
    }



    public String toString()
    {
        StringBuilder docStr = new StringBuilder() ;
        docStr.append("ID: ").append(ID).append("\n").append("Name: ").append(name).append("\n").append("Path: ").append(path)
                .append("\n").append("URL: ").append(link).append("\n").append("Tags: ").append(tags);
        return docStr.toString();
    }


    public Document() {
    }
}
