package annotationapi;

import Model.IpModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
    @author zhenglize
    Retrofit请求参数注解的使用
*/
public interface IpServiceForPath {
    //将需要请求的参数用大括号包裹，在@path参数注解中填入和大括号中相同的值即可
    @GET("{path}/getInfo.php?ip=59.108.54.37")
    Call<IpModel> getIpMsg(@Path("path") String path);
}
