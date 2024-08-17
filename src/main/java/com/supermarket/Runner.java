package com.supermarket;

import com.supermarket.model.*;
import com.supermarket.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Component
@Slf4j
public class Runner implements CommandLineRunner {
    private Scanner scanner = new Scanner(System.in);

    private final CategoryService categoryService;
    private final TownService townService;
    private final ShopService shopService;
    private final SellerService sellerService;
    private final ProductService productService;

    @Autowired
    public Runner(CategoryService categoryService,
                  TownService townService,
                  ShopService shopService,
                  SellerService sellerService,
                  ProductService productService) {
        this.categoryService = categoryService;
        this.townService = townService;
        this.shopService = shopService;
        this.sellerService = sellerService;
        this.productService = productService;
    }


    @Override
    public void run(String... args) throws Exception {
        // TODO: Add README.md
        // TODO: Spring Database Initialization
        // TODO: Spring Add tests

        String menu = """
                          Hi
                          Choose option from:
                          1 - for Add Category
                          2 - for Add Town
                          3 - for Add Shop
                          4 - for Add Seller
                          5 - for Add Product
                          6 - for Set seller new manager
                          7 - for Distributing product in shops
                          8 - for Showing all sellers in shop
                          9 - for Showing all products in shop
                          """;
        System.out.println(menu);

        String input = scanner.nextLine();
        while (!input.equals("STOP")) {

            switch (input) {
                case "1" -> {
                    addCategory();
                }
                case "2" -> {
                    addTown();
                }
                case "3" -> {
                    addShop();
                }
                case "4" -> {
                    addSeller();
                }
                case "5" -> {
                    addProduct();
                }
                case "6" -> {
                    setNewMangerForSeller();
                }
                case "7" -> {
                    distributeProductInShops();
                }
                case "8" -> {
                    showAllSellersInShop();
                }
                case "9" -> {
                    showAllProductsInShop();
                }
                default -> log.info("Incorrect input!");
            }

            input = scanner.nextLine();
        }
    }

    private void addCategory() {
        System.out.println("Enter category name:");
        String categoryName = scanner.nextLine();
        this.categoryService.addCategory(categoryName);
    }

    private void addTown() {
        System.out.println("Enter town name:");
        String townName = scanner.nextLine();
        this.townService.addTown(townName);
    }

    private void addShop() {
        System.out.println("Enter shop address:");
        String shopAddress = scanner.nextLine();
        System.out.println("Enter shop name:");
        String shopName = scanner.nextLine();
        Town town = this.townService.getTownById("Town_1");
        this.shopService.addShop(shopAddress, shopName, town);
    }

    private void addSeller() {
        System.out.println("Enter seller first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter seller last name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter seller age:");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter seller salary:");
        BigDecimal salary = BigDecimal.valueOf(Double.parseDouble(scanner.nextLine()));
        Shop shop = null;
        Seller manager = null;
        this.sellerService.addSeller(firstName, lastName, age, salary, shop, manager);
    }

    private void addProduct() throws ParseException {
        System.out.println("Enter product best_before date in the format DD-MM-YYYY:");
        String inputDate = scanner.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date bestBeforeDate = dateFormat.parse(inputDate);
        System.out.println("Enter product description:");
        String description = scanner.nextLine();
        System.out.println("Enter product name:");
        String productName = scanner.nextLine();
        System.out.println("Enter product price:");
        BigDecimal productPrice = BigDecimal.valueOf(Double.parseDouble(scanner.nextLine()));
        Category category = null;
        this.productService.addProduct(bestBeforeDate, description, productName, productPrice, category);
    }

    private void setNewMangerForSeller() {
        Optional<Seller> seller = this.sellerService.findById(17);
        if (seller.isEmpty()) {
            log.info("Seller with id {} does not exist!", 17);
        } else {
            this.sellerService.updateManagerId(1, 17);
            log.info("Successfully update seller with id {}", 17);
        }
    }

    private void distributeProductInShops() {
        System.out.println("Enter product name:");
        String productName = scanner.nextLine();
        System.out.println("Enter product distribution in shops in the format [shopName1 shopName2 ...]:");
        String shopNames = scanner.nextLine();
        List<String> shops = Arrays.stream(shopNames.split("\\s+")).collect(Collectors.toList());
        this.shopService.addProductToShops(productName, shops);
    }

    private void showAllSellersInShop() {
        this.shopService.getSellersByShopId(1);
    }

    private void showAllProductsInShop() {
        this.shopService.getAllProductsByShopId(1);
    }
}
