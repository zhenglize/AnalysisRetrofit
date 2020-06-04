package annotationapi;

import Model.IpModel;
import retrofit2.Call;
import retrofit2.http.GET;

/**
    @author zhenglize
    Retrofit规定将请求方式，请求参数数，返回值写在接口中（且必选是原生的接口，不能继承其他的接口）
*/
public interface IpService {
    //将请求方式和请求路径写在GET注解中，返回值为Call，泛型中为对应的实体类
    @GET("getIpInfo.php?ip=59.108.54.37")
    Call<IpModel> getIpMsg();
}
