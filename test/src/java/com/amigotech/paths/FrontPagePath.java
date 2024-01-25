package test.src.java.com.amigotech.paths;

public enum FrontPagePath {
    INVENTORY_ITEM_NAME("//*[@class='cart_item'][1]//*[@class='inventory_item_name']"),
    INVENTORY_ITEM2_NAME("//*[@class='cart_item'][2]//*[@class='inventory_item_name']"),
    ITEM1_ADD_TO_CHART_BUTTON("//*[@class='inventory_item_name ' and text()='Sauce Labs Backpack']/ancestor::*[@class='inventory_item_label']/following-sibling::*//*[contains(@id, 'add-to-cart')]"),
    ITEM2_ADD_TO_CHART_BUTTON("//*[@class='inventory_item_name ' and text()='Sauce Labs Bike Light']/ancestor::*[@class='inventory_item_label']/following-sibling::*//*[contains(@id, 'add-to-cart')]"),
    ITEM2_REMOVE_CHART_BUTTON("//*[@class='inventory_item_name ' and text()='Sauce Labs Bike Light']/ancestor::*[@class='inventory_item_label']/following-sibling::*//*[contains(@id, 'remove')]"),
    ITEM1_REMOVE_TO_CHART_BUTTON("//*[@class='inventory_item_name ' and text()='Sauce Labs Backpack']/ancestor::*[@class='inventory_item_label']/following-sibling::*//*[contains(@id, 'remove')]"),
    LOGIN_BUTTON("//*[@id='login-button']"),
    LOGOUT_BUTTON("//*[@id='logout_sidebar_link']"),
    MENU_BURGER("//*[@id='react-burger-menu-btn']"),
    PASSWORD_INPUT("//*[@id='password']"),
    RESET_APP_STATE_BUTTON("//*[@id='reset_sidebar_link']"),
    SHOP_CHART_BADGE("//*[@class='shopping_cart_badge']"),
    USER_NAME_INPUT("//*[@id='user-name']");

    private final String text;

    FrontPagePath(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
