package reagodjj.example.com.myprovider;

import android.annotation.SuppressLint;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

@SuppressLint("Registered")
public class MyContentProvider extends ContentProvider {
    private static final String PACKAGE_NAME = "reagodjj.example.com.myprovider";
    private static UriMatcher uriMatcher;
    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase sqLiteDatabase;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PACKAGE_NAME, "person", 0);
    }

    @Override
    public boolean onCreate() {
        myOpenHelper = new MyOpenHelper(getContext(), "database", null, 1);
        sqLiteDatabase = myOpenHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", "RealgodJJ");
        contentValues.put("age", 23);
        sqLiteDatabase.insert("person", null, contentValues);
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        int code = uriMatcher.match(uri);
        switch (code) {
            case 0:
                @SuppressLint("Recycle")
                Cursor cursor = sqLiteDatabase.query("person", null, null, null, null, null, null);
                return cursor;
        }
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
