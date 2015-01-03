package me.scape.ti.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import me.scape.ti.dao.StyleDAO;
import me.scape.ti.dataobject.StyleDO;
import me.scape.ti.service.StyleService;
import me.scape.ti.vo.StyleListVO;

import org.springframework.stereotype.Service;

@Service
public class StyleServiceImpl implements StyleService {

    @Resource
    private StyleDAO styleDAO;

    @Override
    public List<StyleListVO> getAllStyles() {
        List<StyleListVO> styleVOs = new ArrayList<StyleListVO>();

        List<StyleDO> styles = styleDAO.getAllStyles();
        for (StyleDO style : styles) {
            StyleListVO styleVO = new StyleListVO();
            styleVO.setId(style.getId());
            styleVO.setName(style.getName());
            styleVO.setIcon(style.getIcon());
            styleVO.setGmt_created(style.getGmt_created());

            styleVOs.add(styleVO);
        }

        return styleVOs;
    }

    @Override
    public List<StyleListVO> getAllActiveStyles() {
        List<StyleListVO> styleVOs = new ArrayList<StyleListVO>();

        List<StyleDO> styles = styleDAO.getAllStyles();
        for (StyleDO style : styles) {
            if (1 == style.getDisplay().intValue()) {
                StyleListVO styleVO = new StyleListVO();
                styleVO.setId(style.getId());
                styleVO.setName(style.getName());
                styleVO.setIcon(style.getIcon());
                styleVO.setGmt_created(style.getGmt_created());

                styleVOs.add(styleVO);
            }
        }

        return styleVOs;
    }

}
