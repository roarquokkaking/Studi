package manager.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class ManagerPaging {
    private int currentPage;//현재페이지
    private int pageBlock;//[이전][1][2][3][다음]
    private int pageSize;//1페이지당 3개씩
    private int totalA;//총글수
    private StringBuffer pagingHTML;

    public void makePagingHTML() {
        pagingHTML = new StringBuffer();

        int totalP = (totalA + pageSize-1) / pageSize;//총 페이지 수

        int startPage = (currentPage-1) / pageBlock * pageBlock + 1;

        int endPage = startPage + pageBlock - 1;

        if(endPage > totalP) endPage = totalP;

        if(startPage != 1)
            pagingHTML.append("<span id='paging' onclick='managerPaging(" + (startPage-1) + ")'>이전</span>");

        for(int i=startPage; i<=endPage; i++) {
            if(i == currentPage)
                pagingHTML.append("<span id='currentPaging' onclick='managerPaging(" + i + ")'>" + i + "</span>");
            else
                pagingHTML.append("<span id='paging' onclick='managerPaging(" + i + ")'>" + i + "</span>");
        }

        if(endPage < totalP)
            pagingHTML.append("<span id='paging' onclick='managerPaging(" + (endPage+1) +")'>다음</span>");
    }
}
