package cn.crm.entity;

/**
 * <p>
 * Title:Visit
 * </p>
 * <p>
 * Description: 拜访实体类
 * </p>
 * @author Administrator
 * @date 2017-5-17 下午3:24:16
 * @version 1.0
 */
public class Visit {

	private Integer vid;
	private String vaddress;
	private String vcontent;
	
	//表示所属客户
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	//表示拜访记录所属的用户
	private SysUser user;
	public SysUser getUser() {
		return user;
	}

	public void setUser(SysUser user) {
		this.user = user;
	}

	public Integer getVid() {
		return vid;
	}

	public void setVid(Integer vid) {
		this.vid = vid;
	}

	public String getVaddress() {
		return vaddress;
	}

	public void setVaddress(String vaddress) {
		this.vaddress = vaddress;
	}

	public String getVcontent() {
		return vcontent;
	}

	public void setVcontent(String vcontent) {
		this.vcontent = vcontent;
	}
}
