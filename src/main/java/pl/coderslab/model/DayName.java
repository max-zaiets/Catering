package pl.coderslab.model;

public class DayName {

    private int id;
    private String name;
    private Integer displayOrder;


    public DayName(String name, Integer displayOrder) {
        this.name = name;
        this.displayOrder = displayOrder;
    }

    public DayName() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    @Override
    public String toString() {
        return "DayName{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", displayOrder=" + displayOrder +
                '}';
    }
}
