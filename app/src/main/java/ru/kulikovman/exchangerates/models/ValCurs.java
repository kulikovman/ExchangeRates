package ru.kulikovman.exchangerates.models;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "ValCurs")
public class ValCurs {

    @Attribute(name = "Date")
    private String Date;

    @Attribute(name = "name")
    private String name;

    @ElementList(inline=true)
    private List<Valute> mList;


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

    public List<Valute> getList() {
        return mList;
    }

    public void setList(List<Valute> list) {
        mList = list;
    }
}
