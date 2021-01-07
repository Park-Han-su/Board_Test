package rest.board.vo;

public class Page {
	
	private int totlaCnt;
	private int pageCnt;
	private int pageNo;
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getTotlaCnt() {
		return totlaCnt;
	}
	public void setTotlaCnt(int totlaCnt) {
		this.totlaCnt = totlaCnt;
	}
	public int getPageCnt() {
		return pageCnt;
	}
	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}
}
