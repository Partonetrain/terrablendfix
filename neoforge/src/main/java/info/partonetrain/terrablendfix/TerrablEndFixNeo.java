package info.partonetrain.terrablendfix;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class TerrablEndFixNeo {

    public TerrablEndFixNeo(IEventBus eventBus) {
        CommonClass.init();

    }
}