package ru.kulikovman.exchangerates.models;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

@Root(strict = false)
public class Valute {
    @Text(required = false)
    private String Name;
    @Text(required = false)
    private String Value;
    @Text(required = false)
    private String ID;
    @Text(required = false)
    private String Nominal;
    @Text(required = false)
    private String CharCode;
    @Text(required = false)
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
