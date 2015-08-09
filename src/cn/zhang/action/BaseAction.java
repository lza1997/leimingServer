package cn.zhang.action;

public class BaseAction {
    protected String page; // 当前第几页
    protected String rows; // 每页显示多少条记录

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getRows() {
        return rows;
    }

    public void setRows(String rows) {
        this.rows = rows;
    }
}
