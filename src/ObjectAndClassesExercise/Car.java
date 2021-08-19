public class Car {
    private String type;
    private String model;
    private String color;
    private int horsePower;

    Car(String model, String color, int horsePower) {
        this.type = "Car";
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return String.format("Type: %s%n" +
                "Model: %s%n" +
                "Color: %s%n" +
                "Horsepower: %d", this.type, this.model, this.color, this.horsePower);
    }
}

