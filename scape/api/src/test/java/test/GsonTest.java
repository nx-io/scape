package test;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.reflect.TypeToken;

import me.ocs.commons.serializer.GsonSerializer;
import me.ocs.commons.serializer.Serializer;
import me.scape.ti.vo.ApplyTaskVO;
import me.scape.ti.vo.SimpleUserVO;
import me.scape.ti.vo.TaskVO;
import me.scape.ti.vo.UserVO;

/**
 * @author 刘飞 E-mail:liufei_it@126.com
 *
 * @version 1.0.0
 * @since 2015年10月15日 下午11:02:27
 */
public class GsonTest {
    
    private final static Serializer SERIALIZER = new GsonSerializer(true, true, true);

    public static void main(String[] args) {

        List<TaskVO> taskVOList = new ArrayList<TaskVO>();
        taskVOList.add(new TaskVO());
        
        System.out.println(SERIALIZER.serialize(new TypeToken<ArrayList<TaskVO>>(){}.getType(), taskVOList));
        
        System.out.println(SERIALIZER.serialize(new TypeToken<ApplyTaskVO>(){}.getType(), new ApplyTaskVO()));
        
        System.out.println(SERIALIZER.serialize(new TypeToken<SimpleUserVO>(){}.getType(), new SimpleUserVO()));


        List<UserVO> applyUserList = new ArrayList<UserVO>();
        applyUserList.add(new UserVO());
        
        System.out.println(SERIALIZER.serialize(new TypeToken<ArrayList<UserVO>>(){}.getType(), applyUserList));
    }
}