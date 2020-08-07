package ink.zfei.mapper;

public class EnrollActivity extends AbstractActivity {
    public void play(String param) {
        if(!check(param))
        {
            System.out.println("报名类活动时间没到！");
        }
        System.out.println("报名类活动");
//        finsh();
    }


    protected boolean checkOther(String param) {
        System.out.println("检查报名");
        return false;
    }
}
