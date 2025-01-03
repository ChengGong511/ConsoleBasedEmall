public class Admin {
    private int adminId;
    private String name;
    private String password;

    public Admin() {
    }

    public Admin(int adminId, String name, String password) {
        this.adminId = adminId;
        this.name = name;
        this.password = password;
    }

    public Admin(String admin, String password) {
        this.name = admin;
        this.password = password;

    }

    /**
     * 获取
     * @return adminId
     */
    public int getAdminId() {
        return adminId;
    }

    /**
     * 设置
     * @param adminId
     */
    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "admin{adminId = " + adminId + ", name = " + name + ", password = " + password + "}";
    }
}
