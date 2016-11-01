package ce1103.ChefREST.service;

import ce1103.ChefREST.data.listwrapper;

public class ServicePull {
	
	public String orderReady(String status1){
		String status = status1;
		if (status == "Ready"){
			listwrapper.listordenes.dequeue();
		}
		return status;
	}
}
