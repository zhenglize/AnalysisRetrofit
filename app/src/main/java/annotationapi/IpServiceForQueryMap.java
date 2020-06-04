package annotationapi;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
    @author zhenglize
    传入的参数相当于具有多个query的Map
*/
public interface IpServiceForQueryMap {
    @GET("getIpInfo.php")
    Call<IpServiceForQueryMap> getIpMsg(@QueryMap Map<String,String> map);
}
