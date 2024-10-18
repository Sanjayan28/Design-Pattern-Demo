/*
* Structural pattern
Structural patterns focus on the composition of classes or objects to form larger structures.
* Examples include: Decorator pattern

* */


// Coffee interface
interface Coffee {
    double getCost(); // Returns the cost of the coffee
    String getDescription(); // Returns the description of the coffee
}

// SimpleCoffee class (Concrete Component)
class SimpleCoffee implements Coffee {
    @Override
    public double getCost() {
        return 2.0; // Base price of the coffee
    }

    @Override
    public String getDescription() {
        return "Simple Coffee";
    }
}

// CoffeeDecorator abstract class
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }
}

// MilkDecorator class (Concrete Decorator)
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.5; // Add cost of milk
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Milk";
    }
}

// SugarDecorator class (Concrete Decorator)
class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.2; // Add cost of sugar
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Sugar";
    }
}

// WhipDecorator class (Concrete Decorator)
class WhipDecorator extends CoffeeDecorator {
    public WhipDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.7; // Add cost of whip
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Whip";
    }
}

// Main class (Client)
public class DecoratorMain {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " $" + coffee.getCost());

        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " $" + coffee.getCost());

        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription() + " $" + coffee.getCost());

        coffee = new WhipDecorator(coffee);
        System.out.println(coffee.getDescription() + " $" + coffee.getCost());
    }
}
