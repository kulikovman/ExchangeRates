package ru.kulikovman.exchangerates.models;

import org.simpleframework.xml.Root;

@Root(strict = false)
public class CbrBodyResponse {
    private ValCurs ValCurs;

    public ValCurs getValCurs() {
        return ValCurs;
    }

    public void setValCurs(ValCurs ValCurs) {
        this.ValCurs = ValCurs;
    }
}
