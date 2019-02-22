package models;

public class Munro {

    private String name;
    private Integer height;
    private Enum<MunroType> type;
    private String gridReference;

    public Munro(String name, Integer height, Enum<MunroType> type, String gridReference) {
        this.name = name;
        this.height = height;
        this.type = type;
        this.gridReference = gridReference;
    }

    public String getName() {
        return name;
    }

    public Integer getHeight() {
        return height;
    }

    public Enum<MunroType> getType() {
        return type;
    }

    public String getGridReference() {
        return gridReference;
    }
}
