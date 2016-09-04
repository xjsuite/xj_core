/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xj.utils;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Hendranto Nugroho
 */
public class XjPages {

    public class DetailPage {

        protected Integer key;
        protected String value;

        public DetailPage(Integer key, String value) {
            this.key = key;
            this.value = value;
        }

        public Integer getKey() {
            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

    }

    // pages
    protected List<DetailPage> pages = new LinkedList<>();
    protected int page = 0;
    protected int itemPerpage = 20;
    protected int maxDisplayPages = 10;
    protected int numberOfPages = 0;

    public List<DetailPage> getPages() {
        if (pages.isEmpty()) {
            pages.add(new DetailPage(1, "1"));
        }
        
        return pages;
    }
    
    public int getPreviousPage() {
        if (page < 2) {
            return -1;
        }
        
        return page-1;        
    }
    
    public int getNextPage() {
        if (page < numberOfPages) {
            return page+1;
        }
        return -1;
    }

    public int getPage() {
        if (page == 0) {
            return 1;
        }
        return page;
    }

    public void calculatePages(long count) {
        if (page == 0) {
            page = 1;
        }        
        if (count <= itemPerpage) {
            pages.add(new DetailPage(1, "1"));
            return;
        }

        numberOfPages = (int) Math.ceil(count / itemPerpage) + 1;


        int window = (page - 1) / maxDisplayPages;
        int startDisplayPage = window * maxDisplayPages;
        int endDisplayPage = Math.min(startDisplayPage + maxDisplayPages, numberOfPages);

        // make start display page to 1 
        startDisplayPage++;

        if (startDisplayPage != 1) {
            pages.add(new DetailPage(startDisplayPage - 1, "<"));
        }
        for (int i = startDisplayPage; i <= endDisplayPage; i++) {
            pages.add(new DetailPage(i, String.valueOf(i)));
        }

        if (endDisplayPage < numberOfPages) {
            pages.add(new DetailPage(endDisplayPage + 1, ">"));
        }
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return itemPerpage;
    }

    public int getOffset() {
        return (page - 1) * itemPerpage;
    }
}
