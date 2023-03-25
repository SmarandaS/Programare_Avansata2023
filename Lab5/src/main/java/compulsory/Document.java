package compulsory;

import java.io.Serializable;
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

    public void setID(String ID) {

        this.ID = ID;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setPath(String path) {

        this.path = path;
    }

    public void setLink(String link) {

        this.link = link;
    }

    public void setTags(Map<String, String> tags) {

        this.tags = tags;
    }

    public String getID() {

        return ID;
    }

    public String getName() {

        return name;
    }

    public String getPath() {

        return path;
    }

    public String getLink() {

        return link;
    }

    public Map<String, String> getTags() {

        return tags;
    }

    public void addTag(String name, String value)
    {

        tags.put(name, value);
    }

    public String getValue(String name)
    {

        return tags.get(name);
    }


    public Document(String ID, String name){
        this.ID = ID;
        this.name = name;
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
