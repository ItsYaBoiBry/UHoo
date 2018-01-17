package hoo.u.magazine.u_hooprototype;

import java.io.Serializable;

/**
 * Created by bryan on 16/1/2018.
 */

public class ClassDoctor implements Serializable{
    private String docName, docPosition, docImage;
    private int id, docPrice;

    public ClassDoctor(int id,String docName, String docPosition, String docImage, int docPrice) {
        this.id=id;
        this.docName = docName;
        this.docPosition = docPosition;
        this.docImage = docImage;
        this.docPrice = docPrice;
    }

    public String getDocName() {
        return docName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocPosition() {
        return docPosition;
    }

    public void setDocPosition(String docPosition) {
        this.docPosition = docPosition;
    }

    public String getDocImage() {
        return docImage;
    }

    public void setDocImage(String docImage) {
        this.docImage = docImage;
    }

    public int getDocPrice() {
        return docPrice;
    }

    public void setDocPrice(int docPrice) {
        this.docPrice = docPrice;
    }
}
