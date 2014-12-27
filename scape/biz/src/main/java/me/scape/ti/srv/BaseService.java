package me.scape.ti.srv;

import javax.servlet.http.HttpServletRequest;

import me.scape.ti.dao.AreaCategoryDAO;
import me.scape.ti.dao.CategoryDAO;
import me.scape.ti.dao.CommentsDAO;
import me.scape.ti.dao.ItemDAO;
import me.scape.ti.dao.ItemFavoriteDAO;
import me.scape.ti.dao.ItemMediaDAO;
import me.scape.ti.dao.LabelDAO;
import me.scape.ti.dao.ManagerDAO;
import me.scape.ti.dao.ManagerRolesDAO;
import me.scape.ti.dao.RoleDAO;
import me.scape.ti.dao.StyleDAO;
import me.scape.ti.dao.UserDAO;
import me.scape.ti.dao.UserFavoriteDAO;
import me.scape.ti.utils.WebUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月27日 下午4:21:29
 */
public class BaseService implements InitializingBean {

	protected Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    protected HttpServletRequest request;
    
	@Autowired
	@Qualifier(value = "areaCategoryDAO")
	protected AreaCategoryDAO areaCategoryDAO;

	@Autowired
	@Qualifier(value = "categoryDAO")
	protected CategoryDAO categoryDAO;

	@Autowired
	@Qualifier(value = "commentsDAO")
	protected CommentsDAO commentsDAO;

	@Autowired
	@Qualifier(value = "itemDAO")
	protected ItemDAO itemDAO;

	@Autowired
	@Qualifier(value = "itemFavoriteDAO")
	protected ItemFavoriteDAO itemFavoriteDAO;

	@Autowired
	@Qualifier(value = "itemMediaDAO")
	protected ItemMediaDAO itemMediaDAO;

	@Autowired
	@Qualifier(value = "labelDAO")
	protected LabelDAO labelDAO;

	@Autowired
	@Qualifier(value = "managerDAO")
	protected ManagerDAO managerDAO;

	@Autowired
	@Qualifier(value = "managerRolesDAO")
	protected ManagerRolesDAO managerRolesDAO;

	@Autowired
	@Qualifier(value = "roleDAO")
	protected RoleDAO roleDAO;

	@Autowired
	@Qualifier(value = "styleDAO")
	protected StyleDAO styleDAO;

	@Autowired
	@Qualifier(value = "userDAO")
	protected UserDAO userDAO;

	@Autowired
	@Qualifier(value = "userFavoriteDAO")
	protected UserFavoriteDAO userFavoriteDAO;
	
	protected final long getIp() {
        return WebUtils.ipToLng(WebUtils.getIpAddr(request));
    }
	
	@Override
	public final void afterPropertiesSet() throws Exception {
		init();
	}
	
	protected void init() throws Exception {
		
	}
}