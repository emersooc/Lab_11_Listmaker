import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker
{
    private static ArrayList<String> itemList = new ArrayList<>(); //creates array
    private static Scanner scanner = new Scanner(System.in); //scanner object

    public static void main(String[] args)
    {
        while (true)
        {
            displayMenu();
            String choice = SafeInput.getRegExString(scanner, "Enter your choice", "[AaDdPpQq]");
            switch (choice.toUpperCase())
            {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    if (SafeInput.getYNConfirm(scanner, "Are you sure you want to quit? (Y/N)"))
                    {
                        System.out.println("Goodbye!");
                        System.exit(0);
                    }
                    break;
            }
        }
    }

    private static void displayMenu()
    {
        SafeInput.prettyHeader("Menu");
        System.out.println("A – Add an item to the list");
        System.out.println("D – Delete an item from the list");
        System.out.println("P – Print the list");
        System.out.println("Q – Quit the program");
    }

    private static void addItem()
    {
        String item = SafeInput.getNonZeroLenString(scanner, "Enter item to add");
        itemList.add(item);
        System.out.println("Item added successfully!");
    }

    private static void deleteItem()
    {
        if (itemList.isEmpty())
        {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }
        printNumberedList();
        int itemNumber = SafeInput.getRangedInt(scanner, "Enter item number to delete", 1, itemList.size());
        String deletedItem = itemList.remove(itemNumber - 1); //arrays are 0-X, converts input to this scale
        System.out.println("'" + deletedItem + "' deleted successfully!");
    }

    private static void printList()
    {
        if (itemList.isEmpty())
        {
            System.out.println("The list is empty.");
            return;
        }
        SafeInput.prettyHeader("List Items");
        for (int i = 0; i < itemList.size(); i++)
        {
            System.out.println((i + 1) + ". " + itemList.get(i));
        }
    }

    private static void printNumberedList()
    {
        SafeInput.prettyHeader("List Items");
        for (int i = 0; i < itemList.size(); i++)
        {
            System.out.println((i + 1) + ". " + itemList.get(i));
        }
    }
}