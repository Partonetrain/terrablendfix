package info.partonetrain.terrablendfix.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import info.partonetrain.terrablendfix.CommonClass;
import info.partonetrain.terrablendfix.Constants;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.WeightedEntry;
import net.minecraft.world.level.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import terrablender.api.EndBiomeRegistry;
import terrablender.core.TerraBlender;
import terrablender.worldgen.noise.LayeredNoiseUtil;

import java.util.List;

@Mixin(LayeredNoiseUtil.class)
public class LayeredNoiseUtilMixin {

    @ModifyArg(method = "biomeArea", at= @At(value = "INVOKE", target = "Lterrablender/worldgen/noise/BiomeInitialLayer;<init>(Lnet/minecraft/core/RegistryAccess;Ljava/util/List;)V"), index = 1)
    private static List<WeightedEntry.Wrapper<ResourceKey<Biome>>> terrablendfix$biomeArea(List<WeightedEntry.Wrapper<ResourceKey<Biome>>> original, @Local(argsOnly = true) int size){
        if(!CommonClass.fixed && size == TerraBlender.CONFIG.endIslandBiomeSize && original.equals(EndBiomeRegistry.getEdgeBiomes())){
            Constants.LOG.info("Edge biomes detected where island biomes should be, fixing...");
            CommonClass.fixed = true;
            return EndBiomeRegistry.getIslandBiomes();
        }
        return original;
    }
}
