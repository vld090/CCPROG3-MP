
public class VendingMachineDirector {

    public static Item HOT_DOG = new Item("Hot dog", 35);
    public static Item HAM = new Item("Ham", 45);
    public static Item BEEF_SLICES = new Item("Beef Slices", 40);
    public static Item LETTUCE = new Item("Lettuce", 10);
    public static Item TOMATO = new Item("Tomato", 10);
    public static Item EGG = new Item("Egg", 20);
    public static Item WHOLE_WHEAT_BREAD = new Item("Whole Wheat Bread", 10);
    public static Item WHITE_BREAD = new Item("White Bread", 30);

    public static Item HEALTHYHOTDOG = new Item("Healthy Hot dog Sandwich", 50); 
    public static Item HEALTHYHAM = new Item("Healthy Ham Sandwich",    50);
    public static Item HEALTHYBEEF = new Item("Healthy Beef  Sandwich", 50);
    public static Item HEALTHYVEG = new Item("Vegetarian Sandwich",    100);

    public static VendingMachineBuilder createStandardVendingMachine(){
        VendingMachineBuilder builder = new VendingMachineBuilder();
        builder.addItem(HOT_DOG, 50, 10);
        builder.addItem(HAM, 50, 10);
        builder.addItem(BEEF_SLICES, 100, 10);
        builder.addItem(LETTUCE, 20, 10);
        builder.addItem(TOMATO, 20, 10);
        builder.addItem(EGG, 20, 10);
        builder.addItem(WHOLE_WHEAT_BREAD, 50, 10);
        builder.addItem(WHITE_BREAD, 50, 10);

        return builder;
    }


    public static VendingMachineBuilder createSpecialVendingMachine(){
        VendingMachineBuilder builder = createStandardVendingMachine();

        builder.addItem(HEALTHYHOTDOG, 100, 10);
        builder.addItem(HEALTHYHAM, 100, 10);
        builder.addItem(HEALTHYBEEF, 100, 10);
        builder.addItem(HEALTHYVEG, 100, 10);

        return builder;
    }
}
