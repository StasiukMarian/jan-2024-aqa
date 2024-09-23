package base.pages;

import base.config.PageTools;

public class DetailItemPage extends PageTools {
    private final String header = "//div[contains(@class, 'inventory_details_name')]";
    private final String description = "//div[@class='inventory_details_desc_container']//div[contains(@class, 'inventory_details_desc')]";
    private final String price = "//div[@class='inventory_details_price']";

    public Item getDetailedItem() {
        Item item = new Item();

        item.setHeader(getText("xpath", header));
        item.setDescription(getText("xpath", description));
        item.setPrice(getText("xpath", price));
        return item;
    }
}
