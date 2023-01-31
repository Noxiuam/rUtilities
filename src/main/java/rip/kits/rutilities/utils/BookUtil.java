package rip.kits.rutilities.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.List;

public class BookUtil {
    /* Title and Author of the book */
    private String title, author;

    /* Pages of the book */
    private List<String> pages;


    /**
     *
     * @param title
     * @return
     */
    public BookUtil title(String title) {
        this.title = title;
        return this;
    }

    /**
     *
     * @param author
     * @return
     */

    public BookUtil author(String author) {
        this.author = author;
        return this;
    }



    /**
     *
     *
     * @return
     */

    public ItemStack build() {
        ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
        BookMeta bookMeta = (BookMeta) book.getItemMeta();
        if (author != null)
            bookMeta.setAuthor(author);
        if (title != null)
            bookMeta.setTitle(title);
        if (pages != null)
            pages.forEach(string -> bookMeta.addPage(CCUtil.s("&r" + string)));
        book.setItemMeta(bookMeta);
        return book;
    }
}
