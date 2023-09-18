package com.thumbs.up.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class PageHandler {
    //    private int pageSize;   // 한 페이지의 크기
//    private String option;
//    private String keyword;

    private SearchCondition sc; // 위 3개를 묶은 것
    private int totalCnt;   // 총 게시물 갯수

    private int naviSize = 10;    // 페이지 내비게이션의 크기
    private int totalPage;  // 전체 페이지의 갯수
    private int page;       // 현재 페이지
    private int beginPage;  // 내비게이션의 첫번째 페이지
    private int endPage;    // 내비게이션의 마지막 페이지
    private boolean showPrev;   // 이전 페이지로 이동하는 링크를 보여줄 것인지의 여부
    private boolean showNext;   // 다음 페이지로 이동하는 핑크를 보여줄 것인지의 여부
    public PageHandler(int totalCnt, SearchCondition sc) {
        this.totalCnt = totalCnt;
        this.sc = sc;

        doPaging(totalCnt, sc);
    }

    public PageHandler(int totalCnt, Integer page, Integer pageSize) {
    }

    public void doPaging(int totalCnt, SearchCondition sc) {
        this.totalCnt = totalCnt;

        totalPage = (int)Math.ceil(totalCnt / (double)sc.getPageSize());
        beginPage = (sc.getPage() - 1) / naviSize * naviSize + 1;
        endPage = Math.min(beginPage + naviSize - 1, totalPage);
        showPrev = beginPage != 1;
        showNext = endPage != totalPage;
    }

    void print() {
        System.out.println("page = " + sc.getPage());
        System.out.print(showPrev ? "[PREV] " : "");

        for (int i = beginPage; i <= endPage; i++) {
            System.out.print(i + " ");
        }
        System.out.println(showNext ? "[NEXT] " : "");
    }

}
