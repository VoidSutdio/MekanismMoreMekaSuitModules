package moremekasuitmodules.common.content.gear.integration.srparasites;

import com.dhanantry.scapeandrunparasites.init.SRPPotions;
import mekanism.api.gear.ModuleData;
import moremekasuitmodules.common.MekaSuitMoreModules;
import moremekasuitmodules.common.config.MoreModulesConfig;
import net.minecraft.potion.Potion;

import java.util.function.Supplier;

public enum ParasiteDebuffModulesInfo {
    BLEEDING(MekaSuitMoreModules.BLEEDING_DEBUFF_UNIT, SRPPotions.BLEED_E, 80, () -> MoreModulesConfig.current().config.moduleBleedingDebuffEnergyUsage.val()),
    IMMALEABLE(MekaSuitMoreModules.IMMALEABLE_DEBUFF_UNIT, SRPPotions.RES_E, 80, () -> MoreModulesConfig.current().config.moduleImmaleableDebuffEnergyUsage.val()),
    ;

    private final ModuleData<?> moduleData;
    private final Potion potion;
    private final Supplier<Double> energyPerUsageProvider;
    private final int duration;

    ParasiteDebuffModulesInfo(ModuleData<?> moduleData, Potion potion, int durationInTicks, Supplier<Double> energyPerUsageProvider) {
        this.moduleData = moduleData;
        this.potion = potion;
        this.duration = durationInTicks;
        this.energyPerUsageProvider = energyPerUsageProvider;
    }

    public double getEnergyPerUsage() {
        return energyPerUsageProvider.get();
    }

    public ModuleData<?> getModuleData() {
        return moduleData;
    }

    public int getDuration() {
        return duration;
    }

    public Potion getPotion() {
        return potion;
    }
}
