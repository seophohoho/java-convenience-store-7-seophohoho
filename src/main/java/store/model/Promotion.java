package store.model;

public enum Promotion {
    TWO_PLUS_ONE("",0,0,"0000-00-00","0000-00-00"),
    MD_RECOMMEND("",0,0,"0000-00-00","0000-00-00"),
    SHINY_SALE("",0,0,"0000-00-00","0000-00-00");

    private String name;
    private int buy;
    private int get;
    private String start;
    private String end;

    Promotion(String name, int buy, int get,String start, String end) {
        this.name = name;
        this.buy = buy;
        this.get = get;
        this.start = start;
        this.end = end;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBuy(int buy) {
        this.buy = buy;
    }

    public void setGet(int get) {
        this.get = get;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public int getBuy() {
        return buy;
    }

    public int getGet() {
        return get;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }
}
