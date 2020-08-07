package ink.zfei.mapper;

public class DzpActivity extends AbstractActivity {

    public void play(String param) {
        if(!check(param))
        {
            System.out.println("大转盘活动时间没到！");
        }
        System.out.println("大转盘活动进行中");
    }


    protected boolean checkOther(String param) {
        System.out.println("检查库存");
        return false;
    }
}
