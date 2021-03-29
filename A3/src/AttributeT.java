package src;

import src.IndicatorT;

public class AttributeT {
    private final String name;
    private final IndicatorT[] s;

    public AttributeT(String attribName, IndicatorT[] indicators) {
        this.name = attribName;
        this.s = indicators;
    }

    public String getName() {
        return this.name;
    }

    public IndicatorT[] getIndicators() {
        return this.s;
    }
}