package app.noti.simple4;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

/**
 * Created by geek on 4/23/2017 AD.
 */

public class Data_base extends SQLiteOpenHelper {
    public static final String Database_name = "noti22.db";
    public static final String DB_PATH = Environment.getDataDirectory() + "/data/app.noti.simple4/databases/";
    public static final String azkar = "time";
    public static final String TABLE_NAME = "notit_mor";
    private Context mycontext;
    private SQLiteDatabase SQLITEDATABASE;


    public Data_base(Context context) {
        super(context, Database_name, null, 1);
        this.mycontext = context;

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("CREATE TABLE myazkar (id INTEGER PRIMARY KEY AUTOINCREMENT , "+azkar+" TEXT, "+click+" INTEGER)");
//        db.openOrCreateDatabase("file:///android_asset/azkari88.db",null);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS m0");
//        onCreate(db);

    }

//    public boolean insertazkar(AzkariClass azkariClass) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("azkar", azkariClass.getAzkar());
//        contentValues.put("click", azkariClass.getClick());
//        long res = db.insert("myazkar", null, contentValues);
//        if (res == -1) {
//            return false;
//        } else {
//            return true;
//        }
//    }


    public boolean updatetazkar(int id, String time) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("time", time);
        db.update("noti_mor", contentValues, "id=?", new String[]{String.valueOf(id)});
        db.close();
        return true;
    }

//    public Integer deleteazkar(int id) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        return db.delete("myazkar", "id=?", new String[]{String.valueOf(id)});
//    }

    public void openDatabase() {
        String dbPath = mycontext.getDatabasePath(Database_name).getPath();

        if (SQLITEDATABASE != null && SQLITEDATABASE.isOpen()) {
            return;
        }
        SQLITEDATABASE = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);

    }

    public void closeDatabase() {
        if (SQLITEDATABASE != null) {
            SQLITEDATABASE.close();
        }
    }

//    public boolean updatetextsize(int id, int azkar_size, int click_size) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("azkar_size", azkar_size);
//        contentValues.put("click_size", click_size);
//        db.update("textsizetb", contentValues, "id=?", new String[]{String.valueOf(id)});
//        db.close();
//        return true;
//    }





}