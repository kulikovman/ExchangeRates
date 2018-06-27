package ru.kulikovman.exchangerates.models;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Valute")
public class Valute {

    @Element(name = "Name")
    private String mName;

    @Element(name = "Value")
    private String mValue;

    @Attribute(name = "ID")
    private String mId;

    @Element(name = "Nominal")
    private String mNominal;

    @Element(name = "CharCode")
    private String mCharCode;

    @Element(name = "NumCode")
    private String NumCode;


    public String getName() {
        return mName;
    }

    public void setName(String Name) {
        mName = Name;
    }

    public String getValue() {
        return mValue;
    }

    public void setValue(String Value) {
        mValue = Value;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getNominal() {
        return mNominal;
    }

    public void setNominal(String Nominal) {
        mNominal = Nominal;
    }

    public String getCharCode() {
        return mCharCode;
    }

    public void setCharCode(String CharCode) {
        mCharCode = CharCode;
    }

    public String getNumCode() {
        return NumCode;
    }

    public void setNumCode(String NumCode) {
        NumCode = NumCode;
    }
}
