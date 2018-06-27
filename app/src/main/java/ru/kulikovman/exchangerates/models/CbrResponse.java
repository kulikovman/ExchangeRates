package ru.kulikovman.exchangerates.models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "CbrResponse")
public class CbrResponse {
    @Element(name = "ValCurs")
    private ValCurs ValCurs;

    public ValCurs getValCurs() {
        return ValCurs;
    }

    public void setValCurs(ValCurs ValCurs) {
        this.ValCurs = ValCurs;
    }
}
