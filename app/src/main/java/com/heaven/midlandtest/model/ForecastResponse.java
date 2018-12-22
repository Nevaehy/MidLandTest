package com.heaven.midlandtest.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;

public class ForecastResponse implements Parcelable {

    @Expose
    private String cod;
    @Expose
    private Double message;
    @Expose
    private Integer cnt;
    @Expose
    private java.util.List<List> list = null;
    @Expose
    private City city;

    protected ForecastResponse(Parcel in) {
        cod = in.readString();
        if (in.readByte() == 0) {
            message = null;
        } else {
            message = in.readDouble();
        }
        if (in.readByte() == 0) {
            cnt = null;
        } else {
            cnt = in.readInt();
        }
    }

    public static final Creator<ForecastResponse> CREATOR = new Creator<ForecastResponse>() {
        @Override
        public ForecastResponse createFromParcel(Parcel in) {
            return new ForecastResponse(in);
        }

        @Override
        public ForecastResponse[] newArray(int size) {
            return new ForecastResponse[size];
        }
    };

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Double getMessage() {
        return message;
    }

    public void setMessage(Double message) {
        this.message = message;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public java.util.List<List> getList() {
        return list;
    }

    public void setList(java.util.List<List> list) {
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(cod);
        if (message == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(message);
        }
        if (cnt == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(cnt);
        }
    }

    public class City {

        @Expose
        private Integer id;
        @Expose
        private String name;
        @Expose
        private Coord coord;
        @Expose
        private String country;
        @Expose
        private Integer population;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Coord getCoord() {
            return coord;
        }

        public void setCoord(Coord coord) {
            this.coord = coord;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public Integer getPopulation() {
            return population;
        }

        public void setPopulation(Integer population) {
            this.population = population;
        }

    }

    public class Clouds {
        @Expose
        private Integer all;

        public Integer getAll() {
            return all;
        }

        public void setAll(Integer all) {
            this.all = all;
        }

    }

    public class Coord {
        @Expose
        private Double lat;
        @Expose
        private Double lon;

        public Double getLat() {
            return lat;
        }

        public void setLat(Double lat) {
            this.lat = lat;
        }

        public Double getLon() {
            return lon;
        }

        public void setLon(Double lon) {
            this.lon = lon;
        }

    }


    public class Wind {
        @Expose
        private Double speed;
        @Expose
        private Double deg;

        public Double getSpeed() {
            return speed;
        }

        public void setSpeed(Double speed) {
            this.speed = speed;
        }

        public Double getDeg() {
            return deg;
        }

        public void setDeg(Double deg) {
            this.deg = deg;
        }

    }



    public class List {
        @Expose
        private Integer dt;
        @Expose
        private Main main;
        @Expose
        private java.util.List<Weather> weather = null;
        @Expose
        private Clouds clouds;
        @Expose
        private Wind wind;
        @Expose
        private Snow snow;
        @Expose
        private Sys sys;
        @Expose
        private String dtTxt;

        public Integer getDt() {
            return dt;
        }

        public void setDt(Integer dt) {
            this.dt = dt;
        }

        public Main getMain() {
            return main;
        }

        public void setMain(Main main) {
            this.main = main;
        }

        public java.util.List<Weather> getWeather() {
            return weather;
        }

        public void setWeather(java.util.List<Weather> weather) {
            this.weather = weather;
        }

        public Clouds getClouds() {
            return clouds;
        }

        public void setClouds(Clouds clouds) {
            this.clouds = clouds;
        }

        public Wind getWind() {
            return wind;
        }

        public void setWind(Wind wind) {
            this.wind = wind;
        }

        public Snow getSnow() {
            return snow;
        }

        public void setSnow(Snow snow) {
            this.snow = snow;
        }

        public Sys getSys() {
            return sys;
        }

        public void setSys(Sys sys) {
            this.sys = sys;
        }

        public String getDtTxt() {
            return dtTxt;
        }

        public void setDtTxt(String dtTxt) {
            this.dtTxt = dtTxt;
        }

    }

    public class Main {
        @Expose
        private Double temp;
        @Expose
        private Double tempMin;
        @Expose
        private Double tempMax;
        @Expose
        private Double pressure;
        @Expose
        private Double seaLevel;
        @Expose
        private Double grndLevel;
        @Expose
        private Integer humidity;
        @Expose
        private Integer tempKf;

        public Double getTemp() {
            return temp;
        }

        public void setTemp(Double temp) {
            this.temp = temp;
        }

        public Double getTempMin() {
            return tempMin;
        }

        public void setTempMin(Double tempMin) {
            this.tempMin = tempMin;
        }

        public Double getTempMax() {
            return tempMax;
        }

        public void setTempMax(Double tempMax) {
            this.tempMax = tempMax;
        }

        public Double getPressure() {
            return pressure;
        }

        public void setPressure(Double pressure) {
            this.pressure = pressure;
        }

        public Double getSeaLevel() {
            return seaLevel;
        }

        public void setSeaLevel(Double seaLevel) {
            this.seaLevel = seaLevel;
        }

        public Double getGrndLevel() {
            return grndLevel;
        }

        public void setGrndLevel(Double grndLevel) {
            this.grndLevel = grndLevel;
        }

        public Integer getHumidity() {
            return humidity;
        }

        public void setHumidity(Integer humidity) {
            this.humidity = humidity;
        }

        public Integer getTempKf() {
            return tempKf;
        }

        public void setTempKf(Integer tempKf) {
            this.tempKf = tempKf;
        }

    }

    public class Snow {
        @Expose
        private Double _3h;

        public Double get3h() {
            return _3h;
        }

        public void set3h(Double _3h) {
            this._3h = _3h;
        }

    }

    public class Sys {
        @Expose
        private String pod;

        public String getPod() {
            return pod;
        }

        public void setPod(String pod) {
            this.pod = pod;
        }

    }

    public class Weather {
        @Expose
        private Integer id;
        @Expose
        private String main;
        @Expose
        private String description;
        @Expose
        private String icon;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

    }

}

