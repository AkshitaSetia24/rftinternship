
abstract class Device {
    protected boolean isOn;

    
    public void turnOn() {
        isOn = true;
        System.out.println(getName() + " is turned ON");
    }

    
    public void turnOff() {
        isOn = false;
        System.out.println(getName() + " is turned OFF");
    }

    
    public abstract void displayStatus();
    public abstract String getName();
}


class Light extends Device {

    @Override
    public void displayStatus() {
        System.out.println("Light is " + (isOn ? "ON" : "OFF"));
    }

    @Override
    public String getName() {
        return "Light";
    }
}


class Fan extends Device {
    private int speed = 0; 

    public void setSpeed(int speed) {
        if (speed >= 0 && speed <= 5) {
            this.speed = speed;
            System.out.println("Fan speed set to " + speed);
        } else {
            System.out.println("Invalid speed! (0-5 allowed)");
        }
    }

    @Override
    public void displayStatus() {
        System.out.println("Fan is " + (isOn ? "ON" : "OFF") + " | Speed: " + speed);
    }

    @Override
    public String getName() {
        return "Fan";
    }
}


class AC extends Device {
    private int temperature = 24; 
    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("AC temperature set to " + temperature + "°C");
    }

    @Override
    public void displayStatus() {
        System.out.println("AC is " + (isOn ? "ON" : "OFF") + " | Temperature: " + temperature + "°C");
    }

    @Override
    public String getName() {
        return "AC";
    }
}


public class Day4 {
    public static void main(String[] args) {

        
        Light light = new Light();
        Fan fan = new Fan();
        AC ac = new AC();

        
        light.turnOn();
        light.displayStatus();
        light.turnOff();

        System.out.println();

        
        fan.turnOn();
        fan.setSpeed(3); 
        fan.displayStatus();
        fan.turnOff();

        System.out.println();

        
        ac.turnOn();
        ac.setTemperature(20); 
        ac.displayStatus();
        ac.turnOff();
    }
}