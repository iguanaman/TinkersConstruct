package tconstruct.items.blocks;

import java.util.List;

import mantle.blocks.abstracts.MultiItemBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;

public class LavaTankItemBlock extends MultiItemBlock
{
    public static final String blockTypes[] = { "Tank", "Gague", "Window" };

    public LavaTankItemBlock(int id)
    {
        super(id, "LavaTank", blockTypes);
        setMaxDamage(0);
        setHasSubtypes(true);
    }



    public void addInformation (ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
        if (stack.hasTagCompound())
        {
            NBTTagCompound liquidTag = stack.getTagCompound().getCompoundTag("Fluid");
            if (liquidTag != null)
            {
                list.add(StatCollector.translateToLocal("searedtank1.tooltip") + StatCollector.translateToLocal(liquidTag.getString("FluidName")));
                list.add(liquidTag.getInteger("Amount") + " mB");
            }
        }
        else
        {
            list.add(StatCollector.translateToLocal("searedtank2.tooltip"));
        }
    }
}
