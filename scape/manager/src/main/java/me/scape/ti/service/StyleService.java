package me.scape.ti.service;

import java.util.List;

import me.scape.ti.vo.StyleListVO;

public interface StyleService {
    List<StyleListVO> getAllStyles();

    List<StyleListVO> getAllActiveStyles();
}
