package rest.common;

public class PageUtil {
	
	public static final int PER_PAGE_CNT = 3;
	
	public static int getPageCnt(int totalCnt) {
		int pageCnt = totalCnt / PER_PAGE_CNT;
		if (0 < totalCnt % PER_PAGE_CNT) {
			pageCnt++;
		}
		return pageCnt;
	}
	
}
