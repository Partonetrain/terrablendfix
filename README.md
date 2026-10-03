# TerrablEndFix
(it's pronounced "terrible end fix")

[There is a bug in TerraBlender 1.21.1 that prevents the vanilla Small End Islands biome from generating](https://github.com/Glitchfiend/TerraBlender/issues/179) at all. [This was fixed for 1.21.5+](https://github.com/Glitchfiend/TerraBlender/pull/211) but not for 1.21.1.
This mod simply fixes the issue in 1.21.1, since TerraBlender is no longer maintained for that version.

I could not reproduce this issue in the Fabric version of TerraBlender, but a Fabric version is provided just in case you run into it somehow.

This mod is very simple, it changes one variable. Unfortunately for this to work, TerraBlender's `endEdgeBiomeSize` and `endIslandBiomeSize` config options **need to be different** (which they are by default).
You can tell it worked if you see `Edge biomes detected where island biomes should be, fixing...` in your log (and of course, Small End Islands generate again)
