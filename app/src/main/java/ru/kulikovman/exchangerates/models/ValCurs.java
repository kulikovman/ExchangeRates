package ru.kulikovman.exchangerates.models;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

@Root(strict = false)
public class ValCurs {
    @Text(required = false)
    private String Date;
    @Text(required = false)
    private String name;

    private Valute[] Valute;

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Valute[] getValute() {
        return Valute;
    }

    public void setValute(Valute[] Valute) {
        this.Valute = Valute;
    }
}
