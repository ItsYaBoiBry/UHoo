package hoo.u.magazine.u_hooprototype;

import java.io.Serializable;

/**
 * Created by bryan on 11/12/2017.
 */

public class TestingRestaurants implements Serializable {
    private int id;
    private String imgSrc;
    private String tvSrc;

    public TestingRestaurants(int id, String imgSrc, String tvSrc) {
        this.id = id;
        this.imgSrc = imgSrc;
        this.tvSrc = tvSrc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getTvSrc() {
        return tvSrc;
    }

    public void setTvSrc(String tvSrc) {
        this.tvSrc = tvSrc;
    }
}
