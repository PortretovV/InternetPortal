import javax.faces.bean.ManagedBean;

@ManagedBean
public class PageManage {

    public String index(){
        return "index";
    }

    public String basket(){
        return "basket";
    }

}
