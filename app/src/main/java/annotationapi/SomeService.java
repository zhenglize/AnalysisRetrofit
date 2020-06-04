package annotationapi;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

/**
    @author zhenglize
    消息头的使用，为了防止攻击，过滤不安全的访问，或者添加特殊的加密访问（比如在消息头中添加Base64）来保证安全
*/
public interface SomeService {
    //静态添加单个消息头
    @GET("some/endpoint")
    @Headers("Accept-Encoding : application/json")
    Call<ResponseBody> getInfo();
    //静态添加多个消息头
    @GET("some/endpoint")
    @Headers({
            "Accept-Encoding : application/json",
            "User-Agent: MoonRetrofit"
    })
    Call<ResponseBody> getInfo02();
    //动态添加消息头,添加到参数列表中
    @GET("some/endpoint")
    Call<ResponseBody> getInfo03(@Header("param1") String param1);
}
