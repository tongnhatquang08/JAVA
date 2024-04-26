package Btap_them;

import java.util.*;


class Country{
    protected String countryCode;
    protected String countryName;
    protected float totalArea;
    public Country(String countryCode, String countryName, float totalArea){
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.totalArea = totalArea;
    }
    public String getCountryCode() {
        return countryCode;
    }
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    public String getCountryName() {
        return countryName;
    }
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    public float getTotalArea() {
        return totalArea;
    }
    public void setTotalArea(float totalArea) {
        this.totalArea = totalArea;
    }
    public void display(){
        System.out.println("Country Code: " + countryCode);
        System.out.println("Country Name: " + countryName);
        System.out.println("Total Area: "+ totalArea);
    }
}

class EastAsiaCountries extends Country {
    private String countryTerrain;
    public EastAsiaCountries (String countryCode, String countryName, float totalArea, String countryTerrain){
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }
    public String getCountryTerrain() {
        return countryTerrain;
    }
    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    @Override
    public void display(){
        System.out.println("Country Code: " + countryCode);
        System.out.println("Country Name: " + countryName);
        System.out.println("Total Area: "+ totalArea);
        System.out.println("Country Terrain: " + countryTerrain);
    }
}

class CountryManager {
    private List<EastAsiaCountries> countryList = new ArrayList<>();
    private EastAsiaCountries mostRecentCountry;
    public void addCountryInformation(EastAsiaCountries country) throws Exception {
        countryList.add(country);
        mostRecentCountry = country;

    }
    public EastAsiaCountries getRecentlyEnteredInformation() throws Exception {
        if (mostRecentCountry == null) {
            throw new Exception("No country has been entered yet.");
        }
        return mostRecentCountry;
    }
    public EastAsiaCountries[] searchInformationByName(String name) throws Exception {
        List<EastAsiaCountries> resultList = new ArrayList<>();
        for (EastAsiaCountries country : countryList) {
            if (country.getCountryName().equals(name)) {
                resultList.add(country);
            }
        }
        if (resultList.isEmpty()) {
            throw new Exception("Country not found.");
        }
        return resultList.toArray(new EastAsiaCountries[0]);
    }
    public void sortInformationByAscendingOrder() {
    Collections.sort(countryList, new Comparator<EastAsiaCountries>() {
        @Override
        public int compare(EastAsiaCountries o1, EastAsiaCountries o2) {
            return o1.getCountryName().compareTo(o2.getCountryName());
        }
    });
    }

    public void display() {
        for (EastAsiaCountries country : countryList) {
            country.display();
        }
    }

    public void addCountryInformation() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter country code: ");
        String code = scanner.nextLine();
        System.out.print("Enter country name: ");
        String name = scanner.nextLine();
        System.out.print("Enter total area: ");
        float area = scanner.nextFloat();
        System.out.print("Enter country terrain: ");
        scanner.nextLine();
        String terrain = scanner.nextLine();
        try {
            EastAsiaCountries country = new EastAsiaCountries(code, name, area, terrain);
            addCountryInformation(country);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

public class CountryManagement {
    public static void main(String[] args) {
        CountryManager manager = new CountryManager();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add country information");
            System.out.println("2. Display recently entered information");
            System.out.println("3. Search information by name");
            System.out.println("4. Sort information by ascending order");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    manager.addCountryInformation();
                    break;
                case 2:
                    try {
                        manager.getRecentlyEnteredInformation().display();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Enter country name: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    try {
                        EastAsiaCountries[] result = manager.searchInformationByName(name);
                        if (result.length > 0) {
                            System.out.println("Search results:");
                            for (EastAsiaCountries country : result) {
                                country.display();
                            }
                        } else{
                            System.out.println("No results found.");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    manager.sortInformationByAscendingOrder();
                    System.out.println("Sorted information:");
                    manager.display();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}