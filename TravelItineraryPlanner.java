import java.util.*;

class TravelDestination {
    private String name;
    private String date;
    private double budgetInINR;

    public TravelDestination(String name, String date, double budgetInINR) {
        this.name = name;
        this.date = date;
        this.budgetInINR = budgetInINR;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public double getBudgetInINR() {
        return budgetInINR;
    }

    public String displayDetails() {
        return "Destination: " + name + ", Date: " + date + ", Budget: ₹" + budgetInINR;
    }
}

public class TravelItineraryPlanner {
    private List<TravelDestination> destinations;
    private double totalBudgetInINR;

    public TravelItineraryPlanner() {
        destinations = new ArrayList<>();
        totalBudgetInINR = 0;
    }

    public void addDestination(String name, String date, double budgetInINR) {
        destinations.add(new TravelDestination(name, date, budgetInINR));
        totalBudgetInINR += budgetInINR;
        System.out.println("Added: " + name + " on " + date + " with a budget of ₹" + budgetInINR);
    }

    public void showItinerary() {
        System.out.println("\n--- Travel Itinerary ---");
        for (TravelDestination destination : destinations) {
            System.out.println(destination.displayDetails());
        }
        System.out.println("Total Budget: R.s " + totalBudgetInINR);
    }

    public void showMap(String destination) {
        System.out.println("Map for " + destination + " (simulated): https://maps.example.com?q=" + destination.replace(" ", "+"));
    }

    public void showWeather(String destination) {
        // Placeholder for actual weather data
        System.out.println("Weather for " + destination + " (simulated): Sunny, 25°C");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TravelItineraryPlanner planner = new TravelItineraryPlanner();

        while (true) {
            System.out.println("\n--- Travel Itinerary Planner ---");
            System.out.println("1. Add Destination");
            System.out.println("2. Show Itinerary");
            System.out.println("3. Show Map");
            System.out.println("4. Show Weather");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter destination name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter travel date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter budget in INR: ");
                    double budgetInINR = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    planner.addDestination(name, date, budgetInINR);
                    break;
                case 2:
                    planner.showItinerary();
                    break;
                case 3:
                    System.out.print("Enter destination name for map: ");
                    String mapDestination = scanner.nextLine();
                    planner.showMap(mapDestination);
                    break;
                case 4:
                    System.out.print("Enter destination name for weather: ");
                    String weatherDestination = scanner.nextLine();
                    planner.showWeather(weatherDestination);
                    break;
                case 5:
                    System.out.println("Exiting Travel Itinerary Planner. Safe travels!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
