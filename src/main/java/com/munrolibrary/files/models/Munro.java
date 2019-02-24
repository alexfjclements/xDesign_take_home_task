package com.munrolibrary.files.models;

import java.util.ArrayList;

public class Munro implements Comparable<Munro>{

    private String name;
    private Double height;
    private Enum type;
    private String gridReference;

    public Munro(ArrayList<String> params) {
        this.name = params.get(6);
        this.height = Double.parseDouble(params.get(10));
        String rawType = params.get(28);
        defineType(rawType);
        this.gridReference = params.get(14);
    }

    private void defineType(String rawTypeForEvaluation) {
        if (rawTypeForEvaluation.contains("MUN")) {
            this.type = MunroType.MUNRO;
        } else if (rawTypeForEvaluation.contains("TOP")) {
            this.type = MunroType.MUNROTOP;
        }
    }

    public String getName() {
        return name;
    }

    public Double getHeight() {
        return height;
    }

    public Enum<MunroType> getType() {
        return type;
    }

    public String getGridReference() {
        return gridReference;
    }

    public int compareTo(Munro munro) {
        if (height < munro.getHeight()) return -1;
        if (height > munro.getHeight()) return 1;
        return 0;
    }
}
