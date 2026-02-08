package moremekasuitmodules.common.content.gear.integration.resourceradar;

import mekanism.api.annotations.ParametersAreNotNullByDefault;
import mekanism.api.gear.ICustomModule;
import mekanism.api.gear.IModule;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.nbt.NBTTagCompound;

@ParametersAreNotNullByDefault
public class ModuleResourceRadarUnit implements ICustomModule<ModuleResourceRadarUnit> {

    @Override
    public void onAdded(IModule<ModuleResourceRadarUnit> module, boolean first) {
        setXrayEnabledTag(module, module.isEnabled());
    }

    @Override
    public void onRemoved(IModule<ModuleResourceRadarUnit> module, boolean last) {
        NBTTagCompound compound = module.getContainer().getTagCompound();
        if (compound != null) {
            compound.removeTag("xray");
        }
    }

    @Override
    public void onEnabledStateChange(IModule<ModuleResourceRadarUnit> module) {
        setXrayEnabledTag(module, module.isEnabled());
    }

    private void setXrayEnabledTag(IModule<ModuleResourceRadarUnit> module, boolean enabled) {
        NBTTagCompound compound = module.getContainer().getTagCompound();
        if (compound == null) {
            module.getContainer().setTagInfo("xray", new NBTTagByte((byte) (enabled ? 1 : 0)));
        } else {
            compound.setBoolean("xray", enabled);
        }
    }
}
