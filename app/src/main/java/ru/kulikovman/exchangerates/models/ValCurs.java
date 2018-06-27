package ru.kulikovman.exchangerates.models;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "ValCurs")
public class ValCurs {

    @Attribute(name = "Date")
    private String mDate;

    @Attribute(name = "name")
    private String mName;

    @ElementList(inline=true)
    private List<Valute> mList;


    public String getDate() {
        return mDate;
    }

    public void setDate(String Date) {
        mDate = Date;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public List<Valute> getList() {
        return mList;
    }

    public void setList(List<Valute> list) {
        mList = list;
    }
}
