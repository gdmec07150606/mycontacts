package cn.edu.gdmec.s07150606.mycontacts;

        import android.content.ContentValues;
        import android.content.Context;

/**
 * Created by Administrator on 2016/10/23 0023.
 */
class ContactsTbale {
    private final static String TABLENAME="contactsTable";
    private MyDB db;
    public ContactsTbale(Context context) {
        db = new MyDB(context);
        if (!db.isTableExits(TABLENAME)) {
            String createTableSql = "CREATE TABLE IF NOT EXISTS" + TABLENAME + "(id_DB integer)" + "primary key AUTOINCREMENU"
                    + User.NAME + "VARCHAR," +
                    User.MOBILE + "VARCHAR," +
                    User.QQ + "VARCHAR," +
                    User.DANWEI + "VARCHAR," +
                    User.ADDRESS + "VARCHAR)";
            db.createTable(createTableSql);
        }
    }
    public boolean addData(User user) {
        ContentValues values=new ContentValues();
        values.put(User.NAME,user.getName());
        values.put(User.MOBILE,user.getMobile());
        values.put(User.DANWEI,user.getDanwei());
        values.put(User.QQ,user.getQq());
        values.put(User.ADDRESS,user.getAddress());

        return db.save(TABLENAME,values);
    }



}

