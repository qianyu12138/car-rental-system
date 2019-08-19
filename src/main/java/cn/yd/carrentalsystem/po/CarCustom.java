package cn.yd.carrentalsystem.po;

import java.util.List;

public class CarCustom extends Car {
    private List<String> imgPaths;
    private Kind kind;

    public Kind getKind() {
        return kind;
    }

    public void setKind(Kind kind) {
        this.kind = kind;
    }

    public List<String> getImgPaths() {
        return imgPaths;
    }

    public void setImgPaths(List<String> imgPaths) {
        this.imgPaths = imgPaths;
    }
}
