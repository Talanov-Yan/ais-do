package pages;

public interface XPLib {
    String
            // типичные выражения xpath
            r = "descendant::",
            f = "/following::",
            p = "/preceding-sibling::",
            a = "/ancestor::",
    // шаблоны для подстановки. использование шаблона в xpath добавляет префикс в названии, например sHeader, nLabel. Префиксы переходят в конкатенирующие имена
    NAME = "name",
            INDEX = "index",
            TITLE = "title",

    $VISIBLE = "[not(contains(@style,'none'))]",
            WRONG_SYMBOLS = " ",
            SYMBOLS_OLD = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯё«»:*?,. " + WRONG_SYMBOLS, // заменяются буквы, удаляются символы
            SYMBOLS_NEW = "абвгдеежзийклмнопрстуфхцчшщъыьэюяе",
            $NAME = "[translate(normalize-space(.),'" + SYMBOLS_OLD + "','" + SYMBOLS_NEW + "')" +
                    " =translate('{{ " + NAME + " }}','" + SYMBOLS_OLD + "','" + SYMBOLS_NEW + "')]",
            $NAME_HOLDER = "[translate(@data-placeholder,'" + SYMBOLS_OLD + "','" + SYMBOLS_NEW + "')" +
                    " =translate('{{ " + NAME + " }}','" + SYMBOLS_OLD + "','" + SYMBOLS_NEW + "')]",
            $TITLE = "[translate(normalize-space(translate(.,' ',' ')),' ', '')=translate('{{ " +
                    "" + TITLE + " }}',' ','') or @title='{{ " + TITLE + " }}']",
            $NAME_CONTAINS = "[contains(translate(normalize-space(.),'" + SYMBOLS_OLD + "','" + SYMBOLS_NEW + "')" +
                    ", translate('{{ " + NAME + " }}','" + SYMBOLS_OLD + "','" + SYMBOLS_NEW + "'))]",
            $NAME_CONTAINS2 = "contains(translate(normalize-space(.),'" + SYMBOLS_OLD + "','" + SYMBOLS_NEW + "')" +
                    ", translate('{{ " + NAME + " }}','" + SYMBOLS_OLD + "','" + SYMBOLS_NEW + "'))",

    nLABEL = "label" + $NAME,
            nLABEL_tBUTTON = r + nLABEL + "/" + f + "a" + $TITLE + $VISIBLE,

    $INDEX = "[{{ " + INDEX + " }}]",
            nLABEL_iINPUT = r + nLABEL + f + $INDEX + $VISIBLE;
}
