package germangirod.goldcoastevents.data.api;

import germangirod.goldcoastevents.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by germangirod on 4/8/16.
 */
public class RestClient {

    private static Api REST_Client;

    static {
        setupRestClient();
    }

    private RestClient() {

    }

    public static Api get() {
        return REST_Client;
    }

    private static void setupRestClient() {

        Retrofit builder = new Retrofit.Builder().baseUrl(BuildConfig.API_ROOT).client(createOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create()).build();

        REST_Client = builder.create(Api.class);
    }

    private  static OkHttpClient createOkHttpClient(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        return client;
    }

}
