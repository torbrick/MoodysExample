package com.example.moodysexercise.data.persistence;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.example.moodysexercise.data.persistence.dao.DigitalCardDao;
import com.example.moodysexercise.data.persistence.dao.DigitalCardDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile DigitalCardDao _digitalCardDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `digital_cards` (`id` TEXT NOT NULL, `type` TEXT NOT NULL, `text_textValue` TEXT, `text_textColor` TEXT, `text_font_size` INTEGER, `text_font_family` TEXT, `text_font_style` TEXT, `title_textValue` TEXT, `title_textColor` TEXT, `title_font_size` INTEGER, `title_font_family` TEXT, `title_font_style` TEXT, `description_textValue` TEXT, `description_textColor` TEXT, `description_font_size` INTEGER, `description_font_family` TEXT, `description_font_style` TEXT, `image_url` TEXT, `image_altText` TEXT, `image_width` INTEGER, `image_height` INTEGER, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '115b84a9b47955339186c3db126ea69b')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `digital_cards`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsDigitalCards = new HashMap<String, TableInfo.Column>(21);
        _columnsDigitalCards.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDigitalCards.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDigitalCards.put("text_textValue", new TableInfo.Column("text_textValue", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDigitalCards.put("text_textColor", new TableInfo.Column("text_textColor", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDigitalCards.put("text_font_size", new TableInfo.Column("text_font_size", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDigitalCards.put("text_font_family", new TableInfo.Column("text_font_family", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDigitalCards.put("text_font_style", new TableInfo.Column("text_font_style", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDigitalCards.put("title_textValue", new TableInfo.Column("title_textValue", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDigitalCards.put("title_textColor", new TableInfo.Column("title_textColor", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDigitalCards.put("title_font_size", new TableInfo.Column("title_font_size", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDigitalCards.put("title_font_family", new TableInfo.Column("title_font_family", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDigitalCards.put("title_font_style", new TableInfo.Column("title_font_style", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDigitalCards.put("description_textValue", new TableInfo.Column("description_textValue", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDigitalCards.put("description_textColor", new TableInfo.Column("description_textColor", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDigitalCards.put("description_font_size", new TableInfo.Column("description_font_size", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDigitalCards.put("description_font_family", new TableInfo.Column("description_font_family", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDigitalCards.put("description_font_style", new TableInfo.Column("description_font_style", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDigitalCards.put("image_url", new TableInfo.Column("image_url", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDigitalCards.put("image_altText", new TableInfo.Column("image_altText", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDigitalCards.put("image_width", new TableInfo.Column("image_width", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDigitalCards.put("image_height", new TableInfo.Column("image_height", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDigitalCards = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesDigitalCards = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoDigitalCards = new TableInfo("digital_cards", _columnsDigitalCards, _foreignKeysDigitalCards, _indicesDigitalCards);
        final TableInfo _existingDigitalCards = TableInfo.read(db, "digital_cards");
        if (!_infoDigitalCards.equals(_existingDigitalCards)) {
          return new RoomOpenHelper.ValidationResult(false, "digital_cards(com.example.moodysexercise.data.persistence.model.DigitalCardEntity).\n"
                  + " Expected:\n" + _infoDigitalCards + "\n"
                  + " Found:\n" + _existingDigitalCards);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "115b84a9b47955339186c3db126ea69b", "b1b41a2027c12afc1406266ea2829f0d");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "digital_cards");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `digital_cards`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(DigitalCardDao.class, DigitalCardDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public DigitalCardDao digitalCardDao() {
    if (_digitalCardDao != null) {
      return _digitalCardDao;
    } else {
      synchronized(this) {
        if(_digitalCardDao == null) {
          _digitalCardDao = new DigitalCardDao_Impl(this);
        }
        return _digitalCardDao;
      }
    }
  }
}
