package pages.aisdo.pages;

import pages.aisdo.blocks.GiftsTableBlock;
import pages.aisdo.blocks.TableBlock;
import pages.html_elements.Text;
import ru.lanit.at.pages.AbstractPage;
import ru.lanit.at.pages.annotations.Title;


@Title(value = "Ребёнок")
public interface ChildPage extends AbstractPage,
        TableBlock.WithTableBlock, GiftsTableBlock.WithGiftsTable, Text.WithText {

    @Override
    default boolean isOpen() {
        return getWrappedDriver().getCurrentUrl().contains("/NewBout/ManageChild/");
    }

}