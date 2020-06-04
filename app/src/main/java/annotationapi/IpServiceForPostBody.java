package annotationapi;

import Model.Ip;
import Model.IpModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
    @author zhenglize
    @Body注解在post请求中传输Json等格式的数据，在body注解中传入
*/
public interface IpServiceForPostBody {
    @POST("getIpInfo.php")
    //用body注解标识对象，Retrofit会将Ip对象转化为字符串
    Call<IpModel> getIpMsg(@Body Ip ip);
}
