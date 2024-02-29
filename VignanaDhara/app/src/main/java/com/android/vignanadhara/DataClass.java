package com.android.vignanadhara;

public class DataClass {

    private String datatitle;
    private int datadesc;
    private int dataimg;

    private String desig;

    public String getDesig() {
        return desig;
    }

    public String getDatatitle() {
        return datatitle;
    }

    public int getDatadesc() {
        return datadesc;
    }

    public int getDataimg() {
        return dataimg;
    }

    public DataClass(String datatitle, int datadesc, int dataimg, String desig) {
        this.datatitle = datatitle;
        this.datadesc = datadesc;
        this.dataimg = dataimg;
        this.desig = desig;
    }
}
