import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSV {
    private Scanner sc;
    private List<String[]> productInfo;
    private List<Product> productList;
    private List<String[]> customerInfo;
    private List<Customer> customerList;
    public CSV() {
        sc = null;
        productInfo = new ArrayList<>();
        productList = new ArrayList<>();
        customerInfo = new ArrayList<>();
        customerList = new ArrayList<>();
    }
    public List<Product> getData() {
        try {
            String path = "C:\\Users\\Akash Bhatt\\OneDrive\\Desktop\\Sem-4\\JavaIotDeveloper\\Product.csv";
            sc = new Scanner(new FileReader(path));
            sc.nextLine();
            while (sc.hasNext()) {
                productInfo.add(sc.nextLine().split(","));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (String[] str : productInfo) {
            Product p = new Product();
            String productName, productId, stock, price, productURL;
            for (int i = 0; i < str.length; i++) {
                switch (i) {
                    case 0:
                        productName = str[i].isEmpty() ? " " : str[i];
                        p.setProductName(productName);
                        break;
                    case 1:
                        productId = str[i].isEmpty() ? " " : str[i];
                        p.setProductId(productId);
                        break;
                    case 2:
                        stock = str[i].isEmpty() ? " " : str[i];
                        p.setStock(stock);
                        break;
                    case 3:
                        price = str[i].isEmpty() ? " " : str[i];
                        p.setPrice(Double.parseDouble(price));
                        break;
                    case 4:
                        productURL = str[i].isEmpty() ? " " : str[i];
                        p.setProductURL(productURL);
                        break;
                }
            }
            productList.add(p);
        }
        return productList;
    }
    public List<Customer> getData1() {
        try {
            String path = "C:\\Users\\Akash Bhatt\\OneDrive\\Desktop\\Sem-4\\JavaIotDeveloper\\Customer.csv";
            sc = new Scanner(new FileReader(path));
            sc.nextLine();
            while (sc.hasNext()) {
                customerInfo.add(sc.nextLine().split(","));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (String[] str : customerInfo) {
            Customer c =new Customer();
            String customerId,customerName,productId;
            for (int i = 0; i < str.length; i++) {
                switch (i) {
                    case 0:
                       customerId = str[i].isEmpty() ? " " : str[i];
                        c.setCustomerId(Integer.parseInt(customerId));
                        break;
                    case 1:
                        customerName= str[i].isEmpty() ? " " : str[i];
                        c.setCustomerName(customerName);
                        break;
                    case 2:
                        productId = str[i].isEmpty() ? " " : str[i];
                        c.setProdcuctId(productId);
                        break;
                }
            }
            customerList.add(c);
        }
        return customerList;
    }
}
