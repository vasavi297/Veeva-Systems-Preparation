import java.util.*;
class Product
{

    String productcode;
    double price;
    public Product(String productcode, double price) {
        this.productcode=productcode;
        this.price=price;
    }
}
class InventorySystem
{
    Map<String,List<Product>> categoryMap=new HashMap<>();
    void addProduct(String category,String productcode,double price)
    {
        if(categoryMap.containsKey(category))
        {
          categoryMap.get(category)
          .add(new Product(productcode, price))  ;
        }
        else
        {
            List<Product>products=new ArrayList<>();
            products.add(new Product(productcode, price));
            categoryMap.put(category, products);
        }
    }
    void findCategory(String category)
    {
        List<Product>products=categoryMap.get(category);
        if(!categoryMap.containsKey(category))
        {
            System.out.println("Category not found");
            return;
        }
        for(Product product:products)
        {
            System.out.println("Productcode: "+product.productcode+" Price: "+product.price);
        }
        System.out.println("Total products in category "+category+": "+products.size());
        Product highestProduct = products.get(0);

        for (Product product : products) 
        {
            if (product.price > highestProduct.price) 
            {
            highestProduct = product;
            }
        }
  
        System.out.println("Highest priced product: "+ highestProduct.productcode + " Price: " + highestProduct.price);
       
    }
    void displayCategoryWise()
    {
        for (Map.Entry<String, List<Product>> entry : categoryMap.entrySet()) {
            System.out.println("Category: " + entry.getKey());
            List<Product> products = entry.getValue();
            products.sort((p1, p2) -> Double.compare(p2.price, p1.price));
            for (Product product : products) {
                System.out.println("Productcode: " + product.productcode + " Price: " + product.price);
            }
        }
    }
  void highestPriceCategory()
{
    double maxPrice = 0;
    String highestCategory = "";

    for (Map.Entry<String, List<Product>> entry : categoryMap.entrySet())
    {
        String category = entry.getKey();
        List<Product> products = entry.getValue();

        Product highestProduct = products.get(0);

        for (Product product : products)
        {
            if (product.price > highestProduct.price)
            {
                highestProduct = product;
            }
        }

        if (highestProduct.price > maxPrice)
        {
            maxPrice = highestProduct.price;
            highestCategory = category;
        }
    }

    System.out.println("Category with highest priced product: "
            + highestCategory);
    System.out.println("Highest price: " + maxPrice);
}
public static void main(String args[])
{
    InventorySystem inventorySystem = new InventorySystem();
    Scanner sc = new Scanner(System.in);
    while (true) {
        System.out.println("1. Add Product");
        System.out.println("2. Find Category");
        System.out.println("3. Display Category Wise");
        System.out.println("4. Highest Price Category");
        System.out.println("5. Exit");
        int choice = sc.nextInt();
        sc.nextLine(); // Consume newline
        switch (choice) {
            case 1:
                System.out.print("Enter category: ");
                String category = sc.nextLine();
                System.out.print("Enter product code: ");
                String productcode = sc.nextLine();
                System.out.print("Enter price: ");
                double price = sc.nextDouble();
                inventorySystem.addProduct(category, productcode, price);
                break;
            case 2:
                System.out.print("Enter category to find: ");
                String findCategory = sc.nextLine();
                inventorySystem.findCategory(findCategory);
                break;
            case 3:
                inventorySystem.displayCategoryWise();
                break;
            case 4:
                inventorySystem.highestPriceCategory();
                break;
            case 5:
                System.exit(0);
            default:
                System.out.println("Invalid choice");
                break;
            }
        }
    }
}



