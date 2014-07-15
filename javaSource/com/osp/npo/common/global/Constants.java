package com.osp.npo.common.global;


/**
 * <P>Constants</P>
 *
 * @author  Nguyen Thanh Hai
 * @version $Revision: 20437 $
 */
public class Constants {

    /** Filter Kind */
    public enum FilterKind {
        /** Full */
        FULL
        /** Left */
        , LEFT
        /** Middle */
        , MIDDLE

        ;


        public Integer getValue() {
            switch (this) {
            case FULL:
                return 0;
            case LEFT:
                return 1;
            case MIDDLE:
                return 2;
            default:
                return null;
            }
        }


        public static FilterKind changeValue(Integer value) {
            if (value == null) {
                return null;
            }
            switch (value) {
            case 0:
                return FULL;
            case 1:
                return LEFT;
            case 2:
                return MIDDLE;
            default:
                return null;
            }
        }
    };


    /** Authority Code */
    public static final String AUTHORITY_CONTRACT		= "01";
    public static final String AUTHORITY_PREVENT_DATA	= "02";
    public static final String AUTHORITY_BANK_REPORT	= "03";
    public static final String AUTHORITY_ADMIN 			= "04";
    public static final String AUTHORITY_ANNOUNCEMENT   = "05";

    /** Common Integer */
    public static final int LENGTH_STRING_LIMIT = 25;
    public static final int LENGTH_OUTPUT_LIMIT = 200;

    /** Common String */
    public static final String DOT3 = "...";
    public static final String ENTER = "\n";
    public static final String SPACE = " ";
    public static final String COLON = ":";
    public static final String MASK = "\"";
    public static final String PLUS = "\\+";
    public static final String MINUS = "\\-";
    public static final String SEMI_COLON = ";";
    public static final String UNIT_SEPARATOR = "_";
    public static final String SHARP = "#";
    public static final String BULLET = "-";


    /** Screen ID */
    public static final String SCREEN_COM001 = "COM001";
    public static final String SCREEN_COM003 = "COM003";
    public static final String SCREEN_COM004 = "COM004";

    public static final String SCREEN_PRV001 = "PRV001";
    public static final String SCREEN_PRV002 = "PRV002";
    public static final String SCREEN_PRV003 = "PRV003";
    public static final String SCREEN_PRV004 = "PRV004";
    public static final String SCREEN_PRV005 = "PRV005";

    public static final String SCREEN_CNTR001 = "CNTR001";
    public static final String SCREEN_CNTR003 = "CNTR003";
    public static final String SCREEN_CNTR004 = "CNTR004";
    public static final String SCREEN_CNTR005 = "CNTR005";
    public static final String SCREEN_CNTR007 = "CNTR007";
    public static final String SCREEN_CNTR009 = "CNTR009";
    public static final String SCREEN_CNTR011 = "CNTR011";
    public static final String SCREEN_CNTR013 = "CNTR013";
    public static final String SCREEN_CNTR014 = "CNTR014";
    public static final String SCREEN_CNTR015 = "CNTR015";
    public static final String SCREEN_CNTR016 = "CNTR016";
    public static final String SCREEN_CNTR018 = "CNTR018";
    public static final String SCREEN_CNTR019 = "CNTR019";
    public static final String SCREEN_CNTR021 = "CNTR021";
    public static final String SCREEN_CNTR023 = "CNTR023";
    public static final String SCREEN_CNTR024 = "CNTR024";
    public static final String SCREEN_CNTR026 = "CNTR026";
    public static final String SCREEN_CNTR027 = "CNTR027";
    public static final String SCREEN_CNTR028 = "CNTR028";

    public static final String SCREEN_ADM001 = "ADM001";
    public static final String SCREEN_ADM002 = "ADM002";
    public static final String SCREEN_ADM003 = "ADM003";
    public static final String SCREEN_ADM004 = "ADM004";
    public static final String SCREEN_ADM005 = "ADM005";
    public static final String SCREEN_ADM006 = "ADM006";
    public static final String SCREEN_ADM007 = "ADM007";
    public static final String SCREEN_ADM008 = "ADM008";
    public static final String SCREEN_ADM009 = "ADM009";
    public static final String SCREEN_ADM010 = "ADM010";
    public static final String SCREEN_ADM011 = "ADM011";
    public static final String SCREEN_ADM012 = "ADM012";

    public static final String SCREEN_ANNT001 = "ANNT001";
    public static final String SCREEN_ANNT002 = "ANNT002";
    public static final String SCREEN_ANNT003 = "ANNT003";
    public static final String SCREEN_ANNT004 = "ANNT004";

    /** Execute data key */
    public static final String PREVENT_ENTRY_KEY = "PREVENT_ENTRY";
    public static final String PREVENT_UPDATE_KEY = "PREVENT_UPDATE";
    public static final String PREVENT_DELETE_KEY = "PREVENT_DELETE";
    public static final String PREVENT_RELEASE_KEY = "PREVENT_RELEASE";
}
