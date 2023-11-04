package io.fourleaves.earlyarmors;

import org.slf4j.Logger;
import com.mojang.logging.LogUtils;

import io.fourleaves.earlyarmors.armor.WoodArmorMaterial;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(EarlyArmors.MODID)
public class EarlyArmors {
    // Mod Identifier
    public static final String MODID = "earlyarmors";    
    // Grab logger
    public static final Logger LOGGER = LogUtils.getLogger();
    // Create a deferred register for items
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final WoodArmorMaterial WOOD_ARMOR_MATERIAL = new WoodArmorMaterial();



    // Register items
    public static final RegistryObject<Item> WOOD_HELMET = 
        ITEMS.register("wood_helmet", 
        () -> new ArmorItem(WOOD_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> WOOD_CHESTPLATE = 
        ITEMS.register("wood_chestplate", 
        () -> new ArmorItem(WOOD_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> WOOD_LEGGINGS = 
        ITEMS.register("wood_leggings", 
        () -> new ArmorItem(WOOD_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> WOOD_BOOTS = 
        ITEMS.register("wood_boots", 
        () -> new ArmorItem(WOOD_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties()));


    public EarlyArmors() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::commonSetup);

        ITEMS.register(bus);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }
}
