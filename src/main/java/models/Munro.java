package models;

import java.util.ArrayList;

public class Munro {

    private String name;
    private Integer height;
    private Enum type;
    private String gridReference;

    public Munro(ArrayList<String> params) {
        this.name = params.get(6);
        this.height = Integer.parseInt(params.get(10));
        String rawType = params.get(28);
        defineType(rawType);
        this.gridReference = params.get(14);
    }

    private void defineType(String rawType) {
        if (rawType == "MUN") {
            this.type = MunroType.MUNRO;
        } else if (rawType == "TOP") {
            this.type = MunroType.MUNROTOP;
        }
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
