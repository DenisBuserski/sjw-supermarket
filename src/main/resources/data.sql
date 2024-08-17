# Add categories
INSERT INTO supermarket.categories(`id`, `name`) VALUES (1, 'Category-1');
INSERT INTO supermarket.categories(`id`, `name`) VALUES (1, 'Category-1');
INSERT INTO supermarket.categories(`id`, `name`) VALUES (2, 'Category-2');
INSERT INTO supermarket.categories(`id`, `name`) VALUES (3, 'Category-3');
INSERT INTO supermarket.categories(`id`, `name`) VALUES (4, 'Category-4');
INSERT INTO supermarket.categories(`id`, `name`) VALUES (5, 'Category-5');


## Add towns
INSERT INTO supermarket.towns(`town_id`, `name`) VALUES ('Town_1', 'Sofia');
INSERT INTO supermarket.towns(`town_id`, `name`) VALUES ('Town_1', 'Sofia');
INSERT INTO supermarket.towns(`town_id`, `name`) VALUES ('Town_2', 'Pleven');
INSERT INTO supermarket.towns(`town_id`, `name`) VALUES ('Town_3', 'Plovdiv');
INSERT INTO supermarket.towns(`town_id`, `name`) VALUES ('Town_4', 'Varna');
INSERT INTO supermarket.towns(`town_id`, `name`) VALUES ('Town_5', 'Burgas');
INSERT INTO supermarket.towns(`town_id`, `name`) VALUES ('Town_6', 'Razgrad');
INSERT INTO supermarket.towns(`town_id`, `name`) VALUES ('Town_7', 'Haskovo');
INSERT INTO supermarket.towns(`town_id`, `name`) VALUES ('Town_8', 'Pernik');
INSERT INTO supermarket.towns(`town_id`, `name`) VALUES ('Town_9', 'Vidin');
INSERT INTO supermarket.towns(`town_id`, `name`) VALUES ('Town_10', 'Lovech');
INSERT INTO supermarket.towns(`town_id`, `name`) VALUES ('Town_11', 'Rome');
INSERT INTO supermarket.towns(`town_id`, `name`) VALUES ('Town_12', 'Berlin');
INSERT INTO supermarket.towns(`town_id`, `name`) VALUES ('Town_13', 'London');
INSERT INTO supermarket.towns(`town_id`, `name`) VALUES ('Town_14', 'Madrid');
INSERT INTO supermarket.towns(`town_id`, `name`) VALUES ('Town_15', 'Paris');


## Add shops
INSERT INTO supermarket.shops(`id`, `address`, `name`, `town_id`) VALUES (1, 'Address_1', 'Shop_name_1', 'Town_1');
INSERT INTO supermarket.shops(`id`, `address`, `name`, `town_id`) VALUES (1, 'Address_1', 'Shop_name_1', 'Town_1');
INSERT INTO supermarket.shops(`id`, `address`, `name`, `town_id`) VALUES (2, 'Address_2', 'Shop_name_2', 'Town_2');
INSERT INTO supermarket.shops(`id`, `address`, `name`, `town_id`) VALUES (3, 'Address_3', 'Shop_name_3', 'Town_3');
INSERT INTO supermarket.shops(`id`, `address`, `name`, `town_id`) VALUES (4, 'Address_4', 'Shop_name_4', 'Town_4');
INSERT INTO supermarket.shops(`id`, `address`, `name`, `town_id`) VALUES (5, 'Address_5', 'Shop_name_5', 'Town_5');
INSERT INTO supermarket.shops(`id`, `address`, `name`, `town_id`) VALUES (6, 'Address_6', 'Shop_name_6', 'Town_6');
INSERT INTO supermarket.shops(`id`, `address`, `name`, `town_id`) VALUES (7, 'Address_7', 'Shop_name_7', 'Town_7');
INSERT INTO supermarket.shops(`id`, `address`, `name`, `town_id`) VALUES (8, 'Address_8', 'Shop_name_8', 'Town_8');
INSERT INTO supermarket.shops(`id`, `address`, `name`, `town_id`) VALUES (9, 'Address_9', 'Shop_name_9', 'Town_9');
INSERT INTO supermarket.shops(`id`, `address`, `name`, `town_id`) VALUES (10, 'Address_10', 'Shop_name_10', 'Town_10');
INSERT INTO supermarket.shops(`id`, `address`, `name`, `town_id`) VALUES (11, 'Address_11', 'Shop_name_10', 'Town_1');
INSERT INTO supermarket.shops(`id`, `address`, `name`, `town_id`) VALUES (12, 'Address_12', 'Shop_name_10', 'Town_1');
INSERT INTO supermarket.shops(`id`, `address`, `name`, `town_id`) VALUES (13, 'Address_13', 'Shop_name_10', 'Town_2');
INSERT INTO supermarket.shops(`id`, `address`, `name`, `town_id`) VALUES (14, 'Address_14', 'Shop_name_10', 'Town_2');
INSERT INTO supermarket.shops(`id`, `address`, `name`, `town_id`) VALUES (15, 'Address_15', 'Shop_name_10', 'Town_2');
INSERT INTO supermarket.shops(`id`, `address`, `name`, `town_id`) VALUES (16, 'Address_16', 'Shop_name_10', 'Town_3');
INSERT INTO supermarket.shops(`id`, `address`, `name`, `town_id`) VALUES (17, 'Address_17', 'Shop_name_10', 'Town_3');
INSERT INTO supermarket.shops(`id`, `address`, `name`, `town_id`) VALUES (18, 'Address_18', 'Shop_name_10', 'Town_3');


## Add products
INSERT INTO supermarket.products(`id`, `best_before`, `description`, `name`, `price`, `category_id`) VALUES (1, '2024-12-31', 'Desc-1', 'Dirt', 100, 1);
INSERT INTO supermarket.products(`id`, `best_before`, `description`, `name`, `price`, `category_id`) VALUES (1, '2024-12-31', 'Desc-1', 'Dirt', 100, 1);
INSERT INTO supermarket.products(`id`, `best_before`, `description`, `name`, `price`, `category_id`) VALUES (2, '2024-12-31', 'Desc-2', 'Food', 200, 2);
INSERT INTO supermarket.products(`id`, `best_before`, `description`, `name`, `price`, `category_id`) VALUES (3, '2024-12-31', 'Desc-3', 'Burger', 300, 3);
INSERT INTO supermarket.products(`id`, `best_before`, `description`, `name`, `price`, `category_id`) VALUES (4, '2024-12-31', 'Desc-4', 'Sushi', 400, 4);
INSERT INTO supermarket.products(`id`, `best_before`, `description`, `name`, `price`, `category_id`) VALUES (5, '2024-12-31', 'Desc-5', 'Shirt', 500, 5);
INSERT INTO supermarket.products(`id`, `best_before`, `description`, `name`, `price`, `category_id`) VALUES (6, '2024-12-31', 'Desc-6', 'Milk', 600, 1);
INSERT INTO supermarket.products(`id`, `best_before`, `description`, `name`, `price`, `category_id`) VALUES (7, '2024-12-31', 'Desc-7', 'Bread', 700, 2);
INSERT INTO supermarket.products(`id`, `best_before`, `description`, `name`, `price`, `category_id`) VALUES (8, '2024-12-31', 'Desc-8', 'Flowers', 800, 3);
INSERT INTO supermarket.products(`id`, `best_before`, `description`, `name`, `price`, `category_id`) VALUES (9, '2024-12-31', 'Desc-9', 'Ball', 900, 4);
INSERT INTO supermarket.products(`id`, `best_before`, `description`, `name`, `price`, `category_id`) VALUES (10, '2024-12-31', 'Desc-10', 'Jeans', 1200, 5);
INSERT INTO supermarket.products(`id`, `best_before`, `description`, `name`, `price`, `category_id`) VALUES (11, '2024-12-31', 'Desc-11', 'Skirt', 1100, 1);
INSERT INTO supermarket.products(`id`, `best_before`, `description`, `name`, `price`, `category_id`) VALUES (12, '2024-12-31', 'Desc-12', 'Underwear', 1200, 1);
INSERT INTO supermarket.products(`id`, `best_before`, `description`, `name`, `price`, `category_id`) VALUES (13, '2024-12-31', 'Desc-13', 'Hammer', 1300, 2);
INSERT INTO supermarket.products(`id`, `best_before`, `description`, `name`, `price`, `category_id`) VALUES (14, '2024-12-31', 'Desc-14', 'Mushroom', 1400, 2);
INSERT INTO supermarket.products(`id`, `best_before`, `description`, `name`, `price`, `category_id`) VALUES (15, '2024-12-31', 'Desc-15', 'Toys', 1500, 3);
INSERT INTO supermarket.products(`id`, `best_before`, `description`, `name`, `price`, `category_id`) VALUES (16, '2024-12-31', 'Desc-16', 'Bed', 1600, 3);
INSERT INTO supermarket.products(`id`, `best_before`, `description`, `name`, `price`, `category_id`) VALUES (17, '2024-12-31', 'Desc-17', 'TV', 1700, 1);
INSERT INTO supermarket.products(`id`, `best_before`, `description`, `name`, `price`, `category_id`) VALUES (18, '2024-12-31', 'Desc-18', 'Pizza', 1800, 1);
INSERT INTO supermarket.products(`id`, `best_before`, `description`, `name`, `price`, `category_id`) VALUES (19, '2024-12-31', 'Desc-19', 'Meat', 1900, 1);
INSERT INTO supermarket.products(`id`, `best_before`, `description`, `name`, `price`, `category_id`) VALUES (20, '2024-12-31', 'Desc-20', 'PC', 2000, 2);


## Add sellers
INSERT INTO supermarket.sellers(`id`, `first_name`, `last_name`, `age`, `salary`, `shop_id`, `manager_id`) VALUES (1, 'First_name_1', 'Last_name_1', 20, 5000.00, 1, null);
INSERT INTO supermarket.sellers(`id`, `first_name`, `last_name`, `age`, `salary`, `shop_id`, `manager_id`) VALUES (1, 'First_name_1', 'Last_name_1', 20, 5000.00, 1, null);
INSERT INTO supermarket.sellers(`id`, `first_name`, `last_name`, `age`, `salary`, `shop_id`, `manager_id`) VALUES (2, 'First_name_2', 'Last_name_2', 25, 6000.00, 2, null);
INSERT INTO supermarket.sellers(`id`, `first_name`, `last_name`, `age`, `salary`, `shop_id`, `manager_id`) VALUES (3, 'First_name_3', 'Last_name_3', 30, 7000.00, 3, null);
INSERT INTO supermarket.sellers(`id`, `first_name`, `last_name`, `age`, `salary`, `shop_id`, `manager_id`) VALUES (4, 'First_name_4', 'Last_name_4', 35, 2500.00, 1, 1);
INSERT INTO supermarket.sellers(`id`, `first_name`, `last_name`, `age`, `salary`, `shop_id`, `manager_id`) VALUES (5, 'First_name_5', 'Last_name_5', 40, 2500.00, 1, 1);
INSERT INTO supermarket.sellers(`id`, `first_name`, `last_name`, `age`, `salary`, `shop_id`, `manager_id`) VALUES (6, 'First_name_6', 'Last_name_6', 45, 2500.00, 1, 1);
INSERT INTO supermarket.sellers(`id`, `first_name`, `last_name`, `age`, `salary`, `shop_id`, `manager_id`) VALUES (7, 'First_name_7', 'Last_name_7', 50, 1000.00, 2, 2);
INSERT INTO supermarket.sellers(`id`, `first_name`, `last_name`, `age`, `salary`, `shop_id`, `manager_id`) VALUES (8, 'First_name_8', 'Last_name_8', 55, 1000.00, 2, 2);
INSERT INTO supermarket.sellers(`id`, `first_name`, `last_name`, `age`, `salary`, `shop_id`, `manager_id`) VALUES (9, 'First_name_9', 'Last_name_9', 60, 1000.00, 2, 2);
INSERT INTO supermarket.sellers(`id`, `first_name`, `last_name`, `age`, `salary`, `shop_id`, `manager_id`) VALUES (10, 'First_name_10', 'Last_name_10', 21, 500.00, 3, 3);
INSERT INTO supermarket.sellers(`id`, `first_name`, `last_name`, `age`, `salary`, `shop_id`, `manager_id`) VALUES (11, 'First_name_11', 'Last_name_11', 22, 500.00, 3, 3);
INSERT INTO supermarket.sellers(`id`, `first_name`, `last_name`, `age`, `salary`, `shop_id`, `manager_id`) VALUES (12, 'First_name_12', 'Last_name_12', 23, 500.00, 3, 3);
INSERT INTO supermarket.sellers(`id`, `first_name`, `last_name`, `age`, `salary`, `shop_id`, `manager_id`) VALUES (13, 'First_name_13', 'Last_name_13', 24, 500.00, 3, 3);
INSERT INTO supermarket.sellers(`id`, `first_name`, `last_name`, `age`, `salary`, `shop_id`, `manager_id`) VALUES (14, 'First_name_14', 'Last_name_14', 31, 2000.00, 10, null);
INSERT INTO supermarket.sellers(`id`, `first_name`, `last_name`, `age`, `salary`, `shop_id`, `manager_id`) VALUES (15, 'First_name_15', 'Last_name_15', 32, 2000.00, 11, null);
INSERT INTO supermarket.sellers(`id`, `first_name`, `last_name`, `age`, `salary`, `shop_id`, `manager_id`) VALUES (16, 'First_name_16', 'Last_name_16', 33, 2000.00, 12, null);
INSERT INTO supermarket.sellers(`id`, `first_name`, `last_name`, `age`, `salary`, `shop_id`, `manager_id`) VALUES (17, 'First_name_17', 'Last_name_17', 34, 2000.00, 13, null);
INSERT INTO supermarket.sellers(`id`, `first_name`, `last_name`, `age`, `salary`, `shop_id`, `manager_id`) VALUES (18, 'First_name_18', 'Last_name_18', 36, 2000.00, 14, null);
INSERT INTO supermarket.sellers(`id`, `first_name`, `last_name`, `age`, `salary`, `shop_id`, `manager_id`) VALUES (19, 'First_name_19', 'Last_name_19', 37, 2000.00, 15, null);
INSERT INTO supermarket.sellers(`id`, `first_name`, `last_name`, `age`, `salary`, `shop_id`, `manager_id`) VALUES (20, 'First_name_20', 'Last_name_20', 38, 2000.00, 16, null);


## Add products_shops
INSERT INTO supermarket.products_shops(`product_id`, `shop_id`) VALUES (1, 1);
INSERT INTO supermarket.products_shops(`product_id`, `shop_id`) VALUES (1, 1);
INSERT INTO supermarket.products_shops(`product_id`, `shop_id`) VALUES (1, 2);
INSERT INTO supermarket.products_shops(`product_id`, `shop_id`) VALUES (1, 3);
INSERT INTO supermarket.products_shops(`product_id`, `shop_id`) VALUES (2, 1);
INSERT INTO supermarket.products_shops(`product_id`, `shop_id`) VALUES (2, 2);
INSERT INTO supermarket.products_shops(`product_id`, `shop_id`) VALUES (2, 3);
INSERT INTO supermarket.products_shops(`product_id`, `shop_id`) VALUES (3, 4);
INSERT INTO supermarket.products_shops(`product_id`, `shop_id`) VALUES (3, 5);
INSERT INTO supermarket.products_shops(`product_id`, `shop_id`) VALUES (3, 6);
INSERT INTO supermarket.products_shops(`product_id`, `shop_id`) VALUES (3, 7);
INSERT INTO supermarket.products_shops(`product_id`, `shop_id`) VALUES (4, 2);
INSERT INTO supermarket.products_shops(`product_id`, `shop_id`) VALUES (5, 4);
INSERT INTO supermarket.products_shops(`product_id`, `shop_id`) VALUES (6, 6);
INSERT INTO supermarket.products_shops(`product_id`, `shop_id`) VALUES (7, 8);
INSERT INTO supermarket.products_shops(`product_id`, `shop_id`) VALUES (8, 10);
INSERT INTO supermarket.products_shops(`product_id`, `shop_id`) VALUES (9, 12);
INSERT INTO supermarket.products_shops(`product_id`, `shop_id`) VALUES (10, 14);
INSERT INTO supermarket.products_shops(`product_id`, `shop_id`) VALUES (11, 16);
INSERT INTO supermarket.products_shops(`product_id`, `shop_id`) VALUES (12, 18);
INSERT INTO supermarket.products_shops(`product_id`, `shop_id`) VALUES (13, 1);
