package it.attocchi.studio74.online.pages;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class TestAjax implements Serializable {

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	// public void actionEditItem(AjaxBehaviorEvent event) {
	public String actionEditItem() {
		// passed id
		// log.debug(id);
		System.out.println("actionEditItem");
		System.out.println(id);

		return null;
	}

}
