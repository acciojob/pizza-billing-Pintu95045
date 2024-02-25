package com.driver;
public class Pizza {
    private int basePrice;
    private int extraCheesePrice;
    private int extraToppingsPrice;
    private int paperBagPrice;
    private boolean extraCheeseAdded;
    private boolean extraToppingsAdded;
    private boolean takeaway;
    private boolean isVeg;
    private String bill;

    public Pizza(boolean isVeg) {
        this.isVeg = isVeg;
        this.basePrice = isVeg ? 300 : 400;
        this.extraCheesePrice = 80;
        this.extraToppingsPrice = isVeg ? 70 : 120;
        this.paperBagPrice = 20;
        this.extraCheeseAdded = false;
        this.extraToppingsAdded = false;
        this.takeaway = false;
    }

    public int getPrice() {
        int totalPrice = basePrice;
        if (extraCheeseAdded) totalPrice += extraCheesePrice;
        if (extraToppingsAdded) totalPrice += extraToppingsPrice;
        if (takeaway) totalPrice += paperBagPrice;
        return totalPrice;
    }

    public void addExtraCheese() {
        if (!extraCheeseAdded) {
            extraCheeseAdded = true;
            bill += "Extra Cheese Added: " + extraCheesePrice + "\n";
        }
    }

    public void addExtraToppings() {
        if (!extraToppingsAdded) {
            extraToppingsAdded = true;
            bill += "Extra Toppings Added: " + extraToppingsPrice + "\n";
        }
    }

    public void addTakeaway() {
        if (!takeaway) {
            takeaway = true;
            bill += "Paperbag Added: " + paperBagPrice + "\n";
        }
    }

    public String getBill() {
        StringBuilder builder = new StringBuilder();
        builder.append("Base Price Of The Pizza: ").append(basePrice).append("\n");
        if (extraCheeseAdded) builder.append("Extra Cheese Added: ").append(extraCheesePrice).append("\n");
        if (extraToppingsAdded) builder.append("Extra Toppings Added: ").append(extraToppingsPrice).append("\n");
        if (takeaway) builder.append("Paperbag Added: ").append(paperBagPrice).append("\n");
        builder.append("Total Price: ").append(getPrice()).append("\n");
        return builder.toString();
    }
}