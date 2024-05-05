package com.mycompany.laba3;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "root")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Reactor {
    private String name;
    private double burnup;
    private String classe;
    private double electricalCapacity;
    private double firstLoad;
    private double kpd;
    private double lifeTime;
    private double enrichment;
    private double termalCapacity;
    private String  fileType;
    

    
    @JsonCreator
    public Reactor( @JsonProperty("class")
                    @JacksonXmlProperty(localName = "class")
                    String classe,
                    @JacksonXmlProperty(localName = "burnup")
                    @JsonProperty("burnup")
                    double burnup,
                    @JacksonXmlProperty(localName = "kpd")
                    @JsonProperty("kpd")
                    double kpd,
                    @JacksonXmlProperty(localName = "enrichment")
                    @JsonProperty("enrichment")
                    double enrichment,
                    @JacksonXmlProperty(localName = "electrical_capacity")
                    @JsonProperty("electrical_capacity")
                    double electricalCapacity,
                    @JacksonXmlProperty(localName = "first_load")
                    @JsonProperty("first_load")
                    double firstLoad,
                    @JacksonXmlProperty(localName = "life_time")
                    @JsonProperty("life_time")
                    double lifeTime,
                    @JacksonXmlProperty(localName = "termal_capacity")
                    @JsonProperty("termal_capacity")
                    double termalCapacity
                    ) {
        this.burnup = burnup;
        this.classe = classe;
        this.electricalCapacity = electricalCapacity;
        this.firstLoad = firstLoad;
        this.kpd = kpd;
        this.lifeTime = lifeTime;
        this.termalCapacity = termalCapacity;
        this.enrichment = enrichment;
    }
    
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
    
     public double getBurnup() {
        return burnup;
    }

    public void setBurnup(double burnup) {
        this.burnup = burnup;
    }

    // Getter and Setter for classe
    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    // Getter and Setter for electricalCapacity
    public double getElectricalCapacity() {
        return electricalCapacity;
    }

    public void setElectricalCapacity(double electricalCapacity) {
        this.electricalCapacity = electricalCapacity;
    }

    // Getter and Setter for firstLoad
    public double getFirstLoad() {
        return firstLoad;
    }

    public void setFirstLoad(double firstLoad) {
        this.firstLoad = firstLoad;
    }

    // Getter and Setter for kpd
    public double getKpd() {
        return kpd;
    }

    public void setKpd(double kpd) {
        this.kpd = kpd;
    }

    // Getter and Setter for lifeTime
    public double getLifeTime() {
        return lifeTime;
    }
    
    public double getEnrichment() {
        return enrichment;
    }

    public void setLifeTime(double lifeTime) {
        this.lifeTime = lifeTime;
    }

    // Getter and Setter for terminalCapacity
    public double getTermalCapacity() {
        return termalCapacity;
    }

    public void setTermalCapacity(double termalCapacity) {
        this.termalCapacity = termalCapacity;
    }

    // Getter and Setter for fileType
    public String getFileType() {
        return fileType;
    }
    
    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }


    
}
