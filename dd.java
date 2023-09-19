import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Product {
    private String productName;
    private double productPrice;
    private String brand;
    private String model;

    public Product(String productName, double productPrice, String brand, String model) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.brand = brand;
        this.model = model;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public void displayProductInformation() {
        System.out.println("Product Name: " + productName);
        System.out.println("Product Price: " + productPrice);
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
    }
}

class PhoneProduct extends Product {
    public PhoneProduct(String productName, double productPrice, String brand, String model) {
        super(productName, productPrice, brand, model);
    }

    @Override
    public void displayProductInformation() {
        super.displayProductInformation();
        System.out.println("Product Type: Phone");
    }
}

class ComputerProduct extends Product {
    public ComputerProduct(String productName, double productPrice, String brand, String model) {
        super(productName, productPrice, brand, model);
    }

    @Override
    public void displayProductInformation() {
        super.displayProductInformation();
        System.out.println("Product Type: Computer");
    }
}

public class dd {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Product");
            System.out.println("2. List Products");
            System.out.println("3. Search Product by Name");
            System.out.println("4. Search Product by Price");
            System.out.println("5. Delete Product");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter product type (Phone/Computer): ");
                    String productType = scanner.nextLine();
                    if (!productType.equalsIgnoreCase("Phone") && !productType.equalsIgnoreCase("Computer")) {
                        System.out.println("Invalid product type. Product not added.");
                        continue;
                    }
                    System.out.print("Enter product name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double productPrice = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter brand name: ");
                    String brand = scanner.nextLine();
                    System.out.print("Enter model name: ");
                    String model = scanner.nextLine();
                    
                    Product product;
                    if (productType.equalsIgnoreCase("Phone")) {
                        product = new PhoneProduct(productName, productPrice, brand, model);
                    } else if (productType.equalsIgnoreCase("Computer")) {
                        product = new ComputerProduct(productName, productPrice, brand, model);
                    } else {
                        System.out.println("Invalid product type. Product not added.");
                        continue;
                    }
                    
                    productList.add(product);
                    System.out.println("Product added successfully!");
                    break;
                case 2:
                    System.out.println("List of Products:");
                    for (Product p : productList) {
                        p.displayProductInformation();
                        System.out.println();
                    }
                    break;
                case 3:
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter product name to search: ");
                    String searchName = scanner.nextLine();
                    boolean foundByName = false;
                    for (Product p : productList) {
                        if (p.getProductName().equalsIgnoreCase(searchName)) {
                            p.displayProductInformation();
                            foundByName = true;
                        }
                    }
                    if (!foundByName) {
                        System.out.println("Product not found by name.");
                    }
                    break;
                case 4:
                    System.out.print("Enter product price to search: ");
                    double searchPrice = scanner.nextDouble();
                    boolean foundByPrice = false;
                    for (Product p : productList) {
                        if (p.getProductPrice() == searchPrice) {
                            p.displayProductInformation();
                            foundByPrice = true;
                        }
                    }
                    if (!foundByPrice) {
                        System.out.println("Product not found by price.");
                    }
                    break;
                case 5:
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter product name to delete: ");
                    String deleteName = scanner.nextLine();
                    Iterator<Product> iterator = productList.iterator();
                    while (iterator.hasNext()) {
                        Product p = iterator.next();
                        if (p.getProductName().equalsIgnoreCase(deleteName)) {
                            iterator.remove();
                            System.out.println("Product deleted successfully!");
                        }
                    }
                    break;
                case 6:
                    System.out.println("Exiting program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
