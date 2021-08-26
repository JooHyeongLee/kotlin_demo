package data;

import java.util.HashMap;
import java.util.List;

public class Gpx {
    private String createDt;
    // 출발지와 도착지 좌표 값
    private String fromLat;
    private String fromLon;
    private String toLat;
    private String toLon;
    private List<HashMap<String, Float>> pointList;


    public String getCreateDt() {
        return createDt;
    }

    public void setCreateDt(String createDt) {
        this.createDt = createDt;
    }

    public String getFromLat() {
        return fromLat;
    }

    public void setFromLat(String fromLat) {
        this.fromLat = fromLat;
    }

    public String getFromLon() {
        return fromLon;
    }

    public void setFromLon(String fromLon) {
        this.fromLon = fromLon;
    }

    public String getToLat() {
        return toLat;
    }

    public void setToLat(String toLat) {
        this.toLat = toLat;
    }

    public String getToLon() {
        return toLon;
    }

    public void setToLon(String toLon) {
        this.toLon = toLon;
    }

    public List<HashMap<String, Float>> getPointList() {
        return pointList;
    }

    public void setPointList(List<HashMap<String, Float>> pointList) {
        this.pointList = pointList;
    }
}
