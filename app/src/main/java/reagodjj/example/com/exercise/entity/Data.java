package reagodjj.example.com.exercise.entity;

public class Data {
    private String cDate;//工信部更新时间
    private String comAddress;//公司地址
    private String comName;//公司名称
    private String comType;//公司性质
    private String id;//网备编号
    private String siteDomain;//域名
    private String siteName;//简称
    private String siteType;//网站类型
    private String updateTime;//本站更新时间

    public String getcDate() {
        return cDate;
    }

    public void setcDate(String cDate) {
        this.cDate = cDate;
    }

    public String getComAddress() {
        return comAddress;
    }

    public void setComAddress(String comAddress) {
        this.comAddress = comAddress;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComType() {
        return comType;
    }

    public void setComType(String comType) {
        this.comType = comType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSiteDomain() {
        return siteDomain;
    }

    public void setSiteDomain(String siteDomain) {
        this.siteDomain = siteDomain;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteType() {
        return siteType;
    }

    public void setSiteType(String siteType) {
        this.siteType = siteType;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "{" +
                "cDate='" + cDate + '\'' +
                ", comAddress='" + comAddress + '\'' +
                ", comName='" + comName + '\'' +
                ", comType='" + comType + '\'' +
                ", id='" + id + '\'' +
                ", siteDomain='" + siteDomain + '\'' +
                ", siteName='" + siteName + '\'' +
                ", siteType='" + siteType + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
