package cn.yd.carrentalsystem.po;

import java.math.BigDecimal;
import java.util.Date;

public class Lease {
    private Integer lid;

    private Integer state;

    private Integer uid;

    private Integer cid;

    private Date createtime;

    private Date receivetime;

    private Date returntime;

    private String contactphone;

    private String receiveaddress;

    private String returnaddress;

    private BigDecimal totalprice;

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getReceivetime() {
        return receivetime;
    }

    public void setReceivetime(Date receivetime) {
        this.receivetime = receivetime;
    }

    public Date getReturntime() {
        return returntime;
    }

    public void setReturntime(Date returntime) {
        this.returntime = returntime;
    }

    public String getContactphone() {
        return contactphone;
    }

    public void setContactphone(String contactphone) {
        this.contactphone = contactphone == null ? null : contactphone.trim();
    }

    public String getReceiveaddress() {
        return receiveaddress;
    }

    public void setReceiveaddress(String receiveaddress) {
        this.receiveaddress = receiveaddress == null ? null : receiveaddress.trim();
    }

    public String getReturnaddress() {
        return returnaddress;
    }

    public void setReturnaddress(String returnaddress) {
        this.returnaddress = returnaddress == null ? null : returnaddress.trim();
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }
}