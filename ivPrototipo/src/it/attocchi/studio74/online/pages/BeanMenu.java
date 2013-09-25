package it.attocchi.studio74.online.pages;

import it.attocchi.studio74.online.jsf.PageBaseS74;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class BeanMenu extends PageBaseS74 {

	String menu;

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	@Override
	protected void verificaUtentePrivilegiato() {

	}

	@Override
	protected void init2() throws Exception {
		// appena istanziato vedo il Cruscotto.
		menu = "dashboard";		
	}

	public String actionGo() {
		redirect("../" + menu);
		return null;
	}
}
