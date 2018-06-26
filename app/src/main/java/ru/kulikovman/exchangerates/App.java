package ru.kulikovman.exchangerates;

import android.app.Application;

import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import ru.kulikovman.exchangerates.api.CbrApi;

public class App extends Application {
    private static CbrApi sCbrApi;

    @Override
    public void onCreate() {
        super.onCreate();

        // Логирование трафика
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        // Инициализируем Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.cbr.ru/scripts/XML_daily.asp")
                .addConverterFactory(SimpleXmlConverterFactory
                        .createNonStrict(new Persister(new AnnotationStrategy())))
                .client(client)
                .build();

        sCbrApi = retrofit.create(CbrApi.class);
    }

    public static CbrApi getApi() {
        return sCbrApi;
    }
}
