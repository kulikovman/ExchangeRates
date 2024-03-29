package ru.kulikovman.exchangerates.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;
import ru.kulikovman.exchangerates.models.ValCurs;

public interface CbrApi {

    // Пример запроса:
    // http://www.cbr.ru/scripts/XML_daily.asp?date_req=24/05/2016

    @GET
    Call<ValCurs> getRateOnDate(@Url String path);
}
