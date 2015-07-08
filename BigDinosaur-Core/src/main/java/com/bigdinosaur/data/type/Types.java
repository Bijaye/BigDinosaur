package com.bigdinosaur.data.type;

public interface Types
{
  public static final int SQL_CHAR              = 1;
  public static final int SQL_NUMERIC           = 2;
  public static final int SQL_DECIMAL           = 3;
  public static final int SQL_INTEGER           = 4;
  public static final int SQL_SMALLINT          = 5;
  public static final int SQL_FLOAT             = 6;
  public static final int SQL_REAL              = 7;
  public static final int SQL_DOUBLE            = 8;
  public static final int SQL_VARCHAR           = 12;
  public static final int SQL_BOOLEAN           = 16;
  public static final int SQL_USER_DEFINED_TYPE = 17;
  public static final int SQL_ROW               = 19;
  public static final int SQL_REF               = 20;
  public static final int SQL_BIGINT            = 25;             // different in JDBC
  public static final int SQL_BLOB              = 30;             // different in JDBC
  public static final int SQL_CLOB              = 40;             // different in JDBC
  public static final int SQL_ARRAY             = 50;             // different in JDBC - not predefined
  public static final int SQL_MULTISET = 55;                      //
  public static final int SQL_BINARY   = 60;                      // different in JDBC -in SQL post-2003
  public static final int SQL_VARBINARY = 61;                     // different in JDBC - in SQL post-2003
  public static final int SQL_DATE                      = 91;
  public static final int SQL_TIME                      = 92;
  public static final int SQL_TIMESTAMP                 = 93;     //
  public static final int SQL_TIME_WITH_TIME_ZONE       = 94;
  public static final int SQL_TIMESTAMP_WITH_TIME_ZONE  = 95;     //
  public static final int SQL_INTERVAL_YEAR             = 101;    //
  public static final int SQL_INTERVAL_MONTH            = 102;
  public static final int SQL_INTERVAL_DAY              = 103;
  public static final int SQL_INTERVAL_HOUR             = 104;
  public static final int SQL_INTERVAL_MINUTE           = 105;
  public static final int SQL_INTERVAL_SECOND           = 106;
  public static final int SQL_INTERVAL_YEAR_TO_MONTH    = 107;
  public static final int SQL_INTERVAL_DAY_TO_HOUR      = 108;
  public static final int SQL_INTERVAL_DAY_TO_MINUTE    = 109;
  public static final int SQL_INTERVAL_DAY_TO_SECOND    = 110;
  public static final int SQL_INTERVAL_HOUR_TO_MINUTE   = 111;
  public static final int SQL_INTERVAL_HOUR_TO_SECOND   = 112;
  public static final int SQL_INTERVAL_MINUTE_TO_SECOND = 113;

  // used where local defines are used in the same range as SQL type numbers
  public static final int SQL_TYPE_NUMBER_LIMIT = 256;

  // These values are not in table 37 of the SQL CLI 2003 FCD, but some
  // are found in tables 6-9 and some are found in Annex A1:
  // c Header File SQLCLI.H and/or addendums in other documents,
  // such as:
  // SQL 2003 Part 9: Management of External Data (SQL/MED) : DATALINK
  // SQL 2003 Part 14: XML-Related Specifications (SQL/XML) : XML
  public static final int SQL_BIT         = 14;                   // is in SQL99 but removed from 2003
  public static final int SQL_BIT_VARYING = 15;                   // is in SQL99 but removed from 2003
  public static final int SQL_DATALINK         = 70;
  public static final int SQL_UDT              = 17;
  public static final int SQL_UDT_LOCATOR      = 18;
  public static final int SQL_BLOB_LOCATOR     = 31;
  public static final int SQL_CLOB_LOCATOR     = 41;
  public static final int SQL_ARRAY_LOCATOR    = 51;
  public static final int SQL_MULTISET_LOCATOR = 56;
  public static final int SQL_ALL_TYPES        = 0;
  public static final int SQL_DATETIME         = 9;               // collective name
  public static final int SQL_INTERVAL         = 10;              // collective name
  public static final int SQL_XML              = 137;

  // These values are taken from various SQL CLI header files
  public static final int SQL_NCHAR         = (-8);
  public static final int SQL_WCHAR         = (-8);
  public static final int SQL_WVARCHAR      = (-9);
  public static final int SQL_NVARCHAR      = (-9);
  public static final int SQL_WLONGVARCHAR  = (-10);
  public static final int SQL_NTEXT         = (-10);
  public static final int SQL_LONGVARBINARY = (-4);
  public static final int SQL_IMAGE         = (-4);
  public static final int SQL_GUID          = (-11);
  public static final int SQL_VARIANT       = (-150);

  // SQL_UDT subcodes
  public static final int SQL_SUB_DISTINCT   = 1;
  public static final int SQL_SUB_STRUCTURED = 2;

  // non-standard type not in JDBC or SQL CLI
  public static final int VARCHAR_IGNORECASE = 100;

  /**
   * The constant in the Java programming language, sometimes referred to
   * as a type code, that identifies the generic SQL type
   * <code>ARRAY</code>.
   *
   * @since JDK 1.2
   */
  public static final int ARRAY = 2003;

  /**
   * <P>The constant in the Java programming language, sometimes referred
   * to as a type code, that identifies the generic SQL type
   * <code>BIGINT</code>.
   */
  public static final int BIGINT = -5;

  /**
   * <P>The constant in the Java programming language, sometimes referred
   * to as a type code, that identifies the generic SQL type
   * <code>BINARY</code>.
   */
  public static final int BINARY = -2;

  /**
   * <P>The constant in the Java programming language, sometimes referred
   * to as a type code, that identifies the generic SQL type
   * <code>BIT</code>.
   */
  public static final int BIT = -7;

  /**
   * The constant in the Java programming language, sometimes referred to
   * as a type code, that identifies the generic SQL type
   * <code>BLOB</code>.
   *
   * @since JDK 1.2
   */
  public static final int BLOB = 2004;

  /**
   * The constant in the Java programming language, somtimes referred to
   * as a type code, that identifies the generic SQL type
   * <code>BOOLEAN</code>.
   *
   * @since JDK 1.4
   */
  public static final int BOOLEAN = SQL_BOOLEAN;

  /**
   * <P>The constant in the Java programming language, sometimes referred
   * to as a type code, that identifies the generic SQL type
   * <code>CHAR</code>.
   */
  public static final int CHAR = SQL_CHAR;

  /**
   * The constant in the Java programming language, sometimes referred to
   * as a type code, that identifies the generic SQL type
   * <code>CLOB</code>
   *
   * @since JDK 1.2
   */
  public static final int CLOB = 2005;

  /**
   * The constant in the Java programming language, somtimes referred to
   * as a type code, that identifies the generic SQL type <code>DATALINK</code>.
   *
   * @since JDK 1.4
   */
  public static final int DATALINK = 70;

  /**
   * <P>The constant in the Java programming language, sometimes referred
   * to as a type code, that identifies the generic SQL type
   * <code>DATE</code>.
   */
  public static final int DATE = SQL_DATE;

  /**
   * <P>The constant in the Java programming language, sometimes referred
   * to as a type code, that identifies the generic SQL type
   * <code>DECIMAL</code>.
   */
  public static final int DECIMAL = SQL_DECIMAL;

  /**
   * The constant in the Java programming language, sometimes referred to
   * as a type code, that identifies the generic SQL type
   * <code>DISTINCT</code>.
   *
   * @since JDK 1.2
   */
  public static final int DISTINCT = 2001;

  /**
   * <P>The constant in the Java programming language, sometimes referred
   * to as a type code, that identifies the generic SQL type
   * <code>DOUBLE</code>.
   */
  public static final int DOUBLE = SQL_DOUBLE;

  /**
   * <P>The constant in the Java programming language, sometimes referred
   * to as a type code, that identifies the generic SQL type
   * <code>FLOAT</code>.
   */
  public static final int FLOAT = SQL_FLOAT;

  /**
   * <P>The constant in the Java programming language, sometimes referred
   * to as a type code, that identifies the generic SQL type
   * <code>INTEGER</code>.
   */
  public static final int INTEGER = SQL_INTEGER;

  /**
   * The constant in the Java programming language, sometimes referred to
   * as a type code, that identifies the generic SQL type
   * <code>JAVA_OBJECT</code>.
   *
   * @since JDK 1.2
   */
  public static final int JAVA_OBJECT = 2000;

  /**
   * <P>The constant in the Java programming language, sometimes referred
   * to as a type code, that identifies the generic SQL type
   * <code>LONGVARBINARY</code>.
   */
  public static final int LONGVARBINARY = -4;

  /**
   * <P>The constant in the Java programming language, sometimes referred
   * to as a type code, that identifies the generic SQL type
   * <code>LONGVARCHAR</code>.
   */
  public static final int LONGVARCHAR = -1;

  /**
   * <P>The constant in the Java programming language, sometimes referred
   * to as a type code, that identifies the generic SQL type
   * <code>MULTISET</code>.
   */
  public static final int MULTISET = 0;                           // no java.sql.Types definition

  /**
   * <P>The constant in the Java programming language, sometimes referred
   * to as a type code, that identifies the generic SQL type
   * <code>NULL</code>.
   */
  public static final int NULL = 0;

  /**
   * <P>The constant in the Java programming language, sometimes referred
   * to as a type code, that identifies the generic SQL type
   * <code>NUMERIC</code>.
   */
  public static final int NUMERIC = SQL_NUMERIC;

  /**
   * The constant in the Java programming language that indicates
   * that the SQL type is database-specific and
   * gets mapped to a Java object that can be accessed via
   * the methods <code>getObject</code> and <code>setObject</code>.
   */
  public static final int OTHER = 1111;

  /**
   * <P>The constant in the Java programming language, sometimes referred
   * to as a type code, that identifies the generic SQL type
   * <code>REAL</code>.
   */
  public static final int REAL = SQL_REAL;

  /**
   * The constant in the Java programming language, sometimes referred to
   * as a type code, that identifies the generic SQL type
   * <code>REF</code>.
   *
   * @since JDK 1.2
   */
  public static final int REF = 2006;

  /**
   * <P>The constant in the Java programming language, sometimes referred
   * to as a type code, that identifies the generic SQL type
   * <code>SMALLINT</code>.
   */
  public static final int SMALLINT = SQL_SMALLINT;

  /**
   * The constant in the Java programming language, sometimes referred to
   * as a type code, that identifies the generic SQL type
   * <code>STRUCT</code>.
   *
   * @since JDK 1.2
   */
  public static final int STRUCT = 2002;

  /**
   * <P>The constant in the Java programming language, sometimes referred
   * to as a type code, that identifies the generic SQL type
   * <code>TIME</code>.
   */
  public static final int TIME = SQL_TIME;

  /**
   * <P>The constant in the Java programming language, sometimes referred
   * to as a type code, that identifies the generic SQL type
   * <code>TIMESTAMP</code>.
   */
  public static final int TIMESTAMP = SQL_TIMESTAMP;

  /**
   * <P>The constant in the Java programming language, sometimes referred
   * to as a type code, that identifies the generic SQL type
   * <code>TINYINT</code>.
   */
  public static final int TINYINT = -6;

  /**
   * <P>The constant in the Java programming language, sometimes referred
   * to as a type code, that identifies the generic SQL type
   * <code>VARBINARY</code>.
   */
  public static final int VARBINARY = -3;

  /**
   * <P>The constant in the Java programming language, sometimes referred
   * to as a type code, that identifies the generic SQL type
   * <code>VARCHAR</code>.
   */
  public static final int VARCHAR = SQL_VARCHAR;

//  /**
//   * <P>The constant in the Java programming language, sometimes referred
//   * to as a type code, that identifies the recent SQL 2003 SQL type
//   * <code>XML</code>.
//   *
//   * @since SQL 2003
//   * @deprectated
//   * @see #SQLXML
//   */
//  public static final int XML = 137;
  //------------------------- JDBC 4.0 -----------------------------------

  /**
   * The constant in the Java programming language, sometimes referred to
   * as a type code, that identifies the generic SQL type <code>ROWID</code>
   *
   * @since JDK 1.6, HSQLDB 1.8.x
   *
   */
  public static final int ROWID = 2008;

  /**
   * The constant in the Java programming language, sometimes referred to
   * as a type code, that identifies the generic SQL type <code>NCHAR</code>
   *
   * @since JDK 1.6, HSQLDB 1.8.x
   */
  public static final int NCHAR = -8;

  /**
   * The constant in the Java programming language, sometimes referred to
   * as a type code, that identifies the generic SQL type <code>NVARCHAR</code>.
   *
   * @since JDK 1.6, HSQLDB 1.8.x
   */
  public static final int NVARCHAR = -9;

  /**
   * The constant in the Java programming language, sometimes referred to
   * as a type code, that identifies the generic SQL type <code>LONGNVARCHAR</code>.
   *
   * @since JDK 1.6, HSQLDB 1.8.x
   */
  public static final int LONGNVARCHAR = -10;

  /**
   * The constant in the Java programming language, sometimes referred to
   * as a type code, that identifies the generic SQL type <code>NCLOB</code>.
   *
   * @since JDK 1.6, HSQLDB 1.8.x
   */
  public static final int NCLOB = 2007;

  /**
   * The constant in the Java programming language, sometimes referred to
   * as a type code, that identifies the generic SQL type <code>XML</code>.
   *
   * @since JDK 1.6, HSQLDB 1.8.x
   */
  public static final int SQLXML = 2009;

  //----------------------------- End JDBC 4.0 -------------------------------

  /**
   * The default HSQLODB type sub-identifier. This indicates that an
   * HSQLDB type with this sub-type, if supported, is the very closest
   * thing HSQLDB offerers to the JDBC/SQL2003 type
   */
  public static final int TYPE_SUB_DEFAULT = 1;

}
