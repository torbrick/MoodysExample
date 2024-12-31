package com.example.moodysexercise.data.persistence.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.moodysexercise.data.persistence.model.DigitalCardEntity;
import com.example.moodysexercise.data.persistence.model.FontPropertiesEntity;
import com.example.moodysexercise.data.persistence.model.ImageDetailsEntity;
import com.example.moodysexercise.data.persistence.model.TextAttributesEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class DigitalCardDao_Impl implements DigitalCardDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<DigitalCardEntity> __insertionAdapterOfDigitalCardEntity;

  public DigitalCardDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfDigitalCardEntity = new EntityInsertionAdapter<DigitalCardEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `digital_cards` (`id`,`type`,`text_textValue`,`text_textColor`,`text_font_size`,`text_font_family`,`text_font_style`,`title_textValue`,`title_textColor`,`title_font_size`,`title_font_family`,`title_font_style`,`description_textValue`,`description_textColor`,`description_font_size`,`description_font_family`,`description_font_style`,`image_url`,`image_altText`,`image_width`,`image_height`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final DigitalCardEntity entity) {
        statement.bindString(1, entity.getId());
        statement.bindString(2, entity.getType());
        final TextAttributesEntity _tmpTextAttributes = entity.getTextAttributes();
        if (_tmpTextAttributes != null) {
          statement.bindString(3, _tmpTextAttributes.getTextValue());
          if (_tmpTextAttributes.getTextColor() == null) {
            statement.bindNull(4);
          } else {
            statement.bindString(4, _tmpTextAttributes.getTextColor());
          }
          final FontPropertiesEntity _tmpFontProperties = _tmpTextAttributes.getFontProperties();
          if (_tmpFontProperties != null) {
            if (_tmpFontProperties.getSize() == null) {
              statement.bindNull(5);
            } else {
              statement.bindLong(5, _tmpFontProperties.getSize());
            }
            if (_tmpFontProperties.getFamily() == null) {
              statement.bindNull(6);
            } else {
              statement.bindString(6, _tmpFontProperties.getFamily());
            }
            if (_tmpFontProperties.getStyle() == null) {
              statement.bindNull(7);
            } else {
              statement.bindString(7, _tmpFontProperties.getStyle());
            }
          } else {
            statement.bindNull(5);
            statement.bindNull(6);
            statement.bindNull(7);
          }
        } else {
          statement.bindNull(3);
          statement.bindNull(4);
          statement.bindNull(5);
          statement.bindNull(6);
          statement.bindNull(7);
        }
        final TextAttributesEntity _tmpTitle = entity.getTitle();
        if (_tmpTitle != null) {
          statement.bindString(8, _tmpTitle.getTextValue());
          if (_tmpTitle.getTextColor() == null) {
            statement.bindNull(9);
          } else {
            statement.bindString(9, _tmpTitle.getTextColor());
          }
          final FontPropertiesEntity _tmpFontProperties_1 = _tmpTitle.getFontProperties();
          if (_tmpFontProperties_1 != null) {
            if (_tmpFontProperties_1.getSize() == null) {
              statement.bindNull(10);
            } else {
              statement.bindLong(10, _tmpFontProperties_1.getSize());
            }
            if (_tmpFontProperties_1.getFamily() == null) {
              statement.bindNull(11);
            } else {
              statement.bindString(11, _tmpFontProperties_1.getFamily());
            }
            if (_tmpFontProperties_1.getStyle() == null) {
              statement.bindNull(12);
            } else {
              statement.bindString(12, _tmpFontProperties_1.getStyle());
            }
          } else {
            statement.bindNull(10);
            statement.bindNull(11);
            statement.bindNull(12);
          }
        } else {
          statement.bindNull(8);
          statement.bindNull(9);
          statement.bindNull(10);
          statement.bindNull(11);
          statement.bindNull(12);
        }
        final TextAttributesEntity _tmpDescription = entity.getDescription();
        if (_tmpDescription != null) {
          statement.bindString(13, _tmpDescription.getTextValue());
          if (_tmpDescription.getTextColor() == null) {
            statement.bindNull(14);
          } else {
            statement.bindString(14, _tmpDescription.getTextColor());
          }
          final FontPropertiesEntity _tmpFontProperties_2 = _tmpDescription.getFontProperties();
          if (_tmpFontProperties_2 != null) {
            if (_tmpFontProperties_2.getSize() == null) {
              statement.bindNull(15);
            } else {
              statement.bindLong(15, _tmpFontProperties_2.getSize());
            }
            if (_tmpFontProperties_2.getFamily() == null) {
              statement.bindNull(16);
            } else {
              statement.bindString(16, _tmpFontProperties_2.getFamily());
            }
            if (_tmpFontProperties_2.getStyle() == null) {
              statement.bindNull(17);
            } else {
              statement.bindString(17, _tmpFontProperties_2.getStyle());
            }
          } else {
            statement.bindNull(15);
            statement.bindNull(16);
            statement.bindNull(17);
          }
        } else {
          statement.bindNull(13);
          statement.bindNull(14);
          statement.bindNull(15);
          statement.bindNull(16);
          statement.bindNull(17);
        }
        final ImageDetailsEntity _tmpImageDetails = entity.getImageDetails();
        if (_tmpImageDetails != null) {
          if (_tmpImageDetails.getUrl() == null) {
            statement.bindNull(18);
          } else {
            statement.bindString(18, _tmpImageDetails.getUrl());
          }
          statement.bindString(19, _tmpImageDetails.getAltText());
          if (_tmpImageDetails.getWidth() == null) {
            statement.bindNull(20);
          } else {
            statement.bindLong(20, _tmpImageDetails.getWidth());
          }
          if (_tmpImageDetails.getHeight() == null) {
            statement.bindNull(21);
          } else {
            statement.bindLong(21, _tmpImageDetails.getHeight());
          }
        } else {
          statement.bindNull(18);
          statement.bindNull(19);
          statement.bindNull(20);
          statement.bindNull(21);
        }
      }
    };
  }

  @Override
  public Object insertCard(final DigitalCardEntity card,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfDigitalCardEntity.insert(card);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<DigitalCardEntity>> getAllCards() {
    final String _sql = "SELECT * FROM digital_cards";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"digital_cards"}, new Callable<List<DigitalCardEntity>>() {
      @Override
      @NonNull
      public List<DigitalCardEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfTextValue = CursorUtil.getColumnIndexOrThrow(_cursor, "text_textValue");
          final int _cursorIndexOfTextColor = CursorUtil.getColumnIndexOrThrow(_cursor, "text_textColor");
          final int _cursorIndexOfSize = CursorUtil.getColumnIndexOrThrow(_cursor, "text_font_size");
          final int _cursorIndexOfFamily = CursorUtil.getColumnIndexOrThrow(_cursor, "text_font_family");
          final int _cursorIndexOfStyle = CursorUtil.getColumnIndexOrThrow(_cursor, "text_font_style");
          final int _cursorIndexOfTextValue_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "title_textValue");
          final int _cursorIndexOfTextColor_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "title_textColor");
          final int _cursorIndexOfSize_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "title_font_size");
          final int _cursorIndexOfFamily_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "title_font_family");
          final int _cursorIndexOfStyle_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "title_font_style");
          final int _cursorIndexOfTextValue_2 = CursorUtil.getColumnIndexOrThrow(_cursor, "description_textValue");
          final int _cursorIndexOfTextColor_2 = CursorUtil.getColumnIndexOrThrow(_cursor, "description_textColor");
          final int _cursorIndexOfSize_2 = CursorUtil.getColumnIndexOrThrow(_cursor, "description_font_size");
          final int _cursorIndexOfFamily_2 = CursorUtil.getColumnIndexOrThrow(_cursor, "description_font_family");
          final int _cursorIndexOfStyle_2 = CursorUtil.getColumnIndexOrThrow(_cursor, "description_font_style");
          final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "image_url");
          final int _cursorIndexOfAltText = CursorUtil.getColumnIndexOrThrow(_cursor, "image_altText");
          final int _cursorIndexOfWidth = CursorUtil.getColumnIndexOrThrow(_cursor, "image_width");
          final int _cursorIndexOfHeight = CursorUtil.getColumnIndexOrThrow(_cursor, "image_height");
          final List<DigitalCardEntity> _result = new ArrayList<DigitalCardEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final DigitalCardEntity _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpType;
            _tmpType = _cursor.getString(_cursorIndexOfType);
            final TextAttributesEntity _tmpTextAttributes;
            if (!(_cursor.isNull(_cursorIndexOfTextValue) && _cursor.isNull(_cursorIndexOfTextColor) && _cursor.isNull(_cursorIndexOfSize) && _cursor.isNull(_cursorIndexOfFamily) && _cursor.isNull(_cursorIndexOfStyle))) {
              final String _tmpTextValue;
              _tmpTextValue = _cursor.getString(_cursorIndexOfTextValue);
              final String _tmpTextColor;
              if (_cursor.isNull(_cursorIndexOfTextColor)) {
                _tmpTextColor = null;
              } else {
                _tmpTextColor = _cursor.getString(_cursorIndexOfTextColor);
              }
              final FontPropertiesEntity _tmpFontProperties;
              if (!(_cursor.isNull(_cursorIndexOfSize) && _cursor.isNull(_cursorIndexOfFamily) && _cursor.isNull(_cursorIndexOfStyle))) {
                final Integer _tmpSize;
                if (_cursor.isNull(_cursorIndexOfSize)) {
                  _tmpSize = null;
                } else {
                  _tmpSize = _cursor.getInt(_cursorIndexOfSize);
                }
                final String _tmpFamily;
                if (_cursor.isNull(_cursorIndexOfFamily)) {
                  _tmpFamily = null;
                } else {
                  _tmpFamily = _cursor.getString(_cursorIndexOfFamily);
                }
                final String _tmpStyle;
                if (_cursor.isNull(_cursorIndexOfStyle)) {
                  _tmpStyle = null;
                } else {
                  _tmpStyle = _cursor.getString(_cursorIndexOfStyle);
                }
                _tmpFontProperties = new FontPropertiesEntity(_tmpSize,_tmpFamily,_tmpStyle);
              } else {
                _tmpFontProperties = null;
              }
              _tmpTextAttributes = new TextAttributesEntity(_tmpTextValue,_tmpTextColor,_tmpFontProperties);
            } else {
              _tmpTextAttributes = null;
            }
            final TextAttributesEntity _tmpTitle;
            if (!(_cursor.isNull(_cursorIndexOfTextValue_1) && _cursor.isNull(_cursorIndexOfTextColor_1) && _cursor.isNull(_cursorIndexOfSize_1) && _cursor.isNull(_cursorIndexOfFamily_1) && _cursor.isNull(_cursorIndexOfStyle_1))) {
              final String _tmpTextValue_1;
              _tmpTextValue_1 = _cursor.getString(_cursorIndexOfTextValue_1);
              final String _tmpTextColor_1;
              if (_cursor.isNull(_cursorIndexOfTextColor_1)) {
                _tmpTextColor_1 = null;
              } else {
                _tmpTextColor_1 = _cursor.getString(_cursorIndexOfTextColor_1);
              }
              final FontPropertiesEntity _tmpFontProperties_1;
              if (!(_cursor.isNull(_cursorIndexOfSize_1) && _cursor.isNull(_cursorIndexOfFamily_1) && _cursor.isNull(_cursorIndexOfStyle_1))) {
                final Integer _tmpSize_1;
                if (_cursor.isNull(_cursorIndexOfSize_1)) {
                  _tmpSize_1 = null;
                } else {
                  _tmpSize_1 = _cursor.getInt(_cursorIndexOfSize_1);
                }
                final String _tmpFamily_1;
                if (_cursor.isNull(_cursorIndexOfFamily_1)) {
                  _tmpFamily_1 = null;
                } else {
                  _tmpFamily_1 = _cursor.getString(_cursorIndexOfFamily_1);
                }
                final String _tmpStyle_1;
                if (_cursor.isNull(_cursorIndexOfStyle_1)) {
                  _tmpStyle_1 = null;
                } else {
                  _tmpStyle_1 = _cursor.getString(_cursorIndexOfStyle_1);
                }
                _tmpFontProperties_1 = new FontPropertiesEntity(_tmpSize_1,_tmpFamily_1,_tmpStyle_1);
              } else {
                _tmpFontProperties_1 = null;
              }
              _tmpTitle = new TextAttributesEntity(_tmpTextValue_1,_tmpTextColor_1,_tmpFontProperties_1);
            } else {
              _tmpTitle = null;
            }
            final TextAttributesEntity _tmpDescription;
            if (!(_cursor.isNull(_cursorIndexOfTextValue_2) && _cursor.isNull(_cursorIndexOfTextColor_2) && _cursor.isNull(_cursorIndexOfSize_2) && _cursor.isNull(_cursorIndexOfFamily_2) && _cursor.isNull(_cursorIndexOfStyle_2))) {
              final String _tmpTextValue_2;
              _tmpTextValue_2 = _cursor.getString(_cursorIndexOfTextValue_2);
              final String _tmpTextColor_2;
              if (_cursor.isNull(_cursorIndexOfTextColor_2)) {
                _tmpTextColor_2 = null;
              } else {
                _tmpTextColor_2 = _cursor.getString(_cursorIndexOfTextColor_2);
              }
              final FontPropertiesEntity _tmpFontProperties_2;
              if (!(_cursor.isNull(_cursorIndexOfSize_2) && _cursor.isNull(_cursorIndexOfFamily_2) && _cursor.isNull(_cursorIndexOfStyle_2))) {
                final Integer _tmpSize_2;
                if (_cursor.isNull(_cursorIndexOfSize_2)) {
                  _tmpSize_2 = null;
                } else {
                  _tmpSize_2 = _cursor.getInt(_cursorIndexOfSize_2);
                }
                final String _tmpFamily_2;
                if (_cursor.isNull(_cursorIndexOfFamily_2)) {
                  _tmpFamily_2 = null;
                } else {
                  _tmpFamily_2 = _cursor.getString(_cursorIndexOfFamily_2);
                }
                final String _tmpStyle_2;
                if (_cursor.isNull(_cursorIndexOfStyle_2)) {
                  _tmpStyle_2 = null;
                } else {
                  _tmpStyle_2 = _cursor.getString(_cursorIndexOfStyle_2);
                }
                _tmpFontProperties_2 = new FontPropertiesEntity(_tmpSize_2,_tmpFamily_2,_tmpStyle_2);
              } else {
                _tmpFontProperties_2 = null;
              }
              _tmpDescription = new TextAttributesEntity(_tmpTextValue_2,_tmpTextColor_2,_tmpFontProperties_2);
            } else {
              _tmpDescription = null;
            }
            final ImageDetailsEntity _tmpImageDetails;
            if (!(_cursor.isNull(_cursorIndexOfUrl) && _cursor.isNull(_cursorIndexOfAltText) && _cursor.isNull(_cursorIndexOfWidth) && _cursor.isNull(_cursorIndexOfHeight))) {
              final String _tmpUrl;
              if (_cursor.isNull(_cursorIndexOfUrl)) {
                _tmpUrl = null;
              } else {
                _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
              }
              final String _tmpAltText;
              _tmpAltText = _cursor.getString(_cursorIndexOfAltText);
              final Integer _tmpWidth;
              if (_cursor.isNull(_cursorIndexOfWidth)) {
                _tmpWidth = null;
              } else {
                _tmpWidth = _cursor.getInt(_cursorIndexOfWidth);
              }
              final Integer _tmpHeight;
              if (_cursor.isNull(_cursorIndexOfHeight)) {
                _tmpHeight = null;
              } else {
                _tmpHeight = _cursor.getInt(_cursorIndexOfHeight);
              }
              _tmpImageDetails = new ImageDetailsEntity(_tmpUrl,_tmpAltText,_tmpWidth,_tmpHeight);
            } else {
              _tmpImageDetails = null;
            }
            _item = new DigitalCardEntity(_tmpId,_tmpType,_tmpTextAttributes,_tmpTitle,_tmpDescription,_tmpImageDetails);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
