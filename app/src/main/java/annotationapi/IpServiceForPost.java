package annotationapi;

import Model.IpModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
    @author zhenglize
    post网络请求方式
    FormUrlEncoded 表单请求
    Field 键值对
*/
public interface IpServiceForPost {
    @FormUrlEncoded
    @POST("getIpInfo.php")
    //对于Field参数，Field注解中的的是键，实例化接口，调用方法的时候，传入的是具体的值
    Call<IpModel> getIpMsg(@Field("ip") String ip);
}
