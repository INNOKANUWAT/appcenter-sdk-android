package com.microsoft.sonoma.core.utils;

import android.database.sqlite.SQLiteQueryBuilder;
import android.support.annotation.NonNull;

class SQLiteUtils {

    @NonNull
    static SQLiteQueryBuilder newSQLiteQueryBuilder() {
        return new SQLiteQueryBuilder();
    }
}