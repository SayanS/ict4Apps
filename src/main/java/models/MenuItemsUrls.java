package models;

public class MenuItemsUrls {
    private String menuName;
    private String urlOfLinkedPage;

    public MenuItemsUrls(String menuName, String urlOfLinkedPage){
        this.menuName=menuName;
        this.urlOfLinkedPage=urlOfLinkedPage;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public void setUrlOfLinkedPage(String urlOfLinkedPage) {
        this.urlOfLinkedPage = urlOfLinkedPage;
    }

    public String getMenuName(){
        return menuName;
    }

    public String getUrlOfLinkedPage(){
        return urlOfLinkedPage;
    }

}
