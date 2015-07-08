package com.bigdinosaur.bigdata.io;




import java.math.BigDecimal;



/**
 * Base class for writing the data for a database row in different formats.
 * Defines the methods that are independent of storage format and declares
 * the format-dependent methods that subclasses should define.
 *
 * 
 */
abstract class RowOutputBase extends HsqlByteArrayOutputStream
implements RowOutputInterface {

    public static final int CACHED_ROW_160 = 0;
    public static final int CACHED_ROW_170 = 1;

    // the last column in a table is an ID that should not be written to file
    protected boolean skipSystemId = false;

    /**
     *  Constructor used for persistent storage of a Table row
     *
     * @exception  IOException when an IO error is encountered
     */
    public RowOutputBase() {
        super();
    }

    /**
     *  Constructor used for result sets
     *
     * @exception  IOException when an IO error is encountered
     */
    public RowOutputBase(int initialSize) {
        super(initialSize);
    }

    /**
     *  Constructor used for network transmission of result sets
     *
     * @exception  IOException when an IO error is encountered
     */
    public RowOutputBase(byte[] buffer) {
        super(buffer);
    }

// fredt@users - comment - methods for writing Result column type, name and data size
    public abstract void writeEnd();

    public abstract void writeSize(int size);

    public abstract void writeType(int type);

    public abstract void writeIntData(int i, int position);

    public abstract void writeString(String s);

// fredt@users - comment - methods used for writing each SQL type
    protected void writeFieldPrefix() {}

    protected abstract void writeFieldType(Type type);

    protected abstract void writeNull(Type type);

    protected abstract void writeChar(String s, Type t);

    protected abstract void writeSmallint(Number o);

    protected abstract void writeInteger(Number o);

    protected abstract void writeBigint(Number o);

    protected abstract void writeReal(Double o);

    protected abstract void writeDecimal(BigDecimal o, Type type);

    protected abstract void writeBoolean(Boolean o);

    protected abstract void writeDate(TimestampData o, Type type);

    protected abstract void writeTime(TimeData o, Type type);

    protected abstract void writeTimestamp(TimestampData o, Type type);

    protected abstract void writeYearMonthInterval(IntervalMonthData o,
            Type type);

    protected abstract void writeDaySecondInterval(IntervalSecondData o,
            Type type);

    protected abstract void writeOther(JavaObjectData o);

    protected abstract void writeBit(BinaryData o);

    protected abstract void writeBinary(BinaryData o);

    protected abstract void writeClob(ClobData o, Type type);

    protected abstract void writeBlob(BlobData o, Type type);

    protected abstract void writeArray(Object[] o, Type type);

    /**
     *  This method is called to write data for a table row.
     */
    public void writeData(Row row, Type[] types) {
        writeData(types.length, types, row.getData(), null, null);
    }

    /**
     *  This method is called directly to write data for a delete statement.
     */
    public void writeData(int l, Type[] types, Object[] data,
                          HashMappedList cols, int[] primaryKeys) {

        boolean hasPK = primaryKeys != null && primaryKeys.length != 0;
        int     limit = hasPK ? primaryKeys.length
                              : l;

        for (int i = 0; i < limit; i++) {
            int    j = hasPK ? primaryKeys[i]
                             : i;
            Object o = data[j];
            Type   t = types[j];

            if (cols != null) {
                ColumnSchema col = (ColumnSchema) cols.get(j);

                writeFieldPrefix();
                writeString(col.getName().statementName);
            }

            writeData(t, o);
        }
    }

    public void writeData(Type t, Object o) {

        if (o == null) {
            writeNull(t);

            return;
        }

        writeFieldType(t);

        switch (t.typeCode) {

            case Types.SQL_ALL_TYPES :
                break;

            case Types.SQL_CHAR :
            case Types.SQL_VARCHAR :
                writeChar((String) o, t);
                break;

            case Types.TINYINT :
            case Types.SQL_SMALLINT :
                writeSmallint((Number) o);
                break;

            case Types.SQL_INTEGER :
                writeInteger((Number) o);
                break;

            case Types.SQL_BIGINT :
                writeBigint((Number) o);
                break;

            case Types.SQL_REAL :
            case Types.SQL_FLOAT :
            case Types.SQL_DOUBLE :
                writeReal((Double) o);
                break;

            case Types.SQL_NUMERIC :
            case Types.SQL_DECIMAL :
                writeDecimal((BigDecimal) o, t);
                break;

            case Types.SQL_BOOLEAN :
                writeBoolean((Boolean) o);
                break;

            case Types.SQL_DATE :
                writeDate((TimestampData) o, t);
                break;

            case Types.SQL_TIME :
            case Types.SQL_TIME_WITH_TIME_ZONE :
                writeTime((TimeData) o, t);
                break;

            case Types.SQL_TIMESTAMP :
            case Types.SQL_TIMESTAMP_WITH_TIME_ZONE :
                writeTimestamp((TimestampData) o, t);
                break;

            case Types.SQL_INTERVAL_YEAR :
            case Types.SQL_INTERVAL_YEAR_TO_MONTH :
            case Types.SQL_INTERVAL_MONTH :
                writeYearMonthInterval((IntervalMonthData) o, t);
                break;

            case Types.SQL_INTERVAL_DAY :
            case Types.SQL_INTERVAL_DAY_TO_HOUR :
            case Types.SQL_INTERVAL_DAY_TO_MINUTE :
            case Types.SQL_INTERVAL_DAY_TO_SECOND :
            case Types.SQL_INTERVAL_HOUR :
            case Types.SQL_INTERVAL_HOUR_TO_MINUTE :
            case Types.SQL_INTERVAL_HOUR_TO_SECOND :
            case Types.SQL_INTERVAL_MINUTE :
            case Types.SQL_INTERVAL_MINUTE_TO_SECOND :
            case Types.SQL_INTERVAL_SECOND :
                writeDaySecondInterval((IntervalSecondData) o, t);
                break;

            case Types.OTHER :
                writeOther((JavaObjectData) o);
                break;

            case Types.SQL_BLOB :
                writeBlob((BlobData) o, t);
                break;

            case Types.SQL_CLOB :
                writeClob((ClobData) o, t);
                break;

            case Types.SQL_ARRAY :
                writeArray((Object[]) o, t);
                break;


            case Types.SQL_BINARY :
            case Types.SQL_VARBINARY :
                writeBinary((BinaryData) o);
                break;

            case Types.SQL_BIT :
            case Types.SQL_BIT_VARYING :
                writeBit((BinaryData) o);
                break;

            default :
                throw Error.runtimeError(ErrorCode.U_S0500,
                                         "RowOutputBase - "
                                         + t.getNameString());
        }
    }

    // returns the underlying HsqlByteArrayOutputStream
    public HsqlByteArrayOutputStream getOutputStream() {
        return this;
    }

    public abstract RowOutputInterface duplicate();
}
