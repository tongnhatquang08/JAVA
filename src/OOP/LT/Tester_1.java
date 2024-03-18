package OOP.LT;

class Vehicle{
    private String vin;
    public String getVin(){
        return vin;
    }
    public void setVin(String vin){
        this.vin = vin;
    }
}

class Speed{
    private double max;
    public double getMax(){
        return max;
    }
    public void setMax(double max){
        this.max = max;
    }
}

class Van extends Vehicle{
    private Speed speed;
    public Speed getSpeed(){
        return speed;
    }
    public void setSpeed(Speed speed){
        this.speed = speed;
    }
    public void print(){
        System.out.println("Vin: " + this.getVin() + ", Speed: " + speed.getMax());
    }
}

public class Tester_1 {
    public static void main(String[] args) {
        Speed speed = new Speed();
        speed.setMax(120);
        Van van = new Van();
        van.setVin("abcd123");
        van.setSpeed(speed);
        van.print();
    }
}
