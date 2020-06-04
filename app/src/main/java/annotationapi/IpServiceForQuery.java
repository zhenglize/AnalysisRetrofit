package annotationapi;

import Model.IpModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
    @author zhenglize
    query参数注解:相当于URL中问号后面的字符串,在实例化接口，调用其方法的时候，直接传入问号后面的参数即可
*/
public interface IpServiceForQuery {
    @GET("getIpInfo.php")
    Call<IpModel> getIpMsg(@Query("ip")String ip);
}
