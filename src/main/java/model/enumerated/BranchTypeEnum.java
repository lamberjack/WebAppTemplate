package model.enumerated;

public enum BranchTypeEnum {

    OFFICE("Office"),

    SHOP("Shop"),

    WAREHOUSE("Warehouse");

    private String description;

    public String getDescription() {
        return description;
    }

    private BranchTypeEnum(String description) {
        this.description = description;
    }

}
