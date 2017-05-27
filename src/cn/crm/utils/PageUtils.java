package cn.crm.utils;

public class PageUtils {

	private Integer pageNo;	//当前页码
	private Integer pageSize;	//页面显示条数
	private Integer next_page;	//下一页
	private Integer previous_page;	//上一页
	
	/**
	 * index是数据库中记录的下标
	 * 
	 */
	private Integer index;
	
	public Integer getIndex() {
		return index = (pageNo - 1) * pageSize;
	}

	private Long allItemsNum;	//查询出来的信息总记录数
	
	private Integer allPageNum;		//根据allItemsNum和pageSize计算得到总页数

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		if (pageNo < 1 || pageNo > allPageNum) {
			this.pageNo = 1;
		} else {
			this.pageNo = pageNo;
		}
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getNext_page() {
		if (pageNo + 1 <= allPageNum) {
			return pageNo + 1;
		} else {
			return allPageNum;
		}
	}

	

	public Integer getPrevious_page() {
		if (pageNo - 1 >= 0) {
			return pageNo-1;
		} else {
			return 0;
		}
	}

	

	public Long getAllItemsNum() {
		return allItemsNum;
	}

	public void setAllItemsNum(Long allItemsNum) {
		this.allItemsNum = allItemsNum;
	}

	public Integer getAllPageNum() {
		return calAllPageNum();
	}

	
	public Integer calAllPageNum(){
		Long result = allItemsNum % pageSize;
		
		if (result == 0) {
			allPageNum = (int) (allItemsNum / pageSize);
		} else {
			allPageNum = (int) (allItemsNum / pageSize + 1);
		}
		
		return allPageNum;
	}
}
