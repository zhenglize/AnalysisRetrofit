package Model;
/**
    @author zhenglize
   Retrofit请求返回的对象的实体类
*/
public class IpModel {
    private int code;
    private IpData data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public IpData getData() {
        return data;
    }

    public void setData(IpData data) {
        this.data = data;
    }
}
