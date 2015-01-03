package me.scape.ti.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.scape.ti.dao.StyleDAO;
import me.scape.ti.dataobject.StyleDO;
import me.scape.ti.jpa.DefaultGenericDAO;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月21日 下午2:55:02
 */
@Repository(value = "styleDAO")
public class DefaultStyleDAO extends DefaultGenericDAO<StyleDO, Long> implements StyleDAO {

    @Override
    public List<StyleDO> getStylesByIds(List<Long> ids) {
        if (null == ids || ids.size() <= 0) {
            return new ArrayList<StyleDO>();
        }

        Map<String, Object> args = new HashMap<String, Object>();
        args.put("ids", ids);
        return queryNamed("StyleDO.getStylesByIds", args);
    }

    @Override
    public List<StyleDO> getAllStyles() {
        return queryNamed("StyleDO.getAllStyles");
    }

}