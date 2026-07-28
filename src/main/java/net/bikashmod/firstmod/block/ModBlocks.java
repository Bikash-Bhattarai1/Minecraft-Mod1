package net.bikashmod.firstmod.block;

import net.bikashmod.firstmod.FirstMod;
import net.bikashmod.firstmod.item.Moditems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS , FirstMod.MOD_ID);

    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block",
            () -> new DropExperienceBlock(UniformInt.of(20,25),BlockBehaviour.Properties.of()
                    .strength(3f)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> ANUP_BLOCK = registerBlock("anup_block",
            () -> new DropExperienceBlock( UniformInt.of(70,80),BlockBehaviour.Properties.of()
                    .strength(3f)
                    .requiresCorrectToolForDrops()));




     private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
         RegistryObject<T> toReturn = BLOCKS.register(name, block);
         registerBlocksItem(name , toReturn);
         return toReturn;

     }


    private static <T extends Block> void registerBlocksItem (String name, RegistryObject<T> block){
        Moditems.ITEMS.register(name,()-> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
