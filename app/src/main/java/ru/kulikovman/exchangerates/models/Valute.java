package ru.kulikovman.exchangerates.models;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Valute")
public class Valute {

    @Element(name = "Name")
    private String Name;

    @Element(name = "Value")
    private String Value;

    @Attribute(name = "ID")
    private String ID;

    @Element(name = "Nominal")
    private String Nominal;

    @Element(name = "CharCode")
    private String CharCode;

    @Element(name = "NumCode")
    private String NumCode;


    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String Value) {
        this.Value = Value;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNominal() {
        return Nominal;
    }

    public void setNominal(String Nominal) {
        this.Nominal = Nominal;
    }

    public String getCharCode() {
        return CharCode;
    }

    public void setCharCode(String CharCode) {
        this.CharCode = CharCode;
    }

    public String getNumCode() {
        return NumCode;
    }

    public void setNumCode(String NumCode) {
        this.NumCode = NumCode;
    }
}
