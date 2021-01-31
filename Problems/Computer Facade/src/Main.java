class ComputerFacadeTestDrive {
    public static void main(String[] args) {
        Processor processor = new Processor();
        Monitor monitor = new Monitor();
        Keyboard keyboard = new Keyboard();

        ComputerFacade computerFacade = new ComputerFacade(processor, monitor, keyboard);

        computerFacade.turnOnComputer();
        computerFacade.turnOffComputer();
    }
}

class ComputerFacade {
    Processor processor;
    Monitor monitor;
    Keyboard keyboard;

    public ComputerFacade(Processor processor, Monitor monitor, Keyboard keyboard) {
        this.processor = processor;
        this.monitor = monitor;
        this.keyboard = keyboard;
    }

    public void turnOnComputer() {
        processor.on();
        monitor.on();
        keyboard.on();
    }

    public void turnOffComputer() {
        keyboard.off();
        monitor.off();
        processor.off();
    }
}

class Processor {
    String description = "Processor ";

    public void on() {
        System.out.println(description + "on");
    }

    public void off() {
        System.out.println(description + "off");
    }
}

class Monitor {
    String description = "Monitor ";

    public void on() {
        System.out.println(description + "on");
    }

    public void off() {
        System.out.println(description + "off");
    }
}

class Keyboard {
    String description = "Keyboard ";
    String backlight = "Backlight is turned ";

    public void on() {
        System.out.println(description + "on");
        turnOnBacklight();
    }

    public void off() {
        System.out.println(description + "off");
        turnOffBacklight();
    }

    private void turnOnBacklight() {
        System.out.println(backlight + "on");
    }

    private void turnOffBacklight() {
        System.out.println(backlight + "off");
    }
}