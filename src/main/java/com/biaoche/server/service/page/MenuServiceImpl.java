package com.biaoche.server.service.page;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biaoche.server.dao.dao.MenuMapper;
import com.biaoche.server.pojo.entity.Menu;
import com.biaoche.server.pojo.entity.MenuExample;

@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuMapper menuMapper;
	

	@Override
	public List<Menu> getMenuList() {
		//查出所有顶级菜单
		MenuExample example = new MenuExample();
		example.createCriteria().andFatherIdEqualTo(-1);
		List<Menu> menuList =  menuMapper.selectByExample(example);
		for (Menu menu : menuList) {
			MenuExample menuExample = new MenuExample();
			menuExample.createCriteria().andFatherIdEqualTo(menu.getId());
			menu.setChildren(menuMapper.selectByExample(menuExample));
		}
		return menuList;
	}
}
