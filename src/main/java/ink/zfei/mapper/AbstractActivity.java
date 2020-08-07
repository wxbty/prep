package ink.zfei.mapper;

public abstract class AbstractActivity implements Activity {


    protected boolean check(String param) {

        if(!checkDate(param))
        {
            return false;
        }
        if(!checkOther(param))
        {
            return false;
        }

        return false;
    }

    protected abstract boolean checkOther(String param);

    private boolean checkDate(String param)
    {
        System.out.println("从param里获取活动id");
        System.out.println("根据活动id到活动表查询活动detail");
        System.out.println("拿到活动时间，和当前时间对比");
        return true;
    }
}
