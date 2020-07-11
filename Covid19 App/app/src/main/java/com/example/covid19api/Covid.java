package com.example.covid19api;

public class Covid {
    private String active,recovered,deaths,date;

    public Covid(String date, String active, String recovered, String deaths) {
        this.date=date;
        this.active = active;
        this.recovered = recovered;
        this.deaths = deaths;
    }
    public String getDate()
    {
        return date;
    }
    public String getActive()
    {
        return active;
    }
    public void setActive(String active)
    {
        this.active=active;
    }
    public String getRecovered()
    {
        return recovered;
    }
    public void setRecovered(String recovered)
    {
        this.recovered=recovered;
    }
    public String getDeaths()
    {
        return deaths;
    }
    public void setDeaths(String deaths)
    {
        this.deaths=deaths;
    }
}
