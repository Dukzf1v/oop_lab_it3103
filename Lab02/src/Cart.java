public class Cart {
    public static final int MAX_NUMBER_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
    private int qtyOrdered;
    public void addDigitalVideoDisc(DigitalVideoDisc disc)
    {
        if (qtyOrdered<MAX_NUMBER_ORDERED)
        {
            qtyOrdered++;
            itemsOrdered[qtyOrdered-1] = disc;
            System.out.println("The disc has been added");
        }
        else
        {
            System.out.println("The cart is almost full");
        }
    }

public int removeDigitalVideoDisc(DigitalVideoDisc disc) {
    if (itemsOrdered[0] == null) {
        System.out.println("Your cart is empty!");
        return -1; 
    }

    for (int i = 0; i < qtyOrdered; i++) {
        if (itemsOrdered[i].equals(disc)) { 
            for (int j = i; j < qtyOrdered - 1; j++) {
                itemsOrdered[j] = itemsOrdered[j + 1];
            }
            itemsOrdered[qtyOrdered - 1] = null; 
            qtyOrdered--; 
            System.out.println("The disc is removed successfully!");
            return 1; 
        }
    }

    System.out.println("Could not find the searched disc in cart!");
    return -1; 
}

    public float totalCost() {
        float sum = 0.00f;
        for (int i=0;i<qtyOrdered;i++) {
            sum += itemsOrdered[i].getCost();
        }
        return sum;
    }
}