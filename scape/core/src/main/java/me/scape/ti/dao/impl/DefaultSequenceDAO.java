package me.scape.ti.dao.impl;

import org.springframework.stereotype.Repository;

import me.scape.ti.dao.SequenceDAO;
import me.scape.ti.dataobject.Sequence;
import me.scape.ti.jpa.DefaultGenericDAO;

/**
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年4月27日 下午6:05:07
 */
@Repository("sequenceDAO")
public class DefaultSequenceDAO extends DefaultGenericDAO<Sequence, String> implements SequenceDAO {
	
}