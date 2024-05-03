package its.sheepish.fragments.items.custom;

import its.sheepish.fragments.Fragments;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.logging.Logger;

public class DiamondUpgrade extends SmithingTemplateItem {
    public DiamondUpgrade(Text appliesToText, Text ingredientsText, Text titleText, Text baseSlotDescriptionText, Text additionsSlotDescriptionText, List<Identifier> emptyBaseSlotTextures, List<Identifier> emptyAdditionsSlotTextures) {
        super(appliesToText, ingredientsText, titleText, baseSlotDescriptionText, additionsSlotDescriptionText, emptyBaseSlotTextures, emptyAdditionsSlotTextures);
        Fragments.LOGGER.info("Making the diamond upgrade template for "+Fragments.MOD_ID);
    }
}
