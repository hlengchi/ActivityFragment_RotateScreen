package com.example.hlengchi.testrecyclerview;

import android.provider.BaseColumns;

import java.net.PortUnreachableException;

/**
 * Created by hlengchi on 04/25/2018.
 */

public class GroceryCotract {
    public GroceryCotract() {
    }

    public static final class GroceryEntry implements BaseColumns {
        public static final String TABLE_NAME="groceryList";
        public static final String COLUMN_NAME="name";
        public static final String COLUMN_AMOUNT="amount";
        public static final String COLUMN_TIMESTAMP="timestap";
    }
}
