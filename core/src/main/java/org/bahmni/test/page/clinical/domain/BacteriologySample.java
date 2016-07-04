package org.bahmni.test.page.clinical.domain;

/**
 * Created by dharmens on 7/3/16.
 */
public class BacteriologySample {

    private String sample;

    private String date;

    private String type;

    private String id;

    public BacteriologySample(String sample, String date, String type, String id) {
        this.sample = sample;
        this.date = date;
        this.type = type;
        this.id = id;
    }

    public BacteriologySample(String sample, String date, String type) {
        this.sample = sample;
        this.date = date;
        this.type = type;
    }

    public String getSample() {
        return sample;
    }

    public String getDate() {
        return date;
    }

    public String getType() { return type; }

    public String getId(){ return id; }
}
