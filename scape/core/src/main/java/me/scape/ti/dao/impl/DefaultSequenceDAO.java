package me.scape.ti.dao.impl;

import me.scape.ti.dao.EntityManagerSupportGenericDAO;
import me.scape.ti.dao.SequenceDAO;
import me.scape.ti.dataobject.Sequence;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年4月27日 下午6:05:07
 */
@Repository("sequenceDAO")
public class DefaultSequenceDAO extends EntityManagerSupportGenericDAO<Sequence, String> implements SequenceDAO {
	
}