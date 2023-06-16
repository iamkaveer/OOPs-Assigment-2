import java.util.Scanner;

public class CoffeeMachineSimulator {
    private int water;
    private int milk;
    private int beans;
    private int money;
    private int totalMoney;

    public CoffeeMachineSimulator() {
        this.water = 0;
        this.milk = 0;
        this.beans = 0;
        this.money = 0;
        this.totalMoney = 0;
    }

    public void buyCoffee(String coffeeType) {
        int waterNeeded, milkNeeded, beansNeeded, price;

        if (coffeeType.equals("espresso")) {
            waterNeeded = 250;
            milkNeeded = 0;
            beansNeeded = 16;
            price = 4;
        } else if (coffeeType.equals("latte")) {
            waterNeeded = 350;
            milkNeeded = 75;
            beansNeeded = 20;
            price = 7;
        } else if (coffeeType.equals("cappuccino")) {
            waterNeeded = 200;
            milkNeeded = 100;
            beansNeeded = 12;
            price = 6;
        } else {
            System.out.println("Invalid coffee type!");
            return;
        }

        if (water >= waterNeeded && milk >= milkNeeded && beans >= beansNeeded) {
            System.out.println("Dispensing coffee: " + coffeeType);
            water -= waterNeeded;
            milk -= milkNeeded;
            beans -= beansNeeded;
            money += price;
            totalMoney += price;
        } else {
            System.out.println("Insufficient ingredients to make " + coffeeType);
        }
    }

    public void fillIngredients(int waterAmount, int milkAmount, int beansAmount) {
        water += waterAmount;
        milk += milkAmount;
        beans += beansAmount;
    }

    public void takeMoney() {
        System.out.println("Money collected: $" + money);
        money = 0;
        totalMoney += money;
    }

    public void showIngredients() {
        System.out.println("Ingredients in the coffee machine:");
        System.out.println("Water: " + water + " ml");
        System.out.println("Milk: " + milk + " ml");
        System.out.println("Beans: " + beans);
        System.out.println("Money: " + totalMoney);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachineSimulator coffeeMachine = new CoffeeMachineSimulator();

        System.out.println("Coffee Machine Simulator");
        System.out.println("Enter commands: buy, fill, take, show, exit");

        boolean running = true;
        while (running) {
            System.out.print("Enter your choice: ");
            String userChoice = scanner.nextLine().toLowerCase();

            if (userChoice.equals("buy")) {
                System.out.println("Enter coffee type: espresso, latte, cappuccino");
                String coffeeType = scanner.nextLine().toLowerCase();
                coffeeMachine.buyCoffee(coffeeType);
            } else if (userChoice.equals("fill")) {
                System.out.println("Enter amount of water (in ml):");
                int waterAmount = scanner.nextInt();
                System.out.println("Enter amount of milk (in ml):");
                int milkAmount = scanner.nextInt();
                System.out.println("Enter amount of beans:");
                int beansAmount = scanner.nextInt();
                coffeeMachine.fillIngredients(waterAmount, milkAmount, beansAmount);
            } else if (userChoice.equals("take")) {
                coffeeMachine.takeMoney();
            } else if (userChoice.equals("show")) {
                coffeeMachine.showIngredients();
            } else if (userChoice.equals("exit")) {
                running = false;
            } else {
                System.out.println("Invalid command!");
            }

            scanner.nextLine();
        }

        System.out.println("Coffee Machine Simulator terminated.");
    }
}
