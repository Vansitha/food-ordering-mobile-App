package com.example.foodapp.database;

public class FoodDeliverySchema {

    public static class CustomerTable {
        public static final String NAME = "customers";

        public static class Cols {
            public static final String ID = "cust_id";
            public static final String CUSTOMER_NAME = "customer_name";
            public static final String PASSWORD = "password";
            public static final String USERNAME = "username";
            public static final String ADDRESS = "address";
            public static final String EMAIL = "email";
        }
    }

    public static class OrderTable {
        public static final String NAME = "orders";

        public static class Cols {
            public static final String ORDER_ID = "order_id";
            public static final String FK_CUSTOMER_ID = "cust_id";
            public static final String RESTURANT_NAME = "resturant_name";
            public static final String ORDER_ITEM = "order_item";
            public static final String QUANTITY = "quantity";
            public static final String COST = "price";
        }

    }

    public static class ResturantTable {
        public static final String NAME = "restaurants";

        public static class Cols {
            public static final String RESTURANT_ID = "resturant_ID";
            public static final String RESTURANT_NAME = "resturant_name";
            public static final String FOOD_ITEM = "food_item";
            public static final String PRICE = "price";
            public static final String DESCRIPTION = "description";
            public static final String FOOD_IMAGE_REF = "food_image_ref";
            public static final String RESTURANT_LOGO_REF = "resturant_logo_ref";
        }

    }

}
